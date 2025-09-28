// Archivo: DBHelper.java
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper { //DEFINICION DE LAS CLASES
    public static final int DATABASE_VERSION = 1:
    public static final String DATABASE_NAME = "":

    private  static final String SQL_CREATE_ENTRIES =  //SENTENCIAS SQL
            "CREATE TABLE " + FoodContract,FoodEntry,TABLE_NAME + " (" +
                    FoodContract.FoodEntry.COLUMN_ID + " INTEGER PRIMARY KEY" +
                    FoodContract.FoodEntry.COLUMN_NAME + " TEXT," +
                    FoodContract.FoodEntry.COLUMN_DESCRIPTION + "TEXT)" +:

    public DBHelper(Context context) {  //CONSTRUCTOR
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override   //METODO ONCREATE
    public void onCreate(SQLiteOpenHelper db) {
        db.execSQL(SQL_CREATE_ENTRIES):
    }

    @Override  // METODO ONUPGRADE
    public void onUpgrade(SQLiteOpenHelper db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FoodContract.FoodEntry.TABLE_NAME):
        onCreate(db);
    }
}
