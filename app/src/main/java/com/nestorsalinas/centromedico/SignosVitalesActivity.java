package com.nestorsalinas.centromedico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.entity.SignosVitalesEntity;

public class SignosVitalesActivity extends AppCompatActivity {

    private EditText edtPresion, edtTemperatura, edtFrecuencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signos_vitales);

        edtPresion = findViewById(R.id.edtPresion);
        edtTemperatura = findViewById(R.id.edtTemperatura);
        edtFrecuencia = findViewById(R.id.edtFrecuencia);

        Button btnGuardar = findViewById(R.id.btnGuardarSignos);
        Button btnCancelar = findViewById(R.id.btnCancelarSignos);

        if (btnCancelar != null) {
            btnCancelar.setOnClickListener(v -> finish());
        }

        if (btnGuardar != null) {
            btnGuardar.setOnClickListener(v -> {
                String presion = edtPresion != null ? edtPresion.getText().toString().trim() : "";
                String temp = edtTemperatura != null ? edtTemperatura.getText().toString().trim() : "";
                String freq = edtFrecuencia != null ? edtFrecuencia.getText().toString().trim() : "";

                if (presion.isEmpty() || temp.isEmpty() || freq.isEmpty()) {
                    Toast.makeText(this, "Por favor complete todos los campos de signos vitales", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    SignosVitalesEntity signos = new SignosVitalesEntity(1L, 1L, presion, temp, freq, "2026-09-10");
                    AppDatabase.getDatabase(this).signosDao().insertar(signos);
                    Toast.makeText(this, "Signos vitales guardados en Room con éxito", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "Error al guardar signos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}