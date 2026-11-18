package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class AdminInicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_inicio);

        configurarAccesos();
        configurarRecyclerViewCitas();
        configurarNavegacion();
    }

    private void configurarAccesos() {
        View cardRegistrarPaciente = findViewById(R.id.cardRegistrarPaciente);
        View cardAgendarCita = findViewById(R.id.cardAgendarCita);
        View cardVerPacientes = findViewById(R.id.cardVerPacientes);
        View cardGenerarFactura = findViewById(R.id.cardGenerarFactura);

        if (cardRegistrarPaciente != null) {
            cardRegistrarPaciente.setOnClickListener(v -> abrir(RegistrarPacienteActivity.class));
        }

        if (cardAgendarCita != null) {
            cardAgendarCita.setOnClickListener(v -> abrir(AgendarCitaActivity.class));
        }

        if (cardVerPacientes != null) {
            cardVerPacientes.setOnClickListener(v -> abrir(PacientesActivity.class));
        }

        if (cardGenerarFactura != null) {
            cardGenerarFactura.setOnClickListener(v -> abrir(FacturaActivity.class));
        }
    }

    private void configurarRecyclerViewCitas() {
        RecyclerView rv = findViewById(R.id.rvProximasCitas);
        if (rv != null) {
            List<String> citas = new ArrayList<>();
            citas.add("Juan Pérez • Dra. Laura Gómez");
            citas.add("María López • Dr. Carlos Ruiz");
            rv.setAdapter(new CitaAdapter(citas));
        }
    }

    private void abrir(Class<?> destino) {
        if (destino != null && !getClass().equals(destino)) {
            startActivity(new Intent(this, destino));
        }
    }

    private void configurarNavegacion() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        if (bottomNav != null) {
            bottomNav.setSelectedItemId(R.id.nav_inicio);
            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();
                if (id == R.id.nav_inicio) {
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
                    abrir(PersonalActivity.class);
                    return true;
                }
                return false;
            });
        }
    }
}