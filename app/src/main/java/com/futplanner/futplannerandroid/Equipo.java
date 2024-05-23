package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futplanner.futplannerandroid.util.NetworkUtil;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Equipo extends AppCompatActivity {

    private EditText inputFecha;
    private EditText inputHora;
    private EditText inputLugar;
    private EditText inputEquipoVisitante;
    private Button btnGuardarPartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);

        inputFecha = findViewById(R.id.inputFecha);
        inputHora = findViewById(R.id.inputHora);
        inputLugar = findViewById(R.id.inputLugar);
        inputEquipoVisitante = findViewById(R.id.inputEquipoVisitante);
        btnGuardarPartido = findViewById(R.id.btnGuardarPartido);

        btnGuardarPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPartido();
            }
        });
    }

    private void guardarPartido() {
        String fecha = inputFecha.getText().toString();
        String hora = inputHora.getText().toString();
        String lugar = inputLugar.getText().toString();
        String equipoVisitante = inputEquipoVisitante.getText().toString();

        PartidoModel nuevoPartido = new PartidoModel(fecha, hora, lugar, equipoVisitante);
        ObjectMapper objectMapper = new ObjectMapper();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                String jsonBody = objectMapper.writeValueAsString(nuevoPartido);
                String response = NetworkUtil.post(NetworkUtil.URL + "partidos", jsonBody);

                runOnUiThread(() -> {
                    Toast.makeText(Equipo.this, "Partido guardado exitosamente", Toast.LENGTH_SHORT).show();
                    finish(); // Finaliza la actividad después de guardar el partido
                });
            } catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(Equipo.this, "Error al guardar el partido", Toast.LENGTH_SHORT).show());
            }
        });
    }
}