package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.futplanner.futplannerandroid.models.Match;
import com.futplanner.futplannerandroid.models.Player;
import com.futplanner.futplannerandroid.models.Team;
import com.futplanner.futplannerandroid.models.TokenRequest;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Evaluaciones extends AppCompatActivity {
    private List<Player> players;
    private ListView listView;
    private EvaluacionesAdapter evaluacionesAdapter;
    private Team team;
    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluaciones);



        listView = findViewById(R.id.listview_jugador);

        //Fetch de team
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        TokenRequest tokenData = new TokenRequest(MainActivity.user.getId(), MainActivity.user.getLast_token_key());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                String response = NetworkUtil.post(NetworkUtil.URL + "trainer/getTeam", om.writeValueAsString(tokenData));

                this.team = om.readValue(response, new TypeReference<Team>(){});

                this.players = team.getPlayers();


                runOnUiThread(() -> {
                    evaluacionesAdapter = new EvaluacionesAdapter(Evaluaciones.this, this.players);
                    listView.setAdapter(evaluacionesAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Player selPlayer = players.get(position);
                            Intent intent = new Intent(Evaluaciones.this,Sesiones.class);

                            intent.putExtra("player", (Serializable) selPlayer);

                            startActivity(intent);
                        }
                    });
                });


            } catch (IOException e) {
                runOnUiThread(() -> Toast.makeText(Evaluaciones.this, "Error al obtener los jugadores del equipo", Toast.LENGTH_SHORT).show());
            }
        });
    }
}