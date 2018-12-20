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

(defn- make-visitor []
  (proxy [FHIRPathBaseVisitor] []
    (aggregateResult [a b]
      (->> (conj (if (sequential? a) a [a]) b)
           (filterv identity)))

    (visitInvocationExpression [^FHIRPathParser$InvocationExpressionContext ctx]
      (to-list (into ['->] (proxy-super visitChildren ctx))))

    (visitInvocationTerm [^FHIRPathParser$InvocationTermContext ctx]
      (to-list (into ['-> 'doc] (proxy-super visitChildren ctx))))

    (visitMemberInvocation [^FHIRPathParser$MemberInvocationContext ctx]
      (to-list (into ['fhirpath.core/fp-get] (proxy-super visitChildren ctx))))


    (visitIdentifier [^FHIRPathParser$IdentifierContext ctx]
      (keyword (.getText (.getSymbol (.IDENTIFIER ctx)))))


    (visitTermExpression [^FHIRPathParser$TermExpressionContext ctx]
      (first (proxy-super visitChildren ctx)))

    (visitIndexerExpression [^FHIRPathParser$IndexerExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-nth]  (proxy-super visitChildren ctx))))

    (visitMembershipExpression [^FHIRPathParser$MembershipExpressionContext ctx]
      [:member (proxy-super visitChildren ctx)]
      )

    (visitLiteralTerm [^FHIRPathParser$LiteralTermContext ctx]
      (first (proxy-super visitChildren ctx)))


    (visitEqualityExpression [^FHIRPathParser$EqualityExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-eq] (proxy-super visitChildren ctx)))

      )
    ;; (visitAdditiveExpression [^FHIRPathParser$AdditiveExpressionContext ctx])
    ;; (visitAndExpression [^FHIRPathParser$AndExpressionContext ctx])
    ;; (visitBooleanLiteral [^FHIRPathParser$BooleanLiteralContext ctx])
    ;; (visitDateTimeLiteral [^FHIRPathParser$DateTimeLiteralContext ctx])
    ;; (visitDateTimePrecision [^FHIRPathParser$DateTimePrecisionContext ctx])
    ;; (visitEqualityExpression [^FHIRPathParser$EqualityExpressionContext ctx])
    ;; (visitExternalConstantTerm [^FHIRPathParser$ExternalConstantTermContext ctx])

    (visitFunctionInvocation [^FHIRPathParser$FunctionInvocationContext ctx]
      (let [[fn-name & params :as call] (first (proxy-super visitChildren ctx))]
        (cond
          (contains? #{:ofType} fn-name)
          (to-list [(symbol (str "fhirpath.core/fp-" (name fn-name)))
                    (last (last (ffirst params)))])

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

    ;; (visitImpliesExpression [^FHIRPathParser$ImpliesExpressionContext ctx])
    ;; (visitMultiplicativeExpression [^FHIRPathParser$MultiplicativeExpressionContext ctx])
    ;; (visitNullLiteral [^FHIRPathParser$NullLiteralContext ctx])

    (visitInequalityExpression [^FHIRPathParser$InequalityExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-ineq
                      (symbol (.getText (.getChild ctx 1)))]
                     (proxy-super visitChildren ctx))))

    (visitNumberLiteral [^FHIRPathParser$NumberLiteralContext ctx]
      (Float/parseFloat (.getText (.NUMBER ctx))))
    ;; (visitOrExpression [^FHIRPathParser$OrExpressionContext ctx])

    (visitParenthesizedTerm [^FHIRPathParser$ParenthesizedTermContext ctx]
      [:parent (proxy-super visitChildren ctx)]
      )
    ;; (visitPluralDateTimePrecision [^FHIRPathParser$PluralDateTimePrecisionContext ctx])
    ;; (visitPolarityExpression [^FHIRPathParser$PolarityExpressionContext ctx])
    ;; (visitQualifiedIdentifier [^FHIRPathParser$QualifiedIdentifierContext ctx])
    ;; (visitQuantity [^FHIRPathParser$QuantityContext ctx])
    ;; (visitQuantityLiteral [^FHIRPathParser$QuantityLiteralContext ctx])

    (visitStringLiteral [^FHIRPathParser$StringLiteralContext ctx]
      (str/replace (.getText (.STRING ctx))
                   #"(^'|'$)" ""))
    (visitThisInvocation [^FHIRPathParser$ThisInvocationContext ctx]
      'identity
      )
    
    ;; (visitTimeLiteral [^FHIRPathParser$TimeLiteralContext ctx])
    ;; (visitTypeExpression [^FHIRPathParser$TypeExpressionContext ctx])
    ;; (visitTypeSpecifier [^FHIRPathParser$TypeSpecifierContext ctx])

    (visitUnionExpression [^FHIRPathParser$UnionExpressionContext ctx]
      (to-list (into ['fhirpath.core/fp-union] (proxy-super visitChildren ctx)))
      )

    ;; (visitUnit [^FHIRPathParser$UnitContext ctx])

    ))

(defn parse [s]
  (let [lexer  (FHIRPathLexer. (CharStreams/fromString s))
        tokens (CommonTokenStream. lexer)
        parser (FHIRPathParser. tokens)
        visitor (make-visitor)]
    (to-list (into ['fn ['doc] (.visit visitor (.expression parser))]))))

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
  (= a b))

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

(defn seqy [s]
  (if (sequential? s) s (if (nil? s) [] [s])))


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


(defn compile [expr]
  (eval (parse expr)))

(defn fp [expr data]
  ((compile expr) data))

(defn fp-ineq [op a b]
  (if (and (number? a) (number? b))
    (op a b)
    false))

(defn fp-union [a b]
  (dedupe
   (into (or a []) b)))

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
  (println ">>>>subsetof"
           (into #{} (seqy s))
           (into #{} (seqy m)))
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
  (dedupe (seqy s)))

;; (parse "a.exists(a = 1)")
;; (parse "Functions.coll1[0]")

;; (fp "Functions.coll1"
;;     {:resourceType "Functions"
;;      :coll1 [{:coll2 [{:attr 1} {:attr 2}]}]})


