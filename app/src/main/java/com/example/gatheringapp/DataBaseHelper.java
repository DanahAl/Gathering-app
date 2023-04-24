package com.example.gatheringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.net.InetAddress;
import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_Name ="Renting_Chalet";
    private static final int DB_Version = 1;
    public static final String chalet_ID = " ID";
    public static final String chalet_name = " NAME";
    public static final String chalet_price = " PRICE";
    public static final String chalet_table = " CHALET";
    public static final String CHALET_DECRIPTION = " chalet_decription";
    public static final String CHALET_ADDRESS = " chalet_address";


    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE" + chalet_table + "(" + chalet_ID + " INTEGER PRIMARY KEY," + chalet_name +
                " Text ," + chalet_price + " INTEGER ," + CHALET_DECRIPTION + " Text ," + CHALET_ADDRESS + " Text )";

        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String delete_query = "drop table if exists "+chalet_table;
       db.execSQL(delete_query);
     onCreate(db);

    }


    public boolean addChalet(Chalet chalet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(chalet_ID , chalet.getChalet_id());
        values.put(chalet_name , chalet.getChalet_name());
        values.put(CHALET_DECRIPTION , chalet.getChalet_decription());
        values.put(CHALET_ADDRESS , chalet.getChalet_address());
        values.put(chalet_price , chalet.getChalet_price());



       long insert = db.insert(chalet_table , null , values);

       if (insert == -1)
           return false;
       else
           return true;
    }



    /*
    public ArrayList<Chalet> getAllChalets() {

        ArrayList<Chalet> chalets = new ArrayList<>();

        String select_query = "select * from " + chalet_table ;

        SQLiteDatabase db = this.getReadableDatabase();
        //                      condition
       Cursor cursor= db.rawQuery(select_query , null );


       if(cursor.moveToFirst()) {
           do{

/*
               int ChaletID = cursor.getColumnIndex(chalet_ID);
               int CID = Integer.parseInt(cursor.getString(ChaletID));

                   int indexName = cursor.getColumnIndex(chalet_name);
                  String name = cursor.getString(indexName);

               int indexPrice = cursor.getColumnIndex(chalet_price);
              int price = Integer.parseInt(cursor.getString(indexPrice));

              int indexDec = cursor.getColumnIndex(CHALET_DECRIPTION)   ;
              String dec = cursor.getString(indexDec) ;

             int indexAddress = cursor.getColumnIndex(CHALET_ADDRESS)  ;
             String address = cursor.getString(indexAddress) ;


*/
/*
             int ChaletID = cursor.getInt(0);
              String name = cursor.getString(1);
              int price = cursor.getInt(2);
               String dec = cursor.getString(3);
               String address = cursor.getString(4);



               Chalet chalet = new Chalet( name ,ChaletID,  dec,  address,price);

               chalets.add(chalet);


           }while (cursor.moveToNext());

       }

       cursor.close();
       db.close();


        /*
       while(cursor.moveToNext()){

           int indexName = cursor.getColumnIndex(chalet_name);
           String name = cursor.getString(indexName);

           int indexPrice = cursor.getColumnIndex(chalet_price);
           int price = Integer.parseInt(cursor.getString(indexPrice));

           int indexDec = cursor.getColumnIndex(CHALET_DECRIPTION)   ;
           String dec = cursor.getString(indexDec) ;

           int indexAddress = cursor.getColumnIndex(CHALET_ADDRESS)  ;
           String address = cursor.getString(indexAddress) ;



           Chalet chalet = new Chalet(name ,dec , address , price);

           chalets.add(chalet);
       }



        return chalets;
    }

    */

}
