// Generated from com/example/pseudocode/PseudoCode.g4 by ANTLR 4.13.1
package com.example.pseudocode;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PseudoCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PseudoCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PseudoCodeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncion(PseudoCodeParser.FuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(PseudoCodeParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#codigo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodigo(PseudoCodeParser.CodigoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#estructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructura(PseudoCodeParser.EstructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#ifEstructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfEstructura(PseudoCodeParser.IfEstructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#doEstructura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoEstructura(PseudoCodeParser.DoEstructuraContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(PseudoCodeParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(PseudoCodeParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PseudoCodeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(PseudoCodeParser.ExpresionContext ctx);
}