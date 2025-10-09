package com.example.layout_android.Contratos;

public class IngredientContract {
    private IngredientContract(){}

    public static class IngredientEntry {
        public static final String TABLE_NAME = "ingrediente";
        public static final String COLUMN_ID = "id";  // Primary Key
        public static final String COLUMN_NAME = "nombre";  //Varchar
        public static final String COLUMN_UNIT = "unidad"; //Varchar
    }
}
