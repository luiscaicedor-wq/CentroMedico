package com.nestorsalinas.centromedico;

public class Consulta {
    private String idConsulta;
    private String fecha;
    private String motivo;
    private String diagnostico;
    private String prescripcion;
    private Paciente paciente;
    private Medico medico;

    public Consulta(String idConsulta, String fecha, String motivo, String diagnostico, String prescripcion, Paciente paciente, Medico medico) {
        this.idConsulta = idConsulta;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.prescripcion = prescripcion;
        this.paciente = paciente;
        this.medico = medico;
    }

    public String getIdConsulta() { return idConsulta; }
    public String getFecha() { return fecha; }
    public String getMotivo() { return motivo; }
    public String getDiagnostico() { return diagnostico; }
    public String getPrescripcion() { return prescripcion; }
    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
}