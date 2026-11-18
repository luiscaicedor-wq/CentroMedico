package com.nestorsalinas.centromedico.data.repository;

import android.content.Context;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.dao.PacienteDao;
import com.nestorsalinas.centromedico.data.local.entity.PacienteEntity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PacienteRepository {
    private final PacienteDao pacienteDao;
    private final ExecutorService executorService;

    public PacienteRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        pacienteDao = db.pacienteDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insertarPaciente(PacienteEntity paciente, Runnable onComplete) {
        executorService.execute(() -> {
            pacienteDao.insertar(paciente);
            if (onComplete != null) {
                onComplete.run();
            }
        });
    }
}