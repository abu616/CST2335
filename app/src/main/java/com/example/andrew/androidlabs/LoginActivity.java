package com.example.andrew.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class LoginActivity extends Activity {

    Button login_button;
    SharedPreferences prefs;
    TextView login_email;

    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_login);

        //Error Msg
        Log.i(ACTIVITY_NAME, "in onCreate()");


        prefs = getApplicationContext().getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();

        //Read default email
        prefs.getString("default_email", "email@domain.com");
        //login_email.setText(prefs.getString("default_email", "email@domain.com"));

        // write default email
        //edit.putString("default_email", );

        //login_button = ;


        // commit
        edit.commit();
    }

   @Override
    protected void onResume() {
        super.onResume();
       Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}

