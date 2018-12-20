// Generated from FHIRPath.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FHIRPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		DATETIME=53, TIME=54, IDENTIFIER=55, QUOTEDIDENTIFIER=56, STRING=57, NUMBER=58, 
		WS=59, COMMENT=60, LINE_COMMENT=61;
	public static final int
		RULE_expression = 0, RULE_term = 1, RULE_literal = 2, RULE_externalConstant = 3, 
		RULE_invocation = 4, RULE_functn = 5, RULE_paramList = 6, RULE_quantity = 7, 
		RULE_unit = 8, RULE_dateTimePrecision = 9, RULE_pluralDateTimePrecision = 10, 
		RULE_typeSpecifier = 11, RULE_qualifiedIdentifier = 12, RULE_identifier = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression", "term", "literal", "externalConstant", "invocation", "functn", 
			"paramList", "quantity", "unit", "dateTimePrecision", "pluralDateTimePrecision", 
			"typeSpecifier", "qualifiedIdentifier", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'['", "']'", "'+'", "'-'", "'*'", "'/'", "'div'", "'mod'", 
			"'&'", "'|'", "'<='", "'<'", "'>'", "'>='", "'is'", "'as'", "'='", "'~'", 
			"'!='", "'!~'", "'in'", "'contains'", "'and'", "'or'", "'xor'", "'implies'", 
			"'('", "')'", "'{'", "'}'", "'true'", "'false'", "'%'", "'$this'", "','", 
			"'year'", "'month'", "'week'", "'day'", "'hour'", "'minute'", "'second'", 
			"'millisecond'", "'years'", "'months'", "'weeks'", "'days'", "'hours'", 
			"'minutes'", "'seconds'", "'milliseconds'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "DATETIME", "TIME", "IDENTIFIER", "QUOTEDIDENTIFIER", 
			"STRING", "NUMBER", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FHIRPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FHIRPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IndexerExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IndexerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterIndexerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitIndexerExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitIndexerExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PolarityExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PolarityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterPolarityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitPolarityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitPolarityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AdditiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicativeExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UnionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterUnionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitUnionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitUnionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MembershipExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MembershipExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterMembershipExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitMembershipExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitMembershipExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InequalityExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InequalityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterInequalityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitInequalityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitInequalityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvocationExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public InvocationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterInvocationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitInvocationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitInvocationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImpliesExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ImpliesExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterImpliesExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitImpliesExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitImpliesExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermExpressionContext extends ExpressionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterTermExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitTermExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitTermExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TypeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterTypeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitTypeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitTypeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
			case T__16:
			case T__22:
			case T__27:
			case T__29:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case DATETIME:
			case TIME:
			case IDENTIFIER:
			case QUOTEDIDENTIFIER:
			case STRING:
			case NUMBER:
				{
				_localctx = new TermExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(29);
				term();
				}
				break;
			case T__3:
			case T__4:
				{
				_localctx = new PolarityExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(31);
				expression(11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(34);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(35);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(36);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(37);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(38);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__9))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(39);
						expression(10);
						}
						break;
					case 3:
						{
						_localctx = new UnionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(40);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(41);
						match(T__10);
						setState(42);
						expression(9);
						}
						break;
					case 4:
						{
						_localctx = new InequalityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(43);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(44);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(45);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(46);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(47);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(48);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new MembershipExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(49);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(50);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(51);
						expression(5);
						}
						break;
					case 7:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(52);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(53);
						match(T__23);
						setState(54);
						expression(4);
						}
						break;
					case 8:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(55);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(56);
						_la = _input.LA(1);
						if ( !(_la==T__24 || _la==T__25) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(57);
						expression(3);
						}
						break;
					case 9:
						{
						_localctx = new ImpliesExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(58);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(59);
						match(T__26);
						setState(60);
						expression(2);
						}
						break;
					case 10:
						{
						_localctx = new InvocationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(61);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(62);
						match(T__0);
						setState(63);
						invocation();
						}
						break;
					case 11:
						{
						_localctx = new IndexerExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(64);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(65);
						match(T__1);
						setState(66);
						expression(0);
						setState(67);
						match(T__2);
						}
						break;
					case 12:
						{
						_localctx = new TypeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(69);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(70);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(71);
						typeSpecifier();
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExternalConstantTermContext extends TermContext {
		public ExternalConstantContext externalConstant() {
			return getRuleContext(ExternalConstantContext.class,0);
		}
		public ExternalConstantTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterExternalConstantTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitExternalConstantTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitExternalConstantTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralTermContext extends TermContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterLiteralTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitLiteralTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitLiteralTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedTermContext extends TermContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterParenthesizedTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitParenthesizedTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitParenthesizedTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvocationTermContext extends TermContext {
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
		}
		public InvocationTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterInvocationTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitInvocationTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitInvocationTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_term);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
			case T__16:
			case T__22:
			case T__34:
			case IDENTIFIER:
			case QUOTEDIDENTIFIER:
				_localctx = new InvocationTermContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				invocation();
				}
				break;
			case T__29:
			case T__31:
			case T__32:
			case DATETIME:
			case TIME:
			case STRING:
			case NUMBER:
				_localctx = new LiteralTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				literal();
				}
				break;
			case T__33:
				_localctx = new ExternalConstantTermContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				externalConstant();
				}
				break;
			case T__27:
				_localctx = new ParenthesizedTermContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				match(T__27);
				setState(81);
				expression(0);
				setState(82);
				match(T__28);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TimeLiteralContext extends LiteralContext {
		public TerminalNode TIME() { return getToken(FHIRPathParser.TIME, 0); }
		public TimeLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterTimeLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitTimeLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitTimeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLiteralContext extends LiteralContext {
		public NullLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DateTimeLiteralContext extends LiteralContext {
		public TerminalNode DATETIME() { return getToken(FHIRPathParser.DATETIME, 0); }
		public DateTimeLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterDateTimeLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitDateTimeLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitDateTimeLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode STRING() { return getToken(FHIRPathParser.STRING, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends LiteralContext {
		public BooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralContext extends LiteralContext {
		public TerminalNode NUMBER() { return getToken(FHIRPathParser.NUMBER, 0); }
		public NumberLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QuantityLiteralContext extends LiteralContext {
		public QuantityContext quantity() {
			return getRuleContext(QuantityContext.class,0);
		}
		public QuantityLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterQuantityLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitQuantityLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitQuantityLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_literal);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(T__29);
				setState(87);
				match(T__30);
				}
				break;
			case 2:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				_la = _input.LA(1);
				if ( !(_la==T__31 || _la==T__32) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new NumberLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				match(NUMBER);
				}
				break;
			case 5:
				_localctx = new DateTimeLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(91);
				match(DATETIME);
				}
				break;
			case 6:
				_localctx = new TimeLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(92);
				match(TIME);
				}
				break;
			case 7:
				_localctx = new QuantityLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(93);
				quantity();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExternalConstantContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExternalConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterExternalConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitExternalConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitExternalConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExternalConstantContext externalConstant() throws RecognitionException {
		ExternalConstantContext _localctx = new ExternalConstantContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_externalConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__33);
			setState(97);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvocationContext extends ParserRuleContext {
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
	 
		public InvocationContext() { }
		public void copyFrom(InvocationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ThisInvocationContext extends InvocationContext {
		public ThisInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterThisInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitThisInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitThisInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionInvocationContext extends InvocationContext {
		public FunctnContext functn() {
			return getRuleContext(FunctnContext.class,0);
		}
		public FunctionInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterFunctionInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitFunctionInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitFunctionInvocation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberInvocationContext extends InvocationContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MemberInvocationContext(InvocationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterMemberInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitMemberInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitMemberInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_invocation);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new MemberInvocationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				identifier();
				}
				break;
			case 2:
				_localctx = new FunctionInvocationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				functn();
				}
				break;
			case 3:
				_localctx = new ThisInvocationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				match(T__34);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctnContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterFunctn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitFunctn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitFunctn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctnContext functn() throws RecognitionException {
		FunctnContext _localctx = new FunctnContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			identifier();
			setState(105);
			match(T__27);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__15) | (1L << T__16) | (1L << T__22) | (1L << T__27) | (1L << T__29) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << DATETIME) | (1L << TIME) | (1L << IDENTIFIER) | (1L << QUOTEDIDENTIFIER) | (1L << STRING) | (1L << NUMBER))) != 0)) {
				{
				setState(106);
				paramList();
				}
			}

			setState(109);
			match(T__28);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			expression(0);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(112);
				match(T__35);
				setState(113);
				expression(0);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantityContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(FHIRPathParser.NUMBER, 0); }
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public QuantityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterQuantity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitQuantity(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitQuantity(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantityContext quantity() throws RecognitionException {
		QuantityContext _localctx = new QuantityContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_quantity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(NUMBER);
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(120);
				unit();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitContext extends ParserRuleContext {
		public DateTimePrecisionContext dateTimePrecision() {
			return getRuleContext(DateTimePrecisionContext.class,0);
		}
		public PluralDateTimePrecisionContext pluralDateTimePrecision() {
			return getRuleContext(PluralDateTimePrecisionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(FHIRPathParser.STRING, 0); }
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unit);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				dateTimePrecision();
				}
				break;
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				pluralDateTimePrecision();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(125);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DateTimePrecisionContext extends ParserRuleContext {
		public DateTimePrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateTimePrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterDateTimePrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitDateTimePrecision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitDateTimePrecision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateTimePrecisionContext dateTimePrecision() throws RecognitionException {
		DateTimePrecisionContext _localctx = new DateTimePrecisionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dateTimePrecision);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PluralDateTimePrecisionContext extends ParserRuleContext {
		public PluralDateTimePrecisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pluralDateTimePrecision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterPluralDateTimePrecision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitPluralDateTimePrecision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitPluralDateTimePrecision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PluralDateTimePrecisionContext pluralDateTimePrecision() throws RecognitionException {
		PluralDateTimePrecisionContext _localctx = new PluralDateTimePrecisionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pluralDateTimePrecision);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public QualifiedIdentifierContext qualifiedIdentifier() {
			return getRuleContext(QualifiedIdentifierContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			qualifiedIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedIdentifierContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterQualifiedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitQualifiedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitQualifiedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedIdentifierContext qualifiedIdentifier() throws RecognitionException {
		QualifiedIdentifierContext _localctx = new QualifiedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_qualifiedIdentifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			identifier();
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(135);
					match(T__0);
					setState(136);
					identifier();
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FHIRPathParser.IDENTIFIER, 0); }
		public TerminalNode QUOTEDIDENTIFIER() { return getToken(FHIRPathParser.QUOTEDIDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FHIRPathListener ) ((FHIRPathListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FHIRPathVisitor ) return ((FHIRPathVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__22) | (1L << IDENTIFIER) | (1L << QUOTEDIDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		case 9:
			return precpred(_ctx, 13);
		case 10:
			return precpred(_ctx, 12);
		case 11:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u0093\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\5\2#\n\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3W\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4a\n\4\3\5\3\5\3\5\3\6\3\6\3\6\5\6i\n"+
		"\6\3\7\3\7\3\7\5\7n\n\7\3\7\3\7\3\b\3\b\3\b\7\bu\n\b\f\b\16\bx\13\b\3"+
		"\t\3\t\5\t|\n\t\3\n\3\n\3\n\5\n\u0081\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\16\7\16\u008c\n\16\f\16\16\16\u008f\13\16\3\17\3\17\3\17\2"+
		"\3\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\16\3\2\6\7\3\2\b\13\4\2"+
		"\6\7\f\f\3\2\16\21\3\2\24\27\3\2\30\31\3\2\33\34\3\2\22\23\3\2\"#\3\2"+
		"\'.\3\2/\66\5\2\22\23\31\319:\2\u00a2\2\"\3\2\2\2\4V\3\2\2\2\6`\3\2\2"+
		"\2\bb\3\2\2\2\nh\3\2\2\2\fj\3\2\2\2\16q\3\2\2\2\20y\3\2\2\2\22\u0080\3"+
		"\2\2\2\24\u0082\3\2\2\2\26\u0084\3\2\2\2\30\u0086\3\2\2\2\32\u0088\3\2"+
		"\2\2\34\u0090\3\2\2\2\36\37\b\2\1\2\37#\5\4\3\2 !\t\2\2\2!#\5\2\2\r\""+
		"\36\3\2\2\2\" \3\2\2\2#L\3\2\2\2$%\f\f\2\2%&\t\3\2\2&K\5\2\2\r\'(\f\13"+
		"\2\2()\t\4\2\2)K\5\2\2\f*+\f\n\2\2+,\7\r\2\2,K\5\2\2\13-.\f\t\2\2./\t"+
		"\5\2\2/K\5\2\2\n\60\61\f\7\2\2\61\62\t\6\2\2\62K\5\2\2\b\63\64\f\6\2\2"+
		"\64\65\t\7\2\2\65K\5\2\2\7\66\67\f\5\2\2\678\7\32\2\28K\5\2\2\69:\f\4"+
		"\2\2:;\t\b\2\2;K\5\2\2\5<=\f\3\2\2=>\7\35\2\2>K\5\2\2\4?@\f\17\2\2@A\7"+
		"\3\2\2AK\5\n\6\2BC\f\16\2\2CD\7\4\2\2DE\5\2\2\2EF\7\5\2\2FK\3\2\2\2GH"+
		"\f\b\2\2HI\t\t\2\2IK\5\30\r\2J$\3\2\2\2J\'\3\2\2\2J*\3\2\2\2J-\3\2\2\2"+
		"J\60\3\2\2\2J\63\3\2\2\2J\66\3\2\2\2J9\3\2\2\2J<\3\2\2\2J?\3\2\2\2JB\3"+
		"\2\2\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\3\3\2\2\2NL\3\2\2\2OW"+
		"\5\n\6\2PW\5\6\4\2QW\5\b\5\2RS\7\36\2\2ST\5\2\2\2TU\7\37\2\2UW\3\2\2\2"+
		"VO\3\2\2\2VP\3\2\2\2VQ\3\2\2\2VR\3\2\2\2W\5\3\2\2\2XY\7 \2\2Ya\7!\2\2"+
		"Za\t\n\2\2[a\7;\2\2\\a\7<\2\2]a\7\67\2\2^a\78\2\2_a\5\20\t\2`X\3\2\2\2"+
		"`Z\3\2\2\2`[\3\2\2\2`\\\3\2\2\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2a\7\3\2\2"+
		"\2bc\7$\2\2cd\5\34\17\2d\t\3\2\2\2ei\5\34\17\2fi\5\f\7\2gi\7%\2\2he\3"+
		"\2\2\2hf\3\2\2\2hg\3\2\2\2i\13\3\2\2\2jk\5\34\17\2km\7\36\2\2ln\5\16\b"+
		"\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\37\2\2p\r\3\2\2\2qv\5\2\2\2rs\7&"+
		"\2\2su\5\2\2\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\17\3\2\2\2xv\3"+
		"\2\2\2y{\7<\2\2z|\5\22\n\2{z\3\2\2\2{|\3\2\2\2|\21\3\2\2\2}\u0081\5\24"+
		"\13\2~\u0081\5\26\f\2\177\u0081\7;\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\177\3\2\2\2\u0081\23\3\2\2\2\u0082\u0083\t\13\2\2\u0083\25\3\2\2\2\u0084"+
		"\u0085\t\f\2\2\u0085\27\3\2\2\2\u0086\u0087\5\32\16\2\u0087\31\3\2\2\2"+
		"\u0088\u008d\5\34\17\2\u0089\u008a\7\3\2\2\u008a\u008c\5\34\17\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\33\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\t\r\2\2\u0091\35"+
		"\3\2\2\2\r\"JLV`hmv{\u0080\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}