(ns fhirpath.core
  (:import FHIRPathParser
           FHIRPathLexer
           FHIRPathBaseVisitor
           FHIRPathVisitor
           [org.antlr.v4.runtime CharStreams CommonTokenStream]
           [org.antlr.v4.runtime.tree ParseTreeWalker])
  (:require [clojure.string :as str]
            [clojure.set]))

(defn to-list [x]
  (apply list x))

(defn seqy [s]
  (if (sequential? s)
    (vec s)
    (if (nil? s) [] [s])))

(defn pick-single [a]
  (if (sequential? a)
    (cond
      (= (count a) 1)  (first a)
      (> (count a ) 1) (throw (Exception. (str "Expected only one element, but " (pr-str a))))
      :else [])
    a))

(defn- make-visitor []
  (proxy [FHIRPathBaseVisitor] []
    (aggregateResult [a b]
      (->> (conj (seqy a) b)
           (filterv #(not (nil? %)))))

    (visitInvocationExpression [^FHIRPathParser$InvocationExpressionContext ctx]
      `(->  ~@(proxy-super visitChildren ctx)))

    (visitInvocationTerm [^FHIRPathParser$InvocationTermContext ctx]
      `(-> ~'doc ~@(proxy-super visitChildren ctx)))

    (visitMemberInvocation [^FHIRPathParser$MemberInvocationContext ctx]
      `(fp-get ~@(proxy-super visitChildren ctx)))

    (visitIdentifier [^FHIRPathParser$IdentifierContext ctx]
      (keyword (.getText ctx)))

    (visitTermExpression [^FHIRPathParser$TermExpressionContext ctx]
      (first (seqy (proxy-super visitChildren ctx))))

    (visitIndexerExpression [^FHIRPathParser$IndexerExpressionContext ctx]
      `(fp-nth ~@(proxy-super visitChildren ctx)))

    (visitLiteralTerm [^FHIRPathParser$LiteralTermContext ctx]
      (first (seqy (proxy-super visitChildren ctx))))


    (visitAndExpression [^FHIRPathParser$AndExpressionContext ctx]
      `(fp-and ~@(proxy-super visitChildren ctx)))

    (visitFunctionInvocation [^FHIRPathParser$FunctionInvocationContext ctx]
      (let [[fn-name & params :as call] (first (proxy-super visitChildren ctx))]
        (let [qfn-name (symbol (str "fhirpath.core/fp-" (name fn-name) "-fn"))]
          (cond
            (contains? #{:ofType} fn-name)
            `(~qfn-name ~(last (last (ffirst params))))
            (contains? #{:iif :where :select :repeat :exists :all} fn-name)
            (let [lambdas  (mapv (fn [l] `(fn [~'doc] ~l)) (first params))]
              `(~qfn-name ~@lambdas))
            :else
            `(~qfn-name ~@(first params))))))

    (visitParamList [^FHIRPathParser$ParamListContext ctx]
      (proxy-super visitChildren ctx))


    (visitFunctn [^FHIRPathParser$FunctnContext ctx]
      (proxy-super visitChildren ctx))

    (visitMembershipExpression [^FHIRPathParser$MembershipExpressionContext ctx]
      `(~(symbol (str "fhirpath.core/fp-" (.getText (.getChild ctx 1))))
        ~@(proxy-super visitChildren ctx)))

    (visitAdditiveExpression [^FHIRPathParser$AdditiveExpressionContext ctx]
      `(~(symbol (str "fhirpath.core/fp-" (.getText (.getChild ctx 1))))
        ~@(proxy-super visitChildren ctx)))

    (visitMultiplicativeExpression [^FHIRPathParser$MultiplicativeExpressionContext ctx]
      (let [op (.getText (.getChild ctx 1))
            op (if (= op "/") "division" op)
            qfn (symbol (str "fhirpath.core/fp-" op))]
        `(~qfn ~@(proxy-super visitChildren ctx))))

    (visitEqualityExpression [^FHIRPathParser$EqualityExpressionContext ctx]
      (let [op (.getText (.getChild ctx 1))]
        (case op
          "!="
          `(fp-not-eq ~@(proxy-super visitChildren ctx))
          "="
          `(fp-eq ~@(proxy-super visitChildren ctx))
          "~"
          `(fp-eq? ~@(proxy-super visitChildren ctx))

          "!~"
          `(fp-not-eq? ~@(proxy-super visitChildren ctx))

          )))

    (visitNullLiteral [^FHIRPathParser$NullLiteralContext ctx]
      nil)

    (visitInequalityExpression [^FHIRPathParser$InequalityExpressionContext ctx]
      (let [op (.getText (.getChild ctx 1))]
        (case op
          "<"
          `(fp-lt ~@(proxy-super visitChildren ctx))
          "<="
          `(fp-lte ~@(proxy-super visitChildren ctx))
          ">"
          `(fp-gt ~@(proxy-super visitChildren ctx))

          ">="
          `(fp-gte ~@(proxy-super visitChildren ctx)))))

    (visitNumberLiteral [^FHIRPathParser$NumberLiteralContext ctx]
      (read-string (.getText (.NUMBER ctx))))

    (visitBooleanLiteral [^FHIRPathParser$BooleanLiteralContext ctx]
      (= "true" (.getText ctx)))

    (visitStringLiteral [^FHIRPathParser$StringLiteralContext ctx]
      (str/replace (.getText (.STRING ctx)) #"(^'|'$)" ""))

    (visitThisInvocation [^FHIRPathParser$ThisInvocationContext ctx]
      'identity)

    (visitUnionExpression [^FHIRPathParser$UnionExpressionContext ctx]
      `(fp-union ~@(proxy-super visitChildren ctx)))

    (visitExternalConstantTerm [^FHIRPathParser$ExternalConstantTermContext ctx]
      (let [v (subs (.getText ctx) 1)
            v (if (str/starts-with? v "\"")
                (str/replace v #"\"" "")
                v)]
        `(get ~'**env ~(keyword v))))

    ;; (visitDateTimeLiteral [^FHIRPathParser$DateTimeLiteralContext ctx])
    ;; (visitDateTimePrecision [^FHIRPathParser$DateTimePrecisionContext ctx])
    ;; (visitUnit [^FHIRPathParser$UnitContext ctx])
    ;; (visitTimeLiteral [^FHIRPathParser$TimeLiteralContext ctx])
    ;; (visitTypeExpression [^FHIRPathParser$TypeExpressionContext ctx])
    ;; (visitTypeSpecifier [^FHIRPathParser$TypeSpecifierContext ctx])
    ;; (visitPluralDateTimePrecision [^FHIRPathParser$PluralDateTimePrecisionContext ctx])
    ;; (visitPolarityExpression [^FHIRPathParser$PolarityExpressionContext ctx])
    ;; (visitQualifiedIdentifier [^FHIRPathParser$QualifiedIdentifierContext ctx])
    ;; (visitQuantity [^FHIRPathParser$QuantityContext ctx])
    ;; (visitQuantityLiteral [^FHIRPathParser$QuantityLiteralContext ctx])

    (visitOrExpression [^FHIRPathParser$OrExpressionContext ctx]
      (let [op (.getText (.getChild ctx 1))
            qfn (symbol (str "fhirpath.core/fp-" op))]
        `(~qfn ~@(proxy-super visitChildren ctx))))

    (visitXorExpression [^FHIRPathParser$OrExpressionContext ctx]
      `(fp-xor ~@(proxy-super visitChildren ctx)))

    (visitImpliesExpression [^FHIRPathParser$ImpliesExpressionContext ctx]
      `(fp-implies ~@(proxy-super visitChildren ctx)))

    (visitParenthesizedTerm [^FHIRPathParser$ParenthesizedTermContext ctx]
      `(do ~@(proxy-super visitChildren ctx)))
    ))

(defn getk [x k]
  (let [v (get x k)]
    (if (nil? v)
      (get x (name k))
      v)))

(defn conjy [acc res]
  (if (sequential? res)
    (into acc res)
    (if (nil? res)
      acc
      (conj acc res))))

(defn fp-take-fn [subj num]
  (take (int num) (seqy subj)))

;; TODO: other types
(defn fp-get-one [x k]
  (let [v (getk x k)]
    (if (nil? v)
      (or (when (= (:resourceType x) (name k)) x)
          (get x (str (name k) "Quantity")))
      v)))

(defn fp-get [subj k]
  (if (sequential? subj)
    (->> subj
         (reduce (fn [acc x] (conjy acc (fp-get-one x k))) []))
    (fp-get-one subj k)))


(def epsilon 0.0000000000001) ;; 1e-13
(defn double=
  [a b]
  (< (Math/abs (- a b)) epsilon))

(defn fp-eq [a b]
  (println :eq a b (type a) (type b))
  (cond (or (nil? a)
          (nil? b)
          (and (sequential? a) (empty? a))
          (and (sequential? b) (empty? b)))
    []
    (and (double? a) (double? b)) [(double= a b)]
    :else [(= a b)]))

(defn fp-not-eq [a b]
  (let [b (fp-eq a b)]
    (if (empty? b)
      b
      [(not (first b))])))


(defn precision [num]
  (if (integer? num)
    0
    (-> num
        str
        (clojure.string/split #"\.")
        second
        count)))

(defn number-eq? [a b]
  (let [precision (min (precision a) (precision b))
        fmt (str "%." precision "f")]
    (= (format fmt a) (format fmt b))))

(defn fp-eq? [a b]
  (if (or (and (sequential? a) (empty? a))
          (and (sequential? b) (empty? b)))
    []
    (if (or (nil? a) (nil? b))
      []
      (cond
        (and (string? a) (string? b))
        [(= (str/replace (str/lower-case a) #"\s+" " ")
            (str/replace (str/lower-case b) #"\s+" " "))]
        (and (number? a) (number? b)) [(number-eq? a b)]
        :else [(= a b)]))))

(defn fp-not-eq? [a b]
  (if (and (nil? a) (nil? b))
    [false]
    (let [b (fp-eq? a b)]
      (if (empty? b)
        b
        [(not (first b))]))))

(defn fp-subs-fn [s a b]
  (->> (seqy s)
       (mapv #(subs % (int a) (int b)))))

(defn bool-fn [f]
  (fn [x]
    (let [v (f x)] (if (boolean? v) v (first v)))))

(defn fp-where-fn [s f]
  (filter (bool-fn f) (seqy s)))

(defn fp-select-fn [s f]
  (->> (seqy s)
       (reduce (fn [acc x]
                 (conjy acc (f x)))
               [])))

(defn fp-count-fn [s]
  (count (seqy s)))

(defn fp-repeat-fn [s f]
  (let [init (fp-select-fn s f)]
    (loop [res init
           work init]
      (let [more (fp-select-fn work f)]
        (if (or (and more (empty? more)) (= more init))
          res
          (recur (into res more) more))))))

(defn fp-ofType-fn [s tp]
  (let [v (seqy s)]
    (filter (fn [x]
              (cond
                (= tp :string)  (string? x)
                (= tp :integer) (integer? x)
                (= tp :decimal) (number? x)
                (= tp :boolean) (boolean? x)
                (= tp :object) (map? x)
                ))
            v)))

(defn fp-nth [s n]
  (nth (seqy s) (int n) nil))

(defn fp-ineq [op a b]
  [:ineq op a b]
  #_(if (and (number? a) (number? b))
    (op a b)
    false))

(defn fp-compare [op a b]
  (let [a (pick-single a)
        b (pick-single b)]
    (cond
      (or (nil? a) (nil? b)) []
      (or (and (sequential? a) (empty? a))
          (and (sequential? b) (empty? b))) []
      (and (int? a) (int? b)) [(op a b)]
      (and (double? a) (double? b)) [(op a b)]
      (and (number? a) (number? b)) [(op a b)]
      (and (string? a) (string? b)) [(op (compare a b) 0)]
      (not (= (type a) (type b))) (throw (Exception. (str (pr-str a) " " op " " (pr-str b) " wrong type")))
      :else (throw (Exception. (str (pr-str a) " " op " " (pr-str b) " wrong type"))))))



(defn fp-lt [a b]
  (fp-compare < a b))

(defn fp-lte [a b]
  (fp-compare <= a b))

(defn fp-gt [a b]
  (fp-compare > a b))

(defn fp-gte [a b]
  (fp-compare >= a b))

(defn fp-empty-fn [s]
  (if (sequential? s)
    (empty? s)
    (if (nil? s)
      true false)))

(defn fp-not-fn [s]
  (if (nil? s)
    true
    (let [s (seqy s)]
      (if (empty? s)
        []
        (if (> (count s) 1)
          false
          (let [val (pick-single s)]
            (if (boolean? val)
              (not val)
              false)))))))

(defn fp-exists-fn [s & [f]]
  (if f
    (fp-exists-fn (fp-where-fn s f))
    (not (empty? (seqy s)))))

(defn fp-all-fn [s f]
  (every? (bool-fn f) (seqy s)))

(defn fp-allTrue-fn [s]
  (every? #(= true %) (seqy s)))

(defn fp-anyTrue-fn [s]
  (let [s (seqy s)]
    (if (empty? s)
      false
      (not (nil? (some true? s))))))

(defn fp-allFalse-fn [s]
  (every? false? (seqy s)))

(defn fp-anyFalse-fn [s]
  (let [s (seqy s)]
    (if (empty? s)
      false
      (not (nil? (some false? s))))))

(defn fp-subsetOf-fn [s m]
  (clojure.set/subset? (into #{} (seqy s))
                       (into #{} (seqy m))))

(defn fp-supersetOf-fn [s m]
  (clojure.set/superset? (into #{} (seqy s))
                         (into #{} (seqy m))))

(defn fp-isDistinct-fn [s]
  (let [s (seqy s)]
    (if (empty? s)
      true
      (apply distinct? s))))

(defn fp-distinct-fn [s]
  (distinct (seqy s)))


(defn fp-single-fn [s]
  (if (sequential? s)
    (cond
      (empty? s) nil
      (= 1 (count s)) (first s)
      :else {:$status "error" :$error "Expected single"})
    s))

(defn fp-first-fn [s]
  (first (seqy s)))

(defn fp-last-fn [s]
  (last (seqy s)))

(defn fp-tail-fn [s]
  (rest (seqy s)))

(defn fp-skip-fn [s n]
  (drop (int n) (seqy s)))

(defn fp-union [a b]
  (vec
   (distinct
    (into (seqy a)
          (seqy b)))))

(defn fp-combine-fn [a b]
  (into (seqy a) (seqy b)))


(defn fp-math-op [op a b]
  (let [a (pick-single a)
        b (pick-single b)]
    (cond
      (and  (number? a) (number? b))  (op a b)
      (or (and (sequential? a) (empty? a))
          (and (sequential? b) (empty? b))) []
      (or (nil? a) (nil? b)) []
      (and (= op +) (string? a) (string? b)) (str a b)
      :else (throw (Exception. (str (pr-str a) "  " op  " " (pr-str b) " type missmatch"))))))

(defn fp-* [a b]
  (fp-math-op * a b))

(defn fp-division [a b]
  (when-let [v (fp-math-op / a b)]
    (double v)))

(defn fp-- [a b]
  (fp-math-op - a b))

(defn fp-div [a b]
  (fp-math-op #(int (/ %1 %2)) a b))

(defn fp-mod [a b]
  (fp-math-op mod a b))

(defn fp-+ [a b]
  (fp-math-op + a b))

(defn fp-& [a b]
  (let [a (if (and (sequential? a) (empty? a)) "" a)
        b (if (and (sequential? b) (empty? b)) "" b)]
    (cond
      (and  (string? a) (string? b)) (str a b)
      :else nil)))

(defn fp-iif-fn [s c ok & [ups]]
  (let [cnd (c s)]
    (if (if (boolean? cnd) cnd (if (sequential? cnd) (first cnd) cnd))
      (ok s)
      (when ups (ups s)))))

(defn fp-toInteger-fn [x]
  (let [x (pick-single x)]
    (cond
      (string? x) (Integer/parseInt x)
      (number? x) (int x)
      (boolean? x) (if true 1 0))))

(defn fp-toDecimal-fn [x]
  (let [x (pick-single x)]
    (cond
      (string? x) (Double/parseDouble x)
      (number? x) (double x)
      (boolean? x) (if true 1.0 0))))

(defn fp-toDateTime-fn [x]
  [:todatetime x])

(defn fp-toTime-fn [x]
  [:totime x])

(defn fp-toDate-fn [x]
  [:todate x])

(defn fp-toBoolean-fn [x]
  [:toboolean x])

(defn fp-toString-fn [x]
  (str (pick-single x)))

(defn fp-toString-fn [x]
  (str (pick-single x)))

(defn fp-indexOf-fn [x s]
  (let [x (pick-single x)]
    (when (string? x)
      (let [res (str/index-of x s)]
        (if (nil? res) -1 res)))))


(defn fp-substring-fn [s & [i j]]
  (println :substring i j)
  (let [s (pick-single s)]
    (when (string? s)
      (let [l (count s)]
        (cond
          (and i j)
          (when (and (< -1 i l))
            (subs s i (min l (+ i j))))
          i
          (when (< i l)
            (subs s i))
          :else s)))))

(defn fp-startsWith-fn [s & [ss]]
  (let [s (pick-single s)]
    (when (string? s)
      (when ss
        (str/starts-with? s ss)))))

(defn fp-endsWith-fn [s & [ss]]
  (let [s (pick-single s)]
    (when (string? s)
      (when ss
        (str/ends-with? s ss)))))

(defn fp-upper-fn [s]
  (let [s (pick-single s)]
    (when (string? s)
      (str/upper-case s))))

(defn fp-lower-fn [s]
  (let [s (pick-single s)]
    (when (string? s)
      (str/lower-case s))))



(defn fp-replace-fn [s & [ss r]]
  (let [s (pick-single s)]
    (when (and (string? s) ss r)
      (str/replace s (re-pattern ss) r))))

(defn fp-matches-fn [s & [ss]]
  (let [s (pick-single s)]
    (when (and (string? s) ss)
      [(not (nil? (re-matches (re-pattern ss) s)))])))

(defn fp-replaceMatches-fn [s ss r]
  (let [s (pick-single s)]
    (when (string? s)
      (str/replace s (re-pattern ss) r))))

(defn fp-length-fn [s]
  (let [s (pick-single s)]
    (when (string? s)
      (count s))))

(defn fp-children-fn [s]
  (filterv
   #(not (nil? %))
   (cond (map? s)
         (mapcat seqy (vals s))
         (sequential? s)
         (vec (mapcat #(seqy (fp-children-fn %)) s)))))

(defn fp-descendants-fn [s]
  (let [ch (fp-children-fn s)]
    (into ch (mapcat #(seqy (fp-descendants-fn %)) ch))))

(defn fp-and [a b]
  (cond
    (sequential? b)
    (cond
      (true? a) []
      (false? a) [false]
      (sequential? a) []
      :else a)
    (sequential? a)
    (if (true? b)
      []
      [false])
    :else
    [(and a b)]))

(defn fp-or [a b]
  (cond (sequential? b)
        (cond
          (boolean? a) a
          (sequential? a) []
          :else a)
        (sequential? a)
        (if (true? b) true [])
        :else
        (not (nil? (or a b)))))

(defn fp-xor [a b]
  (cond
    (and (sequential? a) (sequential? b) (empty? a) (empty? b)) []
    (and (sequential? a) (empty? a)) (if b [true] [])
    (and (sequential? b) (empty? b)) (if a [true] [])
    :else
    [(or (and a (not b))
         (and (not a) b))]))

(defn fp-implies [a b]
  (cond
    (sequential? b)
    (cond
      (true? a) []
      (false? a) [true]
      (sequential? a) []
      :else a)
    (sequential? a)
    (if (true? b)
      [true]
      [])
    (false? a)
    [true]
    :else
    [(and a b)]))


(defn fp-trace-fn [x & args] (println :trace x args) x)

(def converters
  {["lbs" "kg"] (fn [lbs] (* lbs 0.45359237))
   ["kgs" "kg"] (fn [k] k)
   ["centimeters" "m"] (fn [c] (/ c 100))
   ["feet" "m"] (fn [feet] (* feet 0.3048))
   ["inches" "m"] (fn [inches] (* inches 0.0254))})

;;TODO: implement ucum
(defn fp-toQuantity-fn [x & [unit]]
  (->> (if (sequential? x) x [x])
       (mapv (fn [x]
               (when unit
                 (let [from (or (get x "unit") (get x :unit))
                       v (or (get x "value") (get x :value))
                       v (and v (if (string? v) (Double/parseDouble v) v))]
                   (if (= from unit)
                     x
                     (do #_(println :conv x [from unit] x "->" v (get converters [from unit]))
                         (if-let [conv (and v (get converters [from unit]))]
                           {:value (conv v) :unit unit}
                           {:error (str "No conversion from " from " to " unit)})))))))))

(defn fp-today-fn [s]
  (.format (java.time.LocalDate/now) java.time.format.DateTimeFormatter/ISO_LOCAL_DATE))

(defn fp-now-fn [s]
  (.format (java.time.ZonedDateTime/now) java.time.format.DateTimeFormatter/ISO_OFFSET_DATE_TIME))


(defn fp-in [el coll]
  (if (nil? el)
    []
    (let [el (pick-single el)]
      [(not (nil? (some #(= % el) (seqy coll))))])))

(defn fp-contains [coll el]
  (if (nil? el)
    []
    (let [el (pick-single el)]
      [(not (nil? (some #(= % el) (seqy coll))))])))

(defn fp-intersect-fn [& args]
  [:intersect args])

(defn fp-exclude-fn [& args]
  [:exclude args])

(defn fp-contains-fn [s ss]
  (let [s (pick-single s)]
    (when (string? s)
      (str/includes? s ss))))

(defn fp-extension-fn [& args]
  [:extension args])

(defn fp-is-fn [& args]
  [:is args])

(defn fp-as-fn [& args]
  [:as args])


;; (fp-descendants {:a [{:e 1 :d 20}] :b 2 :c 3})

;; (fp-descendants {:a [{:b 1 :c [{:d 1}]}]})

(defn parse [s]
  (let [lexer  (FHIRPathLexer. (CharStreams/fromString s))
        tokens (CommonTokenStream. lexer)
        parser (FHIRPathParser. tokens)
        visitor (make-visitor)
        body (.visit visitor (.expression parser))]
    (to-list (into ['fn ['doc '& ['**env]] body]))))

(defn compile [expr]
  (eval (parse expr)))

(defn fp [expr data & [env]]
  ((compile expr) data (assoc (or env {}) :context data)))

;; (parse "Functions.coll1[0].a.take(10).where(use= 'ok').subs(1)")
;; (parse "%var.a")
;; (fp "%varo.a" {} {:varo {:a 1}})
;; (fp "a.b.c" {:a {:b {:c 2}}} {:varo {:a 1}})
;; (fp "((%weight/%height/%height*10 +0.5) div 1)/10" {} {:weight 10 :height 10})
;; (fp "((%weight/%height/%height*10 +0.5) div 1)/10" {} {:weight [10] :height [10]})
;; (parse "((%weight/%height/%height*10 +0.5) div 1)/10")
;; (type (fp "101.99" {}))
;; (fp "Functions.coll1"
;;     {:resourceType "Functions"
;;      :coll1 [{:coll2 [{:attr 1} {:attr 2}]}]})
;; (parse "ok1 xor ok2")
;; (parse "1 != 2")
;; (parse "1 = 2")
;; (parse "1 ~ 2")
;; (parse "1 !~ 2")
 ;; (parse "1 > 2")
