package com.nestorsalinas.centromedico;

public class Persona {
    protected String nombres;
    protected String apellidos;
    protected String tipoIdentidad;
    protected String identidad;
    protected int edad;
    protected String nacionalidad;
    protected double estatura;

    public Persona(String nombres, String apellidos, String tipoIdentidad, String identidad, int edad, String nacionalidad, double estatura) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoIdentidad = tipoIdentidad;
        this.identidad = identidad;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.estatura = estatura;
    }

    public String mostrarDatos() {
        return "Nombres: " + nombres + " " + apellidos +
                "\n" + tipoIdentidad + ": " + identidad +
                "\nEdad: " + edad +
                "\nNacionalidad: " + nacionalidad +
                "\nEstatura: " + estatura + "m";
    }
}