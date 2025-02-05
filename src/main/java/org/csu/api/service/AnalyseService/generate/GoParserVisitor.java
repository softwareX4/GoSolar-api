// Generated from G:/AAApersonal/����/project/go-parse-master/src/service/AnalyseService\GoParser.g4 by ANTLR 4.8
package org.csu.api.service.AnalyseService.generate;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GoParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GoParser#sourceFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceFile(GoParser.SourceFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#packageClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageClause(GoParser.PackageClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#importDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDecl(GoParser.ImportDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#importSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpec(GoParser.ImportSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#importPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportPath(GoParser.ImportPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GoParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(GoParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#constSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstSpec(GoParser.ConstSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(GoParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(GoParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDecl(GoParser.TypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpec(GoParser.TypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(GoParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(GoParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#receiver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiver(GoParser.ReceiverContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(GoParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#varSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarSpec(GoParser.VarSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GoParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(GoParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GoParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#simpleStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmt(GoParser.SimpleStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#expressionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(GoParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#sendStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSendStmt(GoParser.SendStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#incDecStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDecStmt(GoParser.IncDecStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GoParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#assign_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_op(GoParser.Assign_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#shortVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortVarDecl(GoParser.ShortVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#emptyStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(GoParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#labeledStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStmt(GoParser.LabeledStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(GoParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(GoParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#continueStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(GoParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#gotoStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStmt(GoParser.GotoStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#fallthroughStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFallthroughStmt(GoParser.FallthroughStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#deferStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeferStmt(GoParser.DeferStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(GoParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#switchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStmt(GoParser.SwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#exprSwitchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSwitchStmt(GoParser.ExprSwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#exprCaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCaseClause(GoParser.ExprCaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#exprSwitchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSwitchCase(GoParser.ExprSwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeSwitchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSwitchStmt(GoParser.TypeSwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeSwitchGuard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSwitchGuard(GoParser.TypeSwitchGuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeCaseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCaseClause(GoParser.TypeCaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeSwitchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSwitchCase(GoParser.TypeSwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(GoParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#selectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStmt(GoParser.SelectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#commClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommClause(GoParser.CommClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#commCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommCase(GoParser.CommCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#recvStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecvStmt(GoParser.RecvStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(GoParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(GoParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#rangeClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeClause(GoParser.RangeClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#goStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoStmt(GoParser.GoStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#type_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_(GoParser.Type_Context ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(GoParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeLit(GoParser.TypeLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(GoParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#arrayLength}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLength(GoParser.ArrayLengthContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#elementType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementType(GoParser.ElementTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#pointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerType(GoParser.PointerTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#interfaceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceType(GoParser.InterfaceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#sliceType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceType(GoParser.SliceTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#mapType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapType(GoParser.MapTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#channelType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannelType(GoParser.ChannelTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#methodSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSpec(GoParser.MethodSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(GoParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(GoParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#result}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResult(GoParser.ResultContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(GoParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#parameterDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDecl(GoParser.ParameterDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GoParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(GoParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(GoParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#conversion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConversion(GoParser.ConversionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(GoParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(GoParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#basicLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicLit(GoParser.BasicLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(GoParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#operandName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperandName(GoParser.OperandNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#qualifiedIdent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedIdent(GoParser.QualifiedIdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#compositeLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeLit(GoParser.CompositeLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#literalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralType(GoParser.LiteralTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#literalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(GoParser.LiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(GoParser.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#keyedElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyedElement(GoParser.KeyedElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(GoParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(GoParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#structType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(GoParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(GoParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#string_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_(GoParser.String_Context ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#anonymousField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousField(GoParser.AnonymousFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#functionLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLit(GoParser.FunctionLitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(GoParser.IndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#slice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlice(GoParser.SliceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#typeAssertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssertion(GoParser.TypeAssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(GoParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#methodExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExpr(GoParser.MethodExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#receiverType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverType(GoParser.ReceiverTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoParser#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(GoParser.EosContext ctx);
}