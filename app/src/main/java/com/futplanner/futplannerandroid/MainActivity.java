package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.futplanner.futplannerandroid.models.User;

public class MainActivity extends AppCompatActivity {
    //Singleton del usuario ya cargado
    public static User user;
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
                Intent intent = new Intent(MainActivity.this,Evaluaciones.class);
                // Iniciar la actividad Sesiones
                startActivity(intent);
            }
        });
        // Configurar OnClickListener para el botón de Logout
        botonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InicioSesion.class);

                startActivity(intent);

                finish();
            }
        });
    }

    private boolean usuarioHaIniciadoSesion() {
        return true;
    }
}