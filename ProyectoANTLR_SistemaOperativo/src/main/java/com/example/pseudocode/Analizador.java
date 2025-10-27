package com.example.pseudocode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analizador {

    public static Reporte analyze(String contenido) {
        Reporte r = new Reporte();

        // Contar funciones
        r.funciones = countTag(contenido, "funcion");

        // Contar parámetros válidos (identificador o número)
        Pattern paramPattern = Pattern.compile("<parametros>(.*?)</parametros>");
        Matcher paramMatcher = paramPattern.matcher(contenido);
        while (paramMatcher.find()) {
            String[] parametros = paramMatcher.group(1).split(",");
            for (String p : parametros) {
                p = p.trim();
                if (p.matches("[a-zA-Z_][a-zA-Z0-9_]*") || p.matches("\\d+")) {
                    r.parametrosValidos++;
                } else {
                    r.parametrosInvalidos++;
                }
            }
        }

        // Contar asignaciones válidas (id = num; o id = id + id;)
        Pattern codigoPattern = Pattern.compile("<codigo>(.*?)</codigo>", Pattern.DOTALL);
        Matcher codigoMatcher = codigoPattern.matcher(contenido);
        while (codigoMatcher.find()) {
            String codigo = codigoMatcher.group(1);
            Pattern asignPattern = Pattern.compile("\\s*([a-zA-Z_][a-zA-Z0-9_]*)\\s*=\\s*([a-zA-Z0-9_+\\-*/ ]+);");
            Matcher m = asignPattern.matcher(codigo);
            while (m.find()) {
                r.asignacionesValidas++;
            }
        }

        // Contar condiciones
        Pattern condPattern = Pattern.compile("<condicion>(.*?)</condicion>");
        Matcher condMatcher = condPattern.matcher(contenido);
        while (condMatcher.find()) {
            String c = condMatcher.group(1).trim();
            if (c.matches("[a-zA-Z0-9_ ]+[><=!]+[a-zA-Z0-9_ ]+(\\s*(&&|\\|\\|)\\s*[a-zA-Z0-9_ ]+[><=!]+[a-zA-Z0-9_ ]+)?")) {
                r.condicionesValidas++;
            } else {
                r.condicionesInvalidas++;
            }
        }

        // Contar if y do válidos
        r.ifValidos = countTag(contenido, "if");
        r.doValidos = countTag(contenido, "do");

        // Para simplificar, los errores sintácticos se podrían contar si hay etiquetas abiertas sin cerrar
        r.erroresSintacticos = 0; // Por ahora no implementado

        return r;
    }

    private static int countTag(String contenido, String tag) {
        int abiertos = contenido.split("<" + tag + ">").length - 1;
        int cerrados = contenido.split("</" + tag + ">").length - 1;
        return Math.min(abiertos, cerrados); // solo válidos completos
    }
}
