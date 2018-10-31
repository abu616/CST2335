package com.example.andrew.androidlabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ChatDatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db";
    public static int VERSION_NUM = 2;

    public static String TABLE_NAME = "Messages";
    public static String KEY_ID = "_id";
    public static String KEY_MESSAGE= "message";

    public ChatDatabaseHelper(Context ctx){
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate( db);
        Log.i("ChatDatabaseHelper", "Calling onUpgrade, oldVersion=" +oldVer + "newVersion= " + newVer);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_MESSAGE+" text);");
        Log.i("ChatDatabaseHelper", "Calling onCreate");
    }
}
