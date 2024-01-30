package com.example.josemainstadam.db;

public class StructureDB {

    public static final String DATABASE_NAME = "instaDam";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_USER_ID = "user_id";


    public static final String SQL_CREATE_TABLE_USERS =
            "CREATE TABLE " + StructureDB.TABLE_USERS + " (" +
                    StructureDB.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    StructureDB.COLUMN_USERNAME + " TEXT UNIQUE," +
                    StructureDB.COLUMN_PASSWORD + " TEXT)";


    public static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS " + StructureDB.TABLE_USERS;


    public static final String[] columnas = {
            StructureDB.COLUMN_ID,
            StructureDB.COLUMN_USERNAME,
            StructureDB.COLUMN_PASSWORD
    };


    public static final String columnWhere = StructureDB.COLUMN_USERNAME + " = ?";
    public static final String sortOrder = StructureDB.COLUMN_PASSWORD + " DESC";
}
