// Archivo: DBHelper.java
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper { // DEFINICIÓN DE LA CLASE
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FoodDB.db";

    // SENTENCIAS SQL
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FoodContract.FoodEntry.TABLE_NAME + " (" +
                    FoodContract.FoodEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FoodContract.FoodEntry.COLUMN_NAME + " TEXT, " +
                    FoodContract.FoodEntry.COLUMN_DESCRIPTION + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FoodContract.FoodEntry.TABLE_NAME;

    // CONSTRUCTOR
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override   // MÉTODO ONCREATE
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override  // MÉTODO ONUPGRADE
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
