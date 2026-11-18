package com.nestorsalinas.centromedico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.entity.PacienteEntity;

public class RegistrarPacienteActivity extends AppCompatActivity {

    private EditText edtDni, edtNombre, edtContacto, edtHistoriaMedica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);

        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        edtDni = findViewById(R.id.edtDni);
        edtNombre = findViewById(R.id.edtNombre);
        edtContacto = findViewById(R.id.edtContacto);
        edtHistoriaMedica = findViewById(R.id.edtHistoriaMedica);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnCancelar = findViewById(R.id.btnCancelar);

        if (btnCancelar != null) {
            btnCancelar.setOnClickListener(v -> finish());
        }

        if (btnRegistrar != null) {
            btnRegistrar.setOnClickListener(v -> {
                String dni = edtDni != null ? edtDni.getText().toString().trim() : "";
                String nom = edtNombre != null ? edtNombre.getText().toString().trim() : "";
                String contacto = edtContacto != null ? edtContacto.getText().toString().trim() : "";
                String historia = edtHistoriaMedica != null ? edtHistoriaMedica.getText().toString().trim() : "I-C-2024-001";

                if (nom.isEmpty() || dni.isEmpty()) {
                    Toast.makeText(this, "Ingrese DNI y Nombre del paciente", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    PacienteEntity paciente = new PacienteEntity(dni, nom, "", contacto, historia);
                    AppDatabase.getDatabase(this).pacienteDao().insertar(paciente);
                    Toast.makeText(this, "Paciente " + nom + " guardado en la base de datos (Room)", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "Error al guardar paciente: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}