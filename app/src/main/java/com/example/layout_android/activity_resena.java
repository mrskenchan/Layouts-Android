package com.example.layout_android;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

public class activity_resena extends AppCompatActivity {

    //declara los campos que referencia a los input
    private TextInputEditText nombre, correo, region, nombreReceta,
            ingredientes, etPreparacion;
    //declara los campos que referencian a los botones
    private Button btnEnviar, btnVolver;

    @Override
    //se crea la actividad
    protected void onCreate(Bundle savedInstanceState) {
        //se implementa la clase padre obligatoriamente
        super.onCreate(savedInstanceState);
        //vincula ambos archivos en el layout con el de java (este)
        setContentView(R.layout.activity_resena);

        // Inicializar vistas
        initViews();

        // Configurar listeners
        setOnClickListeners();
    }

    //busca los input y los botones por id y los guarda
    private void initViews() {
        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correo);
        region = findViewById(R.id.region);
        nombreReceta = findViewById(R.id.nombre_receta);
        ingredientes = findViewById(R.id.ingredientes);
        etPreparacion = findViewById(R.id.et_preparacion);
        btnEnviar = findViewById(R.id.btn_enviar_receta);
        btnVolver = findViewById(R.id.btn_volver_formulario);
    }

    //agrupa la informacion  de las fincionalidades o actividades de los botones
    private void setOnClickListeners() {
        //se le da la funcionalidad
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarReceta();
            }
        });

        //se le da la funcionalidad
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta activity y vuelve a MainActivity
            }
        });
    }

    //agrupa lo que
    private void enviarReceta() {
        // Validar campos obligatorios
        if (!validarCampos()) {
            return;
        }

        // Obtener los datos del formulario
        String nombreStr = nombre.getText().toString().trim();
        String correoStr = correo.getText().toString().trim();
        String regionStr = region.getText().toString().trim();
        String nombreRecetaStr = nombreReceta.getText().toString().trim();
        String ingredientesStr = ingredientes.getText().toString().trim();
        String preparacionStr = etPreparacion.getText().toString().trim();

        // Aquí normalmente enviarías los datos a un servidor
        // Por ahora, solo mostramos un mensaje de confirmación

        Toast.makeText(this, "¡Gracias " + nombreStr + "! Tu receta '" + nombreRecetaStr +
                "' ha sido enviada exitosamente.", Toast.LENGTH_LONG).show();

        // Limpiar el formulario
        limpiarFormulario();
    }

    private boolean validarCampos() {
        String nombreStr = nombre.getText().toString().trim();
        String correoStr = correo.getText().toString().trim();
        String regionStr = region.getText().toString().trim();
        String nombreRecetaStr = nombreReceta.getText().toString().trim();
        String ingredientesStr = ingredientes.getText().toString().trim();
        String preparacionStr = etPreparacion.getText().toString().trim();

        if (nombreStr.isEmpty()) {
            nombre.setError("Por favor ingresa tu nombre");
            nombre.requestFocus();
            return false;
        }

        if (correoStr.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(correoStr).matches()) {
            correo.setError("Por favor ingresa un email válido");
            correo.requestFocus();
            return false;
        }

        if (regionStr.isEmpty()) {
            region.setError("Por favor ingresa tu región");
            region.requestFocus();
            return false;
        }

        if (nombreRecetaStr.isEmpty()) {
            nombreReceta.setError("Por favor ingresa el nombre de la receta");
            nombreReceta.requestFocus();
            return false;
        }

        if (ingredientesStr.isEmpty()) {
            ingredientes.setError("Por favor ingresa los ingredientes");
            ingredientes.requestFocus();
            return false;
        }

        if (preparacionStr.isEmpty()) {
            etPreparacion.setError("Por favor ingresa la preparación");
            etPreparacion.requestFocus();
            return false;
        }

        return true;
    }

    private void limpiarFormulario() {
        nombre.setText("");
        correo.setText("");
        region.setText("");
        nombreReceta.setText("");
        ingredientes.setText("");
        etPreparacion.setText("");
    }
}
