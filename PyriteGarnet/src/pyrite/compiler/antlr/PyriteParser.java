// Generated from Pyrite.g4 by ANTLR 4.2.2

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
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, DecimalNumeral=8, 
		Digits=9, HexNumeral=10, OctalNumeral=11, BinaryNumeral=12, CharacterLiteral=13, 
		StringLiteral=14, BREAK=15, CASE=16, CATCH=17, CLASS=18, CONST=19, CONTINUE=20, 
		DEFAULT=21, ELSE=22, ENUM=23, EXTENDS=24, FINAL=25, FINALLY=26, FOR=27, 
		IF=28, IMPLEMENTS=29, IMPORT=30, INSTANCEOF=31, INTERFACE=32, NEW=33, 
		PACKAGE=34, PRIVATE=35, PROTECTED=36, PUBLIC=37, RETURN=38, STATIC=39, 
		SUPER=40, SWITCH=41, SYNCHRONIZED=42, THIS=43, THROW=44, THROWS=45, TRY=46, 
		VOID=47, WHILE=48, OBJ=49, VAR=50, NUM=51, INT=52, FLT=53, STR=54, CHR=55, 
		BOL=56, BYT=57, LPAREN=58, RPAREN=59, LBRACE=60, RBRACE=61, LBRACK=62, 
		RBRACK=63, SEMI=64, COMMA=65, DOT=66, ASSIGN=67, GT=68, LT=69, BANG=70, 
		TILDE=71, QUESTION=72, COLON=73, EQUAL=74, LE=75, GE=76, NOTEQUAL=77, 
		AND=78, OR=79, INC=80, DEC=81, ADD=82, SUB=83, MUL=84, DIV=85, BITAND=86, 
		BITOR=87, CARET=88, MOD=89, ADD_ASSIGN=90, SUB_ASSIGN=91, MUL_ASSIGN=92, 
		DIV_ASSIGN=93, AND_ASSIGN=94, OR_ASSIGN=95, XOR_ASSIGN=96, MOD_ASSIGN=97, 
		LSHIFT_ASSIGN=98, RSHIFT_ASSIGN=99, URSHIFT_ASSIGN=100, Identifier=101, 
		AT=102, ELLIPSIS=103, WS=104, COMMENT=105, LINE_COMMENT=106;
	public static final String[] tokenNames = {
		"<INVALID>", "'false'", "'fallthrough'", "'<<'", "'null'", "'>>>'", "'true'", 
		"'>>'", "DecimalNumeral", "Digits", "HexNumeral", "OctalNumeral", "BinaryNumeral", 
		"CharacterLiteral", "StringLiteral", "'break'", "'case'", "'catch'", "'class'", 
		"'const'", "'continue'", "'default'", "'else'", "'enum'", "'extends'", 
		"'final'", "'finally'", "'for'", "'if'", "'implements'", "'import'", "'instanceof'", 
		"'interface'", "'new'", "'package'", "'private'", "'protected'", "'public'", 
		"'return'", "'static'", "'super'", "'switch'", "'synchronized'", "'this'", 
		"'throw'", "'throws'", "'try'", "'void'", "'while'", "'obj'", "'var'", 
		"'num'", "'int'", "'flt'", "'str'", "'chr'", "'bol'", "'byt'", "'('", 
		"')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'='", "'>'", 
		"'<'", "'!'", "'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", 
		"'||'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", 
		"'%'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", 
		"'<<='", "'>>='", "'>>>='", "Identifier", "'@'", "'...'", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_classInstanceModifier = 3, RULE_classDeclaration = 4, RULE_typeList = 5, 
		RULE_classBody = 6, RULE_classBodyDeclaration = 7, RULE_methodDeclaration = 8, 
		RULE_inputParameters = 9, RULE_inputParameter = 10, RULE_outputParameters = 11, 
		RULE_outputParameter = 12, RULE_constructorDeclaration = 13, RULE_fieldDeclaration = 14, 
		RULE_variableInitializer = 15, RULE_arrayInitializer = 16, RULE_type = 17, 
		RULE_classOrInterfaceType = 18, RULE_primitiveType = 19, RULE_methodBody = 20, 
		RULE_constructorBody = 21, RULE_qualifiedName = 22, RULE_literal = 23, 
		RULE_block = 24, RULE_blockStatement = 25, RULE_localVariableDeclarationStatement = 26, 
		RULE_localVariableDeclaration = 27, RULE_statement = 28, RULE_label = 29, 
		RULE_ifStatement = 30, RULE_switchBlockStatementGroup = 31, RULE_switchLabel = 32, 
		RULE_forControl = 33, RULE_forInit = 34, RULE_forUpdate = 35, RULE_parExpression = 36, 
		RULE_expressionList = 37, RULE_expression = 38, RULE_primary = 39, RULE_creator = 40, 
		RULE_createdName = 41, RULE_arrayCreatorRest = 42, RULE_arguments = 43, 
		RULE_integerLiteral = 44, RULE_floatingPointLiteral = 45, RULE_booleanLiteral = 46, 
		RULE_characterLiteral = 47, RULE_stringLiteral = 48, RULE_nullLiteral = 49;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "classInstanceModifier", 
		"classDeclaration", "typeList", "classBody", "classBodyDeclaration", "methodDeclaration", 
		"inputParameters", "inputParameter", "outputParameters", "outputParameter", 
		"constructorDeclaration", "fieldDeclaration", "variableInitializer", "arrayInitializer", 
		"type", "classOrInterfaceType", "primitiveType", "methodBody", "constructorBody", 
		"qualifiedName", "literal", "block", "blockStatement", "localVariableDeclarationStatement", 
		"localVariableDeclaration", "statement", "label", "ifStatement", "switchBlockStatementGroup", 
		"switchLabel", "forControl", "forInit", "forUpdate", "parExpression", 
		"expressionList", "expression", "primary", "creator", "createdName", "arrayCreatorRest", 
		"arguments", "integerLiteral", "floatingPointLiteral", "booleanLiteral", 
		"characterLiteral", "stringLiteral", "nullLiteral"
	};

	@Override
	public String getGrammarFileName() { return "Pyrite.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public TerminalNode EOF() { return getToken(PyriteParser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
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
			setState(101);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(100); packageDeclaration();
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(103); importDeclaration();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109); classDeclaration();
			setState(110); match(EOF);
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
			setState(112); match(PACKAGE);
			setState(113); qualifiedName();
			setState(114); match(SEMI);
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
			setState(116); match(IMPORT);
			setState(117); qualifiedName();
			setState(120);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(118); match(DOT);
				setState(119); ((ImportDeclarationContext)_localctx).ast = match(MUL);
				}
			}

			setState(122); match(SEMI);
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
			setState(124); match(STATIC);
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
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
			setState(126); match(CLASS);
			setState(127); match(Identifier);
			setState(130);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(128); match(EXTENDS);
				setState(129); type();
				}
			}

			setState(134);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(132); match(IMPLEMENTS);
				setState(133); typeList();
				}
			}

			setState(136); classBody();
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
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
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
			setState(138); type();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(139); match(COMMA);
				setState(140); type();
				}
				}
				setState(145);
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
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
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
			setState(146); match(LBRACE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (STATIC - 39)) | (1L << (OBJ - 39)) | (1L << (VAR - 39)) | (1L << (NUM - 39)) | (1L << (INT - 39)) | (1L << (FLT - 39)) | (1L << (STR - 39)) | (1L << (CHR - 39)) | (1L << (BOL - 39)) | (1L << (BYT - 39)) | (1L << (SEMI - 39)) | (1L << (Identifier - 39)))) != 0)) {
				{
				{
				setState(147); classBodyDeclaration();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153); match(RBRACE);
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
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
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
			setState(159);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); match(SEMI);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156); constructorDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157); methodDeclaration();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(158); fieldDeclaration();
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
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public ClassInstanceModifierContext classInstanceModifier() {
			return getRuleContext(ClassInstanceModifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public InputParametersContext inputParameters() {
			return getRuleContext(InputParametersContext.class,0);
		}
		public OutputParametersContext outputParameters() {
			return getRuleContext(OutputParametersContext.class,0);
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
			setState(162);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(161); classInstanceModifier();
				}
			}

			setState(164); match(Identifier);
			setState(165); inputParameters();
			setState(166); outputParameters();
			setState(167); methodBody();
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
			setState(169); match(LPAREN);
			setState(178);
			_la = _input.LA(1);
			if (((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (OBJ - 49)) | (1L << (VAR - 49)) | (1L << (NUM - 49)) | (1L << (INT - 49)) | (1L << (FLT - 49)) | (1L << (STR - 49)) | (1L << (CHR - 49)) | (1L << (BOL - 49)) | (1L << (BYT - 49)) | (1L << (Identifier - 49)))) != 0)) {
				{
				setState(170); inputParameter();
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(171); match(COMMA);
					setState(172); inputParameter();
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(180); match(RPAREN);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182); type();
			setState(183); match(Identifier);
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
			setState(185); match(LPAREN);
			setState(194);
			_la = _input.LA(1);
			if (((((_la - 49)) & ~0x3f) == 0 && ((1L << (_la - 49)) & ((1L << (OBJ - 49)) | (1L << (VAR - 49)) | (1L << (NUM - 49)) | (1L << (INT - 49)) | (1L << (FLT - 49)) | (1L << (STR - 49)) | (1L << (CHR - 49)) | (1L << (BOL - 49)) | (1L << (BYT - 49)) | (1L << (Identifier - 49)))) != 0)) {
				{
				setState(186); outputParameter();
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(187); match(COMMA);
					setState(188); outputParameter();
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(196); match(RPAREN);
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
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
			setState(198); type();
			setState(200);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(199); match(Identifier);
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

	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public InputParametersContext inputParameters() {
			return getRuleContext(InputParametersContext.class,0);
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
			setState(202); match(Identifier);
			setState(203); inputParameters();
			setState(204); constructorBody();
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
		public ClassInstanceModifierContext classInstanceModifier() {
			return getRuleContext(ClassInstanceModifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
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
			setState(207);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(206); classInstanceModifier();
				}
			}

			setState(209); type();
			setState(210); match(Identifier);
			setState(213);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(211); match(ASSIGN);
				setState(212); variableInitializer();
				}
			}

			setState(215); match(SEMI);
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

	public static class VariableInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_variableInitializer);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(217); arrayInitializer();
				}
				break;
			case 1:
			case 4:
			case 6:
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
				setState(218); expression(0);
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

	public static class ArrayInitializerContext extends ParserRuleContext {
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221); match(LBRACE);
			setState(233);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN) | (1L << LBRACE))) != 0) || _la==DOT || _la==Identifier) {
				{
				setState(222); variableInitializer();
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(223); match(COMMA);
						setState(224); variableInitializer();
						}
						} 
					}
					setState(229);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(231);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(230); match(COMMA);
					}
				}

				}
			}

			setState(235); match(RBRACE);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeClassTypeContext extends TypeContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeClassTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitTypeClassType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePrimitiveTypeContext extends TypeContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypePrimitiveTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitTypePrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			setState(253);
			switch (_input.LA(1)) {
			case OBJ:
			case VAR:
			case NUM:
			case INT:
			case FLT:
			case STR:
			case CHR:
			case BOL:
			case BYT:
				_localctx = new TypePrimitiveTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(237); primitiveType();
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(238); match(LBRACK);
					setState(239); match(RBRACK);
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case Identifier:
				_localctx = new TypeClassTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(245); classOrInterfaceType();
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(246); match(LBRACK);
					setState(247); match(RBRACK);
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier(int i) {
			return getToken(PyriteParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(PyriteParser.Identifier); }
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); match(Identifier);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(256); match(DOT);
				setState(257); match(Identifier);
				}
				}
				setState(262);
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
		enterRule(_localctx, 38, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJ) | (1L << VAR) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 40, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); block();
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
		enterRule(_localctx, 42, RULE_constructorBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); block();
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
		public TerminalNode Identifier(int i) {
			return getToken(PyriteParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(PyriteParser.Identifier); }
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
			setState(269); match(Identifier);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(270); match(DOT);
					setState(271); match(Identifier);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public NullLiteralContext nullLiteral() {
			return getRuleContext(NullLiteralContext.class,0);
		}
		public CharacterLiteralContext characterLiteral() {
			return getRuleContext(CharacterLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
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
			setState(283);
			switch (_input.LA(1)) {
			case DecimalNumeral:
			case HexNumeral:
			case OctalNumeral:
			case BinaryNumeral:
				enterOuterAlt(_localctx, 1);
				{
				setState(277); integerLiteral();
				}
				break;
			case Digits:
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(278); floatingPointLiteral();
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(279); characterLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(280); stringLiteral();
				}
				break;
			case 1:
			case 6:
				enterOuterAlt(_localctx, 5);
				{
				setState(281); booleanLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 6);
				{
				setState(282); nullLiteral();
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
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
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
			setState(285); match(LBRACE);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << WHILE) | (1L << OBJ) | (1L << VAR) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEMI - 64)) | (1L << (DOT - 64)) | (1L << (Identifier - 64)))) != 0)) {
				{
				{
				setState(286); blockStatement();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(292); match(RBRACE);
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

	public static class BlockStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_blockStatement);
		try {
			setState(296);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294); localVariableDeclarationStatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(295); statement();
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

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); localVariableDeclaration();
			setState(299); match(SEMI);
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

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301); type();
			setState(302); match(Identifier);
			setState(305);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(303); match(ASSIGN);
				setState(304); variableInitializer();
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
	public static class StatementSwitchContext extends StatementContext {
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public StatementSwitchContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementSwitch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementWhileContext extends StatementContext {
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
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
	public static class StatementEmptyContext extends StatementContext {
		public StatementEmptyContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitStatementEmpty(this);
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
	public static class StatementForContext extends StatementContext {
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(355);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307); block();
				}
				break;

			case 2:
				_localctx = new StatementEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(308); match(SEMI);
				}
				break;

			case 3:
				_localctx = new StatementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(309); expression(0);
				setState(310); match(SEMI);
				}
				break;

			case 4:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(312); match(RETURN);
				setState(314);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(313); expressionList();
					}
				}

				setState(316); match(SEMI);
				}
				break;

			case 5:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(317); ifStatement();
				}
				break;

			case 6:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(318); label();
				setState(319); match(WHILE);
				setState(320); parExpression();
				setState(321); block();
				}
				break;

			case 7:
				_localctx = new StatementForContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(323); label();
				setState(324); match(FOR);
				setState(325); match(LPAREN);
				setState(326); forControl();
				setState(327); match(RPAREN);
				setState(328); block();
				}
				break;

			case 8:
				_localctx = new StatementSwitchContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(330); match(SWITCH);
				setState(331); parExpression();
				setState(332); match(LBRACE);
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(333); switchBlockStatementGroup();
						}
						} 
					}
					setState(338);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(339); switchLabel();
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(345); match(RBRACE);
				}
				break;

			case 9:
				_localctx = new StatementBreakContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(347); match(BREAK);
				setState(348); label();
				setState(349); match(SEMI);
				}
				break;

			case 10:
				_localctx = new StatementContinueContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(351); match(CONTINUE);
				setState(352); label();
				setState(353); match(SEMI);
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
		enterRule(_localctx, 58, RULE_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(357); match(Identifier);
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
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
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
		enterRule(_localctx, 60, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360); match(IF);
			setState(361); parExpression();
			setState(362); ((IfStatementContext)_localctx).fulfillmentBlock = block();
			setState(368);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(363); match(ELSE);
				setState(366);
				switch (_input.LA(1)) {
				case IF:
					{
					setState(364); ifStatement();
					}
					break;
				case LBRACE:
					{
					setState(365); ((IfStatementContext)_localctx).elseBlock = block();
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
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
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
			setState(371); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(370); switchLabel();
				}
				}
				setState(373); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(376); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(375); blockStatement();
				}
				}
				setState(378); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << BREAK) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << NEW) | (1L << RETURN) | (1L << SWITCH) | (1L << WHILE) | (1L << OBJ) | (1L << VAR) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT) | (1L << LPAREN) | (1L << LBRACE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SEMI - 64)) | (1L << (DOT - 64)) | (1L << (Identifier - 64)))) != 0) );
			setState(382);
			_la = _input.LA(1);
			if (_la==2) {
				{
				setState(380); ((SwitchBlockStatementGroupContext)_localctx).fallthrough = match(2);
				setState(381); match(SEMI);
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
	public static class SwitchLabelDefaultContext extends SwitchLabelContext {
		public SwitchLabelDefaultContext(SwitchLabelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitSwitchLabelDefault(this);
			else return visitor.visitChildren(this);
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
			setState(394);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new SwitchLabelCaseIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(384); match(CASE);
				setState(385); integerLiteral();
				setState(386); match(COLON);
				}
				break;

			case 2:
				_localctx = new SwitchLabelCaseStrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(388); match(CASE);
				setState(389); stringLiteral();
				setState(390); match(COLON);
				}
				break;

			case 3:
				_localctx = new SwitchLabelDefaultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(392); match(DEFAULT);
				setState(393); match(COLON);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		enterRule(_localctx, 66, RULE_forControl);
		int _la;
		try {
			setState(412);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new ForControlIteratorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(396); type();
				setState(397); match(Identifier);
				setState(398); match(COLON);
				setState(399); expression(0);
				}
				break;

			case 2:
				_localctx = new ForControlICUContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << OBJ) | (1L << VAR) | (1L << NUM) | (1L << INT) | (1L << FLT) | (1L << STR) | (1L << CHR) | (1L << BOL) | (1L << BYT) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(401); forInit();
					}
				}

				setState(404); match(SEMI);
				setState(406);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(405); expression(0);
					}
				}

				setState(408); match(SEMI);
				setState(410);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
					{
					setState(409); forUpdate();
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
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
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
		enterRule(_localctx, 68, RULE_forInit);
		try {
			setState(416);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(414); localVariableDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(415); expressionList();
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
		enterRule(_localctx, 70, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418); expressionList();
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
		enterRule(_localctx, 72, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420); match(LPAREN);
			setState(421); expression(0);
			setState(422); match(RPAREN);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		enterRule(_localctx, 74, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); expression(0);
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(425); match(COMMA);
				setState(426); expression(0);
				}
				}
				setState(431);
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
	public static class ExpressionBitExOrContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionBitExOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBitExOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBitOrContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBolAndContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionBolAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBolAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionMulDivContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionMulDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionArrayAccessContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionArrayAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionCompareContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionCompareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBitAndContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionBitAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionShiftContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionShiftContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionShift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionClassFieldRefContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(PyriteParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
	public static class ExpressionAssignContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
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
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBolOrContext extends ExpressionContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionBolOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitExpressionBolOr(this);
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
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			switch (_input.LA(1)) {
			case 1:
			case 4:
			case 6:
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

				setState(433); primary();
				}
				break;
			case NEW:
				{
				_localctx = new ExpressionNewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(434); match(NEW);
				setState(435); creator();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(483);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(481);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMulDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(438);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(439);
						((ExpressionMulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (MUL - 84)) | (1L << (DIV - 84)) | (1L << (MOD - 84)))) != 0)) ) {
							((ExpressionMulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(440); expression(12);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(441);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(442);
						((ExpressionAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(443); expression(11);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(444);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(445);
						((ExpressionShiftContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 3) | (1L << 5) | (1L << 7))) != 0)) ) {
							((ExpressionShiftContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(446); expression(10);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionCompareContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(447);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(448);
						((ExpressionCompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (GT - 68)) | (1L << (LT - 68)) | (1L << (LE - 68)) | (1L << (GE - 68)))) != 0)) ) {
							((ExpressionCompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(449); expression(9);
						}
						break;

					case 5:
						{
						_localctx = new ExpressionEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(450);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(451);
						((ExpressionEqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionEqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(452); expression(8);
						}
						break;

					case 6:
						{
						_localctx = new ExpressionBitAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(453);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(454); match(BITAND);
						setState(455); expression(7);
						}
						break;

					case 7:
						{
						_localctx = new ExpressionBitExOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(456);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(457); match(CARET);
						setState(458); expression(6);
						}
						break;

					case 8:
						{
						_localctx = new ExpressionBitOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(459);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(460); match(BITOR);
						setState(461); expression(5);
						}
						break;

					case 9:
						{
						_localctx = new ExpressionBolAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(462);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(463); match(AND);
						setState(464); expression(4);
						}
						break;

					case 10:
						{
						_localctx = new ExpressionBolOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(465);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(466); match(OR);
						setState(467); expression(3);
						}
						break;

					case 11:
						{
						_localctx = new ExpressionAssignContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(468);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(469);
						((ExpressionAssignContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (ASSIGN - 67)) | (1L << (ADD_ASSIGN - 67)) | (1L << (SUB_ASSIGN - 67)) | (1L << (MUL_ASSIGN - 67)) | (1L << (DIV_ASSIGN - 67)) | (1L << (AND_ASSIGN - 67)) | (1L << (OR_ASSIGN - 67)) | (1L << (XOR_ASSIGN - 67)) | (1L << (MOD_ASSIGN - 67)) | (1L << (LSHIFT_ASSIGN - 67)) | (1L << (RSHIFT_ASSIGN - 67)) | (1L << (URSHIFT_ASSIGN - 67)))) != 0)) ) {
							((ExpressionAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(470); expression(1);
						}
						break;

					case 12:
						{
						_localctx = new ExpressionClassFieldRefContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(471);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(472); match(DOT);
						setState(473); match(Identifier);
						}
						break;

					case 13:
						{
						_localctx = new ExpressionInvokeMethodContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(474);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(475); arguments();
						}
						break;

					case 14:
						{
						_localctx = new ExpressionArrayAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(476);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(477); match(LBRACK);
						setState(478); expression(0);
						setState(479); match(RBRACK);
						}
						break;
					}
					} 
				}
				setState(485);
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

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_primary);
		try {
			setState(492);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new PrimaryParensContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(486); match(LPAREN);
				setState(487); expression(0);
				setState(488); match(RPAREN);
				}
				break;
			case 1:
			case 4:
			case 6:
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
				setState(490); literal();
				}
				break;
			case Identifier:
				_localctx = new PrimaryIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(491); match(Identifier);
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
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_creator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494); createdName();
			setState(497);
			switch (_input.LA(1)) {
			case LBRACK:
				{
				setState(495); arrayCreatorRest();
				}
				break;
			case LPAREN:
				{
				setState(496); arguments();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CreatedNameContext extends ParserRuleContext {
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
	 
		public CreatedNameContext() { }
		public void copyFrom(CreatedNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreatedNamePrimitiveTypeContext extends CreatedNameContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNamePrimitiveTypeContext(CreatedNameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCreatedNamePrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreatedNameIdentiferContext extends CreatedNameContext {
		public TerminalNode Identifier(int i) {
			return getToken(PyriteParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(PyriteParser.Identifier); }
		public CreatedNameIdentiferContext(CreatedNameContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitCreatedNameIdentifer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_createdName);
		int _la;
		try {
			setState(508);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new CreatedNameIdentiferContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(499); match(Identifier);
				setState(504);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(500); match(DOT);
					setState(501); match(Identifier);
					}
					}
					setState(506);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case OBJ:
			case VAR:
			case NUM:
			case INT:
			case FLT:
			case STR:
			case CHR:
			case BOL:
			case BYT:
				_localctx = new CreatedNamePrimitiveTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(507); primitiveType();
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

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyriteVisitor ) return ((PyriteVisitor<? extends T>)visitor).visitArrayCreatorRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(510); match(LBRACK);
			setState(538);
			switch (_input.LA(1)) {
			case RBRACK:
				{
				setState(511); match(RBRACK);
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(512); match(LBRACK);
					setState(513); match(RBRACK);
					}
					}
					setState(518);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(519); arrayInitializer();
				}
				break;
			case 1:
			case 4:
			case 6:
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
				setState(520); expression(0);
				setState(521); match(RBRACK);
				setState(528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(522); match(LBRACK);
						setState(523); expression(0);
						setState(524); match(RBRACK);
						}
						} 
					}
					setState(530);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				}
				setState(535);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!=ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(531); match(LBRACK);
						setState(532); match(RBRACK);
						}
						} 
					}
					setState(537);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 86, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(540); match(LPAREN);
			setState(542);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 4) | (1L << 6) | (1L << DecimalNumeral) | (1L << Digits) | (1L << HexNumeral) | (1L << OctalNumeral) | (1L << BinaryNumeral) | (1L << CharacterLiteral) | (1L << StringLiteral) | (1L << NEW) | (1L << LPAREN))) != 0) || _la==DOT || _la==Identifier) {
				{
				setState(541); expressionList();
				}
			}

			setState(544); match(RPAREN);
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
		enterRule(_localctx, 88, RULE_integerLiteral);
		try {
			setState(550);
			switch (_input.LA(1)) {
			case DecimalNumeral:
				_localctx = new IntegerLiteralDecimalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(546); match(DecimalNumeral);
				}
				break;
			case HexNumeral:
				_localctx = new IntegerLiteralHexContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(547); match(HexNumeral);
				}
				break;
			case OctalNumeral:
				_localctx = new IntegerLiteralOctalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(548); match(OctalNumeral);
				}
				break;
			case BinaryNumeral:
				_localctx = new IntegerLiteralBinaryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(549); match(BinaryNumeral);
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
		public TerminalNode Digits(int i) {
			return getToken(PyriteParser.Digits, i);
		}
		public List<TerminalNode> Digits() { return getTokens(PyriteParser.Digits); }
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
		enterRule(_localctx, 90, RULE_floatingPointLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_la = _input.LA(1);
			if (_la==Digits) {
				{
				setState(552); match(Digits);
				}
			}

			setState(555); match(DOT);
			setState(556); match(Digits);
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
		enterRule(_localctx, 92, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			_la = _input.LA(1);
			if ( !(_la==1 || _la==6) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		enterRule(_localctx, 94, RULE_characterLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560); match(CharacterLiteral);
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
		enterRule(_localctx, 96, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562); match(StringLiteral);
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
		enterRule(_localctx, 98, RULE_nullLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564); match(4);
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
		case 38: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);

		case 1: return precpred(_ctx, 10);

		case 2: return precpred(_ctx, 9);

		case 3: return precpred(_ctx, 8);

		case 4: return precpred(_ctx, 7);

		case 5: return precpred(_ctx, 6);

		case 6: return precpred(_ctx, 5);

		case 7: return precpred(_ctx, 4);

		case 8: return precpred(_ctx, 3);

		case 9: return precpred(_ctx, 2);

		case 10: return precpred(_ctx, 1);

		case 11: return precpred(_ctx, 15);

		case 12: return precpred(_ctx, 14);

		case 13: return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3l\u0239\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\5\2"+
		"h\n\2\3\2\7\2k\n\2\f\2\16\2n\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\5\4{\n\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6\u0085\n\6\3\6\3"+
		"\6\5\6\u0089\n\6\3\6\3\6\3\7\3\7\3\7\7\7\u0090\n\7\f\7\16\7\u0093\13\7"+
		"\3\b\3\b\7\b\u0097\n\b\f\b\16\b\u009a\13\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t"+
		"\u00a2\n\t\3\n\5\n\u00a5\n\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7"+
		"\13\u00b0\n\13\f\13\16\13\u00b3\13\13\5\13\u00b5\n\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\7\r\u00c0\n\r\f\r\16\r\u00c3\13\r\5\r\u00c5\n\r"+
		"\3\r\3\r\3\16\3\16\5\16\u00cb\n\16\3\17\3\17\3\17\3\17\3\20\5\20\u00d2"+
		"\n\20\3\20\3\20\3\20\3\20\5\20\u00d8\n\20\3\20\3\20\3\21\3\21\5\21\u00de"+
		"\n\21\3\22\3\22\3\22\3\22\7\22\u00e4\n\22\f\22\16\22\u00e7\13\22\3\22"+
		"\5\22\u00ea\n\22\5\22\u00ec\n\22\3\22\3\22\3\23\3\23\3\23\7\23\u00f3\n"+
		"\23\f\23\16\23\u00f6\13\23\3\23\3\23\3\23\7\23\u00fb\n\23\f\23\16\23\u00fe"+
		"\13\23\5\23\u0100\n\23\3\24\3\24\3\24\7\24\u0105\n\24\f\24\16\24\u0108"+
		"\13\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\7\30\u0113\n\30\f"+
		"\30\16\30\u0116\13\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u011e\n\31\3"+
		"\32\3\32\7\32\u0122\n\32\f\32\16\32\u0125\13\32\3\32\3\32\3\33\3\33\5"+
		"\33\u012b\n\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u0134\n\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u013d\n\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36"+
		"\u0151\n\36\f\36\16\36\u0154\13\36\3\36\7\36\u0157\n\36\f\36\16\36\u015a"+
		"\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0166\n"+
		"\36\3\37\5\37\u0169\n\37\3 \3 \3 \3 \3 \3 \5 \u0171\n \5 \u0173\n \3!"+
		"\6!\u0176\n!\r!\16!\u0177\3!\6!\u017b\n!\r!\16!\u017c\3!\3!\5!\u0181\n"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u018d\n\"\3#\3#\3#\3#\3"+
		"#\3#\5#\u0195\n#\3#\3#\5#\u0199\n#\3#\3#\5#\u019d\n#\5#\u019f\n#\3$\3"+
		"$\5$\u01a3\n$\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\7\'\u01ae\n\'\f\'\16\'\u01b1"+
		"\13\'\3(\3(\3(\3(\5(\u01b7\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\7(\u01e4\n(\f(\16(\u01e7\13(\3)\3)\3)\3)\3)\3)\5)"+
		"\u01ef\n)\3*\3*\3*\5*\u01f4\n*\3+\3+\3+\7+\u01f9\n+\f+\16+\u01fc\13+\3"+
		"+\5+\u01ff\n+\3,\3,\3,\3,\7,\u0205\n,\f,\16,\u0208\13,\3,\3,\3,\3,\3,"+
		"\3,\3,\7,\u0211\n,\f,\16,\u0214\13,\3,\3,\7,\u0218\n,\f,\16,\u021b\13"+
		",\5,\u021d\n,\3-\3-\5-\u0221\n-\3-\3-\3.\3.\3.\3.\5.\u0229\n.\3/\5/\u022c"+
		"\n/\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\2\3N\64\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`bd\2\n\3\2\63;\4\2VW[[\3\2TU\5\2\5\5\7\7\t\t\4\2FGMN\4\2LLOO"+
		"\4\2EE\\f\4\2\3\3\b\b\u0260\2g\3\2\2\2\4r\3\2\2\2\6v\3\2\2\2\b~\3\2\2"+
		"\2\n\u0080\3\2\2\2\f\u008c\3\2\2\2\16\u0094\3\2\2\2\20\u00a1\3\2\2\2\22"+
		"\u00a4\3\2\2\2\24\u00ab\3\2\2\2\26\u00b8\3\2\2\2\30\u00bb\3\2\2\2\32\u00c8"+
		"\3\2\2\2\34\u00cc\3\2\2\2\36\u00d1\3\2\2\2 \u00dd\3\2\2\2\"\u00df\3\2"+
		"\2\2$\u00ff\3\2\2\2&\u0101\3\2\2\2(\u0109\3\2\2\2*\u010b\3\2\2\2,\u010d"+
		"\3\2\2\2.\u010f\3\2\2\2\60\u011d\3\2\2\2\62\u011f\3\2\2\2\64\u012a\3\2"+
		"\2\2\66\u012c\3\2\2\28\u012f\3\2\2\2:\u0165\3\2\2\2<\u0168\3\2\2\2>\u016a"+
		"\3\2\2\2@\u0175\3\2\2\2B\u018c\3\2\2\2D\u019e\3\2\2\2F\u01a2\3\2\2\2H"+
		"\u01a4\3\2\2\2J\u01a6\3\2\2\2L\u01aa\3\2\2\2N\u01b6\3\2\2\2P\u01ee\3\2"+
		"\2\2R\u01f0\3\2\2\2T\u01fe\3\2\2\2V\u0200\3\2\2\2X\u021e\3\2\2\2Z\u0228"+
		"\3\2\2\2\\\u022b\3\2\2\2^\u0230\3\2\2\2`\u0232\3\2\2\2b\u0234\3\2\2\2"+
		"d\u0236\3\2\2\2fh\5\4\3\2gf\3\2\2\2gh\3\2\2\2hl\3\2\2\2ik\5\6\4\2ji\3"+
		"\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\5\n\6\2pq\7"+
		"\2\2\3q\3\3\2\2\2rs\7$\2\2st\5.\30\2tu\7B\2\2u\5\3\2\2\2vw\7 \2\2wz\5"+
		".\30\2xy\7D\2\2y{\7V\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\7B\2\2}\7\3\2"+
		"\2\2~\177\7)\2\2\177\t\3\2\2\2\u0080\u0081\7\24\2\2\u0081\u0084\7g\2\2"+
		"\u0082\u0083\7\32\2\2\u0083\u0085\5$\23\2\u0084\u0082\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0087\7\37\2\2\u0087\u0089\5\f\7\2"+
		"\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b"+
		"\5\16\b\2\u008b\13\3\2\2\2\u008c\u0091\5$\23\2\u008d\u008e\7C\2\2\u008e"+
		"\u0090\5$\23\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\r\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0098"+
		"\7>\2\2\u0095\u0097\5\20\t\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009c\7?\2\2\u009c\17\3\2\2\2\u009d\u00a2\7B\2\2\u009e\u00a2"+
		"\5\34\17\2\u009f\u00a2\5\22\n\2\u00a0\u00a2\5\36\20\2\u00a1\u009d\3\2"+
		"\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2"+
		"\21\3\2\2\2\u00a3\u00a5\5\b\5\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2"+
		"\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\5\24\13\2\u00a8"+
		"\u00a9\5\30\r\2\u00a9\u00aa\5*\26\2\u00aa\23\3\2\2\2\u00ab\u00b4\7<\2"+
		"\2\u00ac\u00b1\5\26\f\2\u00ad\u00ae\7C\2\2\u00ae\u00b0\5\26\f\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7=\2\2\u00b7\25\3\2\2\2"+
		"\u00b8\u00b9\5$\23\2\u00b9\u00ba\7g\2\2\u00ba\27\3\2\2\2\u00bb\u00c4\7"+
		"<\2\2\u00bc\u00c1\5\32\16\2\u00bd\u00be\7C\2\2\u00be\u00c0\5\32\16\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00bc\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7=\2\2\u00c7\31\3\2\2\2"+
		"\u00c8\u00ca\5$\23\2\u00c9\u00cb\7g\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb"+
		"\3\2\2\2\u00cb\33\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\5\24\13\2\u00ce"+
		"\u00cf\5,\27\2\u00cf\35\3\2\2\2\u00d0\u00d2\5\b\5\2\u00d1\u00d0\3\2\2"+
		"\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\5$\23\2\u00d4\u00d7"+
		"\7g\2\2\u00d5\u00d6\7E\2\2\u00d6\u00d8\5 \21\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\7B\2\2\u00da\37\3\2\2\2"+
		"\u00db\u00de\5\"\22\2\u00dc\u00de\5N(\2\u00dd\u00db\3\2\2\2\u00dd\u00dc"+
		"\3\2\2\2\u00de!\3\2\2\2\u00df\u00eb\7>\2\2\u00e0\u00e5\5 \21\2\u00e1\u00e2"+
		"\7C\2\2\u00e2\u00e4\5 \21\2\u00e3\u00e1\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5"+
		"\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2"+
		"\2\2\u00e8\u00ea\7C\2\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ec\3\2\2\2\u00eb\u00e0\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\7?\2\2\u00ee#\3\2\2\2\u00ef\u00f4\5(\25\2\u00f0\u00f1"+
		"\7@\2\2\u00f1\u00f3\7A\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u0100\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f7\u00fc\5&\24\2\u00f8\u00f9\7@\2\2\u00f9\u00fb\7A\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u00ef\3\2\2\2\u00ff\u00f7\3\2"+
		"\2\2\u0100%\3\2\2\2\u0101\u0106\7g\2\2\u0102\u0103\7D\2\2\u0103\u0105"+
		"\7g\2\2\u0104\u0102\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\'\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\t\2\2\2"+
		"\u010a)\3\2\2\2\u010b\u010c\5\62\32\2\u010c+\3\2\2\2\u010d\u010e\5\62"+
		"\32\2\u010e-\3\2\2\2\u010f\u0114\7g\2\2\u0110\u0111\7D\2\2\u0111\u0113"+
		"\7g\2\2\u0112\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115/\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u011e\5Z.\2\u0118"+
		"\u011e\5\\/\2\u0119\u011e\5`\61\2\u011a\u011e\5b\62\2\u011b\u011e\5^\60"+
		"\2\u011c\u011e\5d\63\2\u011d\u0117\3\2\2\2\u011d\u0118\3\2\2\2\u011d\u0119"+
		"\3\2\2\2\u011d\u011a\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e"+
		"\61\3\2\2\2\u011f\u0123\7>\2\2\u0120\u0122\5\64\33\2\u0121\u0120\3\2\2"+
		"\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7?\2\2\u0127\63\3\2\2\2\u0128"+
		"\u012b\5\66\34\2\u0129\u012b\5:\36\2\u012a\u0128\3\2\2\2\u012a\u0129\3"+
		"\2\2\2\u012b\65\3\2\2\2\u012c\u012d\58\35\2\u012d\u012e\7B\2\2\u012e\67"+
		"\3\2\2\2\u012f\u0130\5$\23\2\u0130\u0133\7g\2\2\u0131\u0132\7E\2\2\u0132"+
		"\u0134\5 \21\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u01349\3\2\2\2"+
		"\u0135\u0166\5\62\32\2\u0136\u0166\7B\2\2\u0137\u0138\5N(\2\u0138\u0139"+
		"\7B\2\2\u0139\u0166\3\2\2\2\u013a\u013c\7(\2\2\u013b\u013d\5L\'\2\u013c"+
		"\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0166\7B"+
		"\2\2\u013f\u0166\5> \2\u0140\u0141\5<\37\2\u0141\u0142\7\62\2\2\u0142"+
		"\u0143\5J&\2\u0143\u0144\5\62\32\2\u0144\u0166\3\2\2\2\u0145\u0146\5<"+
		"\37\2\u0146\u0147\7\35\2\2\u0147\u0148\7<\2\2\u0148\u0149\5D#\2\u0149"+
		"\u014a\7=\2\2\u014a\u014b\5\62\32\2\u014b\u0166\3\2\2\2\u014c\u014d\7"+
		"+\2\2\u014d\u014e\5J&\2\u014e\u0152\7>\2\2\u014f\u0151\5@!\2\u0150\u014f"+
		"\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0158\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157\5B\"\2\u0156\u0155\3\2"+
		"\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015b\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\7?\2\2\u015c\u0166\3\2"+
		"\2\2\u015d\u015e\7\21\2\2\u015e\u015f\5<\37\2\u015f\u0160\7B\2\2\u0160"+
		"\u0166\3\2\2\2\u0161\u0162\7\26\2\2\u0162\u0163\5<\37\2\u0163\u0164\7"+
		"B\2\2\u0164\u0166\3\2\2\2\u0165\u0135\3\2\2\2\u0165\u0136\3\2\2\2\u0165"+
		"\u0137\3\2\2\2\u0165\u013a\3\2\2\2\u0165\u013f\3\2\2\2\u0165\u0140\3\2"+
		"\2\2\u0165\u0145\3\2\2\2\u0165\u014c\3\2\2\2\u0165\u015d\3\2\2\2\u0165"+
		"\u0161\3\2\2\2\u0166;\3\2\2\2\u0167\u0169\7g\2\2\u0168\u0167\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169=\3\2\2\2\u016a\u016b\7\36\2\2\u016b\u016c\5J&\2\u016c"+
		"\u0172\5\62\32\2\u016d\u0170\7\30\2\2\u016e\u0171\5> \2\u016f\u0171\5"+
		"\62\32\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171\u0173\3\2\2\2\u0172"+
		"\u016d\3\2\2\2\u0172\u0173\3\2\2\2\u0173?\3\2\2\2\u0174\u0176\5B\"\2\u0175"+
		"\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2"+
		"\2\2\u0178\u017a\3\2\2\2\u0179\u017b\5\64\33\2\u017a\u0179\3\2\2\2\u017b"+
		"\u017c\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0180\3\2"+
		"\2\2\u017e\u017f\7\4\2\2\u017f\u0181\7B\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181A\3\2\2\2\u0182\u0183\7\22\2\2\u0183\u0184\5Z.\2\u0184"+
		"\u0185\7K\2\2\u0185\u018d\3\2\2\2\u0186\u0187\7\22\2\2\u0187\u0188\5b"+
		"\62\2\u0188\u0189\7K\2\2\u0189\u018d\3\2\2\2\u018a\u018b\7\27\2\2\u018b"+
		"\u018d\7K\2\2\u018c\u0182\3\2\2\2\u018c\u0186\3\2\2\2\u018c\u018a\3\2"+
		"\2\2\u018dC\3\2\2\2\u018e\u018f\5$\23\2\u018f\u0190\7g\2\2\u0190\u0191"+
		"\7K\2\2\u0191\u0192\5N(\2\u0192\u019f\3\2\2\2\u0193\u0195\5F$\2\u0194"+
		"\u0193\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\7B"+
		"\2\2\u0197\u0199\5N(\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a"+
		"\3\2\2\2\u019a\u019c\7B\2\2\u019b\u019d\5H%\2\u019c\u019b\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e\u018e\3\2\2\2\u019e\u0194\3\2"+
		"\2\2\u019fE\3\2\2\2\u01a0\u01a3\58\35\2\u01a1\u01a3\5L\'\2\u01a2\u01a0"+
		"\3\2\2\2\u01a2\u01a1\3\2\2\2\u01a3G\3\2\2\2\u01a4\u01a5\5L\'\2\u01a5I"+
		"\3\2\2\2\u01a6\u01a7\7<\2\2\u01a7\u01a8\5N(\2\u01a8\u01a9\7=\2\2\u01a9"+
		"K\3\2\2\2\u01aa\u01af\5N(\2\u01ab\u01ac\7C\2\2\u01ac\u01ae\5N(\2\u01ad"+
		"\u01ab\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2"+
		"\2\2\u01b0M\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01b3\b(\1\2\u01b3\u01b7"+
		"\5P)\2\u01b4\u01b5\7#\2\2\u01b5\u01b7\5R*\2\u01b6\u01b2\3\2\2\2\u01b6"+
		"\u01b4\3\2\2\2\u01b7\u01e5\3\2\2\2\u01b8\u01b9\f\r\2\2\u01b9\u01ba\t\3"+
		"\2\2\u01ba\u01e4\5N(\16\u01bb\u01bc\f\f\2\2\u01bc\u01bd\t\4\2\2\u01bd"+
		"\u01e4\5N(\r\u01be\u01bf\f\13\2\2\u01bf\u01c0\t\5\2\2\u01c0\u01e4\5N("+
		"\f\u01c1\u01c2\f\n\2\2\u01c2\u01c3\t\6\2\2\u01c3\u01e4\5N(\13\u01c4\u01c5"+
		"\f\t\2\2\u01c5\u01c6\t\7\2\2\u01c6\u01e4\5N(\n\u01c7\u01c8\f\b\2\2\u01c8"+
		"\u01c9\7X\2\2\u01c9\u01e4\5N(\t\u01ca\u01cb\f\7\2\2\u01cb\u01cc\7Z\2\2"+
		"\u01cc\u01e4\5N(\b\u01cd\u01ce\f\6\2\2\u01ce\u01cf\7Y\2\2\u01cf\u01e4"+
		"\5N(\7\u01d0\u01d1\f\5\2\2\u01d1\u01d2\7P\2\2\u01d2\u01e4\5N(\6\u01d3"+
		"\u01d4\f\4\2\2\u01d4\u01d5\7Q\2\2\u01d5\u01e4\5N(\5\u01d6\u01d7\f\3\2"+
		"\2\u01d7\u01d8\t\b\2\2\u01d8\u01e4\5N(\3\u01d9\u01da\f\21\2\2\u01da\u01db"+
		"\7D\2\2\u01db\u01e4\7g\2\2\u01dc\u01dd\f\20\2\2\u01dd\u01e4\5X-\2\u01de"+
		"\u01df\f\16\2\2\u01df\u01e0\7@\2\2\u01e0\u01e1\5N(\2\u01e1\u01e2\7A\2"+
		"\2\u01e2\u01e4\3\2\2\2\u01e3\u01b8\3\2\2\2\u01e3\u01bb\3\2\2\2\u01e3\u01be"+
		"\3\2\2\2\u01e3\u01c1\3\2\2\2\u01e3\u01c4\3\2\2\2\u01e3\u01c7\3\2\2\2\u01e3"+
		"\u01ca\3\2\2\2\u01e3\u01cd\3\2\2\2\u01e3\u01d0\3\2\2\2\u01e3\u01d3\3\2"+
		"\2\2\u01e3\u01d6\3\2\2\2\u01e3\u01d9\3\2\2\2\u01e3\u01dc\3\2\2\2\u01e3"+
		"\u01de\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2"+
		"\2\2\u01e6O\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01e9\7<\2\2\u01e9\u01ea"+
		"\5N(\2\u01ea\u01eb\7=\2\2\u01eb\u01ef\3\2\2\2\u01ec\u01ef\5\60\31\2\u01ed"+
		"\u01ef\7g\2\2\u01ee\u01e8\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ed\3\2"+
		"\2\2\u01efQ\3\2\2\2\u01f0\u01f3\5T+\2\u01f1\u01f4\5V,\2\u01f2\u01f4\5"+
		"X-\2\u01f3\u01f1\3\2\2\2\u01f3\u01f2\3\2\2\2\u01f4S\3\2\2\2\u01f5\u01fa"+
		"\7g\2\2\u01f6\u01f7\7D\2\2\u01f7\u01f9\7g\2\2\u01f8\u01f6\3\2\2\2\u01f9"+
		"\u01fc\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01ff\3\2"+
		"\2\2\u01fc\u01fa\3\2\2\2\u01fd\u01ff\5(\25\2\u01fe\u01f5\3\2\2\2\u01fe"+
		"\u01fd\3\2\2\2\u01ffU\3\2\2\2\u0200\u021c\7@\2\2\u0201\u0206\7A\2\2\u0202"+
		"\u0203\7@\2\2\u0203\u0205\7A\2\2\u0204\u0202\3\2\2\2\u0205\u0208\3\2\2"+
		"\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0209\3\2\2\2\u0208\u0206"+
		"\3\2\2\2\u0209\u021d\5\"\22\2\u020a\u020b\5N(\2\u020b\u0212\7A\2\2\u020c"+
		"\u020d\7@\2\2\u020d\u020e\5N(\2\u020e\u020f\7A\2\2\u020f\u0211\3\2\2\2"+
		"\u0210\u020c\3\2\2\2\u0211\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0213"+
		"\3\2\2\2\u0213\u0219\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u0216\7@\2\2\u0216"+
		"\u0218\7A\2\2\u0217\u0215\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2"+
		"\2\2\u0219\u021a\3\2\2\2\u021a\u021d\3\2\2\2\u021b\u0219\3\2\2\2\u021c"+
		"\u0201\3\2\2\2\u021c\u020a\3\2\2\2\u021dW\3\2\2\2\u021e\u0220\7<\2\2\u021f"+
		"\u0221\5L\'\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2"+
		"\2\2\u0222\u0223\7=\2\2\u0223Y\3\2\2\2\u0224\u0229\7\n\2\2\u0225\u0229"+
		"\7\f\2\2\u0226\u0229\7\r\2\2\u0227\u0229\7\16\2\2\u0228\u0224\3\2\2\2"+
		"\u0228\u0225\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0227\3\2\2\2\u0229[\3"+
		"\2\2\2\u022a\u022c\7\13\2\2\u022b\u022a\3\2\2\2\u022b\u022c\3\2\2\2\u022c"+
		"\u022d\3\2\2\2\u022d\u022e\7D\2\2\u022e\u022f\7\13\2\2\u022f]\3\2\2\2"+
		"\u0230\u0231\t\t\2\2\u0231_\3\2\2\2\u0232\u0233\7\17\2\2\u0233a\3\2\2"+
		"\2\u0234\u0235\7\20\2\2\u0235c\3\2\2\2\u0236\u0237\7\6\2\2\u0237e\3\2"+
		"\2\2>glz\u0084\u0088\u0091\u0098\u00a1\u00a4\u00b1\u00b4\u00c1\u00c4\u00ca"+
		"\u00d1\u00d7\u00dd\u00e5\u00e9\u00eb\u00f4\u00fc\u00ff\u0106\u0114\u011d"+
		"\u0123\u012a\u0133\u013c\u0152\u0158\u0165\u0168\u0170\u0172\u0177\u017c"+
		"\u0180\u018c\u0194\u0198\u019c\u019e\u01a2\u01af\u01b6\u01e3\u01e5\u01ee"+
		"\u01f3\u01fa\u01fe\u0206\u0212\u0219\u021c\u0220\u0228\u022b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}