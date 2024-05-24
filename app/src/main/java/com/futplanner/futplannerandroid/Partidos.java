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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.futplanner.futplannerandroid.models.LogInModel;
import com.futplanner.futplannerandroid.models.Match;
import com.futplanner.futplannerandroid.models.TokenRequest;
import com.futplanner.futplannerandroid.models.User;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Partidos extends AppCompatActivity {

    private List<Match> matches;
    private ListView listView;
    private MatchAdapter matchAdapter;

    private TextView proximosPartidosTextView;
    private Button añadirPartidoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos);

        proximosPartidosTextView = findViewById(R.id.prox_partidos);
        añadirPartidoButton = findViewById(R.id.btn_añadir);
        listView = findViewById(R.id.partidos_list_view);


        //Fetch de partidos
        ObjectMapper om = new ObjectMapper();
        TokenRequest tokenData = new TokenRequest(MainActivity.user.getId(), MainActivity.user.getLast_token_key());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                String response = NetworkUtil.post(NetworkUtil.URL + "trainer/getMatches", om.writeValueAsString(tokenData));
                System.out.println(response);
                this.matches = om.readValue(response, new TypeReference<List<Match>>(){});
                for (Match m :
                        this.matches) {
                    System.out.println(m.getId());
                }
                runOnUiThread(() -> {
                    matchAdapter = new MatchAdapter(Partidos.this, this.matches);
                    listView.setAdapter(matchAdapter);
                });
            } catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(Partidos.this, "Error al obtener partidos", Toast.LENGTH_SHORT).show());
            }
        });
    }

}
