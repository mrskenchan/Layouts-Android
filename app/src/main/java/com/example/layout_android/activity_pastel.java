package com.example.layout_android;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_pastel extends AppCompatActivity {

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastel);

        // Inicializar vistas
        initViews();

        // Configurar listeners
        setOnClickListeners();
    }

    private void initViews() {
        btnVolver = findViewById(R.id.btn_volver_pastel_choclo);
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