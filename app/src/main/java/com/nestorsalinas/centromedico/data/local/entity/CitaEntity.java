package com.nestorsalinas.centromedico.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "citas")
public class CitaEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long pacienteId;
    private long medicoId;
    private String fecha;
    private String hora;
    private String motivo;
    private String estado;

    public CitaEntity(long pacienteId, long medicoId, String fecha, String hora, String motivo, String estado) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getPacienteId() { return pacienteId; }
    public long getMedicoId() { return medicoId; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getMotivo() { return motivo; }
    public String getEstado() { return estado; }
}