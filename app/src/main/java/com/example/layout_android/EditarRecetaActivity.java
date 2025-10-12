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

        // Llena opciones del spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.regiones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRegion.setAdapter(adapter);

        btnGuardar.setOnClickListener(v -> {
            guardarCambios();
            Intent inten = new Intent(EditarRecetaActivity.this, activity_main.class);
            inten.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(inten);
            finish();
        });

        if (recetaId != -1) {
            Receta receta = dbHelper.getRecetaById(recetaId);
            if (receta != null) { // verificar que exista la receta
                editNombre.setText(receta.getNombre());
                editPreparacion.setText(receta.getPreparacion());
                spinnerRegion.setSelection(receta.getIdRegion()-1); // IDs 1,2,3 para Norte, Centro, Sur
                idAutor = receta.getIdAutor();
            }
        }
    }

    private void guardarCambios() {
        String nuevoNombre = editNombre.getText().toString();
        String nuevaPreparacion = editPreparacion.getText().toString();
        int nuevaRegion = spinnerRegion.getSelectedItemPosition() + 1;
        dbHelper.actualizarFood(recetaId, nuevoNombre, nuevaPreparacion, "", idAutor, nuevaRegion);
    }
}

