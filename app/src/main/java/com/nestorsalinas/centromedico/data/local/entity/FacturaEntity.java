package com.nestorsalinas.centromedico.data.local.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "facturas")
public class FacturaEntity {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long citaId;
    private String numeroFactura;
    private double monto;
    private String fecha;

    public FacturaEntity(long citaId, String numeroFactura, double monto, String fecha) {
        this.citaId = citaId;
        this.numeroFactura = numeroFactura;
        this.monto = monto;
        this.fecha = fecha;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public long getCitaId() { return citaId; }
    public String getNumeroFactura() { return numeroFactura; }
    public double getMonto() { return monto; }
    public String getFecha() { return fecha; }
}