package com.nestorsalinas.centromedico.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.nestorsalinas.centromedico.data.local.entity.FacturaEntity;

@Dao
public interface FacturaDao {
    @Insert
    long insertar(FacturaEntity factura);

    @Query("SELECT COUNT(*) FROM facturas")
    int contarFacturas();
}