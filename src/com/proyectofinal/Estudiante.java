package com.proyectofinal;

import java.util.List;

class Estudiante {
    private String nombre;
    private String identificacion;
    private int edad;
    private String carrera;
    private double promedio;
    private List<Double> notas;

    public Estudiante(String nombre, String identificacion, int edad, String carrera, List<Double> notas, double promedio) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.carrera = carrera;
        this.notas = notas;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Estudiante: " +
                "Nombre='" + nombre + '\'' +
                ", Identificacion='" + identificacion + '\'' +
                ", Edad=" + edad +
                ", Carrera='" + carrera + '\'' +
                ", Notas- " + notas +
                ", Promedio=" + promedio;
    }
}
