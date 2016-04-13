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
		RULE_label = 26, RULE_ifStatement = 27, RULE_switchBlockStatementGroup = 28, 
		RULE_switchLabel = 29, RULE_forControl = 30, RULE_forInit = 31, RULE_forInitSpec = 32, 
		RULE_forUpdate = 33, RULE_parExpression = 34, RULE_expressionList = 35, 
		RULE_expression = 36, RULE_primary = 37, RULE_creator = 38, RULE_arguments = 39, 
		RULE_integerLiteral = 40, RULE_floatingPointLiteral = 41, RULE_booleanLiteral = 42, 
		RULE_characterLiteral = 43, RULE_stringLiteral = 44, RULE_nullLiteral = 45;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "classInstanceModifier", 
		"classDeclaration", "typeList", "classBody", "classBodyDeclaration", "methodDeclaration", 
		"inputParameters", "inputParameter", "outputParameters", "outputParameter", 
		"constructorDeclaration", "fieldDeclaration", "typeOrArray", "type", "array", 
		"primitiveType", "methodBody", "constructorBody", "qualifiedName", "literal", 
		"block", "statement", "variableDeclarationStatement", "label", "ifStatement", 
		"switchBlockStatementGroup", "switchLabel", "forControl", "forInit", "forInitSpec", 
		"forUpdate", "parExpression", "expressionList", "expression", "primary", 
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
			while (((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & ((1L << (STATIC - 40)) | (1L << (VAR - 40)) | (1L << (SEMI - 40)) | (1L << (Identifier - 40)))) != 0)) {
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << VAR) | (1L << OBJ) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT))) != 0) || _la==LBRACK || _la==Identifier) {
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
			setState(234);
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
			setState(236);
			match(Identifier);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237);
					match(DOT);
					setState(238);
					match(Identifier);
					}
					} 
				}
				setState(243);
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
			setState(250);
			switch (_input.LA(1)) {
			case DecimalNumeral:
			case HexNumeral:
			case OctalNumeral:
			case BinaryNumeral:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				integerLiteral();
				}
				break;
			case Digits:
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				floatingPointLiteral();
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				characterLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(247);
				stringLiteral();
				}
				break;
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(248);
				booleanLiteral();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(249);
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
			setState(252);
			match(LBRACE);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << WHILE) | (1L << VAR) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (SEMI - 66)) | (1L << (DOT - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				{
				setState(253);
				statement();
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(259);
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
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
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				block();
				}
				break;
			case 2:
				_localctx = new StatementEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new StatementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				expression(0);
				setState(264);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(266);
				match(RETURN);
				setState(268);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(267);
					expressionList();
					}
				}

				setState(270);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(271);
				match(IF);
				setState(272);
				ifStatement();
				}
				break;
			case 6:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(273);
				label();
				setState(274);
				match(WHILE);
				setState(275);
				parExpression();
				setState(276);
				block();
				}
				break;
			case 7:
				_localctx = new StatementForContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(278);
				label();
				setState(279);
				match(FOR);
				setState(280);
				match(LPAREN);
				setState(281);
				forControl();
				setState(282);
				match(RPAREN);
				setState(283);
				block();
				}
				break;
			case 8:
				_localctx = new StatementSwitchContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(285);
				match(SWITCH);
				setState(286);
				parExpression();
				setState(287);
				match(LBRACE);
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(288);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(293);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(294);
					switchLabel();
					}
					}
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(300);
				match(RBRACE);
				}
				break;
			case 9:
				_localctx = new StatementBreakContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(302);
				match(BREAK);
				setState(303);
				label();
				setState(304);
				match(SEMI);
				}
				break;
			case 10:
				_localctx = new StatementContinueContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(306);
				match(CONTINUE);
				setState(307);
				label();
				setState(308);
				match(SEMI);
				}
				break;
			case 11:
				_localctx = new StatementVarContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(310);
				match(VAR);
				setState(311);
				variableDeclarationStatement();
				setState(312);
				match(SEMI);
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
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeOrArrayContext typeOrArray() {
			return getRuleContext(TypeOrArrayContext.class,0);
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
			setState(316);
			match(Identifier);
			setState(319);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(317);
				match(COLON);
				setState(318);
				typeOrArray();
				}
			}

			setState(323);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(321);
				match(ASSIGN);
				setState(322);
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
		enterRule(_localctx, 52, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(325);
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
		enterRule(_localctx, 54, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			parExpression();
			setState(329);
			((IfStatementContext)_localctx).fulfillmentBlock = block();
			setState(335);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(330);
				match(ELSE);
				setState(333);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					setState(331);
					ifStatement();
					}
					break;
				case LBRACE:
					{
					setState(332);
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
		enterRule(_localctx, 56, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(337);
				switchLabel();
				}
				}
				setState(340); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(343); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(342);
				statement();
				}
				}
				setState(345); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << WHILE) | (1L << VAR) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (SEMI - 66)) | (1L << (DOT - 66)) | (1L << (Identifier - 66)))) != 0) );
			setState(349);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(347);
				((SwitchBlockStatementGroupContext)_localctx).fallthrough = match(T__1);
				setState(348);
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
		enterRule(_localctx, 58, RULE_switchLabel);
		try {
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new SwitchLabelCaseIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				match(CASE);
				setState(352);
				integerLiteral();
				setState(353);
				match(COLON);
				}
				break;
			case 2:
				_localctx = new SwitchLabelCaseStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				match(CASE);
				setState(356);
				stringLiteral();
				setState(357);
				match(COLON);
				}
				break;
			case 3:
				_localctx = new SwitchLabelDefaultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
				match(DEFAULT);
				setState(360);
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
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
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
		enterRule(_localctx, 60, RULE_forControl);
		int _la;
		try {
			setState(381);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new ForControlIteratorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				match(VAR);
				setState(364);
				match(Identifier);
				setState(365);
				match(COLON);
				setState(366);
				typeOrArray();
				setState(367);
				match(IN);
				setState(368);
				expression(0);
				}
				break;
			case 2:
				_localctx = new ForControlICUContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << VAR) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(370);
					forInit();
					}
				}

				setState(373);
				match(SEMI);
				setState(375);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(374);
					expression(0);
					}
				}

				setState(377);
				match(SEMI);
				setState(379);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(378);
					forUpdate();
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

	public static class ForInitContext extends ParserRuleContext {
		public List<ForInitSpecContext> forInitSpec() {
			return getRuleContexts(ForInitSpecContext.class);
		}
		public ForInitSpecContext forInitSpec(int i) {
			return getRuleContext(ForInitSpecContext.class,i);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_forInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(383);
				forInitSpec();
				}
				}
				setState(386); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << VAR) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier );
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

	public static class ForInitSpecContext extends ParserRuleContext {
		public VariableDeclarationStatementContext variableDeclarationStatement() {
			return getRuleContext(VariableDeclarationStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInitSpec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitForInitSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitSpecContext forInitSpec() throws RecognitionException {
		ForInitSpecContext _localctx = new ForInitSpecContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_forInitSpec);
		try {
			setState(391);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(388);
				match(VAR);
				setState(389);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				expression(0);
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

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			expressionList();
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
			setState(395);
			match(LPAREN);
			setState(396);
			expression(0);
			setState(397);
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

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			expression(0);
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(400);
				match(COMMA);
				setState(401);
				expression(0);
				}
				}
				setState(406);
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
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
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

				setState(408);
				primary();
				}
				break;
			case NEW:
				{
				_localctx = new ExpressionNewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(409);
				match(NEW);
				setState(410);
				creator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(458);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(456);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(414);
						((ExpressionMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & ((1L << (MUL - 86)) | (1L << (DIV - 86)) | (1L << (MOD - 86)))) != 0)) ) {
							((ExpressionMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(415);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(416);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(417);
						((ExpressionAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(418);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(420);
						((ExpressionShiftContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
							((ExpressionShiftContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(421);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionCompareContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(422);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(423);
						((ExpressionCompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (GT - 70)) | (1L << (LT - 70)) | (1L << (LE - 70)) | (1L << (GE - 70)))) != 0)) ) {
							((ExpressionCompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(424);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(425);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(426);
						((ExpressionEqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionEqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(427);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionBitAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(428);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(429);
						match(BITAND);
						setState(430);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionBitExOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(431);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(432);
						match(CARET);
						setState(433);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionBitOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(434);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(435);
						match(BITOR);
						setState(436);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionBolAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(438);
						match(AND);
						setState(439);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionBolOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(440);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(441);
						match(OR);
						setState(442);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(444);
						((ExpressionAssignContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (ASSIGN - 69)) | (1L << (ADD_ASSIGN - 69)) | (1L << (SUB_ASSIGN - 69)) | (1L << (MUL_ASSIGN - 69)) | (1L << (DIV_ASSIGN - 69)) | (1L << (AND_ASSIGN - 69)) | (1L << (OR_ASSIGN - 69)) | (1L << (XOR_ASSIGN - 69)) | (1L << (MOD_ASSIGN - 69)) | (1L << (LSHIFT_ASSIGN - 69)) | (1L << (RSHIFT_ASSIGN - 69)) | (1L << (URSHIFT_ASSIGN - 69)))) != 0)) ) {
							((ExpressionAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(445);
						expression(1);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionClassFieldRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(446);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(447);
						match(DOT);
						setState(448);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionInvokeMethodContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(449);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(450);
						arguments();
						}
						break;
					case 14:
						{
						_localctx = new ExpressionArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(451);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(452);
						match(LBRACK);
						setState(453);
						expression(0);
						setState(454);
						match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(460);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
			setState(467);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimaryParensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				match(LPAREN);
				setState(462);
				expression(0);
				setState(463);
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
				setState(465);
				literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(466);
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
			setState(476);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new CreatorClassContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				qualifiedName();
				setState(470);
				arguments();
				}
				break;
			case LBRACK:
				_localctx = new CreatorArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				array();
				setState(473);
				match(LPAREN);
				setState(474);
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
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
			setState(478);
			match(LPAREN);
			setState(480);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
				{
				setState(479);
				expressionList();
				}
			}

			setState(482);
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
			setState(488);
			switch (_input.LA(1)) {
			case DecimalNumeral:
				_localctx = new IntegerLiteralDecimalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(484);
				match(DecimalNumeral);
				}
				break;
			case HexNumeral:
				_localctx = new IntegerLiteralHexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				match(HexNumeral);
				}
				break;
			case OctalNumeral:
				_localctx = new IntegerLiteralOctalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(486);
				match(OctalNumeral);
				}
				break;
			case BinaryNumeral:
				_localctx = new IntegerLiteralBinaryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(487);
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
			setState(491);
			_la = _input.LA(1);
			if (_la==Digits) {
				{
				setState(490);
				match(Digits);
				}
			}

			setState(493);
			match(DOT);
			setState(494);
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
			setState(496);
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
		enterRule(_localctx, 86, RULE_characterLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
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
			setState(500);
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
			setState(502);
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
		case 36:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 15);
		case 12:
			return precpred(_ctx, 14);
		case 13:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3n\u01fb\4\2\t\2\4"+
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
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\7\27\u00f2\n\27\f\27\16\27\u00f5\13"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00fd\n\30\3\31\3\31\7\31\u0101"+
		"\n\31\f\31\16\31\u0104\13\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\5\32\u010f\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0124\n\32\f\32\16"+
		"\32\u0127\13\32\3\32\7\32\u012a\n\32\f\32\16\32\u012d\13\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u013d"+
		"\n\32\3\33\3\33\3\33\5\33\u0142\n\33\3\33\3\33\5\33\u0146\n\33\3\34\5"+
		"\34\u0149\n\34\3\35\3\35\3\35\3\35\3\35\5\35\u0150\n\35\5\35\u0152\n\35"+
		"\3\36\6\36\u0155\n\36\r\36\16\36\u0156\3\36\6\36\u015a\n\36\r\36\16\36"+
		"\u015b\3\36\3\36\5\36\u0160\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\5\37\u016c\n\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u0176\n \3 \3"+
		" \5 \u017a\n \3 \3 \5 \u017e\n \5 \u0180\n \3!\6!\u0183\n!\r!\16!\u0184"+
		"\3\"\3\"\3\"\5\"\u018a\n\"\3#\3#\3$\3$\3$\3$\3%\3%\3%\7%\u0195\n%\f%\16"+
		"%\u0198\13%\3&\3&\3&\3&\5&\u019e\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\7&\u01cb\n&\f&\16&\u01ce\13&\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\5\'\u01d6\n\'\3(\3(\3(\3(\3(\3(\3(\5(\u01df\n(\3)\3)\5)\u01e3"+
		"\n)\3)\3)\3*\3*\3*\3*\5*\u01eb\n*\3+\5+\u01ee\n+\3+\3+\3+\3,\3,\3-\3-"+
		"\3.\3.\3/\3/\3/\2\3J\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\n\4\2\3\3\65<\4\2XY]]\3\2VW\3\2\5"+
		"\7\4\2HIOP\4\2NNQQ\4\2GG^h\3\2\b\t\u021e\2_\3\2\2\2\4j\3\2\2\2\6n\3\2"+
		"\2\2\bv\3\2\2\2\nx\3\2\2\2\f\u0084\3\2\2\2\16\u008c\3\2\2\2\20\u0099\3"+
		"\2\2\2\22\u009c\3\2\2\2\24\u00a3\3\2\2\2\26\u00b1\3\2\2\2\30\u00b7\3\2"+
		"\2\2\32\u00c9\3\2\2\2\34\u00cd\3\2\2\2\36\u00d2\3\2\2\2 \u00da\3\2\2\2"+
		"\"\u00de\3\2\2\2$\u00e0\3\2\2\2&\u00e8\3\2\2\2(\u00ea\3\2\2\2*\u00ec\3"+
		"\2\2\2,\u00ee\3\2\2\2.\u00fc\3\2\2\2\60\u00fe\3\2\2\2\62\u013c\3\2\2\2"+
		"\64\u013e\3\2\2\2\66\u0148\3\2\2\28\u014a\3\2\2\2:\u0154\3\2\2\2<\u016b"+
		"\3\2\2\2>\u017f\3\2\2\2@\u0182\3\2\2\2B\u0189\3\2\2\2D\u018b\3\2\2\2F"+
		"\u018d\3\2\2\2H\u0191\3\2\2\2J\u019d\3\2\2\2L\u01d5\3\2\2\2N\u01de\3\2"+
		"\2\2P\u01e0\3\2\2\2R\u01ea\3\2\2\2T\u01ed\3\2\2\2V\u01f2\3\2\2\2X\u01f4"+
		"\3\2\2\2Z\u01f6\3\2\2\2\\\u01f8\3\2\2\2^`\5\4\3\2_^\3\2\2\2_`\3\2\2\2"+
		"`d\3\2\2\2ac\5\6\4\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2"+
		"fd\3\2\2\2gh\5\n\6\2hi\7\2\2\3i\3\3\2\2\2jk\7%\2\2kl\5,\27\2lm\7D\2\2"+
		"m\5\3\2\2\2no\7!\2\2or\5,\27\2pq\7F\2\2qs\7X\2\2rp\3\2\2\2rs\3\2\2\2s"+
		"t\3\2\2\2tu\7D\2\2u\7\3\2\2\2vw\7*\2\2w\t\3\2\2\2xy\7\25\2\2y|\7i\2\2"+
		"z{\7\33\2\2{}\5\"\22\2|z\3\2\2\2|}\3\2\2\2}\u0080\3\2\2\2~\177\7 \2\2"+
		"\177\u0081\5\f\7\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2"+
		"\2\2\u0082\u0083\5\16\b\2\u0083\13\3\2\2\2\u0084\u0089\5\"\22\2\u0085"+
		"\u0086\7E\2\2\u0086\u0088\5\"\22\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\r\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008c\u0090\7@\2\2\u008d\u008f\5\20\t\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7A\2\2\u0094\17\3\2\2\2\u0095\u009a"+
		"\7D\2\2\u0096\u009a\5\34\17\2\u0097\u009a\5\22\n\2\u0098\u009a\5\36\20"+
		"\2\u0099\u0095\3\2\2\2\u0099\u0096\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u0098"+
		"\3\2\2\2\u009a\21\3\2\2\2\u009b\u009d\5\b\5\2\u009c\u009b\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7i\2\2\u009f\u00a0\5\24"+
		"\13\2\u00a0\u00a1\5\30\r\2\u00a1\u00a2\5(\25\2\u00a2\23\3\2\2\2\u00a3"+
		"\u00ac\7>\2\2\u00a4\u00a9\5\26\f\2\u00a5\u00a6\7E\2\2\u00a6\u00a8\5\26"+
		"\f\2\u00a7\u00a5\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00a4\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7?\2\2\u00af"+
		"\25\3\2\2\2\u00b0\u00b2\7\64\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2"+
		"\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7i\2\2\u00b4\u00b5\7M\2\2\u00b5\u00b6"+
		"\5 \21\2\u00b6\27\3\2\2\2\u00b7\u00c0\7>\2\2\u00b8\u00bd\5\32\16\2\u00b9"+
		"\u00ba\7E\2\2\u00ba\u00bc\5\32\16\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3"+
		"\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\7?\2\2\u00c3\31\3\2\2\2\u00c4\u00c6\7\64\2\2\u00c5\u00c4"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\7i\2\2\u00c8"+
		"\u00ca\7M\2\2\u00c9\u00c5\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\5 \21\2\u00cc\33\3\2\2\2\u00cd\u00ce\7i\2\2\u00ce\u00cf"+
		"\5\24\13\2\u00cf\u00d0\5*\26\2\u00d0\35\3\2\2\2\u00d1\u00d3\5\b\5\2\u00d2"+
		"\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\64"+
		"\2\2\u00d5\u00d6\5\64\33\2\u00d6\u00d7\7D\2\2\u00d7\37\3\2\2\2\u00d8\u00db"+
		"\5\"\22\2\u00d9\u00db\5$\23\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2"+
		"\u00db!\3\2\2\2\u00dc\u00df\5&\24\2\u00dd\u00df\5,\27\2\u00de\u00dc\3"+
		"\2\2\2\u00de\u00dd\3\2\2\2\u00df#\3\2\2\2\u00e0\u00e1\7B\2\2\u00e1\u00e4"+
		"\5 \21\2\u00e2\u00e3\7M\2\2\u00e3\u00e5\5 \21\2\u00e4\u00e2\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7C\2\2\u00e7%\3\2\2\2\u00e8"+
		"\u00e9\t\2\2\2\u00e9\'\3\2\2\2\u00ea\u00eb\5\60\31\2\u00eb)\3\2\2\2\u00ec"+
		"\u00ed\5\60\31\2\u00ed+\3\2\2\2\u00ee\u00f3\7i\2\2\u00ef\u00f0\7F\2\2"+
		"\u00f0\u00f2\7i\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4-\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00fd\5R*\2\u00f7\u00fd\5T+\2\u00f8\u00fd\5X-\2\u00f9\u00fd\5Z.\2\u00fa"+
		"\u00fd\5V,\2\u00fb\u00fd\5\\/\2\u00fc\u00f6\3\2\2\2\u00fc\u00f7\3\2\2"+
		"\2\u00fc\u00f8\3\2\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb"+
		"\3\2\2\2\u00fd/\3\2\2\2\u00fe\u0102\7@\2\2\u00ff\u0101\5\62\32\2\u0100"+
		"\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106\7A\2\2\u0106"+
		"\61\3\2\2\2\u0107\u013d\5\60\31\2\u0108\u013d\7D\2\2\u0109\u010a\5J&\2"+
		"\u010a\u010b\7D\2\2\u010b\u013d\3\2\2\2\u010c\u010e\7)\2\2\u010d\u010f"+
		"\5H%\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u013d\7D\2\2\u0111\u0112\7\37\2\2\u0112\u013d\58\35\2\u0113\u0114\5\66"+
		"\34\2\u0114\u0115\7\63\2\2\u0115\u0116\5F$\2\u0116\u0117\5\60\31\2\u0117"+
		"\u013d\3\2\2\2\u0118\u0119\5\66\34\2\u0119\u011a\7\36\2\2\u011a\u011b"+
		"\7>\2\2\u011b\u011c\5> \2\u011c\u011d\7?\2\2\u011d\u011e\5\60\31\2\u011e"+
		"\u013d\3\2\2\2\u011f\u0120\7,\2\2\u0120\u0121\5F$\2\u0121\u0125\7@\2\2"+
		"\u0122\u0124\5:\36\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u012b\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u012a\5<\37\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2"+
		"\2\2\u012b\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e"+
		"\u012f\7A\2\2\u012f\u013d\3\2\2\2\u0130\u0131\7\22\2\2\u0131\u0132\5\66"+
		"\34\2\u0132\u0133\7D\2\2\u0133\u013d\3\2\2\2\u0134\u0135\7\27\2\2\u0135"+
		"\u0136\5\66\34\2\u0136\u0137\7D\2\2\u0137\u013d\3\2\2\2\u0138\u0139\7"+
		"\64\2\2\u0139\u013a\5\64\33\2\u013a\u013b\7D\2\2\u013b\u013d\3\2\2\2\u013c"+
		"\u0107\3\2\2\2\u013c\u0108\3\2\2\2\u013c\u0109\3\2\2\2\u013c\u010c\3\2"+
		"\2\2\u013c\u0111\3\2\2\2\u013c\u0113\3\2\2\2\u013c\u0118\3\2\2\2\u013c"+
		"\u011f\3\2\2\2\u013c\u0130\3\2\2\2\u013c\u0134\3\2\2\2\u013c\u0138\3\2"+
		"\2\2\u013d\63\3\2\2\2\u013e\u0141\7i\2\2\u013f\u0140\7M\2\2\u0140\u0142"+
		"\5 \21\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\3\2\2\2\u0143"+
		"\u0144\7G\2\2\u0144\u0146\5J&\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2"+
		"\2\u0146\65\3\2\2\2\u0147\u0149\7i\2\2\u0148\u0147\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\67\3\2\2\2\u014a\u014b\5F$\2\u014b\u0151\5\60\31\2\u014c"+
		"\u014f\7\31\2\2\u014d\u0150\58\35\2\u014e\u0150\5\60\31\2\u014f\u014d"+
		"\3\2\2\2\u014f\u014e\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014c\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u01529\3\2\2\2\u0153\u0155\5<\37\2\u0154\u0153\3\2\2\2"+
		"\u0155\u0156\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0159"+
		"\3\2\2\2\u0158\u015a\5\62\32\2\u0159\u0158\3\2\2\2\u015a\u015b\3\2\2\2"+
		"\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015e"+
		"\7\4\2\2\u015e\u0160\7D\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		";\3\2\2\2\u0161\u0162\7\23\2\2\u0162\u0163\5R*\2\u0163\u0164\7M\2\2\u0164"+
		"\u016c\3\2\2\2\u0165\u0166\7\23\2\2\u0166\u0167\5Z.\2\u0167\u0168\7M\2"+
		"\2\u0168\u016c\3\2\2\2\u0169\u016a\7\30\2\2\u016a\u016c\7M\2\2\u016b\u0161"+
		"\3\2\2\2\u016b\u0165\3\2\2\2\u016b\u0169\3\2\2\2\u016c=\3\2\2\2\u016d"+
		"\u016e\7\64\2\2\u016e\u016f\7i\2\2\u016f\u0170\7M\2\2\u0170\u0171\5 \21"+
		"\2\u0171\u0172\7=\2\2\u0172\u0173\5J&\2\u0173\u0180\3\2\2\2\u0174\u0176"+
		"\5@!\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"\u0179\7D\2\2\u0178\u017a\5J&\2\u0179\u0178\3\2\2\2\u0179\u017a\3\2\2"+
		"\2\u017a\u017b\3\2\2\2\u017b\u017d\7D\2\2\u017c\u017e\5D#\2\u017d\u017c"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0180\3\2\2\2\u017f\u016d\3\2\2\2\u017f"+
		"\u0175\3\2\2\2\u0180?\3\2\2\2\u0181\u0183\5B\"\2\u0182\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185A\3\2\2\2"+
		"\u0186\u0187\7\64\2\2\u0187\u018a\5\64\33\2\u0188\u018a\5J&\2\u0189\u0186"+
		"\3\2\2\2\u0189\u0188\3\2\2\2\u018aC\3\2\2\2\u018b\u018c\5H%\2\u018cE\3"+
		"\2\2\2\u018d\u018e\7>\2\2\u018e\u018f\5J&\2\u018f\u0190\7?\2\2\u0190G"+
		"\3\2\2\2\u0191\u0196\5J&\2\u0192\u0193\7E\2\2\u0193\u0195\5J&\2\u0194"+
		"\u0192\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197I\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019a\b&\1\2\u019a\u019e"+
		"\5L\'\2\u019b\u019c\7$\2\2\u019c\u019e\5N(\2\u019d\u0199\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019e\u01cc\3\2\2\2\u019f\u01a0\f\r\2\2\u01a0\u01a1\t\3"+
		"\2\2\u01a1\u01cb\5J&\16\u01a2\u01a3\f\f\2\2\u01a3\u01a4\t\4\2\2\u01a4"+
		"\u01cb\5J&\r\u01a5\u01a6\f\13\2\2\u01a6\u01a7\t\5\2\2\u01a7\u01cb\5J&"+
		"\f\u01a8\u01a9\f\n\2\2\u01a9\u01aa\t\6\2\2\u01aa\u01cb\5J&\13\u01ab\u01ac"+
		"\f\t\2\2\u01ac\u01ad\t\7\2\2\u01ad\u01cb\5J&\n\u01ae\u01af\f\b\2\2\u01af"+
		"\u01b0\7Z\2\2\u01b0\u01cb\5J&\t\u01b1\u01b2\f\7\2\2\u01b2\u01b3\7\\\2"+
		"\2\u01b3\u01cb\5J&\b\u01b4\u01b5\f\6\2\2\u01b5\u01b6\7[\2\2\u01b6\u01cb"+
		"\5J&\7\u01b7\u01b8\f\5\2\2\u01b8\u01b9\7R\2\2\u01b9\u01cb\5J&\6\u01ba"+
		"\u01bb\f\4\2\2\u01bb\u01bc\7S\2\2\u01bc\u01cb\5J&\5\u01bd\u01be\f\3\2"+
		"\2\u01be\u01bf\t\b\2\2\u01bf\u01cb\5J&\3\u01c0\u01c1\f\21\2\2\u01c1\u01c2"+
		"\7F\2\2\u01c2\u01cb\7i\2\2\u01c3\u01c4\f\20\2\2\u01c4\u01cb\5P)\2\u01c5"+
		"\u01c6\f\16\2\2\u01c6\u01c7\7B\2\2\u01c7\u01c8\5J&\2\u01c8\u01c9\7C\2"+
		"\2\u01c9\u01cb\3\2\2\2\u01ca\u019f\3\2\2\2\u01ca\u01a2\3\2\2\2\u01ca\u01a5"+
		"\3\2\2\2\u01ca\u01a8\3\2\2\2\u01ca\u01ab\3\2\2\2\u01ca\u01ae\3\2\2\2\u01ca"+
		"\u01b1\3\2\2\2\u01ca\u01b4\3\2\2\2\u01ca\u01b7\3\2\2\2\u01ca\u01ba\3\2"+
		"\2\2\u01ca\u01bd\3\2\2\2\u01ca\u01c0\3\2\2\2\u01ca\u01c3\3\2\2\2\u01ca"+
		"\u01c5\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cdK\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d0\7>\2\2\u01d0\u01d1"+
		"\5J&\2\u01d1\u01d2\7?\2\2\u01d2\u01d6\3\2\2\2\u01d3\u01d6\5.\30\2\u01d4"+
		"\u01d6\7i\2\2\u01d5\u01cf\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4\3\2"+
		"\2\2\u01d6M\3\2\2\2\u01d7\u01d8\5,\27\2\u01d8\u01d9\5P)\2\u01d9\u01df"+
		"\3\2\2\2\u01da\u01db\5$\23\2\u01db\u01dc\7>\2\2\u01dc\u01dd\7?\2\2\u01dd"+
		"\u01df\3\2\2\2\u01de\u01d7\3\2\2\2\u01de\u01da\3\2\2\2\u01dfO\3\2\2\2"+
		"\u01e0\u01e2\7>\2\2\u01e1\u01e3\5H%\2\u01e2\u01e1\3\2\2\2\u01e2\u01e3"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\7?\2\2\u01e5Q\3\2\2\2\u01e6\u01eb"+
		"\7\13\2\2\u01e7\u01eb\7\r\2\2\u01e8\u01eb\7\16\2\2\u01e9\u01eb\7\17\2"+
		"\2\u01ea\u01e6\3\2\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01e9"+
		"\3\2\2\2\u01ebS\3\2\2\2\u01ec\u01ee\7\f\2\2\u01ed\u01ec\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\7F\2\2\u01f0\u01f1\7\f"+
		"\2\2\u01f1U\3\2\2\2\u01f2\u01f3\t\t\2\2\u01f3W\3\2\2\2\u01f4\u01f5\7\20"+
		"\2\2\u01f5Y\3\2\2\2\u01f6\u01f7\7\21\2\2\u01f7[\3\2\2\2\u01f8\u01f9\7"+
		"\n\2\2\u01f9]\3\2\2\2\65_dr|\u0080\u0089\u0090\u0099\u009c\u00a9\u00ac"+
		"\u00b1\u00bd\u00c0\u00c5\u00c9\u00d2\u00da\u00de\u00e4\u00f3\u00fc\u0102"+
		"\u010e\u0125\u012b\u013c\u0141\u0145\u0148\u014f\u0151\u0156\u015b\u015f"+
		"\u016b\u0175\u0179\u017d\u017f\u0184\u0189\u0196\u019d\u01ca\u01cc\u01d5"+
		"\u01de\u01e2\u01ea\u01ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}