package com.nestorsalinas.centromedico;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MedicoAgendaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medico_agenda);

        RecyclerView rv = findViewById(R.id.rvAgendaMedico);
        if (rv != null) {
            List<String> agenda = new ArrayList<>();
            agenda.add("Ana Gómez • 09:00 - Control general");
            agenda.add("Luis Torres • 10:30 - Primera vez");
            rv.setAdapter(new CitaAdapter(agenda));
        }
    }
}