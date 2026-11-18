package com.nestorsalinas.centromedico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleConsulta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_consulta);

        TextView txt = findViewById(R.id.txtDetalle);
        String datos = getIntent().getStringExtra("datos_persona");
        if(datos == null) datos = getIntent().getStringExtra("datos_medico");
        if(txt != null && datos != null) {
            txt.setText(datos);
        }

        Button btnVolver = findViewById(R.id.btnVolverDetalle);
        if (btnVolver != null) {
            btnVolver.setOnClickListener(v -> finish());
        }
    }
}