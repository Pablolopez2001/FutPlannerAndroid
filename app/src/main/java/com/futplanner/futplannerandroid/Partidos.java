package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;

public class Partidos extends AppCompatActivity {

    private TextView proximosPartidosTextView;
    private Button añadirPartidoButton;
    private Button completadosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos);

        proximosPartidosTextView = findViewById(R.id.prox_partidos);
        añadirPartidoButton = findViewById(R.id.btn_añadir);
        completadosButton = findViewById(R.id.btn_completados);

        // Configurar onClickListener para el botón de añadir partido
        añadirPartidoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes abrir una nueva actividad para agregar un nuevo partido
                Toast.makeText(Partidos.this, "Añadir partido", Toast.LENGTH_SHORT).show();
            }
        });

        // Configurar onClickListener para el botón de partidos completados
        completadosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes abrir una nueva actividad para mostrar los partidos completados
                Toast.makeText(Partidos.this, "Partidos completados", Toast.LENGTH_SHORT).show();
            }
        });

        // Llamar al método para obtener y mostrar los próximos partidos
        obtenerProximosPartidos();
    }

    private void obtenerProximosPartidos() {
        // Realizar una solicitud a la API para obtener los próximos partidos
        String url = "http://46.4.74.141:8080/api/partidos/proximos";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Realizar una solicitud POST en lugar de GET utilizando NetworkUtil
            String jsonResponse = NetworkUtil.post(url, "");

            // Convertir la respuesta JSON en un objeto Java utilizando Jackson ObjectMapper
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            // Verificar si la respuesta contiene datos de partidos
            if (jsonNode.isArray()) {
                StringBuilder partidosText = new StringBuilder();

                // Iterar sobre los elementos del array de partidos
                for (JsonNode partidoNode : jsonNode) {
                    String equipoLocal = partidoNode.get("equipoLocal").asText();
                    String equipoVisitante = partidoNode.get("equipoVisitante").asText();
                    String fecha = partidoNode.get("fecha").asText();

                    // Construir la representación de texto del partido
                    String partidoText = "Equipo Local: " + equipoLocal + "\n"
                            + "Equipo Visitante: " + equipoVisitante + "\n"
                            + "Fecha: " + fecha + "\n\n";

                    // Agregar el partido a la cadena de texto
                    partidosText.append(partidoText);
                }

                // Mostrar la información de los partidos en el TextView
                proximosPartidosTextView.setText(partidosText.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al obtener los próximos partidos", Toast.LENGTH_SHORT).show();
        }
    }
}
