package com.example.gatheringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_Name ="Renting_Chalet";
    private static final int DB_Version = 1;
    public static final String chalet_ID = "ID";
    public static final String chalet_name = "NAME";
    public static final String chalet_price = "PRICE";
    public static final String chalet_table = "CHALET";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + chalet_table + "(" + chalet_ID + " INTEGER PRIMARY KEY, " + chalet_name +
                " VARCHAR(30) ," + chalet_price + " INTEGER)";

        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String delete_query = "drop table if exists "+chalet_table;
       db.execSQL(delete_query);
     onCreate(db);

    }


    public void addChalet(Chalet chalet) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
       // values.put(chalet_ID , chalet.getChalet_id());
        values.put(chalet_name , chalet.getChalet_name());
        values.put(chalet_price , chalet.getChalet_price());


        db.insert(chalet_table , null , values);

    }


    public ArrayList<Chalet> getAllChalets() {

        ArrayList<Chalet> chalets = new ArrayList<>();

        String select_query = "select * from " + chalet_table ;

        SQLiteDatabase db = this.getReadableDatabase();
        //                        condition
       Cursor cursor= db.rawQuery(select_query , null );
        int price;
       if(cursor.moveToFirst()) {
           do{


                   int indexName = cursor.getColumnIndex(chalet_name);
                   cursor.getString(indexName);

               int indexPrice = cursor.getColumnIndex(chalet_price);
              String name = cursor.getString(indexPrice);

               Chalet chalet = new Chalet(name ,indexPrice);

               chalets.add(chalet);


           }while (cursor.moveToNext());
       }


        return chalets;
    }
}
