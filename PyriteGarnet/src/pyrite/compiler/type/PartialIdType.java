package pyrite.compiler.type;

import pyrite.compiler.BC;
import pyrite.compiler.ClassResolver;
import pyrite.compiler.CodeGenerationVisitor;
import pyrite.compiler.ConstantPoolManager;
import pyrite.compiler.ImportDeclarationManager;
import pyrite.compiler.MethodCodeDeclation;


public class PartialIdType extends VarType
{
	// for PARTIALID
	protected String	_id;

	// ドット続きのidについて、解析前で型が確定していない状態を示す
	public static VarType	getType(String id)
	{
		int	hashCode = createHashCode(TYPE.PARTIALID, id);
		VarType	varType = __varTypeMap.get(hashCode);
		if (varType == null)
		{
			varType = new PartialIdType(TYPE.PARTIALID, id);
			__varTypeMap.put(hashCode, varType);
		}

		return	varType;
	}

	protected PartialIdType(TYPE type, String id)
	{
		super._type = type;
		super._hashCode = createHashCode(type, id);

		_id = id;
	}


	// ID 先頭要素の型解決を行った後の型を返す
	// this, ローカル変数, 自クラスのインスタンス変数・クラス変数, クラス, パッケージ, 自クラスのメソッド呼び出し が指定できる
	@Override
	public VarType	resolveType(CodeGenerationVisitor cgv)
	{
		ClassResolver	cr = cgv._cr;
		ConstantPoolManager	cpm = cgv._cpm;
		ImportDeclarationManager	idm = cgv._idm;
		MethodCodeDeclation	methodDeclaretion = cgv._currentMethodCodeDeclation;
		String	className = cgv._className;
		ClassResolver.ClassFieldMember	thisClassFieldMember = cgv._thisClassFieldMember;

		VarType	varType;
		if (cgv.isAssignLeftExpressionElement(_id))
		{	// left expression
			// assign()で値設定するため、ここでコードは作成しない。
			// 代わりに setLeftExpressionVarType() を呼び出し、設定情報を保持しておく。

			VarTypeName	varTypeName = methodDeclaretion.getLocalVar(_id);
			if (varTypeName != null)
			{	// local variable
				switch (varTypeName._type._type)
				{
				case INT:
					break;
				case BOL:
					break;
				case STR:
					break;
				case OBJ:
					break;
				default:
					throw new RuntimeException("assert:");
				}

//				cgv.setLeftExpressionVarType(1, varTypeName._localVarNum, null, null);
//				return	varTypeName._type;

				return	new AssignLeftExpressionType(varTypeName._type, 1, varTypeName._localVarNum, null, null);
			}

			varType = thisClassFieldMember._instanceFieldMap.get(_id);
			if (varType != null)
			{	// instance field
				if (methodDeclaretion._isStatic)
				{	// static メソッドで インスタンス変数は使用できない
					throw new RuntimeException("this is not usable at static context. ");
				}
				methodDeclaretion.addCodeOp(BC.ALOAD_0);
//				cgv.setLeftExpressionVarType(2, -1, className, _id);
//				return	varType;

				return	new AssignLeftExpressionType(varType, 2, -1, className, _id);
			}

			varType = thisClassFieldMember._classFieldMap.get(_id);
			if (varType != null)
			{	// class field
//				cgv.setLeftExpressionVarType(3, -1, className, _id);
//				return	varType;

				return	new AssignLeftExpressionType(varType, 3, -1, className, _id);
			}
		}
		else
		{
			if (_id.equals("this"))
			{	// this
				if (methodDeclaretion._isStatic)
				{	// static コンテキストで this キーワードは使用できない
					throw new RuntimeException("this is not usable at static context. ");
				}
				methodDeclaretion.addCodeOp(BC.ALOAD_0);

				return	ObjectType.getType(className);
			}

			VarTypeName	varTypeName = methodDeclaretion.getLocalVar(_id);
			if (varTypeName != null)
			{	// local variable
				switch (varTypeName._type._type)
				{
				case INT:
				case BOL:
					methodDeclaretion.addCodeOpILOAD(varTypeName._localVarNum);
					break;
				case STR:
				case OBJ:
				case ARRAY:
					methodDeclaretion.addCodeOpALOAD(varTypeName._localVarNum);
					break;
				default:
					throw new RuntimeException("assert:");
					}
				return	varTypeName._type;
			}

			varType = thisClassFieldMember._instanceFieldMap.get(_id);
			if (varType != null)
			{	// instance field
				if (methodDeclaretion._isStatic)
				{	// static メソッドで インスタンス変数は使用できない
					throw new RuntimeException("this is not usable at static context. ");
				}

				methodDeclaretion.addCodeOp(BC.ALOAD_0);
				methodDeclaretion.addCodeOp(BC.GETFIELD);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(className, _id, varType._jvmExpression));

				return	varType;
			}

			varType = thisClassFieldMember._classFieldMap.get(_id);
			if (varType != null)
			{	// class field
				methodDeclaretion.addCodeOp(BC.GETSTATIC);
				methodDeclaretion.addCodeU2(cpm.getFieldRef(className, _id, varType._jvmExpression));
				return	varType;
			}

			String[]	packageClassName = idm.resolveClassName("", _id);
			if (packageClassName != null)
			{	// class name
				return	ClassType.getType(packageClassName[0], packageClassName[1]);
			}

			if (cr.isPackage("", _id))
			{	// package name
				return	PackageType.getType("", _id);
			}

			// 同名のクラスメソッド・インスタンスメソッドが存在する場合のため、先にクラスメソッドをチェックする
			varType = thisClassFieldMember._classMethodNameMap.get(_id);
			if (varType != null)
			{	// class method
				return	varType;
			}

			varType = thisClassFieldMember._instanceMethodNameMap.get(_id);
			if (varType != null)
			{	// instance method
				if (methodDeclaretion._isStatic)
				{	// static メソッドで インスタンスメソッドは使用できない
					throw new RuntimeException("this is not usable at static context. ");
				}
				methodDeclaretion.addCodeOp(BC.ALOAD_0);
				return	varType;
			}
		}

		throw new RuntimeException("id is not declared. id:" + _id);
	}

	// (自分の型, 続く型)
	//       (変数, そのクラスのインスタンス変数 | クラス変数 | インスタンスメソッド | クラスメソッド)
	//       (クラス, クラス変数 | クラスメソッド),
	//       (クラス, クラス),
	//       (パッケージ, クラス)
	//       (パッケージ, パッケージ)
	@Override
	public VarType	resolveTrailerType(CodeGenerationVisitor cgv, String id)
	{
		throw new RuntimeException("assertion::PartialIdType can not have trailer.");
	}
}
