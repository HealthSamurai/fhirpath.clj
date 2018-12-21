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

(defn- make-visitor []
  (proxy [FHIRPathBaseVisitor] []
    (aggregateResult [a b]
      (->> (conj (if (sequential? a) a [a]) b)
           (filterv #(not (nil? %)))))

    (visitInvocationExpression [^FHIRPathParser$InvocationExpressionContext ctx]
      (to-list (into ['->] (proxy-super visitChildren ctx))))

    (visitInvocationTerm [^FHIRPathParser$InvocationTermContext ctx]
      (to-list (into ['-> 'doc] (proxy-super visitChildren ctx))))

    (visitMemberInvocation [^FHIRPathParser$MemberInvocationContext ctx]
      (to-list (into ['fhirpath.core/fp-get] (proxy-super visitChildren ctx))))


    (visitIdentifier [^FHIRPathParser$IdentifierContext ctx]
      (keyword (.getText ctx)))


    (visitTermExpression [^FHIRPathParser$TermExpressionContext ctx]
      (first (seqy (proxy-super visitChildren ctx))))

    (visitIndexerExpression [^FHIRPathParser$IndexerExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-nth]  (proxy-super visitChildren ctx))))

    (visitLiteralTerm [^FHIRPathParser$LiteralTermContext ctx]
      (first (seqy (proxy-super visitChildren ctx))))

    (visitEqualityExpression [^FHIRPathParser$EqualityExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-eq] (proxy-super visitChildren ctx))))

    (visitAndExpression [^FHIRPathParser$AndExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-and] (proxy-super visitChildren ctx))))

    (visitFunctionInvocation [^FHIRPathParser$FunctionInvocationContext ctx]
      (let [[fn-name & params :as call] (first (proxy-super visitChildren ctx))]
        (cond
          (contains? #{:ofType} fn-name)
          (to-list [(symbol (str "fhirpath.core/fp-" (name fn-name)))
                    (last (last (ffirst params)))])


          (contains? #{:iif} fn-name)
          (if-let [lambdas  (mapv (fn [l] (to-list ['fn ['doc] l])) (first params))]
            (to-list (into [(symbol (str "fhirpath.core/fp-" (name fn-name)))] lambdas))
            (to-list [(symbol (str "fhirpath.core/fp-" (name fn-name)))]))
          (contains? #{:where :select :repeat :exists :all} fn-name)
          (if-let [lambda  (ffirst params)]
            (to-list [(symbol (str "fhirpath.core/fp-" (name fn-name)))
                      (to-list ['fn ['doc] lambda])])
            (to-list [(symbol (str "fhirpath.core/fp-" (name fn-name)))]))
          :else
          (to-list (into [(symbol (str "fhirpath.core/fp-" (name fn-name)))] (first params))))))

    (visitParamList [^FHIRPathParser$ParamListContext ctx]
      (proxy-super visitChildren ctx))


    (visitFunctn [^FHIRPathParser$FunctnContext ctx]
      (proxy-super visitChildren ctx))

    (visitImpliesExpression [^FHIRPathParser$ImpliesExpressionContext ctx]
      (assert false))

    (visitMembershipExpression [^FHIRPathParser$MembershipExpressionContext ctx]
      (assert false))

    (visitAdditiveExpression [^FHIRPathParser$AdditiveExpressionContext ctx]
      (to-list
       (into [(symbol (str "fhirpath.core/fp-" (.getText (.getChild ctx 1))))]
             (proxy-super visitChildren ctx))))

    (visitMultiplicativeExpression [^FHIRPathParser$MultiplicativeExpressionContext ctx]
      (let [op (.getText (.getChild ctx 1))
            op (if (= op "/") "division" op)]
        (to-list
         (into [(symbol (str "fhirpath.core/fp-" op))]
               (proxy-super visitChildren ctx)))))

    (visitNullLiteral [^FHIRPathParser$NullLiteralContext ctx]
      nil)

    (visitInequalityExpression [^FHIRPathParser$InequalityExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-ineq
                      (symbol (.getText (.getChild ctx 1)))]
                     (proxy-super visitChildren ctx))))

    (visitNumberLiteral [^FHIRPathParser$NumberLiteralContext ctx]
      (read-string (.getText (.NUMBER ctx))))

    (visitBooleanLiteral [^FHIRPathParser$BooleanLiteralContext ctx]
      (= "true" (.getText ctx)))

    (visitStringLiteral [^FHIRPathParser$StringLiteralContext ctx]
      (str/replace (.getText (.STRING ctx))
                   #"(^'|'$)" ""))

    (visitThisInvocation [^FHIRPathParser$ThisInvocationContext ctx]
      'identity)

    (visitUnionExpression [^FHIRPathParser$UnionExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-union] (proxy-super visitChildren ctx))))

    (visitExternalConstantTerm [^FHIRPathParser$ExternalConstantTermContext ctx]
      ;; (to-list (into ['fhirpath.core/fp-union] (proxy-super visitChildren ctx)))
      (let [var (keyword (subs (.getText ctx) 1))]
        (list 'get '**env var)))

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
      (assert false))

    (visitParenthesizedTerm [^FHIRPathParser$ParenthesizedTermContext ctx]
      (assert false))


    ))

(defn fp-take [subj num]
  (take (int num) subj))

(defn fp-get [subj k]
  (if (sequential? subj)
    (->> subj
         (reduce (fn [acc x]
                   (let [res (and (get x k))]
                     (if (sequential? res)
                       (into acc res)
                       (if (not (nil? res))
                         (conj acc res)
                         acc)))) []))
    (or (get subj k)
        (when (= (:resourceType subj) (name k))
          subj))))

(defn fp-eq [a b]
  (cond
    (and (number? a) (number? b))
    (= (double b) (double a))
    :else (= a b)))

(defn fp-subs [s a b]
  (subs s (int a) (int b)))

(defn fp-where [s f]
  (filter f s))

(defn fp-select [s f]
  (reduce (fn [acc x]
            (let [res (f x)]
              (if (sequential? res)
                (into acc res)
                (if (nil? res)
                  acc
                  (conj acc res)))
              )) []
          (if (sequential? s) s [s])))

(defn fp-count [s]
  (count s))

(defn fp-repeat [s f]
  (let [init (fp-select s f)]
    (loop [res init 
           work init]
      (let [more (fp-select work f)]
        (if (and more (empty? more))
          res
          (recur (into res more) more))))))

(defn fp-ofType [s tp]
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
  (if (and (number? a) (number? b))
    (op a b)
    false))

(defn fp-empty [s]
  (if (sequential? s)
    (empty? s)
    (if (nil? s)
      true false)))



(defn fp-not [s]
  (if (sequential? s)
    (if (empty? s)
      []
      (let [val (and (= (count s) 1) (first s))]
        (if (boolean? s) (not s)
            false)))
    (not s)))

(defn fp-exists [s & [f]]
  (if f
    (fp-exists (fp-where s f))
    (not (empty? (seqy s)))))

(defn fp-all [s f]
  (every? f (if (sequential? s) s (if (nil? s) [] [s]))))

(defn fp-allTrue [s]
  (every? #(= true %) (if (sequential? s) s (if (nil? s) [] [s]))))

(defn fp-anyTrue [s]
  (let [s (seqy s)]
    (if (empty? s)
      false
      (not (nil? (some true? s))))))

(defn fp-allFalse [s]
  (every? false? (seqy s)))

(defn fp-anyFalse [s]
  (let [s (seqy s)]
    (if (empty? s)
      false
      (not (nil? (some false? s))))))

(defn fp-subsetOf [s m]
  (clojure.set/subset? (into #{} (seqy s))
                       (into #{} (seqy m))))

(defn fp-supersetOf [s m]
  (clojure.set/superset? (into #{} (seqy s))
                         (into #{} (seqy m))))



(defn fp-isDistinct [s]
  (let [s (seqy s)]
    (if (empty? s)
      true
      (apply distinct? (seqy s)))))

(defn fp-distinct [s]
  (into [] (distinct (seqy s))))

(defn fp-single [s]
  (if (sequential? s)
    (cond
      (empty? s) nil
      (= 1 (count s)) (first s)
      :else {:$status "error" :$error "Expected single"})
    s))

(defn fp-first [s]
  (first (seqy s)))

(defn fp-last [s]
  (last (seqy s)))

(defn fp-tail [s]
  (rest (seqy s)))

(defn fp-skip [s n]
  (drop (int n) (seqy s)))

(defn fp-union [a b]
  (vec
   (distinct
    (into (seqy a)
          (seqy b)))))

(defn fp-combine [a b]
  (into (seqy a) (seqy b)))


(defn fp-* [a b]
  (cond
    (and  (number? a) (number? b)) (* a b)
    :else nil))

(defn fp-division
  [a b]
  (cond
    (and  (number? a) (number? b)) (/ (double a) b)
    :else nil))

(defn fp-+ [a b]
  (cond
    (and  (number? a) (number? b)) (+ a b)
    (and  (string? a) (string? b)) (str a b)
    :else nil))

(defn fp-& [a b]
  (let [a (if (and (sequential? a) (empty? a)) "" a)
        b (if (and (sequential? b) (empty? b)) "" b)]
    (cond
      (and  (string? a) (string? b)) (str a b)
      :else nil)))

(defn fp-- [a b]
  (cond
    (and  (number? a) (number? b)) (- a b)
    :else nil))

(defn fp-div [a b]
  (cond
    (and  (number? a) (number? b)) (int (/ a b))
    :else nil))

(defn fp-mod [a b]
  (cond
    (and  (number? a) (number? b)) (mod a b)
    :else nil))

(defn fp-iif [s c ok & [ups]]
  (if (c s) (ok s) (when ups (ups s))))

(defn fp-toInteger [x]
  (cond
    (string? x) (Integer/parseInt x)
    (number? x) (int x)
    (boolean? x) (if true 1 0)))

(defn fp-toDecimal [x]
  (cond
    (string? x) (Double/parseDouble x)
    (number? x) (double x)
    (boolean? x) (if true 1.0 0)))

(defn fp-toString [x]
  (str x))

(defn singl [x]
  (if (sequential? x) (first x) x))

(defn fp-indexOf [x s]
  (let [x (singl x)]
    (when (string? x)
      (let [res (str/index-of x s)]
        (if (nil? res) -1 res)))))

(defn parse [s]
  (let [lexer  (FHIRPathLexer. (CharStreams/fromString s))
        tokens (CommonTokenStream. lexer)
        parser (FHIRPathParser. tokens)
        visitor (make-visitor)
        body (.visit visitor (.expression parser))]
    (to-list (into ['fn ['doc '& ['**env]] body]))))

(defn compile [expr]
  (eval (parse expr)))

(defn fp-substring [s & [i j]]
  (let [s (singl s)]
    (when (string? s)
      (if (and i j)
        (when (and (< i j) (let [l (count s)] (and (< -1 i l) (< -1 (+ i j) l))))
          (subs s i (+ i j)))
        (when (< i (count s))
          (subs s i)))))
  #_(try
    
    (catch Exception e
      (assert false (pr-str e s i j)))))
(defn fp-startsWith [s ss]
  (let [s (singl s)]
    (when (string? s)
      (str/starts-with? s ss))))

(defn fp-endsWith [s ss]
  (let [s (singl s)]
    (when (string? s)
      (str/ends-with? s ss))))

(defn fp-contains [s ss]
  (let [s (singl s)]
    (when (string? s)
      (str/includes? s ss))))

(defn fp-replace [s ss r]
  (let [s (singl s)]
    (when (string? s)
      (str/replace s ss r))))

(defn fp-matches [s ss]
  (let [s (singl s)]
    (when (string? s)
      (not (nil? (re-matches (re-pattern ss) s))))))

(defn fp-replaceMatches [s ss r]
  (let [s (singl s)]
    (when (string? s)
      (str/replace s (re-pattern ss) r))))

(defn fp-length [s]
  (let [s (singl s)]
    (when (string? s)
      (count s))))

(defn fp-children [s]
  (filterv
   #(not (nil? %))
   (cond (map? s)
         (mapcat seqy (vals s))
         (sequential? s)
         (vec (mapcat #(seqy (fp-children %)) s)))))

(defn fp-descendants [s]
  (let [ch (fp-children s)]
    (into ch (mapcat #(seqy (fp-descendants %)) ch))))

(fp-descendants {:a [{:e 1 :d 20}] :b 2 :c 3})

(fp-descendants {:a [{:b 1 :c [{:d 1}]}]})

(defn fp [expr data & [env]]
  (if env
    ((compile expr) data env)
    ((compile expr) data)))


(parse "Functions.coll1[0].a.take(10).where(use= 'ok').subs(1)")

;; (type (fp "101.99" {}))

;; (fp "Functions.coll1"
;;     {:resourceType "Functions"
;;      :coll1 [{:coll2 [{:attr 1} {:attr 2}]}]})


