package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.futplanner.futplannerandroid.models.Team;
import com.futplanner.futplannerandroid.models.TokenRequest;
import com.futplanner.futplannerandroid.models.User;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    //Singleton del usuario ya cargado
    public static User user;
    private Team team;

    private ListView view;

    private TextView equipo;
    private TextView club;

    private EvaluacionesAdapter mainActivityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        club = findViewById(R.id.club);
        equipo = findViewById(R.id.Nombre_equipo);

        // Obtener referencia a los botones
        Button botonIrAPartidos = findViewById(R.id.partidos);
        Button botonIrASesiones = findViewById(R.id.sesiones);
        Button botonLogout = findViewById(R.id.logout);
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

        //Fetch de team
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        TokenRequest tokenData = new TokenRequest(user.getId(), user.getLast_token_key());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                String response = NetworkUtil.post(NetworkUtil.URL + "trainer/getTeam", om.writeValueAsString(tokenData));

                this.team = om.readValue(response, new TypeReference<Team>(){});

                equipo.setText(team.getTeamName());
                club.setText(team.getClub().getClubName());

            } catch (IOException e) {
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Error al obtener el equipo", Toast.LENGTH_SHORT).show());
            }
        });
    }

    private boolean usuarioHaIniciadoSesion() {
        return true;
    }
}