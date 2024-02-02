package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencia a los botones
        Button botonIrAPartidos = findViewById(R.id.partidos);
        Button botonIrASesiones = findViewById(R.id.sesiones);
        Button botonLogout = findViewById(R.id.logout);

        // Configurar OnClickListener para el botón
        botonIrAPartidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Partidos
                Intent intent = new Intent(MainActivity.this, Partidos.class);

                // Iniciar la actividad Partidos
                startActivity(intent);
            }
        });
        botonIrASesiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Partidos
                Intent intent = new Intent(MainActivity.this,Sesiones.class);

                // Iniciar la actividad Sesiones
                startActivity(intent);
            }
        });
        botonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar la actividad actual para salir
                finish();
            }
        });

    }

}