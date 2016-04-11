package pyrite.compiler;

import org.antlr.v4.runtime.misc.NotNull;

import pyrite.compiler.FQCNParser.FQCN;
import pyrite.compiler.antlr.PyriteBaseVisitor;
import pyrite.compiler.antlr.PyriteParser;

public class ClassNameVisitor extends PyriteBaseVisitor<Object>
{
	private String	_packageName;

	private FQCN	_fqcn;

	// packageDeclaration? importDeclaration* classDeclaration EOF
	@Override
	public Object visitCompilationUnit(@NotNull PyriteParser.CompilationUnitContext ctx)
	{
		// package
		if (ctx.packageDeclaration() != null)
		{
			_packageName = (String)visit(ctx.packageDeclaration());
		}
		else
		{
			_packageName = "";
		}

		// import
		// ここでは処理しない

		// class
		visit(ctx.classDeclaration());

		return	null;
	}

	// 'package' qualifiedName ';'
	@Override
	public Object visitPackageDeclaration(@NotNull PyriteParser.PackageDeclarationContext ctx)
	{
		return	ctx.qualifiedName().getText();
	}

	// 'class' Identifier ('extends' type)? ('implements' typeList)? classBody
	@Override
	public Object visitClassDeclaration(@NotNull PyriteParser.ClassDeclarationContext ctx)
	{
		String	classNameStr = ctx.Identifier().getText();

		_fqcn = FQCNParser.getFQCN(_packageName, classNameStr);

		return	null;
	}

	public FQCN getFQCN()
	{
		return _fqcn;
	}
}
