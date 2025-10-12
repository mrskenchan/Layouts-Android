package com.example.layout_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleRecetaActivity extends AppCompatActivity {

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);

        // Inicializar vistas
        initViews();

        // Configurar listeners
        setOnClickListeners();

        ImageView imagen = findViewById(R.id.imagenDetalleReceta);
        TextView nombre = findViewById(R.id.nombreDetalleReceta);
        TextView preparacion = findViewById(R.id.preparacionDetalleReceta);

        String nombreReceta = getIntent().getStringExtra("nombre");
        String preparacionReceta = getIntent().getStringExtra("preparacion");
        String fotoRuta = getIntent().getStringExtra("fotoRuta");

        nombre.setText(nombreReceta);
        preparacion.setText(preparacionReceta);
        if (fotoRuta != null && !fotoRuta.isEmpty()) {
            imagen.setImageURI(Uri.parse(fotoRuta));
        } else {
            imagen.setImageResource(R.mipmap.ic_launcher);
        }


    }
    private void initViews() {
        btnVolver = findViewById(R.id.btn_volver_detalle_receta);
    }

    private void setOnClickListeners() {
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta activity y vuelve a MainActivity
            }
        });
    }
}
