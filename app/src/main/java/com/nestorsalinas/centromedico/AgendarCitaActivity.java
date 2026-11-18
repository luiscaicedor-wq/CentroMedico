package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.entity.CitaEntity;

public class AgendarCitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar_cita);

        Button btnConfirmar = findViewById(R.id.btnConfirmarCita);
        if (btnConfirmar != null) {
            btnConfirmar.setOnClickListener(v -> {
                try {
                    CitaEntity cita = new CitaEntity(1L, 1L, "2026-09-10", "10:00 AM", "Consulta General", "PENDIENTE");
                    AppDatabase.getDatabase(this).citaDao().insertar(cita);
                    Toast.makeText(this, "Cita agendada y guardada en Room con éxito", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "Error al agendar cita: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        configurarNavegacion();
    }

    private void abrir(Class<?> destino) {
        if (destino != null && !getClass().equals(destino)) {
            startActivity(new Intent(this, destino));
        }
    }

    private void configurarNavegacion() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_citas);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_inicio) {
                    abrir(AdminInicioActivity.class);
                    return true;
                } else if (id == R.id.nav_pacientes) {
                    abrir(PacientesActivity.class);
                    return true;
                } else if (id == R.id.nav_citas) {
                    return true;
                } else if (id == R.id.nav_factura) {
                    abrir(FacturaActivity.class);
                    return true;
                } else if (id == R.id.nav_personal) {
                    abrir(PersonalActivity.class);
                    return true;
                }
                return false;
            });
        }
    }
}