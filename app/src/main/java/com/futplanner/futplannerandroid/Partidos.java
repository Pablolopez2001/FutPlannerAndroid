package com.futplanner.futplannerandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Partidos extends AppCompatActivity {

    private Button btnCompletados;
    private PopupWindow popupWindow;
    private ListView listView;
    private String[] elementosLista = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partidos);

        btnCompletados = findViewById(R.id.btn_completados);

        // Configurar el onClickListener para el botón
        btnCompletados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarListaDesplegable();
            }
        });
    }

    private void mostrarListaDesplegable() {
        // Inflar la vista del layout de la lista desplegable
        View view = getLayoutInflater().inflate(R.layout.layout_lista_desplegable, null);

        // Configurar la lista desplegable
        listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elementosLista);
        listView.setAdapter(adapter);

        // Configurar el evento de clic en los elementos de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Acción a realizar cuando se hace clic en un elemento de la lista
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(Partidos.this, "Seleccionado: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
        // Crear la ventana emergente (popup window)
        popupWindow = new PopupWindow(view, btnCompletados.getWidth(), 400, true);
        popupWindow.showAsDropDown(btnCompletados, 0, 0);
    }
}