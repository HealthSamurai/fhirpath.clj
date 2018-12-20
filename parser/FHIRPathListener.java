// Generated from FHIRPath.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FHIRPathParser}.
 */
public interface FHIRPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code indexerExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexerExpression(FHIRPathParser.IndexerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexerExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexerExpression(FHIRPathParser.IndexerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code polarityExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPolarityExpression(FHIRPathParser.PolarityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code polarityExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPolarityExpression(FHIRPathParser.PolarityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(FHIRPathParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(FHIRPathParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(FHIRPathParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(FHIRPathParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unionExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnionExpression(FHIRPathParser.UnionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unionExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnionExpression(FHIRPathParser.UnionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(FHIRPathParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(FHIRPathParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(FHIRPathParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(FHIRPathParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code membershipExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMembershipExpression(FHIRPathParser.MembershipExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code membershipExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMembershipExpression(FHIRPathParser.MembershipExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inequalityExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInequalityExpression(FHIRPathParser.InequalityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inequalityExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInequalityExpression(FHIRPathParser.InequalityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invocationExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInvocationExpression(FHIRPathParser.InvocationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invocationExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInvocationExpression(FHIRPathParser.InvocationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(FHIRPathParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(FHIRPathParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code impliesExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImpliesExpression(FHIRPathParser.ImpliesExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code impliesExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImpliesExpression(FHIRPathParser.ImpliesExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTermExpression(FHIRPathParser.TermExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTermExpression(FHIRPathParser.TermExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTypeExpression(FHIRPathParser.TypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeExpression}
	 * labeled alternative in {@link FHIRPathParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTypeExpression(FHIRPathParser.TypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invocationTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void enterInvocationTerm(FHIRPathParser.InvocationTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invocationTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void exitInvocationTerm(FHIRPathParser.InvocationTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void enterLiteralTerm(FHIRPathParser.LiteralTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void exitLiteralTerm(FHIRPathParser.LiteralTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code externalConstantTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void enterExternalConstantTerm(FHIRPathParser.ExternalConstantTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code externalConstantTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void exitExternalConstantTerm(FHIRPathParser.ExternalConstantTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedTerm(FHIRPathParser.ParenthesizedTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedTerm}
	 * labeled alternative in {@link FHIRPathParser#term}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedTerm(FHIRPathParser.ParenthesizedTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(FHIRPathParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(FHIRPathParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(FHIRPathParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(FHIRPathParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(FHIRPathParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(FHIRPathParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(FHIRPathParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(FHIRPathParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dateTimeLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDateTimeLiteral(FHIRPathParser.DateTimeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dateTimeLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDateTimeLiteral(FHIRPathParser.DateTimeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTimeLiteral(FHIRPathParser.TimeLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTimeLiteral(FHIRPathParser.TimeLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quantityLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterQuantityLiteral(FHIRPathParser.QuantityLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantityLiteral}
	 * labeled alternative in {@link FHIRPathParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitQuantityLiteral(FHIRPathParser.QuantityLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#externalConstant}.
	 * @param ctx the parse tree
	 */
	void enterExternalConstant(FHIRPathParser.ExternalConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#externalConstant}.
	 * @param ctx the parse tree
	 */
	void exitExternalConstant(FHIRPathParser.ExternalConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberInvocation}
	 * labeled alternative in {@link FHIRPathParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterMemberInvocation(FHIRPathParser.MemberInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberInvocation}
	 * labeled alternative in {@link FHIRPathParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitMemberInvocation(FHIRPathParser.MemberInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionInvocation}
	 * labeled alternative in {@link FHIRPathParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(FHIRPathParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionInvocation}
	 * labeled alternative in {@link FHIRPathParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(FHIRPathParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisInvocation}
	 * labeled alternative in {@link FHIRPathParser#invocation}.
	 * @param ctx the parse tree
	 */
	void enterThisInvocation(FHIRPathParser.ThisInvocationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisInvocation}
	 * labeled alternative in {@link FHIRPathParser#invocation}.
	 * @param ctx the parse tree
	 */
	void exitThisInvocation(FHIRPathParser.ThisInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#functn}.
	 * @param ctx the parse tree
	 */
	void enterFunctn(FHIRPathParser.FunctnContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#functn}.
	 * @param ctx the parse tree
	 */
	void exitFunctn(FHIRPathParser.FunctnContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(FHIRPathParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(FHIRPathParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#quantity}.
	 * @param ctx the parse tree
	 */
	void enterQuantity(FHIRPathParser.QuantityContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#quantity}.
	 * @param ctx the parse tree
	 */
	void exitQuantity(FHIRPathParser.QuantityContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(FHIRPathParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(FHIRPathParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#dateTimePrecision}.
	 * @param ctx the parse tree
	 */
	void enterDateTimePrecision(FHIRPathParser.DateTimePrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#dateTimePrecision}.
	 * @param ctx the parse tree
	 */
	void exitDateTimePrecision(FHIRPathParser.DateTimePrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#pluralDateTimePrecision}.
	 * @param ctx the parse tree
	 */
	void enterPluralDateTimePrecision(FHIRPathParser.PluralDateTimePrecisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#pluralDateTimePrecision}.
	 * @param ctx the parse tree
	 */
	void exitPluralDateTimePrecision(FHIRPathParser.PluralDateTimePrecisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(FHIRPathParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(FHIRPathParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedIdentifier(FHIRPathParser.QualifiedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#qualifiedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedIdentifier(FHIRPathParser.QualifiedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FHIRPathParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(FHIRPathParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FHIRPathParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(FHIRPathParser.IdentifierContext ctx);
}