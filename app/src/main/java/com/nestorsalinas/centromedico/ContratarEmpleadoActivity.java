package com.nestorsalinas.centromedico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.nestorsalinas.centromedico.data.local.AppDatabase;
import com.nestorsalinas.centromedico.data.local.entity.EmpleadoEntity;

public class ContratarEmpleadoActivity extends AppCompatActivity {

    private EditText edtNombres, edtApellidos, edtIdEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratar_empleado);

        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        edtNombres = findViewById(R.id.edtNombres);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtIdEmpleado = findViewById(R.id.edtIdEmpleado);

        Button btnContratar = findViewById(R.id.btnContratar);

        if (btnContratar != null) {
            btnContratar.setOnClickListener(v -> {
                String nom = edtNombres != null ? edtNombres.getText().toString().trim() : "";
                String ape = edtApellidos != null ? edtApellidos.getText().toString().trim() : "";
                String idEmp = edtIdEmpleado != null ? edtIdEmpleado.getText().toString().trim() : "EMP-999";

                if (nom.isEmpty() || ape.isEmpty()) {
                    Toast.makeText(this, "Ingrese nombres y apellidos", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    EmpleadoEntity empleado = new EmpleadoEntity(idEmp, nom.toLowerCase() + "@mavata.test", "1234", "Administrativo", nom, ape);
                    AppDatabase.getDatabase(this).empleadoDao().insertar(empleado);
                    Toast.makeText(this, "Empleado " + nom + " " + ape + " guardado en la base de datos (Room)", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (Exception e) {
                    Toast.makeText(this, "Error al guardar empleado: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}