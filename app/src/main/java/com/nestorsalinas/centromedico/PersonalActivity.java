package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        ImageView btnBack = findViewById(R.id.btnBack);
        Button btnIrContratar = findViewById(R.id.btnIrAContratar);

        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        if (btnIrContratar != null) {
            btnIrContratar.setOnClickListener(v -> abrir(ContratarEmpleadoActivity.class));
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
            bottomNav.setSelectedItemId(R.id.nav_personal);
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
                    abrir(FacturaActivity.class);
                    return true;
                } else if (id == R.id.nav_personal) {
                    return true;
                }
                return false;
            });
        }
    }
}