package com.example.layout_android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class EditarRecetaActivity extends AppCompatActivity {

    private EditText editNombre, editPreparacion;
    private Spinner spinnerRegion;
    private Button btnGuardar;
    private DBHelper dbHelper;
    private int recetaId;
    private int idAutor; // Si tu modelo lo requiere

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_receta);

        editNombre = findViewById(R.id.editNombre);
        editPreparacion = findViewById(R.id.editPreparacion);
        spinnerRegion = findViewById(R.id.spinnerRegion);
        btnGuardar = findViewById(R.id.btnGuardar);

        dbHelper = new DBHelper(this);

        // Poblar datos
        Intent intent = getIntent();
        recetaId = intent.getIntExtra("id_receta", -1);

        if (recetaId != -1) {
            Receta receta = dbHelper.getRecetaById(recetaId); // este metodo necesitas crearlo si no existe
            editNombre.setText(receta.getNombre());
            editPreparacion.setText(receta.getPreparacion());
            // Puedes usar receta.getIdRegion() para setear el spinner
            spinnerRegion.setSelection(receta.getIdRegion()-1); // suponiendo IDs consecutivos
            idAutor = receta.getIdAutor();
        }

        // Llena opciones del spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.regiones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(adapter);

        btnGuardar.setOnClickListener(v -> {
            guardarCambios();
            finish();
        });
    }

    private void guardarCambios() {
        String nuevoNombre = editNombre.getText().toString();
        String nuevaPreparacion = editPreparacion.getText().toString();
        int nuevaRegion = spinnerRegion.getSelectedItemPosition() + 1; // Asegúrate del mapeo de IDs
        dbHelper.actualizarFood(recetaId, nuevoNombre, nuevaPreparacion, "", idAutor, nuevaRegion);
    }
}

