package com.nestorsalinas.centromedico;

import java.util.ArrayList;
import java.util.List;

public class CentroMedico {
    private static CentroMedico instancia;
    private List<Empleado> listaPersonal;
    private List<Paciente> listaPacientes;
    private List<Consulta> listaCitas;

    private CentroMedico() {
        listaPersonal = new ArrayList<>();
        listaPacientes = new ArrayList<>();
        listaCitas = new ArrayList<>();

        // Datos iniciales de prueba
        listaPersonal.add(new Medico("Laura", "Gómez", "DNI", "0988776655", 38, "Peruana", 1.68, "COL-98765", 6000.0, "Cardiología", "COL-98765"));
        listaPersonal.add(new Enfermero("Carlos", "Ruiz", "DNI", "0988776654", 32, "Peruana", 1.75, "EMP-102", 3200.0, "Turno Mañana", "Emergencias"));
        listaPersonal.add(new Administrativo("María", "López", "DNI", "0988776653", 30, "Peruana", 1.62, "EMP-101", 2800.0, "Recepción", "Asistente"));

        listaPacientes.add(new Paciente("Juan", "Pérez", "DNI", "0988776655", 35, "Peruana", 1.72, "I-C-2024-001", "EPS"));
    }

    public static synchronized CentroMedico getInstancia() {
        if (instancia == null) {
            instancia = new CentroMedico();
        }
        return instancia;
    }

    public List<Empleado> getListaPersonal() { return listaPersonal; }
    public List<Paciente> getListaPacientes() { return listaPacientes; }
    public List<Consulta> getListaCitas() { return listaCitas; }

    public void agregarEmpleado(Empleado e) { listaPersonal.add(e); }
    public void agregarPaciente(Paciente p) { listaPacientes.add(p); }
    public void agregarCita(Consulta c) { listaCitas.add(c); }
}