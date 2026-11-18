package com.nestorsalinas.centromedico.data.repository;

import android.content.Context;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.dao.SignosDao;
import com.nestorsalinas.centromedico.data.local.entity.SignosVitalesEntity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SignosRepository {
    private final SignosDao signosDao;
    private final ExecutorService executorService;

    public SignosRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        signosDao = db.signosDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void guardarSignos(SignosVitalesEntity signos, Runnable onComplete) {
        executorService.execute(() -> {
            signosDao.insertar(signos);
            if (onComplete != null) onComplete.run();
        });
    }
}