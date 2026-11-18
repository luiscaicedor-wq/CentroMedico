package com.nestorsalinas.centromedico.data.repository;

import android.content.Context;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.dao.CitaDao;
import com.nestorsalinas.centromedico.data.local.entity.CitaEntity;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CitaRepository {
    private final CitaDao citaDao;
    private final ExecutorService executorService;

    public CitaRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        citaDao = db.citaDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void obtenerCitasPorMedicoYFecha(long medicoId, String fecha, OnCitasLoadedListener listener) {
        executorService.execute(() -> {
            List<CitaEntity> citas = citaDao.obtenerCitasPorMedicoYFecha(medicoId, fecha);
            if (listener != null) {
                listener.onLoaded(citas);
            }
        });
    }

    public interface OnCitasLoadedListener {
        void onLoaded(List<CitaEntity> citas);
    }
}