package com.nestorsalinas.centromedico;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private String idHistorial;
    private Paciente paciente;
    private List<Consulta> consultas;

    public HistorialMedico(String idHistorial, Paciente paciente) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
        this.consultas = new ArrayList<>();
    }

    public String getIdHistorial() { return idHistorial; }
    public Paciente getPaciente() { return paciente; }
    public List<Consulta> getConsultas() { return consultas; }
    public void agregarConsulta(Consulta c) { consultas.add(c); }
}