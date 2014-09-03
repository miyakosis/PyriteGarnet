package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import pyrite.compiler.antlr.PyriteBaseVisitor;
import pyrite.compiler.antlr.PyriteLexer;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.ArrayType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;
import pyrite.compiler.util.StringUtil;

public class GrammarCommonVisitor extends PyriteBaseVisitor<Object>
{
	public final ImportDeclarationManager	_idm;

	public GrammarCommonVisitor(ImportDeclarationManager idm)
	{
		_idm = idm;
	}

	// '(' (inputParameter (',' inputParameter)*)? ')'
	@Override
	public Object visitInputParameters(@NotNull PyriteParser.InputParametersContext ctx)
	{
		List<VarTypeName>	paramList = new ArrayList<VarTypeName>();
		if (ctx.inputParameter() != null)
		{
			for (PyriteParser.InputParameterContext paramCtx : ctx.inputParameter())
			{
				VarTypeName	methodParam = (VarTypeName)visit(paramCtx);
				paramList.add(methodParam);
			}
		}

		return	paramList;
	}

	// type Identifier
	@Override
	public Object visitInputParameter(@NotNull PyriteParser.InputParameterContext ctx)
	{
		VarType	type = (VarType)visit(ctx.type());
		String	name = ctx.Identifier().getText();

		return	new VarTypeName(type, name);

//		MethodParam	methodParam = (MethodParam)visit(ctx.type());
//		methodParam.setVarName(ctx.Identifier().getText());
//		return	methodParam;
	}

	// '(' (outputParameter (',' outputParameter)*)? ')'
	@Override
	public Object visitOutputParameters(@NotNull PyriteParser.OutputParametersContext ctx)
	{
		List<VarTypeName>	paramList = new ArrayList<VarTypeName>();
		if (ctx.outputParameter() != null)
		{
			for (PyriteParser.OutputParameterContext paramCtx : ctx.outputParameter())
			{
				VarTypeName	methodParam = (VarTypeName)visit(paramCtx);
				paramList.add(methodParam);
			}
		}

		return	paramList;
	}

	// type Identifier?
	@Override
	public Object visitOutputParameter(@NotNull PyriteParser.OutputParameterContext ctx)
	{
		VarType	type = (VarType)visit(ctx.type());
		String	name = ctx.Identifier() != null ? ctx.Identifier().getText() : null;

		return	new VarTypeName(type, name);

//		MethodParam	methodParam = (MethodParam)visit(ctx.type());
//		TerminalNode	id = ctx.Identifier();
//		if (id != null)
//		{
//			methodParam.setVarName(ctx.Identifier().getText());
//		}
//		return	methodParam;
	}

	// primitiveType ('[' ']')*		# TypePrimitiveType	// primitiveType ('[' ']')*
	@Override
	public Object visitTypePrimitiveType(@NotNull PyriteParser.TypePrimitiveTypeContext ctx)
	{
		VarType	type = (VarType)visit(ctx.primitiveType());
		int	nArrayLevel = getArrayLevel(ctx);

		return	(nArrayLevel == 0) ? type : ArrayType.getType(type, nArrayLevel);
	}

	// classOrInterfaceType ('[' ']')*	# TypeClassType	// classOrInterfaceType ('[' ']')*
	@Override
	public Object visitTypeClassType(@NotNull PyriteParser.TypeClassTypeContext ctx)
	{
		String	name = ctx.classOrInterfaceType().getText();
		int	nArrayLevel = getArrayLevel(ctx);

		String[]	elements = StringUtil.splitLastElement(name, '.');
		String[]	packageClassName = _idm.resolveClassName(elements[0], elements[1]);

		if (packageClassName == null)
		{
			throw new PyriteSyntaxException("name class is unknown.");
		}
		name = packageClassName[0] + "." + packageClassName[1];
		VarType	type = ObjectType.getType(name);

		return	(nArrayLevel == 0) ? type : ArrayType.getType(type, nArrayLevel);
	}

	private int	getArrayLevel(PyriteParser.TypeContext ctx)
	{
		List<TerminalNode> tokenList = ctx.getTokens(PyriteLexer.LBRACK);
		return	(tokenList != null) ? tokenList.size() : 0;
	}

	//  type (',' type)*
	@Override
	public Object visitTypeList(@NotNull PyriteParser.TypeListContext ctx)
	{
		List<VarType>	typeList = new ArrayList<VarType>();

		for (PyriteParser.TypeContext tctx : ctx.type())
		{
			typeList.add((VarType)visit(tctx));
		}

		return	typeList;
	}

	// '(' expression ')'
	@Override
	public Object visitPrimaryParens(@NotNull PyriteParser.PrimaryParensContext ctx)
	{
		return visit(ctx.expression());
	}

//	primitiveType
//    :   'obj'
//    |   'var'
//    |   'num'
//    |   'int'
//    |   'flt'
//    |   'str'
//    |   'chr'
//    |   'bol'
//    |   'byt'
//    ;
	@Override
	public Object visitPrimitiveType(@NotNull PyriteParser.PrimitiveTypeContext ctx)
	{
		String	name = ctx.getText();

		switch (name)
		{
		case "int":
			return	VarType.INT;

		case "str":
			return	VarType.STR;

		case "bol":
			return	VarType.BOL;

		case "obj":
		case "var":
		case "num":
		case "flt":
		case "chr":
		case "byt":
		default:
			throw new RuntimeException("not supported");
		}
	}
}
