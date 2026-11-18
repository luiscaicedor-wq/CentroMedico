package com.nestorsalinas.centromedico.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.nestorsalinas.centromedico.data.local.entity.CitaEntity;
import java.util.List;

@Dao
public interface CitaDao {
    @Query("SELECT * FROM citas WHERE medicoId = :medicoId AND fecha = :fecha")
    List<CitaEntity> obtenerCitasPorMedicoYFecha(long medicoId, String fecha);

    @Insert
    long insertar(CitaEntity cita);
}