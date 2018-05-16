package com.example.tushar.library;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by tushar on 15/5/18.
 */

public class MybooksDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "Library.db";
    private static final int DATABASE_VERSION =1;

    public MybooksDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, null,DATABASE_VERSION);
        Log.d("preloaded","good to go for the next");
    }



}