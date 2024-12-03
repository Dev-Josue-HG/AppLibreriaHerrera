package com.intecap.libreriaherrera;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText nameUserEntered;
    EditText passwordEntered;
    Button btnLogin;

    private PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        preferencesHelper = new PreferencesHelper(this);

        preferencesHelper.saveString("username", "Test");
        preferencesHelper.saveString("password", "123");

        nameUserEntered = findViewById(R.id.txtname);
        passwordEntered = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.BtnLogin);
        checkLoginSesion();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameEntered = nameUserEntered.getText().toString();
                String passEntered = passwordEntered.getText().toString();

                checkLogin(nameEntered,passEntered);
            }
        });

    }


    public void checkLogin(String name, String pass){
        String usuario = preferencesHelper.getString("username", "N/A");
        String password = preferencesHelper.getString("password", "N/A");

        if (name.equals(usuario) && pass.equals(password)) {
            preferencesHelper.saveBoolean("estaLogueado", true);
            openActivity();
        } else {
            Toast.makeText(this, "Usuario o contra", Toast.LENGTH_SHORT).show();
            preferencesHelper.saveBoolean("estaLogueado", false);
        }

    }

    public void checkLoginSesion(){
        boolean estaLogueado = preferencesHelper.getBoolean("estaLogueado",false);
        if(estaLogueado) {
            openActivity();
        }
    }

    public void openActivity(){
        Intent intento = new Intent(MainActivity.this, MainActivityLogin.class);
        startActivity(intento);
    }
}