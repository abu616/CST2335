package com.example.andrew.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.Set;

public class LoginActivity extends Activity {

    /*

    protected static final String ACTIVITY_NAME = "LoginActivity";

    SharedPreferences prefs;
    Button loginButton;
    EditText emailLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        // SP obj for reading and writing
        prefs = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
        emailLogin.setText(prefs.getString("defaultEmail", "email@domain.com"));

        // editor obj
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("defaultEmail", "");
        edit.apply();


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
    */

}

