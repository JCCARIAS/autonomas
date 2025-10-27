package com.example.pseudocode;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java Main <archivo.txt>");
            return;
        }

        String fileName = args[0];
        try {
            String content = Files.readString(Paths.get(fileName));
            Reporte reporte = Analizador.analyze(content);
            System.out.println(reporte);
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
