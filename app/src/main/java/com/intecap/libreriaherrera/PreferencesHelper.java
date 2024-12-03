package com.intecap.libreriaherrera;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {

    private static final String PREF_NOMBRE = "Intecap";
    private final SharedPreferences sharedPreferences;

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NOMBRE, Context.MODE_PRIVATE);
    }

    public void saveString(String llave, String valor) {
        sharedPreferences.edit().putString(llave, valor).apply();
    }

    public String getString(String llave, String valorDefault) {
        return sharedPreferences.getString(llave, valorDefault);
    }

    public void saveBoolean(String llave, boolean valor) {
        sharedPreferences.edit().putBoolean(llave, valor).apply();
    }

    public Boolean getBoolean(String llave, boolean valorDefault) {
        return sharedPreferences.getBoolean(llave, valorDefault);
    }


    public void removeKey(String llave) {
        sharedPreferences.edit().remove(llave).apply();
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }


}
