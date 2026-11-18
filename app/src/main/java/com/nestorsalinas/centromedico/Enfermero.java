package com.nestorsalinas.centromedico;

public class
Enfermero extends Empleado {
    private String turno;
    private String areaAsignada;

    public Enfermero(String nombres, String apellidos, String tipoIdentidad, String identidad, int edad, String nacionalidad, double estatura, String idEmpleado, double salario, String turno, String areaAsignada) {
        super(nombres, apellidos, tipoIdentidad, identidad, edad, nacionalidad, estatura, idEmpleado, salario);
        this.turno = turno;
        this.areaAsignada = areaAsignada;
    }

    public String getTurno() { return turno; }
    public String getAreaAsignada() { return areaAsignada; }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() +
                "\nTurno: " + turno +
                "\nÁrea Asignada: " + areaAsignada;
    }
}