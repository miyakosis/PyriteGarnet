package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import pyrite.compiler.antlr.PyriteBaseVisitor;
import pyrite.compiler.antlr.PyriteLexer;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.ArrayType;
import pyrite.compiler.type.AssocType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;

public class GrammarCommonVisitor extends PyriteBaseVisitor<Object>
{
	protected final ClassResolver	_cr;
	protected final ImportDeclarationManager	_idm;

	public GrammarCommonVisitor(ClassResolver cr, ImportDeclarationManager idm)
	{
		_cr = cr;
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

	// Identifier ':' typeOrArray
	@Override
	public Object visitInputParameter(@NotNull PyriteParser.InputParameterContext ctx)
	{
		VarType	type = (VarType)visit(ctx.typeOrArray());
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

	// (Identifier ':')? typeOrArray
	@Override
	public Object visitOutputParameter(@NotNull PyriteParser.OutputParameterContext ctx)
	{
		VarType	type = (VarType)visit(ctx.typeOrArray());
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


/*
	// primitiveType ('[' ']')*		# TypePrimitiveType	// primitiveType ('[' ']')*
	@Override
	public Object visitTypePrimitiveType(@NotNull PyriteParser.TypePrimitiveTypeContext ctx)
	{
		VarType	type = (VarType)visit(ctx.primitiveType());
		int	nArrayLevel = getArrayLevel(ctx);

		return	(nArrayLevel == 0) ? type : ArrayType.getType(type, nArrayLevel);
	}
*/
/*
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
*/
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

	// '[' arraySpec ']'
	@Override
	public Object visitArray(@NotNull PyriteParser.ArrayContext ctx)
	{
		Object	arraySpecObj = visit(ctx.arraySpec());
		// assertion: arraySpec == VarType or VarType[] or ArrayType
		if (arraySpecObj instanceof VarType[])
		{
			VarType[]	varTypes = (VarType[])arraySpecObj;
			assert(varTypes.length == 2);
			return	AssocType.getType(varTypes[0], varTypes[1]);
		}
		else
		{
			return	ArrayType.getType((VarType)arraySpecObj);
		}
	}

	@Override
	// type ':' type
	public Object visitArraySpecAssoc(@NotNull PyriteParser.ArraySpecAssocContext ctx)
	{
		VarType	keyType = (VarType)visit(ctx.type(0));
		VarType	valType = (VarType)visit(ctx.type(1));

		return	new VarType[]{keyType, valType};
	}



//	primitiveType
//    :   'obj'
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
		case "obj":
			return	VarType.OBJ;

		case "num":
			return	VarType.NUM;

		case "int":
			return	VarType.INT;

		case "flt":
			return	VarType.FLT;

		case "str":
			return	VarType.STR;

		case "chr":
			return	VarType.CHR;

		case "bol":
			return	VarType.BOL;

		case "byt":
			return	VarType.BYT;

		default:
			throw new RuntimeException("assertion");
		}
	}


	// Identifier ('.' Identifier)*
	@Override
	public Object visitQualifiedName(@NotNull PyriteParser.QualifiedNameContext ctx)
	{
		String	fqcnStr = ctx.getText();
		if (_cr.isClass(FQCNParser.getFQCN(fqcnStr)) == false)
		{
			throw new PyriteSyntaxException("class not found.");
		}
		return	ObjectType.getType(fqcnStr);
	}

}
