package com.nestorsalinas.centromedico;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EnfermeroInicioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfermero_inicio);

        RecyclerView rv = findViewById(R.id.rvPacientesEnfermero);
        if (rv != null) {
            List<String> pacientesTurno = new ArrayList<>();
            pacientesTurno.add("Ana Gómez (DNI: 0988776655)");
            pacientesTurno.add("Pedro Morales (DNI: 0988776644)");
            rv.setAdapter(new PacienteTurnoAdapter(pacientesTurno));
        }
    }
}