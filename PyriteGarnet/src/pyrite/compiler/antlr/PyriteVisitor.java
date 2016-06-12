// Generated from Pyrite.g4 by ANTLR 4.5.2

  package pyrite.compiler.antlr;

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
	 * Visit a parse tree produced by {@link PyriteParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(PyriteParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#packageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageDeclaration(PyriteParser.PackageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(PyriteParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#classInstanceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassInstanceModifier(PyriteParser.ClassInstanceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(PyriteParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(PyriteParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(PyriteParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(PyriteParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(PyriteParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#inputParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputParameters(PyriteParser.InputParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#inputParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputParameter(PyriteParser.InputParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#outputParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputParameters(PyriteParser.OutputParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#outputParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputParameter(PyriteParser.OutputParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(PyriteParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(PyriteParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#typeOrArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeOrArray(PyriteParser.TypeOrArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PyriteParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(PyriteParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(PyriteParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(PyriteParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#constructorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorBody(PyriteParser.ConstructorBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#constructorCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorCall(PyriteParser.ConstructorCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(PyriteParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PyriteParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PyriteParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(PyriteParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementEmpty}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementEmpty(PyriteParser.StatementEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementExpression}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(PyriteParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementVar}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementVar(PyriteParser.StatementVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(PyriteParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementIf}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIf(PyriteParser.StatementIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementWhile}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementWhile(PyriteParser.StatementWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementFor}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementFor(PyriteParser.StatementForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementSwitch}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSwitch(PyriteParser.StatementSwitchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementBreak}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBreak(PyriteParser.StatementBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementContinue}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementContinue(PyriteParser.StatementContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementTry}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementTry(PyriteParser.StatementTryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementThrow}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementThrow(PyriteParser.StatementThrowContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementSynchronized}
	 * labeled alternative in {@link PyriteParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSynchronized(PyriteParser.StatementSynchronizedContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#variableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationStatement(PyriteParser.VariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(PyriteParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PyriteParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#catchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchClause(PyriteParser.CatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(PyriteParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchBlockStatementGroup(PyriteParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SwitchLabelCaseInt}
	 * labeled alternative in {@link PyriteParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabelCaseInt(PyriteParser.SwitchLabelCaseIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SwitchLabelCaseStr}
	 * labeled alternative in {@link PyriteParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabelCaseStr(PyriteParser.SwitchLabelCaseStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SwitchLabelDefault}
	 * labeled alternative in {@link PyriteParser#switchLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchLabelDefault(PyriteParser.SwitchLabelDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForControlIterator}
	 * labeled alternative in {@link PyriteParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControlIterator(PyriteParser.ForControlIteratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForControlICU}
	 * labeled alternative in {@link PyriteParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControlICU(PyriteParser.ForControlICUContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(PyriteParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionNew}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNew(PyriteParser.ExpressionNewContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionMulDiv}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMulDiv(PyriteParser.ExpressionMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionClassFieldRef}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionClassFieldRef(PyriteParser.ExpressionClassFieldRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionPrimary}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPrimary(PyriteParser.ExpressionPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionArrayAccess}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionArrayAccess(PyriteParser.ExpressionArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionInvokeMethod}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInvokeMethod(PyriteParser.ExpressionInvokeMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBitOr}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitOr(PyriteParser.ExpressionBitOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddSub(PyriteParser.ExpressionAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionShift}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionShift(PyriteParser.ExpressionShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionCast}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCast(PyriteParser.ExpressionCastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBolOr}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBolOr(PyriteParser.ExpressionBolOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBitExOr}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitExOr(PyriteParser.ExpressionBitExOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAssign}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAssign(PyriteParser.ExpressionAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionEqual}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEqual(PyriteParser.ExpressionEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBitAnd}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBitAnd(PyriteParser.ExpressionBitAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionBolAnd}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBolAnd(PyriteParser.ExpressionBolAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionCompare}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCompare(PyriteParser.ExpressionCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionPair}
	 * labeled alternative in {@link PyriteParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPair(PyriteParser.ExpressionPairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryParens}
	 * labeled alternative in {@link PyriteParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryParens(PyriteParser.PrimaryParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryThis}
	 * labeled alternative in {@link PyriteParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryThis(PyriteParser.PrimaryThisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link PyriteParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryLiteral(PyriteParser.PrimaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryIdentifier}
	 * labeled alternative in {@link PyriteParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryIdentifier(PyriteParser.PrimaryIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CreatorClass}
	 * labeled alternative in {@link PyriteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatorClass(PyriteParser.CreatorClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CreatorArray}
	 * labeled alternative in {@link PyriteParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatorArray(PyriteParser.CreatorArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(PyriteParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteralDecimal}
	 * labeled alternative in {@link PyriteParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralDecimal(PyriteParser.IntegerLiteralDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteralHex}
	 * labeled alternative in {@link PyriteParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralHex(PyriteParser.IntegerLiteralHexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteralOctal}
	 * labeled alternative in {@link PyriteParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralOctal(PyriteParser.IntegerLiteralOctalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteralBinary}
	 * labeled alternative in {@link PyriteParser#integerLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteralBinary(PyriteParser.IntegerLiteralBinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#floatingPointLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatingPointLiteral(PyriteParser.FloatingPointLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(PyriteParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#characterLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharacterLiteral(PyriteParser.CharacterLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(PyriteParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyriteParser#nullLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(PyriteParser.NullLiteralContext ctx);
}