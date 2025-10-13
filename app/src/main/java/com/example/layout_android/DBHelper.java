// Archivo: DBHelper.java
package com.example.layout_android;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.layout_android.Contratos.FoodContract;

public class DBHelper extends SQLiteOpenHelper { //DEFINICION DE LAS CLASES
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "FoodDatabase.db";

    private static final String SQL_CREATE_ENTRIES = // SENTENCIAS SQL
            "CREATE TABLE " + FoodContract.FoodEntry.TABLE_NAME + " (" +
                    FoodContract.FoodEntry.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    FoodContract.FoodEntry.COLUMN_NAME + " TEXT, " +
                    FoodContract.FoodEntry.COLUMN_PREPARACION + " TEXT, " +
                    FoodContract.FoodEntry.COLUMN_RUTA + " TEXT, " +
                    FoodContract.FoodEntry.COLUMN_ID_AUTOR + " INTEGER, " +
                    FoodContract.FoodEntry.COLUMN_ID_REGION + " INTEGER " +
                    ");";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FoodContract.FoodEntry.TABLE_NAME;

    public DBHelper(Context context) { //CONSTRUCTOR
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override // METODO ONCREATE
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override // METODO ONUPGRADE
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public int actualizarFood(int id, String nombre, String preparacion, String ruta, int idAutor, int idRegion) {   // METODO PARA ACTUALIZAR RECETA
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(FoodContract.FoodEntry.COLUMN_NAME, nombre);
        valores.put(FoodContract.FoodEntry.COLUMN_PREPARACION, preparacion);
        valores.put(FoodContract.FoodEntry.COLUMN_RUTA, ruta);
        valores.put(FoodContract.FoodEntry.COLUMN_ID_AUTOR, idAutor);
        valores.put(FoodContract.FoodEntry.COLUMN_ID_REGION, idRegion);

        String condicion = FoodContract.FoodEntry.COLUMN_ID + " = ?"; // ACTUALIZAR POR ID
        String[] args = { String.valueOf(id) };

        return db.update(FoodContract.FoodEntry.TABLE_NAME, valores, condicion, args);
    }
    public int eliminarFood(int id) { // ELIMINAR REGISTRO
        SQLiteDatabase db = this.getWritableDatabase();
        String condicion = FoodContract.FoodEntry.COLUMN_ID + " = ?";
        String[] args = { String.valueOf(id) };

        return db.delete(FoodContract.FoodEntry.TABLE_NAME, condicion, args); // RETOMAR EL DELETE
    }

    public Receta getRecetaById(int id){ //METODO PARA MODIFICAR POR ID
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columnas = {
                FoodContract.FoodEntry.COLUMN_ID,
                FoodContract.FoodEntry.COLUMN_NAME,
                FoodContract.FoodEntry.COLUMN_PREPARACION,
                FoodContract.FoodEntry.COLUMN_RUTA,
                FoodContract.FoodEntry.COLUMN_ID_AUTOR,
                FoodContract.FoodEntry.COLUMN_ID_REGION
        };
        String seleccion = FoodContract.FoodEntry.COLUMN_ID + " = ?";
        String[] args = { String.valueOf(id)};

        Cursor cursor = db.query(
                FoodContract.FoodEntry.TABLE_NAME,
                columnas,
                seleccion,
                args,
                null,null,null
        );

        Receta receta = null;
        if(cursor != null && cursor.moveToFirst()){
            receta = new Receta();
            receta.setId(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID)));
            receta.setNombre(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_NAME)));
            receta.setPreparacion(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_PREPARACION)));
            receta.setFotoRuta(cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_RUTA)));
            receta.setIdAutor(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID_AUTOR)));
            receta.setIdRegion(cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.FoodEntry.COLUMN_ID_REGION)));
            cursor.close();
        }
        return receta;
    }
}

