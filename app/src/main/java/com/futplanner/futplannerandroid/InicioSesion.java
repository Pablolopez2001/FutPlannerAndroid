package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futplanner.futplannerandroid.models.LogInModel;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;

public class InicioSesion extends AppCompatActivity {

    EditText username;
    EditText password;
    Button goButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        goButton = findViewById(R.id.login_btn);
        username = findViewById(R.id.login_usuario);
        password = findViewById(R.id.login_password);

        goButton.setOnClickListener(v -> {
            Intent intent = new Intent(InicioSesion.this, MainActivity.class);
            String user = username.getText().toString();
            String pass = password.getText().toString();
            LogInModel login = new LogInModel(user, pass);
            ObjectMapper om = new ObjectMapper();

            try {
                String response = NetworkUtil.post(NetworkUtil.URL + "logIn", om.writeValueAsString(login));
                System.out.println(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            startActivity(intent);
        });
    }
}