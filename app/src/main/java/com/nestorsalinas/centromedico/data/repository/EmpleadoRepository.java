package com.nestorsalinas.centromedico.data.repository;

import android.content.Context;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.dao.EmpleadoDao;
import com.nestorsalinas.centromedico.data.local.entity.EmpleadoEntity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmpleadoRepository {
    private final EmpleadoDao empleadoDao;
    private final ExecutorService executorService;

    public EmpleadoRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        empleadoDao = db.empleadoDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void buscarEmpleado(String idOrEmail, OnEmpleadoLoadedListener listener) {
        executorService.execute(() -> {
            EmpleadoEntity empleado = empleadoDao.getEmpleadoPorIdOCorreo(idOrEmail);
            if (listener != null) {
                listener.onLoaded(empleado);
            }
        });
    }

    public interface OnEmpleadoLoadedListener {
        void onLoaded(EmpleadoEntity empleado);
    }
}