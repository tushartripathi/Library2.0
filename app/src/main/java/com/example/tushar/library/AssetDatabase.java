package com.example.tushar.library;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tushar on 15/5/18.
 */

public class AssetDatabase {
    private SQLiteOpenHelper openHelper;
        private SQLiteDatabase database;
        private static AssetDatabase instance;

        private AssetDatabase(Context context) {
            Log.d("preloaded","Assest data contstructor");
            this.openHelper = new MybooksDatabase(context);
        }

        public static AssetDatabase getInstance(Context context) {
            if (instance == null) {
                Log.d("preloaded","if instance");
                instance = new AssetDatabase(context);
            }
            else
                Log.d("preloaded","else instance");

            return instance;
        }

        public void open() {
            Log.d("preloaded","assest open");
            Log.d("preloaded","my call");
            try {
                this.database = openHelper.getWritableDatabase();
            }
            catch (Exception e)
            {
                Log.d("preloaded","error");
                Log.d("preloaded",e.toString());
            }

            Log.d("preloaded", database.toString());

        }

        public void close() {
            if (database != null) {
                this.database.close();
            }
        }
        public List<String> getbooks()
        {
            Log.d("preloaded","Getting data all data");
            List<String> list = new ArrayList<>();
            Cursor cursor = database.rawQuery("SELECT * FROM books WHERE ID IS NOT 0", null);
            Log.d("preloaded","cursor data");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Log.d("preloaded","looing");
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add("Available : "+cursor.getString(3));
                list.add("\n");
                cursor.moveToNext();
            }
            cursor.close();

            Log.d("preloaded","returning list");
            return list;
        }

        public void Checkdata()
        {
            Log.d("preloaded","cheking ......  data in database............");
            List<String> list = new ArrayList<>();
            Cursor cursor = null;
            try {cursor = database.rawQuery("SELECT * FROM Issuedbook", null);
            }
            catch (SQLException s)
            {
                Log.d("preloaded","Error"+s.toString() );
            }
            catch (Exception e)
            {
                Log.d("preloaded","Exception "+e.toString() );
            }
            Log.d("preloaded","cursor..");
            Log.d("preloaded","cheking ......  1");
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Log.d("preloaded","looing");
                list.add(cursor.getString(2));
                cursor.moveToNext();
            }
            cursor.close();
            Log.d("preloaded",list.toString());


        }

    public String getUserPass (String username)
    {
        Checkdata();
        Log.d("preloaded","Getting Password ...................");
      //  List<String> list = new ArrayList<>();
        String password=null;
        //String query ="SELECT * FROM User WHERE Name =\""+username+"\"";
        String query ="SELECT * FROM user";
        Log.d("preloaded","@@@@@  " + query);
        Cursor cursor=null;
        try {

            cursor = database.rawQuery(query, null);
        }


        catch (SQLiteException s)
        {
            Log.d("preloaded",s.toString());
        }

        if(cursor.getCount()>0)
        {
            Log.d("preloaded","Data found");
        }
        else
            Log.d("preloaded"," not Data found");

        if( cursor != null && cursor.moveToFirst() ){

            Log.d("preloaded","cursor data ifffff.......");

            Log.d("preloaded","looing");
            try {
                password = cursor.getString(1).toString();
            }
            catch (SQLException e)
            {
                Log.d("preloaded",e.toString());
            }

        }
        else
            Log.d("preloaded","else........##");



        Log.d("preloaded",password);
//            list.add(cursor.getString(1));
//            list.add(cursor.getString(2));
//            list.add("Available : "+cursor.getString(3));
//            list.add("\n");
//            cursor.moveToNext();
       // }
        cursor.close();

        Log.d("preloaded","returning password "+ password );

        return password;
    }

    public List<String> getbooksinprofile()
    {
        Log.d("preloaded","Getting data for profile");
        List<String> list = new ArrayList<>();
        Cursor cursor = null;
        try {
             cursor = database.rawQuery("SELECT * FROM books where ID is not 0", null);
        }
        catch (Exception e)
        {
            Log.d("preloaded","Profile error == "+e.toString());
        }
        Log.d("preloaded","cursor data");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Log.d("preloaded","looing");
            list.add(cursor.getString(1));
            list.add(cursor.getString(2));
            list.add("\n");
            cursor.moveToNext();
        }
        cursor.close();

        Log.d("preloaded","returning list");
        return list;
    }

}
