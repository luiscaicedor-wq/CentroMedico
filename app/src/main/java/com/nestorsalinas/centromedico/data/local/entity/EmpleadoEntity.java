package com.nestorsalinas.centromedico.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "empleados")
public class EmpleadoEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String idEmpleado;
    private String correo;
    private String passwordHash;
    private String rol;
    private String nombres;
    private String apellidos;

    public EmpleadoEntity(String idEmpleado, String correo, String passwordHash, String rol, String nombres, String apellidos) {
        this.idEmpleado = idEmpleado;
        this.correo = correo;
        this.passwordHash = passwordHash;
        this.rol = rol;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getIdEmpleado() { return idEmpleado; }
    public String getCorreo() { return correo; }
    public String getPasswordHash() { return passwordHash; }
    public String getRol() { return rol; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
}