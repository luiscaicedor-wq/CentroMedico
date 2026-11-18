package com.nestorsalinas.centromedico.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pacientes")
public class PacienteEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String historiaMedica;

    public PacienteEntity(String dni, String nombres, String apellidos, String telefono, String historiaMedica) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.historiaMedica = historiaMedica;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getHistoriaMedica() { return historiaMedica; }
}