package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText edtUsuario, edtPassword;
    private Button btnLogin;
    private TextView txtError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_login);

            edtUsuario = findViewById(R.id.edtUsuario);
            edtPassword = findViewById(R.id.edtPassword);
            btnLogin = findViewById(R.id.btnLogin);
            txtError = findViewById(R.id.txtError);

            View cardMedico = findViewById(R.id.cardRolMedico);
            View cardEnfermero = findViewById(R.id.cardRolEnfermero);
            View cardAdmin = findViewById(R.id.cardRolAdmin);


            if (btnLogin != null) {
                btnLogin.setOnClickListener(v -> realizarLogin());
            }


            if (cardMedico != null) {
                cardMedico.setOnClickListener(v -> {
                    if (edtUsuario != null) edtUsuario.setText("laura.gomez@mavata.test");
                    if (edtPassword != null) edtPassword.setText("medico1-2026");
                    if (txtError != null) txtError.setText("");
                    Toast.makeText(this, "Credenciales de Médico cargadas", Toast.LENGTH_SHORT).show();
                });
            }

            if (cardEnfermero != null) {
                cardEnfermero.setOnClickListener(v -> {
                    if (edtUsuario != null) edtUsuario.setText("sofia.munoz@mavata.test");
                    if (edtPassword != null) edtPassword.setText("enfermero1-2026");
                    if (txtError != null) txtError.setText("");
                    Toast.makeText(this, "Credenciales de Enfermero cargadas", Toast.LENGTH_SHORT).show();
                });
            }

            if (cardAdmin != null) {
                cardAdmin.setOnClickListener(v -> {
                    if (edtUsuario != null) edtUsuario.setText("superadmin@mavata.test");
                    if (edtPassword != null) edtPassword.setText("superadmin-2026");
                    if (txtError != null) txtError.setText("");
                    Toast.makeText(this, "Credenciales de Administrador cargadas", Toast.LENGTH_SHORT).show();
                });
            }
        } catch (Exception e) {
            Log.e("LoginFatal", "Error al iniciar Login", e);
        }
    }

    private void realizarLogin() {
        if (edtUsuario == null || edtPassword == null) return;

        String user = edtUsuario.getText().toString().trim();
        String pass = edtPassword.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            if (txtError != null) {
                txtError.setText("Por favor ingrese usuario y contraseña");
            }
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (txtError != null) {
            txtError.setText("");
        }

        try {
            Intent intent = null;

            if ((user.equalsIgnoreCase("laura.gomez@mavata.test") && pass.equals("medico1-2026")) ||
                (user.equalsIgnoreCase("andres.mosquera@mavata.test") && pass.equals("medico2-2026")) ||
                (user.equalsIgnoreCase("carmen.torres@mavata.test") && pass.equals("medico3-2026")) ||
                (user.equalsIgnoreCase("julian.herrera@mavata.test") && pass.equals("medico4-2026")) ||
                (user.equalsIgnoreCase("patricia.ruiz@mavata.test") && pass.equals("medico5-2026")) ||
                (user.equalsIgnoreCase("medico") && pass.equals("1234"))) {
                
                Toast.makeText(this, "¡Bienvenido Médico!", Toast.LENGTH_SHORT).show();
                intent = new Intent(Login.this, MedicoAgendaActivity.class);

            } else if ((user.equalsIgnoreCase("sofia.munoz@mavata.test") && pass.equals("enfermero1-2026")) ||
                       (user.equalsIgnoreCase("daniela.ordonez@mavata.test") && pass.equals("enfermero2-2026")) ||
                       (user.equalsIgnoreCase("valentina.quintero@mavata.test") && pass.equals("enfermero3-2026")) ||
                       (user.equalsIgnoreCase("ana.fajardo@mavata.test") && pass.equals("enfermero4-2026")) ||
                       (user.equalsIgnoreCase("camila.rojas@mavata.test") && pass.equals("enfermero5-2026")) ||
                       (user.equalsIgnoreCase("enfermero") && pass.equals("1234"))) {

                Toast.makeText(this, "¡Bienvenido Enfermero!", Toast.LENGTH_SHORT).show();
                intent = new Intent(Login.this, EnfermeroInicioActivity.class);

            } else if ((user.equalsIgnoreCase("superadmin@mavata.test") && pass.equals("superadmin-2026")) ||
                       (user.equalsIgnoreCase("recepcion@mavata.test") && pass.equals("recepcion1-2026")) ||
                       (user.equalsIgnoreCase("nestor") && pass.equals("0812")) ||
                       (user.equalsIgnoreCase("admin") && pass.equals("1234"))) {

                Toast.makeText(this, "¡Bienvenido Administrador!", Toast.LENGTH_SHORT).show();
                intent = new Intent(Login.this, AdminInicioActivity.class);

            } else {
                if (txtError != null) {
                    txtError.setText("Usuario o contraseña incorrectos");
                }
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                return;
            }

            if (intent != null) {
                startActivity(intent);
                finish();
            }

        } catch (Exception e) {
            Log.e("LoginError", "Error en proceso de login", e);
            Toast.makeText(this, "Error al iniciar sesión: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}