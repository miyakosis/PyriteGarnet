package pyrite.compiler;

import java.util.ArrayList;
import java.util.List;

import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.antlr.PyriteBaseVisitor;
import pyrite.compiler.antlr.PyriteParser;
import pyrite.compiler.type.ArrayType;
import pyrite.compiler.type.AssocType;
import pyrite.compiler.type.ObjectType;
import pyrite.compiler.type.VarType;
import pyrite.compiler.type.VarTypeName;

public class GrammarCommonVisitor extends PyriteBaseVisitor<Object>
{
	public final ClassResolver	_cr;
	public final ImportDeclarationManager	_idm;

	public GrammarCommonVisitor(ClassResolver cr, ImportDeclarationManager idm)
	{
		_cr = cr;
		_idm = idm;
	}

	// inputParameters
    // :   '(' (inputParameter (',' inputParameter)*)? ')'
	@Override
	public Object visitInputParameters(PyriteParser.InputParametersContext ctx)
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

	// inputParameter
    // :   'var'? Identifier ':' typeOrArray
	@Override
	public Object visitInputParameter(PyriteParser.InputParameterContext ctx)
	{
		VarType	type = (VarType)visit(ctx.typeOrArray());
		String	name = ctx.Identifier().getText();

		return	new VarTypeName(type, name);

//		MethodParam	methodParam = (MethodParam)visit(ctx.type());
//		methodParam.setVarName(ctx.Identifier().getText());
//		return	methodParam;
	}

	// outputParameters
    // :   '(' (outputParameter (',' outputParameter)*)? ')'
	@Override
	public Object visitOutputParameters(PyriteParser.OutputParametersContext ctx)
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

	// outputParameter
    // :   ('var'? Identifier ':')? typeOrArray
	@Override
	public Object visitOutputParameter(PyriteParser.OutputParameterContext ctx)
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
	public Object visitTypePrimitiveType(PyriteParser.TypePrimitiveTypeContext ctx)
	{
		VarType	type = (VarType)visit(ctx.primitiveType());
		int	nArrayLevel = getArrayLevel(ctx);

		return	(nArrayLevel == 0) ? type : ArrayType.getType(type, nArrayLevel);
	}
*/
/*
	// classOrInterfaceType ('[' ']')*	# TypeClassType	// classOrInterfaceType ('[' ']')*
	@Override
	public Object visitTypeClassType(PyriteParser.TypeClassTypeContext ctx)
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
	/*
	private int	getArrayLevel(PyriteParser.TypeContext ctx)
	{
		List<TerminalNode> tokenList = ctx.getTokens(PyriteLexer.LBRACK);
		return	(tokenList != null) ? tokenList.size() : 0;
	}
	*/

	//  type (',' type)*
	@Override
	public Object visitTypeList(PyriteParser.TypeListContext ctx)
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
	public Object visitPrimaryParens(PyriteParser.PrimaryParensContext ctx)
	{
		return visit(ctx.expression());
	}

	// array
	//	:   '[' typeOrArray (':' typeOrArray)? ']'
	@Override
	public Object visitArray(PyriteParser.ArrayContext ctx)
	{
		if (ctx.typeOrArray().size() == 1)
		{	// array
			VarType	valType = (VarType)visit(ctx.typeOrArray(0));
			return	ArrayType.getType((VarType)valType);
		}
		else
		{	// assoc
			VarType	keyType = (VarType)visit(ctx.typeOrArray(0));
			VarType	valType = (VarType)visit(ctx.typeOrArray(1));
			return	AssocType.getType(keyType, valType);
		}
	}

//	@Override
//	// type ':' type
//	public Object visitArraySpecAssoc(PyriteParser.ArraySpecAssocContext ctx)
//	{
//		VarType	keyType = (VarType)visit(ctx.type(0));
//		VarType	valType = (VarType)visit(ctx.type(1));
//
//		return	new VarType[]{keyType, valType};
//	}



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
	public Object visitPrimitiveType(PyriteParser.PrimitiveTypeContext ctx)
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

		case "dec":
			return	VarType.DEC;

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

	// qualifiedName
	// : Identifier ('.' Identifier)*
	@Override
	public Object visitQualifiedName(PyriteParser.QualifiedNameContext ctx)
	{
		String	fqcnStr = ctx.getText();
		FQCN	fqcn = _idm.resolveClassName(fqcnStr);
		if (fqcn == null || _cr.existsFQCN(fqcn) == false)
		{
			throw new PyriteSyntaxException("class not found.:" + fqcnStr);
		}
		return	ObjectType.getType(fqcn._fqcnStr);
	}

}
