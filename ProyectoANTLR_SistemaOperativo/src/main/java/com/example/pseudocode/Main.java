package com.example.pseudocode;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Uso: java Main <archivo.txt>");
            return;
        }

        String input = Files.readString(Path.of(args[0]));
        PseudoCodeLexer lexer = new PseudoCodeLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PseudoCodeParser parser = new PseudoCodeParser(tokens);

        parser.removeErrorListeners();
        CollectingErrorListener listener = new CollectingErrorListener();
        parser.addErrorListener(listener);

        ParseTree tree = parser.program();
        ValidadorVisitor visitor = new ValidadorVisitor();
        visitor.visit(tree);

        System.out.println("--- REPORTE DE VALIDACIÓN ---");
        System.out.println("Funciones: " + visitor.funciones);
        System.out.println("Parámetros válidos: " + visitor.parametrosValidos);
        System.out.println("Asignaciones válidas: " + visitor.asignacionesValidas);
        System.out.println("Condiciones válidas: " + visitor.condicionesValidas);
        System.out.println("Errores sintácticos: " + listener.getSyntaxErrors());
    }
}
