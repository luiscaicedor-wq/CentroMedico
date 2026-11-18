package com.nestorsalinas.centromedico.data.local;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.nestorsalinas.centromedico.data.local.dao.*;
import com.nestorsalinas.centromedico.data.local.entity.*;
import java.util.concurrent.Executors;

@Database(entities = {
        EmpleadoEntity.class,
        PacienteEntity.class,
        CitaEntity.class,
        SignosVitalesEntity.class,
        FacturaEntity.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;

    public abstract EmpleadoDao empleadoDao();
    public abstract PacienteDao pacienteDao();
    public abstract CitaDao citaDao();
    public abstract SignosDao signosDao();
    public abstract FacturaDao facturaDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "agenda_citas.db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadExecutor().execute(() -> {
                try {
                    db.execSQL("INSERT OR IGNORE INTO empleados (id, idEmpleado, correo, passwordHash, rol, nombres, apellidos) VALUES " +
                            "(1, '1', 'laura.gomez@mavata.test', 'medico1-2026', 'Medico', 'Laura', 'Gómez')," +
                            "(6, '6', 'sofia.munoz@mavata.test', 'enfermero1-2026', 'Enfermero', 'Sofía', 'Muñoz')," +
                            "(11, '11', 'superadmin@mavata.test', 'superadmin-2026', 'Administrativo', 'Super', 'Admin');");
                } catch (Exception e) {
                    // Ignore if table exists or seeded
                }
            });
        }
    };
}