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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, DecimalNumeral=9, 
		Digits=10, HexNumeral=11, OctalNumeral=12, BinaryNumeral=13, CharacterLiteral=14, 
		StringLiteral=15, BREAK=16, CASE=17, CATCH=18, CLASS=19, CONST=20, CONTINUE=21, 
		DEFAULT=22, ELSE=23, ENUM=24, EXTENDS=25, FINAL=26, FINALLY=27, FOR=28, 
		IF=29, IMPLEMENTS=30, IMPORT=31, INSTANCEOF=32, INTERFACE=33, NEW=34, 
		PACKAGE=35, PRIVATE=36, PROTECTED=37, PUBLIC=38, RETURN=39, STATIC=40, 
		SUPER=41, SWITCH=42, SYNCHRONIZED=43, THIS=44, THROW=45, THROWS=46, TRY=47, 
		VOID=48, WHILE=49, VAR=50, OBJ=51, NUM=52, INT=53, FLT=54, STR=55, CHR=56, 
		BOL=57, BYT=58, IN=59, LPAREN=60, RPAREN=61, LBRACE=62, RBRACE=63, LBRACK=64, 
		RBRACK=65, SEMI=66, COMMA=67, DOT=68, ASSIGN=69, GT=70, LT=71, BANG=72, 
		TILDE=73, QUESTION=74, COLON=75, EQUAL=76, LE=77, GE=78, NOTEQUAL=79, 
		AND=80, OR=81, INC=82, DEC=83, ADD=84, SUB=85, MUL=86, DIV=87, BITAND=88, 
		BITOR=89, CARET=90, MOD=91, ADD_ASSIGN=92, SUB_ASSIGN=93, MUL_ASSIGN=94, 
		DIV_ASSIGN=95, AND_ASSIGN=96, OR_ASSIGN=97, XOR_ASSIGN=98, MOD_ASSIGN=99, 
		LSHIFT_ASSIGN=100, RSHIFT_ASSIGN=101, URSHIFT_ASSIGN=102, Identifier=103, 
		AT=104, ELLIPSIS=105, WS=106, COMMENT=107, LINE_COMMENT=108;
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_classInstanceModifier = 3, RULE_classDeclaration = 4, RULE_typeList = 5, 
		RULE_classBody = 6, RULE_classBodyDeclaration = 7, RULE_methodDeclaration = 8, 
		RULE_inputParameters = 9, RULE_inputParameter = 10, RULE_outputParameters = 11, 
		RULE_outputParameter = 12, RULE_constructorDeclaration = 13, RULE_fieldDeclaration = 14, 
		RULE_typeOrArray = 15, RULE_type = 16, RULE_array = 17, RULE_primitiveType = 18, 
		RULE_methodBody = 19, RULE_constructorBody = 20, RULE_qualifiedName = 21, 
		RULE_literal = 22, RULE_block = 23, RULE_statement = 24, RULE_variableDeclarationStatement = 25, 
		RULE_variableDeclaration = 26, RULE_label = 27, RULE_ifStatement = 28, 
		RULE_catchClause = 29, RULE_finallyBlock = 30, RULE_switchBlockStatementGroup = 31, 
		RULE_switchLabel = 32, RULE_forControl = 33, RULE_parExpression = 34, 
		RULE_expression = 35, RULE_primary = 36, RULE_creator = 37, RULE_arguments = 38, 
		RULE_integerLiteral = 39, RULE_floatingPointLiteral = 40, RULE_booleanLiteral = 41, 
		RULE_characterLiteral = 42, RULE_stringLiteral = 43, RULE_nullLiteral = 44;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "classInstanceModifier", 
		"classDeclaration", "typeList", "classBody", "classBodyDeclaration", "methodDeclaration", 
		"inputParameters", "inputParameter", "outputParameters", "outputParameter", 
		"constructorDeclaration", "fieldDeclaration", "typeOrArray", "type", "array", 
		"primitiveType", "methodBody", "constructorBody", "qualifiedName", "literal", 
		"block", "statement", "variableDeclarationStatement", "variableDeclaration", 
		"label", "ifStatement", "catchClause", "finallyBlock", "switchBlockStatementGroup", 
		"switchLabel", "forControl", "parExpression", "expression", "primary", 
		"creator", "arguments", "integerLiteral", "floatingPointLiteral", "booleanLiteral", 
		"characterLiteral", "stringLiteral", "nullLiteral"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'dec'", "'fallthrough'", "'<<'", "'>>>'", "'>>'", "'true'", "'false'", 
		"'null'", null, null, null, null, null, null, null, "'break'", "'case'", 
		"'catch'", "'class'", "'const'", "'continue'", "'default'", "'else'", 
		"'enum'", "'extends'", "'final'", "'finally'", "'for'", "'if'", "'implements'", 
		"'import'", "'instanceof'", "'interface'", "'new'", "'package'", "'private'", 
		"'protected'", "'public'", "'return'", "'static'", "'super'", "'switch'", 
		"'synchronized'", "'this'", "'throw'", "'throws'", "'try'", "'void'", 
		"'while'", "'var'", "'obj'", "'num'", "'int'", "'flt'", "'str'", "'chr'", 
		"'bol'", "'byt'", "'in'", "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", 
		"','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", "'=='", 
		"'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", "'-'", 
		"'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", "'/='", 
		"'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", null, "'@'", 
		"'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "DecimalNumeral", 
		"Digits", "HexNumeral", "OctalNumeral", "BinaryNumeral", "CharacterLiteral", 
		"StringLiteral", "BREAK", "CASE", "CATCH", "CLASS", "CONST", "CONTINUE", 
		"DEFAULT", "ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FOR", "IF", 
		"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INTERFACE", "NEW", "PACKAGE", "PRIVATE", 
		"PROTECTED", "PUBLIC", "RETURN", "STATIC", "SUPER", "SWITCH", "SYNCHRONIZED", 
		"THIS", "THROW", "THROWS", "TRY", "VOID", "WHILE", "VAR", "OBJ", "NUM", 
		"INT", "FLT", "STR", "CHR", "BOL", "BYT", "IN", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", 
		"LT", "BANG", "TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", 
		"AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", 
		"CARET", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
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
			setState(91);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(90);
				packageDeclaration();
				}
			}

			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(93);
				importDeclaration();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			classDeclaration();
			setState(100);
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
			setState(102);
			match(PACKAGE);
			setState(103);
			qualifiedName();
			setState(104);
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
			setState(106);
			match(IMPORT);
			setState(107);
			qualifiedName();
			setState(110);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(108);
				match(DOT);
				setState(109);
				((ImportDeclarationContext)_localctx).ast = match(MUL);
				}
			}

			setState(112);
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
			setState(114);
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
			setState(116);
			match(CLASS);
			setState(117);
			match(Identifier);
			setState(120);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(118);
				match(EXTENDS);
				setState(119);
				type();
				}
			}

			setState(124);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(122);
				match(IMPLEMENTS);
				setState(123);
				typeList();
				}
			}

			setState(126);
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
			setState(128);
			type();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(129);
				match(COMMA);
				setState(130);
				type();
				}
				}
				setState(135);
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
			setState(136);
			match(LBRACE);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (STATIC - 40)) | (1L << (VAR - 40)) | (1L << (SEMI - 40)) | (1L << (Identifier - 40)))) != 0)) {
				{
				{
				setState(137);
				classBodyDeclaration();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
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
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				constructorDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				methodDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
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
			setState(152);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(151);
				classInstanceModifier();
				}
			}

			setState(154);
			match(Identifier);
			setState(155);
			inputParameters();
			setState(156);
			outputParameters();
			setState(157);
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
			setState(159);
			match(LPAREN);
			setState(168);
			_la = _input.LA(1);
			if (_la==VAR || _la==Identifier) {
				{
				setState(160);
				inputParameter();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(161);
					match(COMMA);
					setState(162);
					inputParameter();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(170);
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
			setState(173);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(172);
				match(VAR);
				}
			}

			setState(175);
			match(Identifier);
			setState(176);
			match(COLON);
			setState(177);
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
			setState(179);
			match(LPAREN);
			setState(188);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << VAR) | (1L << OBJ) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT))) != 0) || _la==LBRACK || _la==Identifier) {
				{
				setState(180);
				outputParameter();
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(181);
					match(COMMA);
					setState(182);
					outputParameter();
					}
					}
					setState(187);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(190);
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
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(193);
				_la = _input.LA(1);
				if (_la==VAR) {
					{
					setState(192);
					match(VAR);
					}
				}

				setState(195);
				match(Identifier);
				setState(196);
				match(COLON);
				}
				break;
			}
			setState(199);
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
			setState(201);
			match(Identifier);
			setState(202);
			inputParameters();
			setState(203);
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
			setState(206);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(205);
				classInstanceModifier();
				}
			}

			setState(208);
			match(VAR);
			setState(209);
			variableDeclarationStatement();
			setState(210);
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
			setState(214);
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
				setState(212);
				type();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
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
			setState(218);
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
				setState(216);
				primitiveType();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
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
			setState(220);
			match(LBRACK);
			setState(221);
			typeOrArray();
			setState(224);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(222);
				match(COLON);
				setState(223);
				typeOrArray();
				}
			}

			setState(226);
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
			setState(228);
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
			setState(230);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 42, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(Identifier);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(235);
					match(DOT);
					setState(236);
					match(Identifier);
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 44, RULE_literal);
		try {
			setState(248);
			switch (_input.LA(1)) {
			case DecimalNumeral:
			case HexNumeral:
			case OctalNumeral:
			case BinaryNumeral:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				integerLiteral();
				}
				break;
			case Digits:
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				floatingPointLiteral();
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				characterLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(245);
				stringLiteral();
				}
				break;
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(246);
				booleanLiteral();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(247);
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
		enterRule(_localctx, 46, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(LBRACE);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THROW) | (1L << TRY) | (1L << WHILE) | (1L << VAR) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (SEMI - 66)) | (1L << (DOT - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				{
				setState(251);
				statement();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
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
		enterRule(_localctx, 48, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				block();
				}
				break;
			case 2:
				_localctx = new StatementEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new StatementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				expression(0);
				setState(262);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new StatementVarContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				match(VAR);
				setState(265);
				variableDeclarationStatement();
				setState(266);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				match(RETURN);
				setState(270);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(269);
					expression(0);
					}
				}

				setState(272);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(273);
				match(IF);
				setState(274);
				ifStatement();
				}
				break;
			case 7:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(275);
				label();
				setState(276);
				match(WHILE);
				setState(277);
				parExpression();
				setState(278);
				block();
				}
				break;
			case 8:
				_localctx = new StatementForContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(280);
				label();
				setState(281);
				match(FOR);
				setState(282);
				match(LPAREN);
				setState(283);
				forControl();
				setState(284);
				match(RPAREN);
				setState(285);
				block();
				}
				break;
			case 9:
				_localctx = new StatementSwitchContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(287);
				match(SWITCH);
				setState(288);
				parExpression();
				setState(289);
				match(LBRACE);
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(290);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(295);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(296);
					switchLabel();
					}
					}
					setState(301);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(302);
				match(RBRACE);
				}
				break;
			case 10:
				_localctx = new StatementBreakContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(304);
				match(BREAK);
				setState(305);
				label();
				setState(306);
				match(SEMI);
				}
				break;
			case 11:
				_localctx = new StatementContinueContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(308);
				match(CONTINUE);
				setState(309);
				label();
				setState(310);
				match(SEMI);
				}
				break;
			case 12:
				_localctx = new StatementTryContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(312);
				match(TRY);
				setState(313);
				block();
				setState(323);
				switch (_input.LA(1)) {
				case CATCH:
					{
					setState(315); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(314);
						catchClause();
						}
						}
						setState(317); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CATCH );
					setState(320);
					_la = _input.LA(1);
					if (_la==FINALLY) {
						{
						setState(319);
						finallyBlock();
						}
					}

					}
					break;
				case FINALLY:
					{
					setState(322);
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
				setState(325);
				match(THROW);
				setState(326);
				expression(0);
				setState(327);
				match(SEMI);
				}
				break;
			case 14:
				_localctx = new StatementSynchronizedContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(329);
				match(SYNCHRONIZED);
				setState(330);
				parExpression();
				setState(331);
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
		enterRule(_localctx, 50, RULE_variableDeclarationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			variableDeclaration();
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(336);
				match(COMMA);
				setState(337);
				variableDeclaration();
				}
				}
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(345);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(343);
				match(ASSIGN);
				setState(344);
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
		enterRule(_localctx, 52, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(Identifier);
			setState(350);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(348);
				match(COLON);
				setState(349);
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
		enterRule(_localctx, 54, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(352);
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
		enterRule(_localctx, 56, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			parExpression();
			setState(356);
			((IfStatementContext)_localctx).fulfillmentBlock = block();
			setState(362);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(357);
				match(ELSE);
				setState(360);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					setState(358);
					ifStatement();
					}
					break;
				case LBRACE:
					{
					setState(359);
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
		enterRule(_localctx, 58, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(CATCH);
			setState(365);
			match(LPAREN);
			setState(366);
			match(VAR);
			setState(367);
			match(Identifier);
			setState(370);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(368);
				match(COLON);
				setState(369);
				qualifiedName();
				}
			}

			setState(372);
			match(RPAREN);
			setState(373);
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
		enterRule(_localctx, 60, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(FINALLY);
			setState(376);
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
		enterRule(_localctx, 62, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(378);
				switchLabel();
				}
				}
				setState(381); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(384); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(383);
				statement();
				}
				}
				setState(386); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << SYNCHRONIZED) | (1L << THROW) | (1L << TRY) | (1L << WHILE) | (1L << VAR) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (SEMI - 66)) | (1L << (DOT - 66)) | (1L << (Identifier - 66)))) != 0) );
			setState(390);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(388);
				((SwitchBlockStatementGroupContext)_localctx).fallthrough = match(T__1);
				setState(389);
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
		enterRule(_localctx, 64, RULE_switchLabel);
		try {
			setState(402);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new SwitchLabelCaseIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(392);
				match(CASE);
				setState(393);
				integerLiteral();
				setState(394);
				match(COLON);
				}
				break;
			case 2:
				_localctx = new SwitchLabelCaseStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(396);
				match(CASE);
				setState(397);
				stringLiteral();
				setState(398);
				match(COLON);
				}
				break;
			case 3:
				_localctx = new SwitchLabelDefaultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(400);
				match(DEFAULT);
				setState(401);
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
		enterRule(_localctx, 66, RULE_forControl);
		int _la;
		try {
			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new ForControlIteratorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(404);
				match(VAR);
				setState(405);
				match(Identifier);
				setState(406);
				match(COLON);
				setState(407);
				typeOrArray();
				setState(408);
				match(IN);
				setState(409);
				expression(0);
				}
				break;
			case 2:
				_localctx = new ForControlICUContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(411);
					match(VAR);
					setState(412);
					variableDeclarationStatement();
					}
					break;
				case T__5:
				case T__6:
				case T__7:
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
					setState(413);
					((ForControlICUContext)_localctx).init = expression(0);
					}
					break;
				case SEMI:
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(416);
				match(SEMI);
				setState(418);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(417);
					((ForControlICUContext)_localctx).control = expression(0);
					}
				}

				setState(420);
				match(SEMI);
				setState(422);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(421);
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
		enterRule(_localctx, 68, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(LPAREN);
			setState(427);
			expression(0);
			setState(428);
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
	public static class ExpressionMultipleValueContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMultipleValueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionMultipleValue(this);
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

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
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

				setState(431);
				primary();
				}
				break;
			case NEW:
				{
				_localctx = new ExpressionNewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(432);
				match(NEW);
				setState(433);
				creator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(488);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(486);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(436);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(437);
						((ExpressionMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (MUL - 86)) | (1L << (DIV - 86)) | (1L << (MOD - 86)))) != 0)) ) {
							((ExpressionMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(438);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(439);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(440);
						((ExpressionAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(441);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(442);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(443);
						((ExpressionShiftContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
							((ExpressionShiftContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(444);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionCompareContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(445);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(446);
						((ExpressionCompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (GT - 70)) | (1L << (LT - 70)) | (1L << (LE - 70)) | (1L << (GE - 70)))) != 0)) ) {
							((ExpressionCompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(447);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(448);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(449);
						((ExpressionEqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionEqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(450);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionBitAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(451);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(452);
						match(BITAND);
						setState(453);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionBitExOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(454);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(455);
						match(CARET);
						setState(456);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionBitOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(457);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(458);
						match(BITOR);
						setState(459);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionBolAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(460);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(461);
						match(AND);
						setState(462);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionBolOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(463);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(464);
						match(OR);
						setState(465);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(466);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(467);
						((ExpressionAssignContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ASSIGN - 69)) | (1L << (ADD_ASSIGN - 69)) | (1L << (SUB_ASSIGN - 69)) | (1L << (MUL_ASSIGN - 69)) | (1L << (DIV_ASSIGN - 69)) | (1L << (AND_ASSIGN - 69)) | (1L << (OR_ASSIGN - 69)) | (1L << (XOR_ASSIGN - 69)) | (1L << (MOD_ASSIGN - 69)) | (1L << (LSHIFT_ASSIGN - 69)) | (1L << (RSHIFT_ASSIGN - 69)) | (1L << (URSHIFT_ASSIGN - 69)))) != 0)) ) {
							((ExpressionAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(468);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionClassFieldRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(469);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(470);
						match(DOT);
						setState(471);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionInvokeMethodContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(472);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(473);
						arguments();
						}
						break;
					case 14:
						{
						_localctx = new ExpressionArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(474);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(475);
						match(LBRACK);
						setState(476);
						expression(0);
						setState(477);
						match(RBRACK);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionMultipleValueContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(479);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(482); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(480);
								match(COMMA);
								setState(481);
								expression(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(484); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(490);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		enterRule(_localctx, 72, RULE_primary);
		try {
			setState(497);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimaryParensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				match(LPAREN);
				setState(492);
				expression(0);
				setState(493);
				match(RPAREN);
				}
				break;
			case T__5:
			case T__6:
			case T__7:
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
				setState(495);
				literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(496);
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
		enterRule(_localctx, 74, RULE_creator);
		try {
			setState(506);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new CreatorClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				qualifiedName();
				setState(500);
				arguments();
				}
				break;
			case LBRACK:
				_localctx = new CreatorArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(502);
				array();
				setState(503);
				match(LPAREN);
				setState(504);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 76, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(LPAREN);
			setState(517);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
				{
				setState(509);
				expression(0);
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(510);
					match(COMMA);
					setState(511);
					expression(0);
					}
					}
					setState(516);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(519);
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
		enterRule(_localctx, 78, RULE_integerLiteral);
		try {
			setState(525);
			switch (_input.LA(1)) {
			case DecimalNumeral:
				_localctx = new IntegerLiteralDecimalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				match(DecimalNumeral);
				}
				break;
			case HexNumeral:
				_localctx = new IntegerLiteralHexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
				match(HexNumeral);
				}
				break;
			case OctalNumeral:
				_localctx = new IntegerLiteralOctalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				match(OctalNumeral);
				}
				break;
			case BinaryNumeral:
				_localctx = new IntegerLiteralBinaryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(524);
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
		enterRule(_localctx, 80, RULE_floatingPointLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			_la = _input.LA(1);
			if (_la==Digits) {
				{
				setState(527);
				match(Digits);
				}
			}

			setState(530);
			match(DOT);
			setState(531);
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
		enterRule(_localctx, 82, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			_la = _input.LA(1);
			if ( !(_la==T__5 || _la==T__6) ) {
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
		enterRule(_localctx, 84, RULE_characterLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
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
		enterRule(_localctx, 86, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
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
		enterRule(_localctx, 88, RULE_nullLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			match(T__7);
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
		case 35:
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
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 16);
		case 12:
			return precpred(_ctx, 15);
		case 13:
			return precpred(_ctx, 13);
		case 14:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3n\u0220\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\5\2^\n\2\3\2\7\2a\n\2\f\2\16\2d\13\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4q\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\5\6{\n\6\3\6\3\6\5\6\177\n\6\3\6\3\6\3\7\3\7\3\7\7\7\u0086\n\7\f"+
		"\7\16\7\u0089\13\7\3\b\3\b\7\b\u008d\n\b\f\b\16\b\u0090\13\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\5\t\u0098\n\t\3\n\5\n\u009b\n\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\7\13\u00a6\n\13\f\13\16\13\u00a9\13\13\5\13\u00ab\n\13"+
		"\3\13\3\13\3\f\5\f\u00b0\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00ba"+
		"\n\r\f\r\16\r\u00bd\13\r\5\r\u00bf\n\r\3\r\3\r\3\16\5\16\u00c4\n\16\3"+
		"\16\3\16\5\16\u00c8\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\5\20\u00d1"+
		"\n\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00d9\n\21\3\22\3\22\5\22\u00dd"+
		"\n\22\3\23\3\23\3\23\3\23\5\23\u00e3\n\23\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\7\27\u00f0\n\27\f\27\16\27\u00f3\13\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u00fb\n\30\3\31\3\31\7\31\u00ff\n\31\f"+
		"\31\16\31\u0102\13\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u0111\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0126\n\32"+
		"\f\32\16\32\u0129\13\32\3\32\7\32\u012c\n\32\f\32\16\32\u012f\13\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\6\32\u013e"+
		"\n\32\r\32\16\32\u013f\3\32\5\32\u0143\n\32\3\32\5\32\u0146\n\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0150\n\32\3\33\3\33\3\33\7\33"+
		"\u0155\n\33\f\33\16\33\u0158\13\33\3\33\3\33\5\33\u015c\n\33\3\34\3\34"+
		"\3\34\5\34\u0161\n\34\3\35\5\35\u0164\n\35\3\36\3\36\3\36\3\36\3\36\5"+
		"\36\u016b\n\36\5\36\u016d\n\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0175"+
		"\n\37\3\37\3\37\3\37\3 \3 \3 \3!\6!\u017e\n!\r!\16!\u017f\3!\6!\u0183"+
		"\n!\r!\16!\u0184\3!\3!\5!\u0189\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\5\"\u0195\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01a1\n#\3#\3#\5#"+
		"\u01a5\n#\3#\3#\5#\u01a9\n#\5#\u01ab\n#\3$\3$\3$\3$\3%\3%\3%\3%\5%\u01b5"+
		"\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\6%\u01e5\n%\r%\16%\u01e6\7%\u01e9\n%\f%\16%\u01ec\13%\3&\3&\3&\3&"+
		"\3&\3&\5&\u01f4\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01fd\n\'\3(\3(\3("+
		"\3(\7(\u0203\n(\f(\16(\u0206\13(\5(\u0208\n(\3(\3(\3)\3)\3)\3)\5)\u0210"+
		"\n)\3*\5*\u0213\n*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\2\3H/\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\2"+
		"\n\4\2\3\3\65<\4\2XY]]\3\2VW\3\2\5\7\4\2HIOP\4\2NNQQ\4\2GG^h\3\2\b\t\u024d"+
		"\2]\3\2\2\2\4h\3\2\2\2\6l\3\2\2\2\bt\3\2\2\2\nv\3\2\2\2\f\u0082\3\2\2"+
		"\2\16\u008a\3\2\2\2\20\u0097\3\2\2\2\22\u009a\3\2\2\2\24\u00a1\3\2\2\2"+
		"\26\u00af\3\2\2\2\30\u00b5\3\2\2\2\32\u00c7\3\2\2\2\34\u00cb\3\2\2\2\36"+
		"\u00d0\3\2\2\2 \u00d8\3\2\2\2\"\u00dc\3\2\2\2$\u00de\3\2\2\2&\u00e6\3"+
		"\2\2\2(\u00e8\3\2\2\2*\u00ea\3\2\2\2,\u00ec\3\2\2\2.\u00fa\3\2\2\2\60"+
		"\u00fc\3\2\2\2\62\u014f\3\2\2\2\64\u0151\3\2\2\2\66\u015d\3\2\2\28\u0163"+
		"\3\2\2\2:\u0165\3\2\2\2<\u016e\3\2\2\2>\u0179\3\2\2\2@\u017d\3\2\2\2B"+
		"\u0194\3\2\2\2D\u01aa\3\2\2\2F\u01ac\3\2\2\2H\u01b4\3\2\2\2J\u01f3\3\2"+
		"\2\2L\u01fc\3\2\2\2N\u01fe\3\2\2\2P\u020f\3\2\2\2R\u0212\3\2\2\2T\u0217"+
		"\3\2\2\2V\u0219\3\2\2\2X\u021b\3\2\2\2Z\u021d\3\2\2\2\\^\5\4\3\2]\\\3"+
		"\2\2\2]^\3\2\2\2^b\3\2\2\2_a\5\6\4\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3"+
		"\2\2\2ce\3\2\2\2db\3\2\2\2ef\5\n\6\2fg\7\2\2\3g\3\3\2\2\2hi\7%\2\2ij\5"+
		",\27\2jk\7D\2\2k\5\3\2\2\2lm\7!\2\2mp\5,\27\2no\7F\2\2oq\7X\2\2pn\3\2"+
		"\2\2pq\3\2\2\2qr\3\2\2\2rs\7D\2\2s\7\3\2\2\2tu\7*\2\2u\t\3\2\2\2vw\7\25"+
		"\2\2wz\7i\2\2xy\7\33\2\2y{\5\"\22\2zx\3\2\2\2z{\3\2\2\2{~\3\2\2\2|}\7"+
		" \2\2}\177\5\f\7\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081"+
		"\5\16\b\2\u0081\13\3\2\2\2\u0082\u0087\5\"\22\2\u0083\u0084\7E\2\2\u0084"+
		"\u0086\5\"\22\2\u0085\u0083\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0088\r\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008e"+
		"\7@\2\2\u008b\u008d\5\20\t\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0091\u0092\7A\2\2\u0092\17\3\2\2\2\u0093\u0098\7D\2\2\u0094\u0098"+
		"\5\34\17\2\u0095\u0098\5\22\n\2\u0096\u0098\5\36\20\2\u0097\u0093\3\2"+
		"\2\2\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098"+
		"\21\3\2\2\2\u0099\u009b\5\b\5\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2"+
		"\2\u009b\u009c\3\2\2\2\u009c\u009d\7i\2\2\u009d\u009e\5\24\13\2\u009e"+
		"\u009f\5\30\r\2\u009f\u00a0\5(\25\2\u00a0\23\3\2\2\2\u00a1\u00aa\7>\2"+
		"\2\u00a2\u00a7\5\26\f\2\u00a3\u00a4\7E\2\2\u00a4\u00a6\5\26\f\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00a2\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7?\2\2\u00ad\25\3\2\2\2"+
		"\u00ae\u00b0\7\64\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00b2\7i\2\2\u00b2\u00b3\7M\2\2\u00b3\u00b4\5 \21\2\u00b4"+
		"\27\3\2\2\2\u00b5\u00be\7>\2\2\u00b6\u00bb\5\32\16\2\u00b7\u00b8\7E\2"+
		"\2\u00b8\u00ba\5\32\16\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00be\u00b6\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\7?\2\2\u00c1\31\3\2\2\2\u00c2\u00c4\7\64\2\2\u00c3\u00c2\3\2\2"+
		"\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7i\2\2\u00c6\u00c8"+
		"\7M\2\2\u00c7\u00c3\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\5 \21\2\u00ca\33\3\2\2\2\u00cb\u00cc\7i\2\2\u00cc\u00cd\5\24\13"+
		"\2\u00cd\u00ce\5*\26\2\u00ce\35\3\2\2\2\u00cf\u00d1\5\b\5\2\u00d0\u00cf"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7\64\2\2"+
		"\u00d3\u00d4\5\64\33\2\u00d4\u00d5\7D\2\2\u00d5\37\3\2\2\2\u00d6\u00d9"+
		"\5\"\22\2\u00d7\u00d9\5$\23\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2"+
		"\u00d9!\3\2\2\2\u00da\u00dd\5&\24\2\u00db\u00dd\5,\27\2\u00dc\u00da\3"+
		"\2\2\2\u00dc\u00db\3\2\2\2\u00dd#\3\2\2\2\u00de\u00df\7B\2\2\u00df\u00e2"+
		"\5 \21\2\u00e0\u00e1\7M\2\2\u00e1\u00e3\5 \21\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7C\2\2\u00e5%\3\2\2\2\u00e6"+
		"\u00e7\t\2\2\2\u00e7\'\3\2\2\2\u00e8\u00e9\5\60\31\2\u00e9)\3\2\2\2\u00ea"+
		"\u00eb\5\60\31\2\u00eb+\3\2\2\2\u00ec\u00f1\7i\2\2\u00ed\u00ee\7F\2\2"+
		"\u00ee\u00f0\7i\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef"+
		"\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2-\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\u00fb\5P)\2\u00f5\u00fb\5R*\2\u00f6\u00fb\5V,\2\u00f7\u00fb\5X-\2\u00f8"+
		"\u00fb\5T+\2\u00f9\u00fb\5Z.\2\u00fa\u00f4\3\2\2\2\u00fa\u00f5\3\2\2\2"+
		"\u00fa\u00f6\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9"+
		"\3\2\2\2\u00fb/\3\2\2\2\u00fc\u0100\7@\2\2\u00fd\u00ff\5\62\32\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2"+
		"\2\2\u0101\u0103\3\2\2\2\u0102\u0100\3\2\2\2\u0103\u0104\7A\2\2\u0104"+
		"\61\3\2\2\2\u0105\u0150\5\60\31\2\u0106\u0150\7D\2\2\u0107\u0108\5H%\2"+
		"\u0108\u0109\7D\2\2\u0109\u0150\3\2\2\2\u010a\u010b\7\64\2\2\u010b\u010c"+
		"\5\64\33\2\u010c\u010d\7D\2\2\u010d\u0150\3\2\2\2\u010e\u0110\7)\2\2\u010f"+
		"\u0111\5H%\2\u0110\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2"+
		"\2\u0112\u0150\7D\2\2\u0113\u0114\7\37\2\2\u0114\u0150\5:\36\2\u0115\u0116"+
		"\58\35\2\u0116\u0117\7\63\2\2\u0117\u0118\5F$\2\u0118\u0119\5\60\31\2"+
		"\u0119\u0150\3\2\2\2\u011a\u011b\58\35\2\u011b\u011c\7\36\2\2\u011c\u011d"+
		"\7>\2\2\u011d\u011e\5D#\2\u011e\u011f\7?\2\2\u011f\u0120\5\60\31\2\u0120"+
		"\u0150\3\2\2\2\u0121\u0122\7,\2\2\u0122\u0123\5F$\2\u0123\u0127\7@\2\2"+
		"\u0124\u0126\5@!\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012d\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012c\5B\"\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130"+
		"\u0131\7A\2\2\u0131\u0150\3\2\2\2\u0132\u0133\7\22\2\2\u0133\u0134\58"+
		"\35\2\u0134\u0135\7D\2\2\u0135\u0150\3\2\2\2\u0136\u0137\7\27\2\2\u0137"+
		"\u0138\58\35\2\u0138\u0139\7D\2\2\u0139\u0150\3\2\2\2\u013a\u013b\7\61"+
		"\2\2\u013b\u0145\5\60\31\2\u013c\u013e\5<\37\2\u013d\u013c\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2"+
		"\2\2\u0141\u0143\5> \2\u0142\u0141\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0146"+
		"\3\2\2\2\u0144\u0146\5> \2\u0145\u013d\3\2\2\2\u0145\u0144\3\2\2\2\u0146"+
		"\u0150\3\2\2\2\u0147\u0148\7/\2\2\u0148\u0149\5H%\2\u0149\u014a\7D\2\2"+
		"\u014a\u0150\3\2\2\2\u014b\u014c\7-\2\2\u014c\u014d\5F$\2\u014d\u014e"+
		"\5\60\31\2\u014e\u0150\3\2\2\2\u014f\u0105\3\2\2\2\u014f\u0106\3\2\2\2"+
		"\u014f\u0107\3\2\2\2\u014f\u010a\3\2\2\2\u014f\u010e\3\2\2\2\u014f\u0113"+
		"\3\2\2\2\u014f\u0115\3\2\2\2\u014f\u011a\3\2\2\2\u014f\u0121\3\2\2\2\u014f"+
		"\u0132\3\2\2\2\u014f\u0136\3\2\2\2\u014f\u013a\3\2\2\2\u014f\u0147\3\2"+
		"\2\2\u014f\u014b\3\2\2\2\u0150\63\3\2\2\2\u0151\u0156\5\66\34\2\u0152"+
		"\u0153\7E\2\2\u0153\u0155\5\66\34\2\u0154\u0152\3\2\2\2\u0155\u0158\3"+
		"\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015b\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0159\u015a\7G\2\2\u015a\u015c\5H%\2\u015b\u0159\3\2\2"+
		"\2\u015b\u015c\3\2\2\2\u015c\65\3\2\2\2\u015d\u0160\7i\2\2\u015e\u015f"+
		"\7M\2\2\u015f\u0161\5 \21\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161"+
		"\67\3\2\2\2\u0162\u0164\7i\2\2\u0163\u0162\3\2\2\2\u0163\u0164\3\2\2\2"+
		"\u01649\3\2\2\2\u0165\u0166\5F$\2\u0166\u016c\5\60\31\2\u0167\u016a\7"+
		"\31\2\2\u0168\u016b\5:\36\2\u0169\u016b\5\60\31\2\u016a\u0168\3\2\2\2"+
		"\u016a\u0169\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u0167\3\2\2\2\u016c\u016d"+
		"\3\2\2\2\u016d;\3\2\2\2\u016e\u016f\7\24\2\2\u016f\u0170\7>\2\2\u0170"+
		"\u0171\7\64\2\2\u0171\u0174\7i\2\2\u0172\u0173\7M\2\2\u0173\u0175\5,\27"+
		"\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177"+
		"\7?\2\2\u0177\u0178\5\60\31\2\u0178=\3\2\2\2\u0179\u017a\7\35\2\2\u017a"+
		"\u017b\5\60\31\2\u017b?\3\2\2\2\u017c\u017e\5B\"\2\u017d\u017c\3\2\2\2"+
		"\u017e\u017f\3\2\2\2\u017f\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182"+
		"\3\2\2\2\u0181\u0183\5\62\32\2\u0182\u0181\3\2\2\2\u0183\u0184\3\2\2\2"+
		"\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0187"+
		"\7\4\2\2\u0187\u0189\7D\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"A\3\2\2\2\u018a\u018b\7\23\2\2\u018b\u018c\5P)\2\u018c\u018d\7M\2\2\u018d"+
		"\u0195\3\2\2\2\u018e\u018f\7\23\2\2\u018f\u0190\5X-\2\u0190\u0191\7M\2"+
		"\2\u0191\u0195\3\2\2\2\u0192\u0193\7\30\2\2\u0193\u0195\7M\2\2\u0194\u018a"+
		"\3\2\2\2\u0194\u018e\3\2\2\2\u0194\u0192\3\2\2\2\u0195C\3\2\2\2\u0196"+
		"\u0197\7\64\2\2\u0197\u0198\7i\2\2\u0198\u0199\7M\2\2\u0199\u019a\5 \21"+
		"\2\u019a\u019b\7=\2\2\u019b\u019c\5H%\2\u019c\u01ab\3\2\2\2\u019d\u019e"+
		"\7\64\2\2\u019e\u01a1\5\64\33\2\u019f\u01a1\5H%\2\u01a0\u019d\3\2\2\2"+
		"\u01a0\u019f\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4"+
		"\7D\2\2\u01a3\u01a5\5H%\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6\u01a8\7D\2\2\u01a7\u01a9\5H%\2\u01a8\u01a7\3\2\2"+
		"\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u0196\3\2\2\2\u01aa\u01a0"+
		"\3\2\2\2\u01abE\3\2\2\2\u01ac\u01ad\7>\2\2\u01ad\u01ae\5H%\2\u01ae\u01af"+
		"\7?\2\2\u01afG\3\2\2\2\u01b0\u01b1\b%\1\2\u01b1\u01b5\5J&\2\u01b2\u01b3"+
		"\7$\2\2\u01b3\u01b5\5L\'\2\u01b4\u01b0\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5"+
		"\u01ea\3\2\2\2\u01b6\u01b7\f\16\2\2\u01b7\u01b8\t\3\2\2\u01b8\u01e9\5"+
		"H%\17\u01b9\u01ba\f\r\2\2\u01ba\u01bb\t\4\2\2\u01bb\u01e9\5H%\16\u01bc"+
		"\u01bd\f\f\2\2\u01bd\u01be\t\5\2\2\u01be\u01e9\5H%\r\u01bf\u01c0\f\13"+
		"\2\2\u01c0\u01c1\t\6\2\2\u01c1\u01e9\5H%\f\u01c2\u01c3\f\n\2\2\u01c3\u01c4"+
		"\t\7\2\2\u01c4\u01e9\5H%\13\u01c5\u01c6\f\t\2\2\u01c6\u01c7\7Z\2\2\u01c7"+
		"\u01e9\5H%\n\u01c8\u01c9\f\b\2\2\u01c9\u01ca\7\\\2\2\u01ca\u01e9\5H%\t"+
		"\u01cb\u01cc\f\7\2\2\u01cc\u01cd\7[\2\2\u01cd\u01e9\5H%\b\u01ce\u01cf"+
		"\f\6\2\2\u01cf\u01d0\7R\2\2\u01d0\u01e9\5H%\7\u01d1\u01d2\f\5\2\2\u01d2"+
		"\u01d3\7S\2\2\u01d3\u01e9\5H%\6\u01d4\u01d5\f\3\2\2\u01d5\u01d6\t\b\2"+
		"\2\u01d6\u01e9\5H%\3\u01d7\u01d8\f\22\2\2\u01d8\u01d9\7F\2\2\u01d9\u01e9"+
		"\7i\2\2\u01da\u01db\f\21\2\2\u01db\u01e9\5N(\2\u01dc\u01dd\f\17\2\2\u01dd"+
		"\u01de\7B\2\2\u01de\u01df\5H%\2\u01df\u01e0\7C\2\2\u01e0\u01e9\3\2\2\2"+
		"\u01e1\u01e4\f\4\2\2\u01e2\u01e3\7E\2\2\u01e3\u01e5\5H%\2\u01e4\u01e2"+
		"\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"\u01e9\3\2\2\2\u01e8\u01b6\3\2\2\2\u01e8\u01b9\3\2\2\2\u01e8\u01bc\3\2"+
		"\2\2\u01e8\u01bf\3\2\2\2\u01e8\u01c2\3\2\2\2\u01e8\u01c5\3\2\2\2\u01e8"+
		"\u01c8\3\2\2\2\u01e8\u01cb\3\2\2\2\u01e8\u01ce\3\2\2\2\u01e8\u01d1\3\2"+
		"\2\2\u01e8\u01d4\3\2\2\2\u01e8\u01d7\3\2\2\2\u01e8\u01da\3\2\2\2\u01e8"+
		"\u01dc\3\2\2\2\u01e8\u01e1\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2"+
		"\2\2\u01ea\u01eb\3\2\2\2\u01ebI\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01ee"+
		"\7>\2\2\u01ee\u01ef\5H%\2\u01ef\u01f0\7?\2\2\u01f0\u01f4\3\2\2\2\u01f1"+
		"\u01f4\5.\30\2\u01f2\u01f4\7i\2\2\u01f3\u01ed\3\2\2\2\u01f3\u01f1\3\2"+
		"\2\2\u01f3\u01f2\3\2\2\2\u01f4K\3\2\2\2\u01f5\u01f6\5,\27\2\u01f6\u01f7"+
		"\5N(\2\u01f7\u01fd\3\2\2\2\u01f8\u01f9\5$\23\2\u01f9\u01fa\7>\2\2\u01fa"+
		"\u01fb\7?\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01f5\3\2\2\2\u01fc\u01f8\3\2"+
		"\2\2\u01fdM\3\2\2\2\u01fe\u0207\7>\2\2\u01ff\u0204\5H%\2\u0200\u0201\7"+
		"E\2\2\u0201\u0203\5H%\2\u0202\u0200\3\2\2\2\u0203\u0206\3\2\2\2\u0204"+
		"\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2"+
		"\2\2\u0207\u01ff\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209"+
		"\u020a\7?\2\2\u020aO\3\2\2\2\u020b\u0210\7\13\2\2\u020c\u0210\7\r\2\2"+
		"\u020d\u0210\7\16\2\2\u020e\u0210\7\17\2\2\u020f\u020b\3\2\2\2\u020f\u020c"+
		"\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u020e\3\2\2\2\u0210Q\3\2\2\2\u0211"+
		"\u0213\7\f\2\2\u0212\u0211\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\3\2"+
		"\2\2\u0214\u0215\7F\2\2\u0215\u0216\7\f\2\2\u0216S\3\2\2\2\u0217\u0218"+
		"\t\t\2\2\u0218U\3\2\2\2\u0219\u021a\7\20\2\2\u021aW\3\2\2\2\u021b\u021c"+
		"\7\21\2\2\u021cY\3\2\2\2\u021d\u021e\7\n\2\2\u021e[\3\2\2\29]bpz~\u0087"+
		"\u008e\u0097\u009a\u00a7\u00aa\u00af\u00bb\u00be\u00c3\u00c7\u00d0\u00d8"+
		"\u00dc\u00e2\u00f1\u00fa\u0100\u0110\u0127\u012d\u013f\u0142\u0145\u014f"+
		"\u0156\u015b\u0160\u0163\u016a\u016c\u0174\u017f\u0184\u0188\u0194\u01a0"+
		"\u01a4\u01a8\u01aa\u01b4\u01e6\u01e8\u01ea\u01f3\u01fc\u0204\u0207\u020f"+
		"\u0212";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}