package com.nestorsalinas.centromedico.data.repository;

import android.content.Context;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.dao.FacturaDao;
import com.nestorsalinas.centromedico.data.local.entity.FacturaEntity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FacturaRepository {
    private final FacturaDao facturaDao;
    private final ExecutorService executorService;

    public FacturaRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        facturaDao = db.facturaDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void emitirFactura(FacturaEntity factura, Runnable onComplete) {
        executorService.execute(() -> {
            facturaDao.insertar(factura);
            if (onComplete != null) onComplete.run();
        });
    }
}