package com.nestorsalinas.centromedico.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.nestorsalinas.centromedico.data.local.entity.PacienteEntity;
import java.util.List;

@Dao
public interface PacienteDao {
    @Insert
    long insertar(PacienteEntity paciente);

    @Query("SELECT * FROM pacientes")
    List<PacienteEntity> obtenerTodos();
}