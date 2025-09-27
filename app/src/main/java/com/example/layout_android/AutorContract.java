package com.example.layout_android;

public class AutorContract {
    private AutorContract () {}

    public static class AutorEntry {
        public static final String TABLE_NAME = "autor";
        public static final String COLUMN_ID = "id"; //Primary Key
        public static final String COLUMN_NAME = "nombre"; //Varchar
        public static final String COLUMN_GMAIL = "correo"; //Varchar
    }
}
