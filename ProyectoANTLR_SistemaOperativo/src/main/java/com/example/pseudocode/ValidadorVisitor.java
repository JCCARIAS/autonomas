package com.example.pseudocode;

public class ValidadorVisitor extends PseudoCodeBaseVisitor<Void> {
    public int funciones = 0;
    public int parametrosValidos = 0;
    public int asignacionesValidas = 0;
    public int condicionesValidas = 0;

    @Override
    public Void visitFuncion(PseudoCodeParser.FuncionContext ctx) {
        funciones++;
        return super.visitFuncion(ctx);
    }

    @Override
    public Void visitParametros(PseudoCodeParser.ParametrosContext ctx) {
        parametrosValidos += ctx.getChildCount();
        return super.visitParametros(ctx);
    }

    @Override
    public Void visitAsignacion(PseudoCodeParser.AsignacionContext ctx) {
        asignacionesValidas++;
        return super.visitAsignacion(ctx);
    }

    @Override
    public Void visitCondicion(PseudoCodeParser.CondicionContext ctx) {
        condicionesValidas++;
        return super.visitCondicion(ctx);
    }
}
