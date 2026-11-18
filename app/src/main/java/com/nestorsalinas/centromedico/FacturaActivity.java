package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.entity.FacturaEntity;

public class FacturaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        Button btnCancelar = findViewById(R.id.btnCancelarFactura);
        Button btnEmitir = findViewById(R.id.btnEmitir);

        if (btnCancelar != null) {
            btnCancelar.setOnClickListener(v -> finish());
        }

        if (btnEmitir != null) {
            btnEmitir.setOnClickListener(v -> {
                try {
                    int count = AppDatabase.getDatabase(this).facturaDao().contarFacturas();
                    String numFactura = "F-2026-" + String.format("%04d", count + 1);
                    FacturaEntity factura = new FacturaEntity(1L, numFactura, 100000.0, "2026-09-10");
                    AppDatabase.getDatabase(this).facturaDao().insertar(factura);
                    Toast.makeText(this, "Factura " + numFactura + " emitida y guardada en Room", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "Error al emitir factura: " + e.getMessage(), Toast.LENGTH_SHORT).show();
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
            bottomNav.setSelectedItemId(R.id.nav_factura);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_inicio) {
                    abrir(AdminInicioActivity.class);
                    return true;
                } else if (id == R.id.nav_pacientes) {
                    abrir(PacientesActivity.class);
                    return true;
                } else if (id == R.id.nav_citas) {
                    abrir(AgendarCitaActivity.class);
                    return true;
                } else if (id == R.id.nav_factura) {
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