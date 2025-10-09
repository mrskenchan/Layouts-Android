package com.example.layout_android.Contratos;

public class FoodContract {
    private FoodContract() {}

    public static class FoodEntry {
        public static final String TABLE_NAME = "Receta";
        public static final String COLUMN_ID = "id";  // Primary Key
        public static final String COLUMN_NAME = "nombre_receta";  //Varchar
        public static final String COLUMN_PREPARACION = "preparacion";  //Varchar
        public static final String COLUMN_RUTA = "foto_Ruta"; //Varchar
        public static final String COLUMN_ID_AUTOR = "id_autor"; //Foreign Key
        public static final String COLUMN_ID_REGION = "id_region"; //Foreign Key
    }
}
