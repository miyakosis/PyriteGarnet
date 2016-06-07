// Generated from Pyrite.g4 by ANTLR 4.5.2

  package pyrite.compiler.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PyriteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, DecimalNumeral=7, Digits=8, 
		HexNumeral=9, OctalNumeral=10, BinaryNumeral=11, CharacterLiteral=12, 
		StringLiteral=13, BREAK=14, CASE=15, CATCH=16, CLASS=17, CONST=18, CONTINUE=19, 
		DEFAULT=20, ELSE=21, ENUM=22, EXTENDS=23, FINAL=24, FINALLY=25, FOR=26, 
		IF=27, IMPLEMENTS=28, IMPORT=29, INSTANCEOF=30, INTERFACE=31, NEW=32, 
		PACKAGE=33, PRIVATE=34, PROTECTED=35, PUBLIC=36, RETURN=37, STATIC=38, 
		SUPER=39, SWITCH=40, SYNCHRONIZED=41, THIS=42, THROW=43, THROWS=44, TRY=45, 
		VOID=46, WHILE=47, VAR=48, OBJ=49, NUM=50, INT=51, FLT=52, STR=53, CHR=54, 
		BOL=55, BYT=56, IN=57, LPAREN=58, RPAREN=59, LBRACE=60, RBRACE=61, LBRACK=62, 
		RBRACK=63, SEMI=64, COMMA=65, DOT=66, ASSIGN=67, GT=68, LT=69, BANG=70, 
		TILDE=71, QUESTION=72, COLON=73, EQUAL=74, LE=75, GE=76, NOTEQUAL=77, 
		AND=78, OR=79, INC=80, DEC=81, ADD=82, SUB=83, MUL=84, DIV=85, BITAND=86, 
		BITOR=87, LSHIFT=88, RSHIFT=89, URSHIFT=90, CARET=91, MOD=92, ADD_ASSIGN=93, 
		SUB_ASSIGN=94, MUL_ASSIGN=95, DIV_ASSIGN=96, AND_ASSIGN=97, OR_ASSIGN=98, 
		XOR_ASSIGN=99, MOD_ASSIGN=100, LSHIFT_ASSIGN=101, RSHIFT_ASSIGN=102, URSHIFT_ASSIGN=103, 
		Identifier=104, AT=105, ELLIPSIS=106, WS=107, COMMENT=108, LINE_COMMENT=109;
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_classInstanceModifier = 3, RULE_classDeclaration = 4, RULE_typeList = 5, 
		RULE_classBody = 6, RULE_classBodyDeclaration = 7, RULE_methodDeclaration = 8, 
		RULE_inputParameters = 9, RULE_inputParameter = 10, RULE_outputParameters = 11, 
		RULE_outputParameter = 12, RULE_constructorDeclaration = 13, RULE_fieldDeclaration = 14, 
		RULE_typeOrArray = 15, RULE_type = 16, RULE_array = 17, RULE_primitiveType = 18, 
		RULE_methodBody = 19, RULE_constructorBody = 20, RULE_constructorCall = 21, 
		RULE_qualifiedName = 22, RULE_literal = 23, RULE_block = 24, RULE_statement = 25, 
		RULE_variableDeclarationStatement = 26, RULE_variableDeclaration = 27, 
		RULE_label = 28, RULE_ifStatement = 29, RULE_catchClause = 30, RULE_finallyBlock = 31, 
		RULE_switchBlockStatementGroup = 32, RULE_switchLabel = 33, RULE_forControl = 34, 
		RULE_parExpression = 35, RULE_expression = 36, RULE_primary = 37, RULE_creator = 38, 
		RULE_arguments = 39, RULE_integerLiteral = 40, RULE_floatingPointLiteral = 41, 
		RULE_booleanLiteral = 42, RULE_characterLiteral = 43, RULE_stringLiteral = 44, 
		RULE_nullLiteral = 45;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "classInstanceModifier", 
		"classDeclaration", "typeList", "classBody", "classBodyDeclaration", "methodDeclaration", 
		"inputParameters", "inputParameter", "outputParameters", "outputParameter", 
		"constructorDeclaration", "fieldDeclaration", "typeOrArray", "type", "array", 
		"primitiveType", "methodBody", "constructorBody", "constructorCall", "qualifiedName", 
		"literal", "block", "statement", "variableDeclarationStatement", "variableDeclaration", 
		"label", "ifStatement", "catchClause", "finallyBlock", "switchBlockStatementGroup", 
		"switchLabel", "forControl", "parExpression", "expression", "primary", 
		"creator", "arguments", "integerLiteral", "floatingPointLiteral", "booleanLiteral", 
		"characterLiteral", "stringLiteral", "nullLiteral"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'dec'", "'fallthrough'", "'.('", "'true'", "'false'", "'null'", 
		null, null, null, null, null, null, null, "'break'", "'case'", "'catch'", 
		"'class'", "'const'", "'continue'", "'default'", "'else'", "'enum'", "'extends'", 
		"'final'", "'finally'", "'for'", "'if'", "'implements'", "'import'", "'instanceof'", 
		"'interface'", "'new'", "'package'", "'private'", "'protected'", "'public'", 
		"'return'", "'static'", "'super'", "'switch'", "'synchronized'", "'this'", 
		"'throw'", "'throws'", "'try'", "'void'", "'while'", "'var'", "'obj'", 
		"'num'", "'int'", "'flt'", "'str'", "'chr'", "'bol'", "'byt'", "'in'", 
		"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'='", 
		"'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", 
		"'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", 
		"'<<'", "'>>'", "'>>>'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", 
		"'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", null, "'@'", 
		"'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "DecimalNumeral", "Digits", 
		"HexNumeral", "OctalNumeral", "BinaryNumeral", "CharacterLiteral", "StringLiteral", 
		"BREAK", "CASE", "CATCH", "CLASS", "CONST", "CONTINUE", "DEFAULT", "ELSE", 
		"ENUM", "EXTENDS", "FINAL", "FINALLY", "FOR", "IF", "IMPLEMENTS", "IMPORT", 
		"INSTANCEOF", "INTERFACE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", 
		"RETURN", "STATIC", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
		"THROWS", "TRY", "VOID", "WHILE", "VAR", "OBJ", "NUM", "INT", "FLT", "STR", 
		"CHR", "BOL", "BYT", "IN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", 
		"RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", 
		"QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
		"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "LSHIFT", "RSHIFT", 
		"URSHIFT", "CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", 
		"RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", "AT", "ELLIPSIS", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
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
	public String getGrammarFileName() { return "Pyrite.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PyriteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PyriteParser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(92);
				packageDeclaration();
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(95);
				importDeclaration();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			classDeclaration();
			setState(102);
			match(EOF);
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

	public static class PackageDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitPackageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(PACKAGE);
			setState(105);
			qualifiedName();
			setState(106);
			match(SEMI);
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

	public static class ImportDeclarationContext extends ParserRuleContext {
		public Token ast;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(IMPORT);
			setState(109);
			qualifiedName();
			setState(112);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(110);
				match(DOT);
				setState(111);
				((ImportDeclarationContext)_localctx).ast = match(MUL);
				}
			}

			setState(114);
			match(SEMI);
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

	public static class ClassInstanceModifierContext extends ParserRuleContext {
		public ClassInstanceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitClassInstanceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanceModifierContext classInstanceModifier() throws RecognitionException {
		ClassInstanceModifierContext _localctx = new ClassInstanceModifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classInstanceModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(STATIC);
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

	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(CLASS);
			setState(119);
			match(Identifier);
			setState(122);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(120);
				match(EXTENDS);
				setState(121);
				type();
				}
			}

			setState(126);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(124);
				match(IMPLEMENTS);
				setState(125);
				typeList();
				}
			}

			setState(128);
			classBody();
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

	public static class TypeListContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			type();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(131);
				match(COMMA);
				setState(132);
				type();
				}
				}
				setState(137);
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

	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LBRACE);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STATIC || _la==VAR || _la==SEMI || _la==Identifier) {
				{
				{
				setState(139);
				classBodyDeclaration();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(RBRACE);
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

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classBodyDeclaration);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				constructorDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				methodDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				fieldDeclaration();
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

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public InputParametersContext inputParameters() {
			return getRuleContext(InputParametersContext.class,0);
		}
		public OutputParametersContext outputParameters() {
			return getRuleContext(OutputParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public ClassInstanceModifierContext classInstanceModifier() {
			return getRuleContext(ClassInstanceModifierContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(153);
				classInstanceModifier();
				}
			}

			setState(156);
			match(Identifier);
			setState(157);
			inputParameters();
			setState(158);
			outputParameters();
			setState(159);
			methodBody();
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

	public static class InputParametersContext extends ParserRuleContext {
		public List<InputParameterContext> inputParameter() {
			return getRuleContexts(InputParameterContext.class);
		}
		public InputParameterContext inputParameter(int i) {
			return getRuleContext(InputParameterContext.class,i);
		}
		public InputParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitInputParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputParametersContext inputParameters() throws RecognitionException {
		InputParametersContext _localctx = new InputParametersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_inputParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(LPAREN);
			setState(170);
			_la = _input.LA(1);
			if (_la==VAR || _la==Identifier) {
				{
				setState(162);
				inputParameter();
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(163);
					match(COMMA);
					setState(164);
					inputParameter();
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(172);
			match(RPAREN);
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

	public static class InputParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeOrArrayContext typeOrArray() {
			return getRuleContext(TypeOrArrayContext.class,0);
		}
		public InputParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitInputParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputParameterContext inputParameter() throws RecognitionException {
		InputParameterContext _localctx = new InputParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inputParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(174);
				match(VAR);
				}
			}

			setState(177);
			match(Identifier);
			setState(178);
			match(COLON);
			setState(179);
			typeOrArray();
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

	public static class OutputParametersContext extends ParserRuleContext {
		public List<OutputParameterContext> outputParameter() {
			return getRuleContexts(OutputParameterContext.class);
		}
		public OutputParameterContext outputParameter(int i) {
			return getRuleContext(OutputParameterContext.class,i);
		}
		public OutputParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitOutputParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputParametersContext outputParameters() throws RecognitionException {
		OutputParametersContext _localctx = new OutputParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_outputParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(LPAREN);
			setState(190);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << VAR) | (1L << OBJ) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT) | (1L << LBRACK))) != 0) || _la==Identifier) {
				{
				setState(182);
				outputParameter();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(183);
					match(COMMA);
					setState(184);
					outputParameter();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(192);
			match(RPAREN);
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

	public static class OutputParameterContext extends ParserRuleContext {
		public TypeOrArrayContext typeOrArray() {
			return getRuleContext(TypeOrArrayContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public OutputParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitOutputParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputParameterContext outputParameter() throws RecognitionException {
		OutputParameterContext _localctx = new OutputParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_outputParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(195);
				_la = _input.LA(1);
				if (_la==VAR) {
					{
					setState(194);
					match(VAR);
					}
				}

				setState(197);
				match(Identifier);
				setState(198);
				match(COLON);
				}
				break;
			}
			setState(201);
			typeOrArray();
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

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public InputParametersContext inputParameters() {
			return getRuleContext(InputParametersContext.class,0);
		}
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(Identifier);
			setState(204);
			inputParameters();
			setState(205);
			constructorBody();
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public ClassInstanceModifierContext classInstanceModifier() {
			return getRuleContext(ClassInstanceModifierContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(207);
				classInstanceModifier();
				}
			}

			setState(210);
			match(VAR);
			setState(211);
			variableDeclarationStatement();
			setState(212);
			match(SEMI);
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

	public static class TypeOrArrayContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TypeOrArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeOrArray; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitTypeOrArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeOrArrayContext typeOrArray() throws RecognitionException {
		TypeOrArrayContext _localctx = new TypeOrArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeOrArray);
		try {
			setState(216);
			switch (_input.LA(1)) {
			case T__0:
			case OBJ:
			case NUM:
			case INT:
			case FLT:
			case STR:
			case CHR:
			case BOL:
			case BYT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				type();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				array();
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

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			setState(220);
			switch (_input.LA(1)) {
			case T__0:
			case OBJ:
			case NUM:
			case INT:
			case FLT:
			case STR:
			case CHR:
			case BOL:
			case BYT:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				primitiveType();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				qualifiedName();
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

	public static class ArrayContext extends ParserRuleContext {
		public List<TypeOrArrayContext> typeOrArray() {
			return getRuleContexts(TypeOrArrayContext.class);
		}
		public TypeOrArrayContext typeOrArray(int i) {
			return getRuleContext(TypeOrArrayContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(LBRACK);
			setState(223);
			typeOrArray();
			setState(226);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(224);
				match(COLON);
				setState(225);
				typeOrArray();
				}
			}

			setState(228);
			match(RBRACK);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << OBJ) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			block();
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

	public static class ConstructorBodyContext extends ParserRuleContext {
		public ConstructorCallContext constructorCall() {
			return getRuleContext(ConstructorCallContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitConstructorBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constructorBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(LBRACE);
			setState(236);
			_la = _input.LA(1);
			if (_la==SUPER || _la==THIS) {
				{
				setState(235);
				constructorCall();
				}
			}

			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THROW) | (1L << TRY) | (1L << WHILE) | (1L << VAR) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEMI - 64)) | (1L << (DOT - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(238);
				statement();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(244);
			match(RBRACE);
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

	public static class ConstructorCallContext extends ParserRuleContext {
		public Token method;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ConstructorCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitConstructorCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorCallContext constructorCall() throws RecognitionException {
		ConstructorCallContext _localctx = new ConstructorCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constructorCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			((ConstructorCallContext)_localctx).method = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==SUPER || _la==THIS) ) {
				((ConstructorCallContext)_localctx).method = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(247);
			arguments();
			setState(248);
			match(SEMI);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(PyriteParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(PyriteParser.Identifier, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(Identifier);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(251);
					match(DOT);
					setState(252);
					match(Identifier);
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public FloatingPointLiteralContext floatingPointLiteral() {
			return getRuleContext(FloatingPointLiteralContext.class,0);
		}
		public CharacterLiteralContext characterLiteral() {
			return getRuleContext(CharacterLiteralContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public NullLiteralContext nullLiteral() {
			return getRuleContext(NullLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_literal);
		try {
			setState(264);
			switch (_input.LA(1)) {
			case DecimalNumeral:
			case HexNumeral:
			case OctalNumeral:
			case BinaryNumeral:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				integerLiteral();
				}
				break;
			case Digits:
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				floatingPointLiteral();
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				characterLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(261);
				stringLiteral();
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(262);
				booleanLiteral();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(263);
				nullLiteral();
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(LBRACE);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THROW) | (1L << TRY) | (1L << WHILE) | (1L << VAR) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEMI - 64)) | (1L << (DOT - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(267);
				statement();
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			match(RBRACE);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementWhileContext extends StatementContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExpressionContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementTryContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public StatementTryContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementTry(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementContinueContext extends StatementContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public StatementContinueContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementThrowContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementThrowContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementThrow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementIfContext extends StatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public StatementIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementSynchronizedContext extends StatementContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementSynchronizedContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementSynchronized(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementForContext extends StatementContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementReturnContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementBreakContext extends StatementContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public StatementBreakContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementVarContext extends StatementContext {
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public StatementVarContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementEmptyContext extends StatementContext {
		public StatementEmptyContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementSwitchContext extends StatementContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public StatementSwitchContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementSwitch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementBlockContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				block();
				}
				break;
			case 2:
				_localctx = new StatementEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new StatementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277);
				expression(0);
				setState(278);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new StatementVarContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(280);
				match(VAR);
				setState(281);
				variableDeclarationStatement();
				setState(282);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(284);
				match(RETURN);
				setState(286);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(285);
					expression(0);
					}
				}

				setState(288);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(289);
				match(IF);
				setState(290);
				ifStatement();
				}
				break;
			case 7:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(291);
				label();
				setState(292);
				match(WHILE);
				setState(293);
				parExpression();
				setState(294);
				block();
				}
				break;
			case 8:
				_localctx = new StatementForContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(296);
				label();
				setState(297);
				match(FOR);
				setState(298);
				match(LPAREN);
				setState(299);
				forControl();
				setState(300);
				match(RPAREN);
				setState(301);
				block();
				}
				break;
			case 9:
				_localctx = new StatementSwitchContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(303);
				match(SWITCH);
				setState(304);
				parExpression();
				setState(305);
				match(LBRACE);
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(306);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(311);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(312);
					switchLabel();
					}
					}
					setState(317);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(318);
				match(RBRACE);
				}
				break;
			case 10:
				_localctx = new StatementBreakContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(320);
				match(BREAK);
				setState(321);
				label();
				setState(322);
				match(SEMI);
				}
				break;
			case 11:
				_localctx = new StatementContinueContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(324);
				match(CONTINUE);
				setState(325);
				label();
				setState(326);
				match(SEMI);
				}
				break;
			case 12:
				_localctx = new StatementTryContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(328);
				match(TRY);
				setState(329);
				block();
				setState(339);
				switch (_input.LA(1)) {
				case CATCH:
					{
					setState(331); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(330);
						catchClause();
						}
						}
						setState(333); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CATCH );
					setState(336);
					_la = _input.LA(1);
					if (_la==FINALLY) {
						{
						setState(335);
						finallyBlock();
						}
					}

					}
					break;
				case FINALLY:
					{
					setState(338);
					finallyBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 13:
				_localctx = new StatementThrowContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(341);
				match(THROW);
				setState(342);
				expression(0);
				setState(343);
				match(SEMI);
				}
				break;
			case 14:
				_localctx = new StatementSynchronizedContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(345);
				match(SYNCHRONIZED);
				setState(346);
				parExpression();
				setState(347);
				block();
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

	public static class VariableDeclarationStatementContext extends ParserRuleContext {
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationStatementContext variableDeclarationStatement() throws RecognitionException {
		VariableDeclarationStatementContext _localctx = new VariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			variableDeclaration();
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(352);
				match(COMMA);
				setState(353);
				variableDeclaration();
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(361);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(359);
				match(ASSIGN);
				setState(360);
				expression(0);
				}
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeOrArrayContext typeOrArray() {
			return getRuleContext(TypeOrArrayContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(Identifier);
			setState(366);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(364);
				match(COLON);
				setState(365);
				typeOrArray();
				}
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(368);
				match(Identifier);
				}
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

	public static class IfStatementContext extends ParserRuleContext {
		public BlockContext fulfillmentBlock;
		public BlockContext elseBlock;
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			parExpression();
			setState(372);
			((IfStatementContext)_localctx).fulfillmentBlock = block();
			setState(378);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(373);
				match(ELSE);
				setState(376);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					setState(374);
					ifStatement();
					}
					break;
				case LBRACE:
					{
					setState(375);
					((IfStatementContext)_localctx).elseBlock = block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
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

	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(CATCH);
			setState(381);
			match(LPAREN);
			setState(382);
			match(VAR);
			setState(383);
			match(Identifier);
			setState(386);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(384);
				match(COLON);
				setState(385);
				qualifiedName();
				}
			}

			setState(388);
			match(RPAREN);
			setState(389);
			block();
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

	public static class FinallyBlockContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitFinallyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(FINALLY);
			setState(392);
			block();
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

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public Token fallthrough;
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitSwitchBlockStatementGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(394);
				switchLabel();
				}
				}
				setState(397); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(400); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(399);
				statement();
				}
				}
				setState(402); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THROW) | (1L << TRY) | (1L << WHILE) | (1L << VAR) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEMI - 64)) | (1L << (DOT - 64)) | (1L << (Identifier - 64)))) != 0) );
			setState(406);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(404);
				((SwitchBlockStatementGroupContext)_localctx).fallthrough = match(T__1);
				setState(405);
				match(SEMI);
				}
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

	public static class SwitchLabelContext extends ParserRuleContext {
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
	 
		public SwitchLabelContext() { }
		public void copyFrom(SwitchLabelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SwitchLabelCaseIntContext extends SwitchLabelContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public SwitchLabelCaseIntContext(SwitchLabelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitSwitchLabelCaseInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SwitchLabelDefaultContext extends SwitchLabelContext {
		public SwitchLabelDefaultContext(SwitchLabelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitSwitchLabelDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SwitchLabelCaseStrContext extends SwitchLabelContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public SwitchLabelCaseStrContext(SwitchLabelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitSwitchLabelCaseStr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_switchLabel);
		try {
			setState(418);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new SwitchLabelCaseIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(CASE);
				setState(409);
				integerLiteral();
				setState(410);
				match(COLON);
				}
				break;
			case 2:
				_localctx = new SwitchLabelCaseStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(CASE);
				setState(413);
				stringLiteral();
				setState(414);
				match(COLON);
				}
				break;
			case 3:
				_localctx = new SwitchLabelDefaultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(416);
				match(DEFAULT);
				setState(417);
				match(COLON);
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

	public static class ForControlContext extends ParserRuleContext {
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
	 
		public ForControlContext() { }
		public void copyFrom(ForControlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForControlIteratorContext extends ForControlContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeOrArrayContext typeOrArray() {
			return getRuleContext(TypeOrArrayContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForControlIteratorContext(ForControlContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitForControlIterator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForControlICUContext extends ForControlContext {
		public ExpressionContext init;
		public ExpressionContext control;
		public ExpressionContext update;
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForControlICUContext(ForControlContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitForControlICU(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_forControl);
		int _la;
		try {
			setState(440);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				_localctx = new ForControlIteratorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				match(VAR);
				setState(421);
				match(Identifier);
				setState(422);
				match(COLON);
				setState(423);
				typeOrArray();
				setState(424);
				match(IN);
				setState(425);
				expression(0);
				}
				break;
			case 2:
				_localctx = new ForControlICUContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(430);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(427);
					match(VAR);
					setState(428);
					variableDeclarationStatement();
					}
					break;
				case T__3:
				case T__4:
				case T__5:
				case DecimalNumeral:
				case Digits:
				case HexNumeral:
				case OctalNumeral:
				case BinaryNumeral:
				case CharacterLiteral:
				case StringLiteral:
				case NEW:
				case LPAREN:
				case DOT:
				case Identifier:
					{
					setState(429);
					((ForControlICUContext)_localctx).init = expression(0);
					}
					break;
				case SEMI:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(432);
				match(SEMI);
				setState(434);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(433);
					((ForControlICUContext)_localctx).control = expression(0);
					}
				}

				setState(436);
				match(SEMI);
				setState(438);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(437);
					((ForControlICUContext)_localctx).update = expression(0);
					}
				}

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

	public static class ParExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(LPAREN);
			setState(443);
			expression(0);
			setState(444);
			match(RPAREN);
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
	public static class ExpressionNewContext extends ExpressionContext {
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public ExpressionNewContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionMulDivContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMulDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionClassFieldRefContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public ExpressionClassFieldRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionClassFieldRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionPrimaryContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionPrimaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionArrayAccessContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionArrayAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionInvokeMethodContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionInvokeMethodContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionInvokeMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBitOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionBitOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAddSubContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionShiftContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionShiftContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionShift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionCastContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionCastContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionCast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBolOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionBolOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBolOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBitExOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionBitExOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBitExOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionAssignContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionEqualContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBitAndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionBitAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBolAndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionBolAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBolAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionCompareContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionCompareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionPairContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionPairContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionPair(this);
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
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__5:
			case DecimalNumeral:
			case Digits:
			case HexNumeral:
			case OctalNumeral:
			case BinaryNumeral:
			case CharacterLiteral:
			case StringLiteral:
			case LPAREN:
			case DOT:
			case Identifier:
				{
				_localctx = new ExpressionPrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(447);
				primary();
				}
				break;
			case NEW:
				{
				_localctx = new ExpressionNewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(448);
				match(NEW);
				setState(449);
				creator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(505);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(503);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(452);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(453);
						((ExpressionMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (MUL - 84)) | (1L << (DIV - 84)) | (1L << (MOD - 84)))) != 0)) ) {
							((ExpressionMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(454);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(455);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(456);
						((ExpressionAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(457);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(458);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(459);
						((ExpressionShiftContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (LSHIFT - 88)) | (1L << (RSHIFT - 88)) | (1L << (URSHIFT - 88)))) != 0)) ) {
							((ExpressionShiftContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(460);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionCompareContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(461);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(462);
						((ExpressionCompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (GT - 68)) | (1L << (LT - 68)) | (1L << (LE - 68)) | (1L << (GE - 68)))) != 0)) ) {
							((ExpressionCompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(463);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(464);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(465);
						((ExpressionEqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionEqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(466);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionBitAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(467);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(468);
						match(BITAND);
						setState(469);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionBitExOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(470);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(471);
						match(CARET);
						setState(472);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionBitOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(473);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(474);
						match(BITOR);
						setState(475);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionBolAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(476);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(477);
						match(AND);
						setState(478);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionBolOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(479);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(480);
						match(OR);
						setState(481);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionPairContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(482);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(483);
						match(COMMA);
						setState(484);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(485);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(486);
						((ExpressionAssignContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (ASSIGN - 67)) | (1L << (ADD_ASSIGN - 67)) | (1L << (SUB_ASSIGN - 67)) | (1L << (MUL_ASSIGN - 67)) | (1L << (DIV_ASSIGN - 67)) | (1L << (AND_ASSIGN - 67)) | (1L << (OR_ASSIGN - 67)) | (1L << (XOR_ASSIGN - 67)) | (1L << (MOD_ASSIGN - 67)) | (1L << (LSHIFT_ASSIGN - 67)) | (1L << (RSHIFT_ASSIGN - 67)) | (1L << (URSHIFT_ASSIGN - 67)))) != 0)) ) {
							((ExpressionAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(487);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionClassFieldRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(488);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(489);
						match(DOT);
						setState(490);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionCastContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(491);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(492);
						match(T__2);
						setState(493);
						type();
						setState(494);
						match(RPAREN);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionInvokeMethodContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(496);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(497);
						arguments();
						}
						break;
					case 16:
						{
						_localctx = new ExpressionArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(498);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(499);
						match(LBRACK);
						setState(500);
						expression(0);
						setState(501);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(507);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimaryIdentifierContext extends PrimaryContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public PrimaryIdentifierContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitPrimaryIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryParensContext extends PrimaryContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryParensContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitPrimaryParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryLiteralContext extends PrimaryContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitPrimaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_primary);
		try {
			setState(514);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimaryParensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				match(LPAREN);
				setState(509);
				expression(0);
				setState(510);
				match(RPAREN);
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case DecimalNumeral:
			case Digits:
			case HexNumeral:
			case OctalNumeral:
			case BinaryNumeral:
			case CharacterLiteral:
			case StringLiteral:
			case DOT:
				_localctx = new PrimaryLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
				literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(513);
				match(Identifier);
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

	public static class CreatorContext extends ParserRuleContext {
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
	 
		public CreatorContext() { }
		public void copyFrom(CreatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreatorArrayContext extends CreatorContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public CreatorArrayContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCreatorArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreatorClassContext extends CreatorContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CreatorClassContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCreatorClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_creator);
		try {
			setState(523);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new CreatorClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				qualifiedName();
				setState(517);
				arguments();
				}
				break;
			case LBRACK:
				_localctx = new CreatorArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
				array();
				setState(520);
				match(LPAREN);
				setState(521);
				match(RPAREN);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			match(LPAREN);
			setState(527);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
				{
				setState(526);
				expression(0);
				}
			}

			setState(529);
			match(RPAREN);
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

	public static class IntegerLiteralContext extends ParserRuleContext {
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
	 
		public IntegerLiteralContext() { }
		public void copyFrom(IntegerLiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerLiteralHexContext extends IntegerLiteralContext {
		public TerminalNode HexNumeral() { return getToken(PyriteParser.HexNumeral, 0); }
		public IntegerLiteralHexContext(IntegerLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitIntegerLiteralHex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralBinaryContext extends IntegerLiteralContext {
		public TerminalNode BinaryNumeral() { return getToken(PyriteParser.BinaryNumeral, 0); }
		public IntegerLiteralBinaryContext(IntegerLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitIntegerLiteralBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralOctalContext extends IntegerLiteralContext {
		public TerminalNode OctalNumeral() { return getToken(PyriteParser.OctalNumeral, 0); }
		public IntegerLiteralOctalContext(IntegerLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitIntegerLiteralOctal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralDecimalContext extends IntegerLiteralContext {
		public TerminalNode DecimalNumeral() { return getToken(PyriteParser.DecimalNumeral, 0); }
		public IntegerLiteralDecimalContext(IntegerLiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitIntegerLiteralDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_integerLiteral);
		try {
			setState(535);
			switch (_input.LA(1)) {
			case DecimalNumeral:
				_localctx = new IntegerLiteralDecimalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(531);
				match(DecimalNumeral);
				}
				break;
			case HexNumeral:
				_localctx = new IntegerLiteralHexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(532);
				match(HexNumeral);
				}
				break;
			case OctalNumeral:
				_localctx = new IntegerLiteralOctalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(533);
				match(OctalNumeral);
				}
				break;
			case BinaryNumeral:
				_localctx = new IntegerLiteralBinaryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(534);
				match(BinaryNumeral);
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

	public static class FloatingPointLiteralContext extends ParserRuleContext {
		public List<TerminalNode> Digits() { return getTokens(PyriteParser.Digits); }
		public TerminalNode Digits(int i) {
			return getToken(PyriteParser.Digits, i);
		}
		public FloatingPointLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPointLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitFloatingPointLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingPointLiteralContext floatingPointLiteral() throws RecognitionException {
		FloatingPointLiteralContext _localctx = new FloatingPointLiteralContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_floatingPointLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			_la = _input.LA(1);
			if (_la==Digits) {
				{
				setState(537);
				match(Digits);
				}
			}

			setState(540);
			match(DOT);
			setState(541);
			match(Digits);
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

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class CharacterLiteralContext extends ParserRuleContext {
		public TerminalNode CharacterLiteral() { return getToken(PyriteParser.CharacterLiteral, 0); }
		public CharacterLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_characterLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCharacterLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharacterLiteralContext characterLiteral() throws RecognitionException {
		CharacterLiteralContext _localctx = new CharacterLiteralContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_characterLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			match(CharacterLiteral);
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

	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(PyriteParser.StringLiteral, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
			match(StringLiteral);
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

	public static class NullLiteralContext extends ParserRuleContext {
		public NullLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullLiteralContext nullLiteral() throws RecognitionException {
		NullLiteralContext _localctx = new NullLiteralContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_nullLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			match(T__5);
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
		case 36:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 17);
		case 13:
			return precpred(_ctx, 16);
		case 14:
			return precpred(_ctx, 15);
		case 15:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3o\u022a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\5\2`\n\2\3\2\7\2c\n\2\f\2\16\2f\13\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4s\n\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\5\6}\n\6\3\6\3\6\5\6\u0081\n\6\3\6\3\6\3\7\3\7\3\7\7\7\u0088"+
		"\n\7\f\7\16\7\u008b\13\7\3\b\3\b\7\b\u008f\n\b\f\b\16\b\u0092\13\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\5\t\u009a\n\t\3\n\5\n\u009d\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\7\13\u00a8\n\13\f\13\16\13\u00ab\13\13\5\13\u00ad"+
		"\n\13\3\13\3\13\3\f\5\f\u00b2\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r"+
		"\u00bc\n\r\f\r\16\r\u00bf\13\r\5\r\u00c1\n\r\3\r\3\r\3\16\5\16\u00c6\n"+
		"\16\3\16\3\16\5\16\u00ca\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\5\20"+
		"\u00d3\n\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00db\n\21\3\22\3\22\5"+
		"\22\u00df\n\22\3\23\3\23\3\23\3\23\5\23\u00e5\n\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\5\26\u00ef\n\26\3\26\7\26\u00f2\n\26\f\26\16\26\u00f5"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\7\30\u0100\n\30\f"+
		"\30\16\30\u0103\13\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u010b\n\31\3"+
		"\32\3\32\7\32\u010f\n\32\f\32\16\32\u0112\13\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0121\n\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\7\33\u0136\n\33\f\33\16\33\u0139\13\33\3\33\7\33\u013c"+
		"\n\33\f\33\16\33\u013f\13\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\6\33\u014e\n\33\r\33\16\33\u014f\3\33\5\33\u0153"+
		"\n\33\3\33\5\33\u0156\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u0160\n\33\3\34\3\34\3\34\7\34\u0165\n\34\f\34\16\34\u0168\13\34\3\34"+
		"\3\34\5\34\u016c\n\34\3\35\3\35\3\35\5\35\u0171\n\35\3\36\5\36\u0174\n"+
		"\36\3\37\3\37\3\37\3\37\3\37\5\37\u017b\n\37\5\37\u017d\n\37\3 \3 \3 "+
		"\3 \3 \3 \5 \u0185\n \3 \3 \3 \3!\3!\3!\3\"\6\"\u018e\n\"\r\"\16\"\u018f"+
		"\3\"\6\"\u0193\n\"\r\"\16\"\u0194\3\"\3\"\5\"\u0199\n\"\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\5#\u01a5\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u01b1\n"+
		"$\3$\3$\5$\u01b5\n$\3$\3$\5$\u01b9\n$\5$\u01bb\n$\3%\3%\3%\3%\3&\3&\3"+
		"&\3&\5&\u01c5\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u01fa\n&\f&\16&\u01fd\13&\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\5\'\u0205\n\'\3(\3(\3(\3(\3(\3(\3(\5(\u020e\n(\3)\3)\5"+
		")\u0212\n)\3)\3)\3*\3*\3*\3*\5*\u021a\n*\3+\5+\u021d\n+\3+\3+\3+\3,\3"+
		",\3-\3-\3.\3.\3/\3/\3/\2\3J\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\13\4\2\3\3\63:\4\2)),,\4\2"+
		"VW^^\3\2TU\3\2Z\\\4\2FGMN\4\2LLOO\4\2EE_i\3\2\6\7\u0257\2_\3\2\2\2\4j"+
		"\3\2\2\2\6n\3\2\2\2\bv\3\2\2\2\nx\3\2\2\2\f\u0084\3\2\2\2\16\u008c\3\2"+
		"\2\2\20\u0099\3\2\2\2\22\u009c\3\2\2\2\24\u00a3\3\2\2\2\26\u00b1\3\2\2"+
		"\2\30\u00b7\3\2\2\2\32\u00c9\3\2\2\2\34\u00cd\3\2\2\2\36\u00d2\3\2\2\2"+
		" \u00da\3\2\2\2\"\u00de\3\2\2\2$\u00e0\3\2\2\2&\u00e8\3\2\2\2(\u00ea\3"+
		"\2\2\2*\u00ec\3\2\2\2,\u00f8\3\2\2\2.\u00fc\3\2\2\2\60\u010a\3\2\2\2\62"+
		"\u010c\3\2\2\2\64\u015f\3\2\2\2\66\u0161\3\2\2\28\u016d\3\2\2\2:\u0173"+
		"\3\2\2\2<\u0175\3\2\2\2>\u017e\3\2\2\2@\u0189\3\2\2\2B\u018d\3\2\2\2D"+
		"\u01a4\3\2\2\2F\u01ba\3\2\2\2H\u01bc\3\2\2\2J\u01c4\3\2\2\2L\u0204\3\2"+
		"\2\2N\u020d\3\2\2\2P\u020f\3\2\2\2R\u0219\3\2\2\2T\u021c\3\2\2\2V\u0221"+
		"\3\2\2\2X\u0223\3\2\2\2Z\u0225\3\2\2\2\\\u0227\3\2\2\2^`\5\4\3\2_^\3\2"+
		"\2\2_`\3\2\2\2`d\3\2\2\2ac\5\6\4\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2"+
		"\2\2eg\3\2\2\2fd\3\2\2\2gh\5\n\6\2hi\7\2\2\3i\3\3\2\2\2jk\7#\2\2kl\5."+
		"\30\2lm\7B\2\2m\5\3\2\2\2no\7\37\2\2or\5.\30\2pq\7D\2\2qs\7V\2\2rp\3\2"+
		"\2\2rs\3\2\2\2st\3\2\2\2tu\7B\2\2u\7\3\2\2\2vw\7(\2\2w\t\3\2\2\2xy\7\23"+
		"\2\2y|\7j\2\2z{\7\31\2\2{}\5\"\22\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2"+
		"~\177\7\36\2\2\177\u0081\5\f\7\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\5\16\b\2\u0083\13\3\2\2\2\u0084\u0089\5\"\22"+
		"\2\u0085\u0086\7C\2\2\u0086\u0088\5\"\22\2\u0087\u0085\3\2\2\2\u0088\u008b"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\r\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u0090\7>\2\2\u008d\u008f\5\20\t\2\u008e\u008d\3\2"+
		"\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7?\2\2\u0094\17\3\2\2\2"+
		"\u0095\u009a\7B\2\2\u0096\u009a\5\34\17\2\u0097\u009a\5\22\n\2\u0098\u009a"+
		"\5\36\20\2\u0099\u0095\3\2\2\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2"+
		"\u0099\u0098\3\2\2\2\u009a\21\3\2\2\2\u009b\u009d\5\b\5\2\u009c\u009b"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7j\2\2\u009f"+
		"\u00a0\5\24\13\2\u00a0\u00a1\5\30\r\2\u00a1\u00a2\5(\25\2\u00a2\23\3\2"+
		"\2\2\u00a3\u00ac\7<\2\2\u00a4\u00a9\5\26\f\2\u00a5\u00a6\7C\2\2\u00a6"+
		"\u00a8\5\26\f\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00a4\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7="+
		"\2\2\u00af\25\3\2\2\2\u00b0\u00b2\7\62\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7j\2\2\u00b4\u00b5\7K\2\2\u00b5"+
		"\u00b6\5 \21\2\u00b6\27\3\2\2\2\u00b7\u00c0\7<\2\2\u00b8\u00bd\5\32\16"+
		"\2\u00b9\u00ba\7C\2\2\u00ba\u00bc\5\32\16\2\u00bb\u00b9\3\2\2\2\u00bc"+
		"\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\7=\2\2\u00c3\31\3\2\2\2\u00c4\u00c6\7\62\2"+
		"\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8"+
		"\7j\2\2\u00c8\u00ca\7K\2\2\u00c9\u00c5\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cc\5 \21\2\u00cc\33\3\2\2\2\u00cd\u00ce\7j\2\2"+
		"\u00ce\u00cf\5\24\13\2\u00cf\u00d0\5*\26\2\u00d0\35\3\2\2\2\u00d1\u00d3"+
		"\5\b\5\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\7\62\2\2\u00d5\u00d6\5\66\34\2\u00d6\u00d7\7B\2\2\u00d7\37\3\2"+
		"\2\2\u00d8\u00db\5\"\22\2\u00d9\u00db\5$\23\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00d9\3\2\2\2\u00db!\3\2\2\2\u00dc\u00df\5&\24\2\u00dd\u00df\5.\30\2"+
		"\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df#\3\2\2\2\u00e0\u00e1\7"+
		"@\2\2\u00e1\u00e4\5 \21\2\u00e2\u00e3\7K\2\2\u00e3\u00e5\5 \21\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7A"+
		"\2\2\u00e7%\3\2\2\2\u00e8\u00e9\t\2\2\2\u00e9\'\3\2\2\2\u00ea\u00eb\5"+
		"\62\32\2\u00eb)\3\2\2\2\u00ec\u00ee\7>\2\2\u00ed\u00ef\5,\27\2\u00ee\u00ed"+
		"\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f3\3\2\2\2\u00f0\u00f2\5\64\33\2"+
		"\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7?\2\2\u00f7"+
		"+\3\2\2\2\u00f8\u00f9\t\3\2\2\u00f9\u00fa\5P)\2\u00fa\u00fb\7B\2\2\u00fb"+
		"-\3\2\2\2\u00fc\u0101\7j\2\2\u00fd\u00fe\7D\2\2\u00fe\u0100\7j\2\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102/\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u010b\5R*\2\u0105\u010b"+
		"\5T+\2\u0106\u010b\5X-\2\u0107\u010b\5Z.\2\u0108\u010b\5V,\2\u0109\u010b"+
		"\5\\/\2\u010a\u0104\3\2\2\2\u010a\u0105\3\2\2\2\u010a\u0106\3\2\2\2\u010a"+
		"\u0107\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u0109\3\2\2\2\u010b\61\3\2\2"+
		"\2\u010c\u0110\7>\2\2\u010d\u010f\5\64\33\2\u010e\u010d\3\2\2\2\u010f"+
		"\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2"+
		"\2\2\u0112\u0110\3\2\2\2\u0113\u0114\7?\2\2\u0114\63\3\2\2\2\u0115\u0160"+
		"\5\62\32\2\u0116\u0160\7B\2\2\u0117\u0118\5J&\2\u0118\u0119\7B\2\2\u0119"+
		"\u0160\3\2\2\2\u011a\u011b\7\62\2\2\u011b\u011c\5\66\34\2\u011c\u011d"+
		"\7B\2\2\u011d\u0160\3\2\2\2\u011e\u0120\7\'\2\2\u011f\u0121\5J&\2\u0120"+
		"\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0160\7B"+
		"\2\2\u0123\u0124\7\35\2\2\u0124\u0160\5<\37\2\u0125\u0126\5:\36\2\u0126"+
		"\u0127\7\61\2\2\u0127\u0128\5H%\2\u0128\u0129\5\62\32\2\u0129\u0160\3"+
		"\2\2\2\u012a\u012b\5:\36\2\u012b\u012c\7\34\2\2\u012c\u012d\7<\2\2\u012d"+
		"\u012e\5F$\2\u012e\u012f\7=\2\2\u012f\u0130\5\62\32\2\u0130\u0160\3\2"+
		"\2\2\u0131\u0132\7*\2\2\u0132\u0133\5H%\2\u0133\u0137\7>\2\2\u0134\u0136"+
		"\5B\"\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u013d\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013c\5D"+
		"#\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7?"+
		"\2\2\u0141\u0160\3\2\2\2\u0142\u0143\7\20\2\2\u0143\u0144\5:\36\2\u0144"+
		"\u0145\7B\2\2\u0145\u0160\3\2\2\2\u0146\u0147\7\25\2\2\u0147\u0148\5:"+
		"\36\2\u0148\u0149\7B\2\2\u0149\u0160\3\2\2\2\u014a\u014b\7/\2\2\u014b"+
		"\u0155\5\62\32\2\u014c\u014e\5> \2\u014d\u014c\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151"+
		"\u0153\5@!\2\u0152\u0151\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0156\3\2\2"+
		"\2\u0154\u0156\5@!\2\u0155\u014d\3\2\2\2\u0155\u0154\3\2\2\2\u0156\u0160"+
		"\3\2\2\2\u0157\u0158\7-\2\2\u0158\u0159\5J&\2\u0159\u015a\7B\2\2\u015a"+
		"\u0160\3\2\2\2\u015b\u015c\7+\2\2\u015c\u015d\5H%\2\u015d\u015e\5\62\32"+
		"\2\u015e\u0160\3\2\2\2\u015f\u0115\3\2\2\2\u015f\u0116\3\2\2\2\u015f\u0117"+
		"\3\2\2\2\u015f\u011a\3\2\2\2\u015f\u011e\3\2\2\2\u015f\u0123\3\2\2\2\u015f"+
		"\u0125\3\2\2\2\u015f\u012a\3\2\2\2\u015f\u0131\3\2\2\2\u015f\u0142\3\2"+
		"\2\2\u015f\u0146\3\2\2\2\u015f\u014a\3\2\2\2\u015f\u0157\3\2\2\2\u015f"+
		"\u015b\3\2\2\2\u0160\65\3\2\2\2\u0161\u0166\58\35\2\u0162\u0163\7C\2\2"+
		"\u0163\u0165\58\35\2\u0164\u0162\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164"+
		"\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u016b\3\2\2\2\u0168\u0166\3\2\2\2\u0169"+
		"\u016a\7E\2\2\u016a\u016c\5J&\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2"+
		"\2\u016c\67\3\2\2\2\u016d\u0170\7j\2\2\u016e\u016f\7K\2\2\u016f\u0171"+
		"\5 \21\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u01719\3\2\2\2\u0172"+
		"\u0174\7j\2\2\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174;\3\2\2\2\u0175"+
		"\u0176\5H%\2\u0176\u017c\5\62\32\2\u0177\u017a\7\27\2\2\u0178\u017b\5"+
		"<\37\2\u0179\u017b\5\62\32\2\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017b"+
		"\u017d\3\2\2\2\u017c\u0177\3\2\2\2\u017c\u017d\3\2\2\2\u017d=\3\2\2\2"+
		"\u017e\u017f\7\22\2\2\u017f\u0180\7<\2\2\u0180\u0181\7\62\2\2\u0181\u0184"+
		"\7j\2\2\u0182\u0183\7K\2\2\u0183\u0185\5.\30\2\u0184\u0182\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\7=\2\2\u0187\u0188\5\62"+
		"\32\2\u0188?\3\2\2\2\u0189\u018a\7\33\2\2\u018a\u018b\5\62\32\2\u018b"+
		"A\3\2\2\2\u018c\u018e\5D#\2\u018d\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f"+
		"\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u0193\5\64"+
		"\33\2\u0192\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0192\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0197\7\4\2\2\u0197\u0199\7B"+
		"\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199C\3\2\2\2\u019a\u019b"+
		"\7\21\2\2\u019b\u019c\5R*\2\u019c\u019d\7K\2\2\u019d\u01a5\3\2\2\2\u019e"+
		"\u019f\7\21\2\2\u019f\u01a0\5Z.\2\u01a0\u01a1\7K\2\2\u01a1\u01a5\3\2\2"+
		"\2\u01a2\u01a3\7\26\2\2\u01a3\u01a5\7K\2\2\u01a4\u019a\3\2\2\2\u01a4\u019e"+
		"\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5E\3\2\2\2\u01a6\u01a7\7\62\2\2\u01a7"+
		"\u01a8\7j\2\2\u01a8\u01a9\7K\2\2\u01a9\u01aa\5 \21\2\u01aa\u01ab\7;\2"+
		"\2\u01ab\u01ac\5J&\2\u01ac\u01bb\3\2\2\2\u01ad\u01ae\7\62\2\2\u01ae\u01b1"+
		"\5\66\34\2\u01af\u01b1\5J&\2\u01b0\u01ad\3\2\2\2\u01b0\u01af\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b4\7B\2\2\u01b3\u01b5\5J&"+
		"\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b8"+
		"\7B\2\2\u01b7\u01b9\5J&\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01bb\3\2\2\2\u01ba\u01a6\3\2\2\2\u01ba\u01b0\3\2\2\2\u01bbG\3\2\2\2"+
		"\u01bc\u01bd\7<\2\2\u01bd\u01be\5J&\2\u01be\u01bf\7=\2\2\u01bfI\3\2\2"+
		"\2\u01c0\u01c1\b&\1\2\u01c1\u01c5\5L\'\2\u01c2\u01c3\7\"\2\2\u01c3\u01c5"+
		"\5N(\2\u01c4\u01c0\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01fb\3\2\2\2\u01c6"+
		"\u01c7\f\16\2\2\u01c7\u01c8\t\4\2\2\u01c8\u01fa\5J&\17\u01c9\u01ca\f\r"+
		"\2\2\u01ca\u01cb\t\5\2\2\u01cb\u01fa\5J&\16\u01cc\u01cd\f\f\2\2\u01cd"+
		"\u01ce\t\6\2\2\u01ce\u01fa\5J&\r\u01cf\u01d0\f\13\2\2\u01d0\u01d1\t\7"+
		"\2\2\u01d1\u01fa\5J&\f\u01d2\u01d3\f\n\2\2\u01d3\u01d4\t\b\2\2\u01d4\u01fa"+
		"\5J&\13\u01d5\u01d6\f\t\2\2\u01d6\u01d7\7X\2\2\u01d7\u01fa\5J&\n\u01d8"+
		"\u01d9\f\b\2\2\u01d9\u01da\7]\2\2\u01da\u01fa\5J&\t\u01db\u01dc\f\7\2"+
		"\2\u01dc\u01dd\7Y\2\2\u01dd\u01fa\5J&\b\u01de\u01df\f\6\2\2\u01df\u01e0"+
		"\7P\2\2\u01e0\u01fa\5J&\7\u01e1\u01e2\f\5\2\2\u01e2\u01e3\7Q\2\2\u01e3"+
		"\u01fa\5J&\6\u01e4\u01e5\f\4\2\2\u01e5\u01e6\7C\2\2\u01e6\u01fa\5J&\5"+
		"\u01e7\u01e8\f\3\2\2\u01e8\u01e9\t\t\2\2\u01e9\u01fa\5J&\3\u01ea\u01eb"+
		"\f\23\2\2\u01eb\u01ec\7D\2\2\u01ec\u01fa\7j\2\2\u01ed\u01ee\f\22\2\2\u01ee"+
		"\u01ef\7\5\2\2\u01ef\u01f0\5\"\22\2\u01f0\u01f1\7=\2\2\u01f1\u01fa\3\2"+
		"\2\2\u01f2\u01f3\f\21\2\2\u01f3\u01fa\5P)\2\u01f4\u01f5\f\17\2\2\u01f5"+
		"\u01f6\7@\2\2\u01f6\u01f7\5J&\2\u01f7\u01f8\7A\2\2\u01f8\u01fa\3\2\2\2"+
		"\u01f9\u01c6\3\2\2\2\u01f9\u01c9\3\2\2\2\u01f9\u01cc\3\2\2\2\u01f9\u01cf"+
		"\3\2\2\2\u01f9\u01d2\3\2\2\2\u01f9\u01d5\3\2\2\2\u01f9\u01d8\3\2\2\2\u01f9"+
		"\u01db\3\2\2\2\u01f9\u01de\3\2\2\2\u01f9\u01e1\3\2\2\2\u01f9\u01e4\3\2"+
		"\2\2\u01f9\u01e7\3\2\2\2\u01f9\u01ea\3\2\2\2\u01f9\u01ed\3\2\2\2\u01f9"+
		"\u01f2\3\2\2\2\u01f9\u01f4\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2"+
		"\2\2\u01fb\u01fc\3\2\2\2\u01fcK\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u01ff"+
		"\7<\2\2\u01ff\u0200\5J&\2\u0200\u0201\7=\2\2\u0201\u0205\3\2\2\2\u0202"+
		"\u0205\5\60\31\2\u0203\u0205\7j\2\2\u0204\u01fe\3\2\2\2\u0204\u0202\3"+
		"\2\2\2\u0204\u0203\3\2\2\2\u0205M\3\2\2\2\u0206\u0207\5.\30\2\u0207\u0208"+
		"\5P)\2\u0208\u020e\3\2\2\2\u0209\u020a\5$\23\2\u020a\u020b\7<\2\2\u020b"+
		"\u020c\7=\2\2\u020c\u020e\3\2\2\2\u020d\u0206\3\2\2\2\u020d\u0209\3\2"+
		"\2\2\u020eO\3\2\2\2\u020f\u0211\7<\2\2\u0210\u0212\5J&\2\u0211\u0210\3"+
		"\2\2\2\u0211\u0212\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\7=\2\2\u0214"+
		"Q\3\2\2\2\u0215\u021a\7\t\2\2\u0216\u021a\7\13\2\2\u0217\u021a\7\f\2\2"+
		"\u0218\u021a\7\r\2\2\u0219\u0215\3\2\2\2\u0219\u0216\3\2\2\2\u0219\u0217"+
		"\3\2\2\2\u0219\u0218\3\2\2\2\u021aS\3\2\2\2\u021b\u021d\7\n\2\2\u021c"+
		"\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021e\3\2\2\2\u021e\u021f\7D"+
		"\2\2\u021f\u0220\7\n\2\2\u0220U\3\2\2\2\u0221\u0222\t\n\2\2\u0222W\3\2"+
		"\2\2\u0223\u0224\7\16\2\2\u0224Y\3\2\2\2\u0225\u0226\7\17\2\2\u0226[\3"+
		"\2\2\2\u0227\u0228\7\b\2\2\u0228]\3\2\2\29_dr|\u0080\u0089\u0090\u0099"+
		"\u009c\u00a9\u00ac\u00b1\u00bd\u00c0\u00c5\u00c9\u00d2\u00da\u00de\u00e4"+
		"\u00ee\u00f3\u0101\u010a\u0110\u0120\u0137\u013d\u014f\u0152\u0155\u015f"+
		"\u0166\u016b\u0170\u0173\u017a\u017c\u0184\u018f\u0194\u0198\u01a4\u01b0"+
		"\u01b4\u01b8\u01ba\u01c4\u01f9\u01fb\u0204\u020d\u0211\u0219\u021c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}