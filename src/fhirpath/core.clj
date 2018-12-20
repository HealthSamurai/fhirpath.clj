(ns fhirpath.core
  (:import FHIRPathParser
           FHIRPathLexer
           FHIRPathBaseVisitor
           FHIRPathVisitor
           [org.antlr.v4.runtime CharStreams CommonTokenStream]
           [org.antlr.v4.runtime.tree ParseTreeWalker])
  (:require [clojure.string :as str]))


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
      (to-list ['fhirpath.core/fp-nth
                (first (proxy-super visitChildren (.expression ctx 0)))
                (first (proxy-super visitChildren (.expression ctx 1)))])

      )

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
        (if (= fn-name :where)
          (to-list ['fhirpath.core/fp-where (to-list ['fn ['doc] (ffirst params)])])
          (to-list (into [(symbol (str "fhirpath.core/fp-" (name fn-name)))] (first params))))))

    (visitParamList [^FHIRPathParser$ParamListContext ctx]
      (proxy-super visitChildren ctx))


    (visitFunctn [^FHIRPathParser$FunctnContext ctx]
      (proxy-super visitChildren ctx))

    ;; (visitImpliesExpression [^FHIRPathParser$ImpliesExpressionContext ctx])
    ;; (visitInequalityExpression [^FHIRPathParser$InequalityExpressionContext ctx])
    ;; (visitMultiplicativeExpression [^FHIRPathParser$MultiplicativeExpressionContext ctx])
    ;; (visitNullLiteral [^FHIRPathParser$NullLiteralContext ctx])

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
    ;; (visitThisInvocation [^FHIRPathParser$ThisInvocationContext ctx])
    ;; (visitTimeLiteral [^FHIRPathParser$TimeLiteralContext ctx])
    ;; (visitTypeExpression [^FHIRPathParser$TypeExpressionContext ctx])
    ;; (visitTypeSpecifier [^FHIRPathParser$TypeSpecifierContext ctx])
    ;; (visitUnionExpression [^FHIRPathParser$UnionExpressionContext ctx])
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
    (get subj k)))

(defn fp-eq [a b]
  (= a b))

(defn fp-subs [s a b]
  (subs s (int a) (int b)))

(defn fp-where [s f]
  (filter f s))

(defn fp-nth [s n]
  (get s (int n)))


(defn compile [expr]
  (eval (parse expr)))

(defn fp [expr data]
  ((compile expr) data))

(parse "a.b[0]")

;; public T visitChildren(RuleNode node) {
;;                                        System.out.println(node.getClass().getSimpleName() + " " + node.getText());
;;                                        return super.visitChildren(node);
;;                                        }


