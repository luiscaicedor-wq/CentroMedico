package com.nestorsalinas.centromedico.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.nestorsalinas.centromedico.data.local.entity.EmpleadoEntity;

@Dao
public interface EmpleadoDao {
    @Query("SELECT * FROM empleados WHERE idEmpleado = :idOrEmail OR correo = :idOrEmail LIMIT 1")
    EmpleadoEntity getEmpleadoPorIdOCorreo(String idOrEmail);

    @Insert
    long insertar(EmpleadoEntity empleado);
}