// Generated from Pyrite.g4 by ANTLR 4.2.2

  package pyrite.compiler.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PyriteParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PyriteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(@NotNull PyriteParser.StatementWhileContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#floatingPointLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointLiteral(@NotNull PyriteParser.FloatingPointLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(@NotNull PyriteParser.StatementIfContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(@NotNull PyriteParser.ExpressionListContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(@NotNull PyriteParser.StatementBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull PyriteParser.StringLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(@NotNull PyriteParser.ForUpdateContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionArrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionArrayAccess(@NotNull PyriteParser.ExpressionArrayAccessContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#inputParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputParameter(@NotNull PyriteParser.InputParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#outputParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputParameters(@NotNull PyriteParser.OutputParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionShift}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionShift(@NotNull PyriteParser.ExpressionShiftContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#inputParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputParameters(@NotNull PyriteParser.InputParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#outputParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputParameter(@NotNull PyriteParser.OutputParameterContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#SwitchLabelCaseInt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabelCaseInt(@NotNull PyriteParser.SwitchLabelCaseIntContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#primaryLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryLiteral(@NotNull PyriteParser.PrimaryLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull PyriteParser.ClassBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(@NotNull PyriteParser.ImportDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEqual(@NotNull PyriteParser.ExpressionEqualContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#CreatedNamePrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedNamePrimitiveType(@NotNull PyriteParser.CreatedNamePrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionBitOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitOr(@NotNull PyriteParser.ExpressionBitOrContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionBitExOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitExOr(@NotNull PyriteParser.ExpressionBitExOrContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(@NotNull PyriteParser.PackageDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#IntegerLiteralBinary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralBinary(@NotNull PyriteParser.IntegerLiteralBinaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(@NotNull PyriteParser.LabelContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementContinue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementContinue(@NotNull PyriteParser.StatementContinueContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementSwitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSwitch(@NotNull PyriteParser.StatementSwitchContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#classInstanceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceModifier(@NotNull PyriteParser.ClassInstanceModifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ForControlIterator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControlIterator(@NotNull PyriteParser.ForControlIteratorContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementEmpty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementEmpty(@NotNull PyriteParser.StatementEmptyContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ForControlICU}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControlICU(@NotNull PyriteParser.ForControlICUContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(@NotNull PyriteParser.ClassBodyDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(@NotNull PyriteParser.TypeListContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(@NotNull PyriteParser.LocalVariableDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#IntegerLiteralDecimal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralDecimal(@NotNull PyriteParser.IntegerLiteralDecimalContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#IntegerLiteralOctal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralOctal(@NotNull PyriteParser.IntegerLiteralOctalContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionAddSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddSub(@NotNull PyriteParser.ExpressionAddSubContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(@NotNull PyriteParser.CompilationUnitContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionBolAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBolAnd(@NotNull PyriteParser.ExpressionBolAndContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrInterfaceType(@NotNull PyriteParser.ClassOrInterfaceTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(@NotNull PyriteParser.VariableInitializerContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull PyriteParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionMulDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMulDiv(@NotNull PyriteParser.ExpressionMulDivContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(@NotNull PyriteParser.BlockStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(@NotNull PyriteParser.CreatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#primaryIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryIdentifier(@NotNull PyriteParser.PrimaryIdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(@NotNull PyriteParser.LocalVariableDeclarationStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBreak(@NotNull PyriteParser.StatementBreakContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(@NotNull PyriteParser.StatementReturnContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPrimary(@NotNull PyriteParser.ExpressionPrimaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionClassFieldRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionClassFieldRef(@NotNull PyriteParser.ExpressionClassFieldRefContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(@NotNull PyriteParser.StatementExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(@NotNull PyriteParser.FieldDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionInvokeMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInvokeMethod(@NotNull PyriteParser.ExpressionInvokeMethodContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#TypePrimitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrimitiveType(@NotNull PyriteParser.TypePrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull PyriteParser.MethodDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(@NotNull PyriteParser.ParExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#TypeClassType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeClassType(@NotNull PyriteParser.TypeClassTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(@NotNull PyriteParser.ConstructorDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#CreatedNameIdentifer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedNameIdentifer(@NotNull PyriteParser.CreatedNameIdentiferContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(@NotNull PyriteParser.QualifiedNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(@NotNull PyriteParser.ClassDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(@NotNull PyriteParser.BooleanLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#primaryParens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryParens(@NotNull PyriteParser.PrimaryParensContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionCompare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCompare(@NotNull PyriteParser.ExpressionCompareContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull PyriteParser.IfStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionBitAnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitAnd(@NotNull PyriteParser.ExpressionBitAndContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#nullLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(@NotNull PyriteParser.NullLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull PyriteParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(@NotNull PyriteParser.ConstructorBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(@NotNull PyriteParser.MethodBodyContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#characterLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterLiteral(@NotNull PyriteParser.CharacterLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(@NotNull PyriteParser.ArrayInitializerContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#IntegerLiteralHex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralHex(@NotNull PyriteParser.IntegerLiteralHexContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull PyriteParser.PrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#SwitchLabelDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabelDefault(@NotNull PyriteParser.SwitchLabelDefaultContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#SwitchLabelCaseStr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabelCaseStr(@NotNull PyriteParser.SwitchLabelCaseStrContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionNew}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNew(@NotNull PyriteParser.ExpressionNewContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#StatementFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementFor(@NotNull PyriteParser.StatementForContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(@NotNull PyriteParser.ForInitContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(@NotNull PyriteParser.ArrayCreatorRestContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssign(@NotNull PyriteParser.ExpressionAssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#ExpressionBolOr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBolOr(@NotNull PyriteParser.ExpressionBolOrContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull PyriteParser.LiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link PyriteParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(@NotNull PyriteParser.SwitchBlockStatementGroupContext ctx);
}