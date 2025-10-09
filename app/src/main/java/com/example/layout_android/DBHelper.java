// Archivo: DBHelper.java
package com.example.layout_android;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.layout_android.Contratos.FoodContract;

public class DBHelper extends SQLiteOpenHelper { //DEFINICION DE LAS CLASES
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodDatabase.db";

    private  static final String SQL_CREATE_ENTRIES =  //SENTENCIAS SQL
            "CREATE TABLE " + FoodContract.FoodEntry.TABLE_NAME + " (" +
            FoodContract.FoodEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +
            FoodContract.FoodEntry.COLUMN_NAME + " TEXT," +
            FoodContract.FoodEntry.COLUMN_PREPARACION + "TEXT, "+
            FoodContract.FoodEntry.COLUMN_RUTA + "TEXT, " +
            FoodContract.FoodEntry.COLUMN_ID_AUTOR + "INTEGER, "+
            FoodContract.FoodEntry.COLUMN_ID_REGION + "INTEGER "+
            ");";

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + FoodContract.FoodEntry.TABLE_NAME;

    public DBHelper(Context context) {  //CONSTRUCTOR
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override   //METODO ONCREATE
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override  // METODO ONUPGRADE
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // eliminar tabla antigua
        db.execSQL(SQL_DELETE_ENTRIES);
        // RECREAR TABLA
        onCreate(db);
    }
}
