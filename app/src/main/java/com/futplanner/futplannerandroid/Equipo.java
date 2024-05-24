package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futplanner.futplannerandroid.models.NewMatch;
import com.futplanner.futplannerandroid.models.User;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Equipo extends AppCompatActivity {

    private CalendarView calendar;
    private EditText inputLugar;
    private EditText inputEquipoVisitante;
    private Button btnGuardarPartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        calendar = findViewById(R.id.calendario);
        inputLugar = findViewById(R.id.inputLugar);
        inputEquipoVisitante = findViewById(R.id.inputEquipoVisitante);
        btnGuardarPartido = findViewById(R.id.btnGuardarPartido);

        btnGuardarPartido.setOnClickListener(v ->{
            guardarPartido();
        });
    }

    private void guardarPartido() {
        long fecha = calendar.getDate();
        String lugar = inputLugar.getText().toString();
        String equipoVisitante = inputEquipoVisitante.getText().toString();

        NewMatch nm = new NewMatch();
        nm.setUserId(MainActivity.user.getId());
        nm.setToken(MainActivity.user.getLast_token_key());
        nm.setMatchDate(fecha); // Establecer la fecha actual
        nm.setMapCoords("43.3607563,-5.8702884");
        nm.setPlaceName(lugar);
        nm.setHomeTeamId(2);
        nm.setHomeTeamName("Lopecines");
        nm.setAwayTeamId(null);
        nm.setAwayTeamName(equipoVisitante);
        nm.setSubCategoryId(5);

        ObjectMapper om = new ObjectMapper();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                String response = NetworkUtil.post(NetworkUtil.URL + "trainer/insertMatch", om.writeValueAsString(nm));
                System.out.println(response);

                runOnUiThread(this::finish);
            } catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(Equipo.this, "Error al insertar equipo", Toast.LENGTH_SHORT).show());
            }
        });
    }
}