package com.nestorsalinas.centromedico;

public class Paciente extends Persona {
    private String historiaMedica;
    private String tipoSeguro;

    public Paciente(String nombres, String apellidos, String tipoIdentidad, String identidad, int edad, String nacionalidad, double estatura, String historiaMedica, String tipoSeguro) {
        super(nombres, apellidos, tipoIdentidad, identidad, edad, nacionalidad, estatura);
        this.historiaMedica = historiaMedica;
        this.tipoSeguro = tipoSeguro;
    }

    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getIdentidad() { return identidad; }
    public String getHistoriaMedica() { return historiaMedica; }
    public String getTipoSeguro() { return tipoSeguro; }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() +
                "\nHisteoria Médica: " + historiaMedica +
                "\nTipo de Seguro: " + tipoSeguro;
    }
}