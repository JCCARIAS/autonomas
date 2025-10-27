package com.example.pseudocode;

public class Reporte {
    public int funciones = 0;
    public int parametrosValidos = 0;
    public int parametrosInvalidos = 0;
    public int asignacionesValidas = 0;
    public int asignacionesInvalidas = 0;
    public int ifValidos = 0;
    public int ifInvalidos = 0;
    public int doValidos = 0;
    public int doInvalidos = 0;
    public int condicionesValidas = 0;
    public int condicionesInvalidas = 0;
    public int erroresLexicos = 0;
    public int erroresSintacticos = 0;

    @Override
    public String toString() {
        return String.format(
                "--- REPORTE DE VALIDACIÓN ---\n" +
                        "Funciones: %d\n" +
                        "Parámetros válidos: %d\n" +
                        "Parámetros inválidos: %d\n" +
                        "Asignaciones válidas: %d\n" +
                        "Asignaciones inválidas: %d\n" +
                        "If válidos: %d\n" +
                        "If inválidos: %d\n" +
                        "Do válidos: %d\n" +
                        "Do inválidos: %d\n" +
                        "Condiciones válidas: %d\n" +
                        "Condiciones inválidas: %d\n" +
                        "Errores léxicos: %d\n" +
                        "Errores sintácticos: %d\n" +
                        "--------------------------------",
                funciones, parametrosValidos, parametrosInvalidos,
                asignacionesValidas, asignacionesInvalidas,
                ifValidos, ifInvalidos,
                doValidos, doInvalidos,
                condicionesValidas, condicionesInvalidas,
                erroresLexicos, erroresSintacticos
        );
    }
}
