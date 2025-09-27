package com.example.layout_android;

public class FoodContract {
    private FoodContract() {}

    public static class FoodEntry {
        public static final String TABLE_NAME = "Receta";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "nombre_receta";
        public static final String COLUMN_PREPARACION = "preparacion";
        public static final String COLUMN_RUTA = "fotoRuta";
        public static final String COLUMN_IDAUTOR = "id_autor";
        public static final String COLUMN_IDREGION = "id_region";
    }
}
