package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.futplanner.futplannerandroid.models.Player;
import com.futplanner.futplannerandroid.models.Report;
import com.futplanner.futplannerandroid.models.ReportRequest;
import com.futplanner.futplannerandroid.models.Team;
import com.futplanner.futplannerandroid.models.TokenRequest;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sesiones extends AppCompatActivity {

    private TextView nombre;
    private TextView apellidos;
    private TextView posicion;
    private Player player;
    private ListView list;
    private List<Report> reports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesiones);

        this.player = getIntent().getSerializableExtra("player", Player.class);

        this.nombre = findViewById(R.id.nombre);
        this.apellidos = findViewById(R.id.apellidos);
        this.posicion = findViewById(R.id.posicion);

        this.nombre.setText(this.player.getFirstName());
        this.apellidos.setText(this.player.getLastName());
        this.posicion.setText(this.player.getPosition());

        this.list = findViewById(R.id.listview_estadisticas);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        ReportRequest tokenData = new ReportRequest(MainActivity.user.getId(), MainActivity.user.getLast_token_key(), this.player.getId());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                String response = NetworkUtil.post(NetworkUtil.URL + "trainer/getPlayerReports", om.writeValueAsString(tokenData));

                this.reports = om.readValue(response, new TypeReference<List<Report>>(){});

                runOnUiThread(() -> {
                    ReportesAdapter adapter = new ReportesAdapter(Sesiones.this, this.reports);
                    list.setAdapter(adapter);
                });


            } catch (IOException e) {
                runOnUiThread(() -> {
                    e.printStackTrace();
                    Toast.makeText(Sesiones.this, "Error al obtener los jugadores del equipo", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}