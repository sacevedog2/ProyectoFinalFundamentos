package com.proyectofinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class Persistencia {
    public static void guardarEstudiantes(List<Estudiante> listaEstudiantes) {
        exportarEstudiantes(listaEstudiantes, "Estudiantes.txt");
    }

    public static void exportarEstudiantes(List<Estudiante> listaEstudiantes, String nombreArchivo) {
        try {
            FileWriter writer = new FileWriter(nombreArchivo, true); // Abrir en modo "append"

            for (Estudiante estudiante : listaEstudiantes) {
                String linea = "Estudiante= " + estudiante.getNombre() + ",\n" 
                        + "Identificacion= " + estudiante.getIdentificacion() + ",\n" 
                        + "Edad= " + estudiante.getEdad() + ",\n"
                        + "Carrera= " + estudiante.getCarrera() + ",\n"
                        + "Promedio= " + estudiante.getPromedio() + "\n";
                writer.write(linea);
            }
            writer.close();
            System.out.println("Los datos se han exportado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    public static String leerTxt(String direccion) {
        String texto = "";

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(direccion));
            String linea;
            while ((linea = bf.readLine()) != null) {
                texto += linea;
            }
        } catch (Exception e) {
            System.err.println("Error abriendo el archivo: " + e.getMessage());
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
        
        return texto;
    }
}
