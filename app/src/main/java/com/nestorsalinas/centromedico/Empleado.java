package com.nestorsalinas.centromedico;

public class Empleado extends Persona {
    protected String idEmpleado;
    protected double salario;

    public Empleado(String nombres, String apellidos, String tipoIdentidad, String identidad, int edad, String nacionalidad, double estatura, String idEmpleado, double salario) {
        super(nombres, apellidos, tipoIdentidad, identidad, edad, nacionalidad, estatura);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() +
                "\nID Empleado: " + idEmpleado +
                "\nSalario: S/." + salario;
    }
}