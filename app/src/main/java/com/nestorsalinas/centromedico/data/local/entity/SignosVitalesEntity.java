package com.nestorsalinas.centromedico.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "signos_vitales")
public class SignosVitalesEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long pacienteId;
    private long citaId;
    private String presion;
    private String temperatura;
    private String frecuenciaCardiaca;
    private String fecha;

    public SignosVitalesEntity(long pacienteId, long citaId, String presion, String temperatura, String frecuenciaCardiaca, String fecha) {
        this.pacienteId = pacienteId;
        this.citaId = citaId;
        this.presion = presion;
        this.temperatura = temperatura;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.fecha = fecha;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getPacienteId() { return pacienteId; }
    public long getCitaId() { return citaId; }
    public String getPresion() { return presion; }
    public String getTemperatura() { return temperatura; }
    public String getFrecuenciaCardiaca() { return frecuenciaCardiaca; }
    public String getFecha() { return fecha; }
}