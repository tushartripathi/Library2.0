package com.example.tushar.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

/**
 * Created by tushar on 15/5/18.
 */

public class login  extends AppCompatActivity {

    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editText1 = (EditText)findViewById(R.id.editboxusername);
        editText2 = (EditText)findViewById(R.id.editboxpassword);
    }

    public void login(View view)
    {

        showissueddata();
   String username = editText1.getText().toString();
   String enterpass = editText2.getText().toString();
   if(username.equals(enterpass))
   {
       Intent i = new Intent(this, profile.class);
       startActivity(i);
   }
//        AssetDatabase databaseAccess = AssetDatabase.getInstance(this);
//        Log.d("preloaded","Logi in opeing ");
//        databaseAccess.open();
//        String password = databaseAccess.getUserPass(username);
//        if(password.equals(enterpass))
//        {
//            Log.d("preloaded","Logi in opeing ");
//            Intent i = new Intent(this, allbooks.class);
//            startActivity(i);
//        }
//        else
//            Log.d("preloaded","Incorrect ");
    }

    public void showissueddata()
    {

    }


}