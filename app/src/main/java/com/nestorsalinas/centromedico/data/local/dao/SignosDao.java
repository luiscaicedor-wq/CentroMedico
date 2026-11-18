package com.nestorsalinas.centromedico.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import com.nestorsalinas.centromedico.data.local.entity.SignosVitalesEntity;

@Dao
public interface SignosDao {
    @Insert
    long insertar(SignosVitalesEntity signos);
}