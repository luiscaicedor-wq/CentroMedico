package com.nestorsalinas.centromedico.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SesionManager {
    private static final String PREF_NAME = "CentroMedicoSesion";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_ROL = "rol";
    private static final String KEY_NOMBRE = "nombre";

    private final SharedPreferences prefs;

    public SesionManager(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void guardarSesion(long userId, String rol, String nombre) {
        prefs.edit()
                .putLong(KEY_USER_ID, userId)
                .putString(KEY_ROL, rol)
                .putString(KEY_NOMBRE, nombre)
                .apply();
    }

    public void cerrarSesion() {
        prefs.edit().clear().apply();
    }

    public long getUserId() {
        return prefs.getLong(KEY_USER_ID, -1);
    }

    public String getRol() {
        return prefs.getString(KEY_ROL, "");
    }

    public String getNombre() {
        return prefs.getString(KEY_NOMBRE, "");
    }
}