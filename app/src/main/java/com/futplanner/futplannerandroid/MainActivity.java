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
        Button botonIrAEvaluaciones = findViewById(R.id.evaluaciones);
        Button botonIrAPrincipal = findViewById(R.id.principal);
        Button botonIrAEquipo = findViewById(R.id.equipo);

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

        botonIrAEvaluaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Evaluaciones
                Intent intent = new Intent(MainActivity.this, Evaluaciones.class);

                // Iniciar la actividad Evaluaciones
                startActivity(intent);
            }
        });

        botonIrAPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Principal
                Intent intent = new Intent(MainActivity.this, Principal.class);

                // Iniciar la actividad Principal
                startActivity(intent);
            }
        });

        botonIrAEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Equipo
                Intent intent = new Intent(MainActivity.this, Equipo.class);

                // Iniciar la actividad Equipo
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