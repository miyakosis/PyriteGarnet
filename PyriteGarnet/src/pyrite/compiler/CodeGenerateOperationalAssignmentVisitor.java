package pyrite.compiler;

import org.antlr.v4.runtime.tree.ParseTree;

import pyrite.compiler.ClassResolver.ClassFieldMember;
import pyrite.compiler.FQCNParser.FQCN;

// 演算代入子の際に、左辺要素を参照してスタックに積むためのVisitor
public class CodeGenerateOperationalAssignmentVisitor extends CodeGenerationVisitor
{

	public CodeGenerateOperationalAssignmentVisitor(ClassResolver cr, ConstantPoolManager cpm,
			ImportDeclarationManager idm, FQCN fqcn, ClassFieldMember thisClassFieldMember)
	{
		super(cr, cpm, idm, fqcn, thisClassFieldMember);
	}

	public boolean	isLValueExpressionElement(ParseTree ctx)
	{	// 左辺値要素であっても、参照用のコードを生成する
		return	false;
	}
}
