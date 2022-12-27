package com.example.demomobilv4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Formulario.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "mi_formulario";
    private static final String COLUMN_CODIGO = "Codigo";
    private static final String COLUMN_VALOR = "Valor";
    private static final String COLUMN_DESCRIPCION= "Descripcion";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_VALOR + " TEXT, " +
                        COLUMN_DESCRIPCION + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addParametro(String valor, String descripcion){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_VALOR, valor);
        cv.put(COLUMN_DESCRIPCION, descripcion);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Exito", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return  cursor;
    }
}
