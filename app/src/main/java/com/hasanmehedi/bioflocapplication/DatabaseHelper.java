package com.hasanmehedi.bioflocapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="Biofloc.db";

//    public static  final String INFO_TABLE_NAME="info_table";
//    public static  final String Col_1 ="";
//    public static  final String PH_TABLE_NAME="ph_table";
//    public static  final String TDS_TABLE_NAME="tds_table";
//    public static  final String DO_TABLE_NAME="do_table";
//    public static  final String HARVEST_TABLE_NAME="harvest_table";

    public DatabaseHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table info_table (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
        "FARM_NAME TEXT,START_DATE DATETIME,PHONE_NO TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS info_table");
        onCreate(db);
    }

}

