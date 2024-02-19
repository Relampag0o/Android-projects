package com.example.josemainstadam.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.MessageDigest;

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

        // hashing password
        String hashedPassword = hashPassword(pasw);

        // Creamos mapa de valores con los nombres de las tablas
        ContentValues values = new ContentValues();
        values.put(StructureDB.COLUMN_USERNAME, name);
        values.put(StructureDB.COLUMN_EMAIL, email);
        values.put(StructureDB.COLUMN_PASSWORD, hashedPassword);

        // Insertar nueva fila indicando nombre de la tabla
        long newRowId = this.getWritableDatabase().insert(
                StructureDB.TABLE_USERS, null, values);
        //this.close();

    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
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

        String hashedPassword = hashPassword(passwd);


        Cursor cursor = this.getReadableDatabase().rawQuery(
                "SELECT * FROM " + StructureDB.TABLE_USERS +
                        " WHERE " + StructureDB.COLUMN_EMAIL + "=? AND " + StructureDB.COLUMN_PASSWORD + "=?",
                new String[]{email, hashedPassword});

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        //this.close();

        return exists;
    }
}