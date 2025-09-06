package com.example.layout_android;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;

public class activity_resena extends AppCompatActivity {

    // Inputs
    private TextInputEditText nombre, correo, region, nombreReceta,
            ingredientes, etPreparacion;

    // Botones
    private Button btnEnviar, btnVolver, btnFoto;

    // ImageView para mostrar la foto
    private ImageView imageView;

    // Uri de la foto
    private Uri photoUri;

    // Launchers para cámara y permisos
    private ActivityResultLauncher<Uri> takePictureLauncher;
    private ActivityResultLauncher<String> requestPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resena);

        // Inicializar vistas
        initViews();

        // Configurar listeners de botones
        setOnClickListeners();

        // Inicializar cámara
        initCameraLaunchers();
    }

    private void initViews() {
        nombre = findViewById(R.id.nombre);
        correo = findViewById(R.id.correo);
        region = findViewById(R.id.region);
        nombreReceta = findViewById(R.id.nombre_receta);
        ingredientes = findViewById(R.id.ingredientes);
        etPreparacion = findViewById(R.id.et_preparacion);
        btnEnviar = findViewById(R.id.btn_enviar_receta);
        btnVolver = findViewById(R.id.btn_volver_formulario);
        btnFoto = findViewById(R.id.btn_Camara); // botón extra para la cámara
        imageView = findViewById(R.id.Fotografia); // donde se muestra la foto
    }

    private void setOnClickListeners() {
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarReceta();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Cierra esta activity
            }
        });

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarFoto();
            }
        });
    }

    private void initCameraLaunchers() {
        // Launcher para tomar foto
        takePictureLauncher = registerForActivityResult(
                new ActivityResultContracts.TakePicture(),
                new ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean success) {
                        if (success) {
                            imageView.setImageURI(photoUri);
                        }
                    }
                }
        );

        // Launcher para pedir permisos
        requestPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                new ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean isGranted) {
                        if (isGranted) {
                            abrirCamara();
                        } else {
                            Toast.makeText(activity_resena.this,
                                    "Permiso de cámara denegado", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void tomarFoto() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            abrirCamara();
        } else {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA);
        }
    }

    private void abrirCamara() {
        File foto = new File(getExternalFilesDir("Pictures"), "receta.jpg");
        photoUri = FileProvider.getUriForFile(this,
                getApplicationContext().getPackageName() + ".provider",
                foto);

        takePictureLauncher.launch(photoUri);
    }

    private void enviarReceta() {
        if (!validarCampos()) {
            return;
        }

        String nombreStr = nombre.getText().toString().trim();
        String nombreRecetaStr = nombreReceta.getText().toString().trim();

        Toast.makeText(this, "¡Gracias " + nombreStr + "! Tu receta '" +
                nombreRecetaStr + "' ha sido enviada exitosamente.", Toast.LENGTH_LONG).show();

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
        imageView.setImageURI(null); // limpia la foto
    }
}