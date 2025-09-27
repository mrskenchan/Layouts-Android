package com.example.layout_android;

public class RecipeIngredientContract {
    private RecipeIngredientContract(){}

    public static class RecipeIngredientEntry {
        public static final String TABLE_NAME = "Receta_Ingrediente";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_ID_REC_ING = "id_rec_ing";
        public static final String COLUMN_ID_INGREDIENT = "id_ingrediente";
        public static final String COLUMN_CANTIDAD = "cantidad";
    }
}
