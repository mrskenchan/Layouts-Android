package com.example.layout_android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_recetas);

        recyclerView = findViewById(R.id.recetasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new DBHelper(this);
        listaRecetas = obtenerRecetas();

        adapter = new RecetasAdapter(listaRecetas);
        recyclerView.setAdapter(adapter);
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
}
