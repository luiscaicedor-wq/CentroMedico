package com.nestorsalinas.centromedico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroMedicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medico);

        Button btnIngresar = findViewById(R.id.btnIngresar);
        Button btnCancelar = findViewById(R.id.btnCancelar);

        if (btnCancelar != null) {
            btnCancelar.setOnClickListener(v -> finish());
        }

        if (btnIngresar != null) {
            btnIngresar.setOnClickListener(v -> {
                Toast.makeText(this, "Médico registrado con éxito", Toast.LENGTH_SHORT).show();
                finish();
            });
        }
    }
}