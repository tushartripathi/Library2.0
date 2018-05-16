package com.example.tushar.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

/**
 * Created by tushar on 15/5/18.
 */

public class allbooks extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allbooks);



        Log.d("preloaded","staring");
        listView = (ListView)findViewById(R.id.mylistview);
        AssetDatabase databaseAccess = AssetDatabase.getInstance(this);
        Log.d("preloaded","opening");
        databaseAccess.open();
        List<String> quotes = databaseAccess.getbooks();
        databaseAccess.close();
        quotes.removeAll(Collections.singleton(null));
        Log.d("preloaded","main class closing");
        Log.d("preloaded","Pringting data");
        Log.d("preloaded", quotes.toString());
        try {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
            Log.d("preloaded", "my dta is in ");
            listView.setAdapter(adapter);
            Log.d("preloaded", "Done");
        }
        catch (NullPointerException e)
        {
            Log.d("preloaded",e.toString());
        }

        Log.d("preloaded", "All done");

    }
}