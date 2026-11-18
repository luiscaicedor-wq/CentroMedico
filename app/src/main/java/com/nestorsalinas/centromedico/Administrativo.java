package com.nestorsalinas.centromedico;

public class Administrativo extends Empleado {
    private String area;
    private String cargo;

    public Administrativo(String nombres, String apellidos, String tipoIdentidad, String identidad, int edad, String nacionalidad, double estatura, String idEmpleado, double salario, String area, String cargo) {
        super(nombres, apellidos, tipoIdentidad, identidad, edad, nacionalidad, estatura, idEmpleado, salario);
        this.area = area;
        this.cargo = cargo;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() +
                "\nArea: " + area +
                "\nCargo: " + cargo;
    }
}