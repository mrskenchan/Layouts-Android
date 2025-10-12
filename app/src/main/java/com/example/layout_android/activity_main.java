package com.example.layout_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.net.Uri;

public class activity_main extends AppCompatActivity {

    //se declaran los campos para referenciar los botones
    private ImageButton btnNorte, btnCentro, btnSur, btnCompartir;

    private ImageButton btnInstagram, btnFacebook, btnYoutube;

    private Button btnVerRecetas;

    @Override
    //se crea la actividad
    protected void onCreate(Bundle savedInstanceState) {
        //se implementa la clase padre obligatoriamente
        super.onCreate(savedInstanceState);

        //muestra el archivo main conecta ambos archivos
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        initViews();

        // Configurar los listeners
        setOnClickListeners();
    }

    //busca los botones por id y los guarda
    private void initViews() {
        btnNorte = findViewById(R.id.btn_norte);
        btnCentro = findViewById(R.id.btn_centro);
        btnSur = findViewById(R.id.btn_sur);
        btnCompartir = findViewById(R.id.btn_compartir);
        btnVerRecetas = findViewById(R.id.btn_ver_recetas);

        btnInstagram = findViewById(R.id.btn_instagram);
        btnFacebook = findViewById(R.id.btn_facebook);
        btnYoutube = findViewById(R.id.btn_youtube);
    }

    //agrupa la informacion de las funcionalidades o actividades de los botones
    private void setOnClickListeners() {
        //se le da la funcionalidad, en este caso te manda a una view o vista
        btnNorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instancias un intent para navegar entre ambas activity
                Intent intent = new Intent(activity_main.this, ListaRecetasActivity.class);
                intent.putExtra("id_region",1);
                startActivity(intent);
            }
        });

        btnCentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main.this, ListaRecetasActivity.class);
                intent.putExtra("id_region",2); //centro
                startActivity(intent);
            }
        });

        btnSur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_main.this, ListaRecetasActivity.class);
                intent.putExtra("id_region",3); //sur
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

        btnVerRecetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a ListaRecetasActivity
                Intent intent = new Intent(activity_main.this, ListaRecetasActivity.class);
                startActivity(intent);
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com"));
                startActivity(intent);
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                startActivity(intent);
            }
        });

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/APm2xGg-RjQ"));
                startActivity(intent);
            }
        });

    }
}
