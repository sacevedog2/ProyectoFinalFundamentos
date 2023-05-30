package com.proyectofinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroEstudiantes {

    static List<Estudiante> listaEstudiantes;
    static double promedio;

    public static void main(String[] args) {
        listaEstudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nIngresa '1' para REGISTRAR un nuevo estudiante.");
            System.out.println("Ingresa '2' para BUSCAR un estudiante. (ya debió de crear el estudiante en '1')");
            System.out.println("Ingresa '3' para MOSTRAR estudiantes registrados.");
            System.out.println("Ingresa '4' para leer el archivo de texto plano 'Estudiantes.txt");
            System.out.println("Ingresa '5' para EXPORTAR los datos y salir.");
            System.out.println("Ingresa '6' para SALIR del programa.");
            String eleccion = scanner.nextLine();

            switch (eleccion) {
                case "1":
                    while (true) {
                        Estudiante estudiante = registrarEstudiante(scanner);
                        if (estudiante == null) {
                            break;
                        }
                        listaEstudiantes.add(estudiante);
                        System.out.println("Estudiante registrado correctamente.\n");
                    }
                    break;
                case "2":
                    System.out.println("Busque un estudiante (o 'salir' para finalizar):");
                    String nombreBuscado = scanner.nextLine();
                    Estudiante estudianteEncontrado = buscarEstudiantePorNombre(nombreBuscado);
                    if (estudianteEncontrado != null) {
                        System.out.println("Estudiante encontrado: " + estudianteEncontrado);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case "3":
                    System.out.println("Lista de estudiantes registrados:");
                    for (Estudiante estudiante : listaEstudiantes) {
                        System.out.println(estudiante);
                    }
                    break;
                case "4":
                    // Reemplazar con tu ruta de acceso
                    String direccionArchivo = "C:\\Users\\gomas\\OneDrive\\Escritorio\\ProyectoFinalFundamentos\\Estudiantes.txt";
                    String contenidoArchivo = Persistencia.leerTxt(direccionArchivo);
                    System.out.println("Contenido del archivo:");
                    System.out.println(contenidoArchivo);
                    break;
                case "5":
                    Persistencia.exportarEstudiantes(listaEstudiantes, "Estudiantes.txt");
                case "6":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        System.out.println("¡Programa finalizado!");
        System.exit(0);
    }

    private static Estudiante registrarEstudiante(Scanner scanner) {
        System.out.println("Ingrese el nombre del estudiante (o 'salir' para finalizar):");
        String nombre = scanner.nextLine();
        if (nombre.equalsIgnoreCase("salir")) {
            return null;
        }

        System.out.println("Ingrese el número de identificación:");
        String identificacion = scanner.nextLine();

        System.out.println("Ingrese la edad:");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese la carrera que cursa:");
        String carrera = scanner.nextLine();

        List<Double> notas = new ArrayList<>();
        System.out.println("Ingrese las notas del estudiante " + nombre + " (ingrese -1 para terminar):");
        double nota;
        do {
            System.out.print("Nota: ");
            nota = Double.parseDouble(scanner.nextLine());

            if (nota >= -1 && nota <= 5) {
                notas.add(nota);
            } else {
                System.out.println("Error: La nota debe estar entre 0 y 5. Intente nuevamente.");
            }
        } while (nota != -1);

        double promedio = calcularPromedio(notas);

        return new Estudiante(nombre, identificacion, edad, carrera, notas, promedio);
    }

    public static double calcularPromedio(List<Double> notas) {
        double suma = 0;

        for (double nota : notas) {
            suma += nota;
        }

        if (!notas.isEmpty()) {
            return suma / notas.size();
        } else {
            return 0;
        }
    }

    private static Estudiante buscarEstudiantePorNombre(String nombre) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return estudiante;
            }
        }
        return null;
    }
}
