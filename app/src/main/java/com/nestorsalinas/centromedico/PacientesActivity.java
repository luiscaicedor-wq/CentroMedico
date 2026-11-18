package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PacientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacientes);

        Button btnAgendar = findViewById(R.id.btnAgendarCitaTop);
        Button btnFacturar = findViewById(R.id.btnFacturarTop);
        FloatingActionButton fabAgregar = findViewById(R.id.btnAgregarPacienteFAB);

        if (btnAgendar != null) {
            btnAgendar.setOnClickListener(v -> abrir(AgendarCitaActivity.class));
        }

        if (btnFacturar != null) {
            btnFacturar.setOnClickListener(v -> abrir(FacturaActivity.class));
        }

        if (fabAgregar != null) {
            fabAgregar.setOnClickListener(v -> abrir(RegistrarPacienteActivity.class));
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
            bottomNav.setSelectedItemId(R.id.nav_pacientes);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_inicio) {
                    abrir(AdminInicioActivity.class);
                    return true;
                } else if (id == R.id.nav_pacientes) {
                    return true;
                } else if (id == R.id.nav_citas) {
                    abrir(AgendarCitaActivity.class);
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