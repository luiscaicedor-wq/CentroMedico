package com.nestorsalinas.centromedico;

public class Medico extends Empleado {
    private String especialidad;
    private String numeroColegiado;

    public Medico(String nombres, String apellidos, String tipoIdentidad, String identidad, int edad, String nacionalidad, double estatura, String idEmpleado, double salario, String especialidad, String numeroColegiado) {
        super(nombres, apellidos, tipoIdentidad, identidad, edad, nacionalidad, estatura, idEmpleado, salario);
        this.especialidad = especialidad;
        this.numeroColegiado = numeroColegiado;
    }

    public String getEspecialidad() { return especialidad; }
    public String getNumeroColegiado() { return numeroColegiado; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }

    @Override

    public String mostrarDatos() {
        return super.mostrarDatos() +
                "\nEspecialidad: " + especialidad +
                "\nN° Colegiado: " + numeroColegiado;
    }
}