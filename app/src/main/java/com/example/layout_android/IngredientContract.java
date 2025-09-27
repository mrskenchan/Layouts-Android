package com.example.layout_android;

public class IngredientContract {
    private IngredientContract(){}

    public static class IngredientEntry {
        public static final String TABLE_NAME = "ingrediente";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "nombre";
        public static final String COLUMN_UNIT = "unidad";
    }
}
