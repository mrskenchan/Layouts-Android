package com.example.layout_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_main extends AppCompatActivity {

    private ImageButton btnSalchipapas, btnPastelChoclo, btnCazuela, btnCompartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        initViews();

        // Configurar los listeners
        setOnClickListeners();
    }

    private void initViews() {
        btnSalchipapas = findViewById(R.id.btn_salchipapas);
        btnPastelChoclo = findViewById(R.id.btn_pastel_choclo);
        btnCazuela = findViewById(R.id.btn_cazuela);
        btnCompartir = findViewById(R.id.btn_compartir);
    }

    private void setOnClickListeners() {
        btnSalchipapas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
