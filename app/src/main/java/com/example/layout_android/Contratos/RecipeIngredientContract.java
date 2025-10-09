package com.example.layout_android.Contratos;

public class RecipeIngredientContract {
    private RecipeIngredientContract(){}

    public static class RecipeIngredientEntry {
        public static final String TABLE_NAME = "Receta_Ingrediente";
        public static final String COLUMN_ID = "id";  //Primary Key
        public static final String COLUMN_ID_RECETA = "id_rec_ing";  //Foreign Key
        public static final String COLUMN_ID_INGREDIENT = "id_ingrediente";  //Foreign Key
        public static final String COLUMN_CANTIDAD = "cantidad";  //Int
    }
}
