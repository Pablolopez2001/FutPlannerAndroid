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

        // Configurar OnClickListener para el botón de Partidos
        botonIrAPartidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si el usuario ha iniciado sesión
                if (usuarioHaIniciadoSesion()) {
                    // Crear un Intent para iniciar la actividad Partidos
                    Intent intent = new Intent(MainActivity.this, Partidos.class);
                    // Iniciar la actividad Partidos
                    startActivity(intent);
                } else {
                    // Si el usuario no ha iniciado sesión, redirigir a la actividad de inicio de sesión
                    Intent intent = new Intent(MainActivity.this, InicioSesion.class);
                    startActivity(intent);
                }
            }
        });

        // Configurar OnClickListener para el botón de Sesiones
        botonIrASesiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Sesiones
                Intent intent = new Intent(MainActivity.this,Sesiones.class);
                // Iniciar la actividad Sesiones
                startActivity(intent);
            }
        });

        // Configurar OnClickListener para el botón de Evaluaciones
        botonIrAEvaluaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Evaluaciones
                Intent intent = new Intent(MainActivity.this, Evaluaciones.class);
                // Iniciar la actividad Evaluaciones
                startActivity(intent);
            }
        });

        // Configurar OnClickListener para el botón de Principal
        botonIrAPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Principal
                Intent intent = new Intent(MainActivity.this, Principal.class);
                // Iniciar la actividad Principal
                startActivity(intent);
            }
        });

        // Configurar OnClickListener para el botón de Equipo
        botonIrAEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para iniciar la actividad Equipo
                Intent intent = new Intent(MainActivity.this, Equipo.class);
                // Iniciar la actividad Equipo
                startActivity(intent);
            }
        });

        // Configurar OnClickListener para el botón de Logout
        botonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar la actividad actual para salir
                finish();
            }
        });
    }

    // Método ficticio para verificar si el usuario ha iniciado sesión
    private boolean usuarioHaIniciadoSesion() {
        // Aquí puedes implementar la lógica para verificar si el usuario ha iniciado sesión correctamente
        // Por ahora, siempre se devuelve verdadero
        return true;
    }
}
