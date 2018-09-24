package com.example.andrew.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    Button button;
    SharedPreferences prefs;
    EditText email, password;

    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Error Msg
        Log.i(ACTIVITY_NAME, "in onCreate()");

        email=findViewById(R.id.login_email);
        password=findViewById(R.id.login_password);

        // Button ref from XML
        button=findViewById(R.id.login_button);

        //SharedPref and edit obj
        prefs = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        email.setText(prefs.getString("default_email", "email123@domain.com"));

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String e = email.getText().toString();
                String p = password.getText().toString();

                SharedPreferences.Editor edit = prefs.edit();

                edit.putString("default_email", e);
                edit.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
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

