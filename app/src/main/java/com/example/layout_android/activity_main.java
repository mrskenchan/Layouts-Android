package com.example.layout_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_main extends AppCompatActivity {

    //se declaran los campos para referenciar los botones
    private ImageButton btnSalchipapas, btnPastelChoclo, btnCazuela, btnCompartir;

    @Override
    //se crea la actividad
    protected void onCreate(Bundle savedInstanceState) {
        //se implementa la clase padre obligatoriamente
        super.onCreate(savedInstanceState);
        //muestra el archivo main
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        initViews();

        // Configurar los listeners
        setOnClickListeners();
    }

    //inicia las vistas, las busca por id y debuelve la vista correspondiente
    private void initViews() {
        btnSalchipapas = findViewById(R.id.btn_salchipapas);
        btnPastelChoclo = findViewById(R.id.btn_pastel_choclo);
        btnCazuela = findViewById(R.id.btn_cazuela);
        btnCompartir = findViewById(R.id.btn_compartir);
    }

    //agrupa la informacion de las funcionalidades de los botones
    private void setOnClickListeners() {
        //se le da la funcionalidad, en este caso te manda a una view o vista
        btnSalchipapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instancias un intent para navegar entre ambas activity
                Intent intent = new Intent(activity_main.this, activity_salchi.class);
                startActivity(intent);
            }
        });

        btnPastelChoclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main.this, activity_pastel.class);
                startActivity(intent);
            }
        });

        btnCazuela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main.this, activity_cazuela.class);
                startActivity(intent);
            }
        });

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main.this, activity_resena.class);
                startActivity(intent);
            }
        });
    }
}
