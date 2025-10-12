package com.example.layout_android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.layout_android.Contratos.FoodContract;
import com.example.layout_android.adapters.RecetasAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaRecetasActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecetasAdapter adapter;
    private List<Receta> listaRecetas;
    private DBHelper dbHelper;
    private Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        recyclerView = findViewById(R.id.recetasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dbHelper = new DBHelper(this);

        int idRegion = getIntent().getIntExtra("id_region",-1);

        if (idRegion != -1){
            listaRecetas = obtenerRecetasPorRegion(idRegion);
        } else {
            listaRecetas = obtenerRecetas();
        }

        adapter = new RecetasAdapter(listaRecetas, new RecetasAdapter.OnRecetaActionListener(){
            @Override
            public void onEditar(Receta receta, int position){
                //logica editar
            }

            @Override
            public void onEliminar(Receta receta, int position){
                new AlertDialog.Builder(ListaRecetasActivity.this)
                        .setTitle("Eliminar receta")
                        .setMessage("¿Deseas eliminar esta receta?")
                        .setPositiveButton("Eliminar", (dialog, which) -> {
                            dbHelper.eliminarFood(receta.getId());
                            listaRecetas.remove(position);
                            adapter.notifyItemRemoved(position);
                        })
                        .setNegativeButton("Cancelar",null)
                        .show();
            }
        });
        recyclerView.setAdapter(adapter);
        //Inicializar vistas
        initViews();

        //Configurar listener
        setOnClickListeners();
    }

    private void initViews() {btn_volver = findViewById(R.id.btn_volver_listado);}

    private void setOnClickListeners () {
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); //cierra el activity y lo devuelve al mainActivity
            }
        });
    }
    private List<Receta> obtenerRecetas(){
        List<Receta> recetas = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columnas = {
                FoodContract.FoodEntry.COLUMN_ID,
                FoodContract.FoodEntry.COLUMN_NAME,
                FoodContract.FoodEntry.COLUMN_PREPARACION,
                FoodContract.FoodEntry.COLUMN_RUTA,
                FoodContract.FoodEntry.COLUMN_ID_AUTOR,
                FoodContract.FoodEntry.COLUMN_ID_REGION
        };

        Cursor cursor = db.query(
                FoodContract.FoodEntry.TABLE_NAME,
                columnas,
                null,null,null,null, null
        );

        while (cursor.moveToNext()){
            Receta receta = new Receta();
            receta.setId(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_NAME)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_PREPARACION)));
            receta.setFotoRuta(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_RUTA)));
            receta.setIdAutor(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID_AUTOR)));
            receta.setIdRegion(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID_REGION)));
            recetas.add(receta);

        }
        cursor.close();

        return recetas;
    }

    private List<Receta> obtenerRecetasPorRegion(int idRegion){
        List<Receta> recetas = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] columnas = {
                FoodContract.FoodEntry.COLUMN_ID,
                FoodContract.FoodEntry.COLUMN_NAME,
                FoodContract.FoodEntry.COLUMN_PREPARACION,
                FoodContract.FoodEntry.COLUMN_RUTA,
                FoodContract.FoodEntry.COLUMN_ID_AUTOR,
                FoodContract.FoodEntry.COLUMN_ID_REGION
        };
        String selection = FoodContract.FoodEntry.COLUMN_ID_REGION + " = ?";
        String[] selectionArgs = { String.valueOf(idRegion)};

        Cursor cursor = db.query(
                FoodContract.FoodEntry.TABLE_NAME,
                columnas,
                selection,
                selectionArgs,
                null, null, null
        );

        while (cursor.moveToNext()) {
            Receta receta = new Receta();
            receta.setId(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_NAME)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_PREPARACION)));
            receta.setFotoRuta(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_RUTA)));
            receta.setIdAutor(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID_AUTOR)));
            receta.setIdRegion(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID_REGION)));
            recetas.add(receta);
        }
        cursor.close();
        return recetas;
    }
}
