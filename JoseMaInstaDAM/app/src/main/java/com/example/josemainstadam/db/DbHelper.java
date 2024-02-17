package com.example.josemainstadam.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, StructureDB.DATABASE_NAME, null, StructureDB.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StructureDB.SQL_CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(StructureDB.SQL_DELETE_TABLES);
        onCreate(db);

    }

    public void insertBBDD(String name, String email, String pasw) {

        // Creamos mapa de valores con los nombres de las tablas
        ContentValues values = new ContentValues();
        values.put(StructureDB.COLUMN_USERNAME, name);
        values.put(StructureDB.COLUMN_EMAIL, email);
        values.put(StructureDB.COLUMN_PASSWORD, pasw);

        // Insertar nueva fila indicando nombre de la tabla
        long newRowId = this.getWritableDatabase().insert(
                StructureDB.TABLE_USERS, null, values);
        //this.close();

    }


    public boolean checkUser(String email) {

        Cursor cursor = this.getReadableDatabase().rawQuery(
                "SELECT * FROM " + StructureDB.TABLE_USERS +
                        " WHERE " + StructureDB.COLUMN_EMAIL + "=? ",
                new String[]{email});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        //this.close();

        return exists;
    }

    public boolean checkPasswd(String email, String passwd) {

        Cursor cursor = this.getReadableDatabase().rawQuery(
                "SELECT * FROM " + StructureDB.TABLE_USERS +
                        " WHERE " + StructureDB.COLUMN_EMAIL + "=? AND " + StructureDB.COLUMN_PASSWORD + "=?",
                new String[]{email, passwd});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        //this.close();

        return exists;
    }
}