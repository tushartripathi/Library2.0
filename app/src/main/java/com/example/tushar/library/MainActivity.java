package com.example.tushar.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Allbooks(View view)
    {
        Intent i = new Intent(this, allbooks.class );
        startActivity(i);
    }
    public void Login(View view)
    {
        Intent i = new Intent(this, login.class);
        startActivity(i);
    }
}
