package com.example.andrew.androidlabs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME="StartActivity";

    Button button;

   protected void onActivityResult(int requestCode, int responseCode, Intent data){
        if(requestCode == 50){
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult()");
        }
        if(responseCode == Activity.RESULT_OK){
           Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult()");
            String messagePassed = data.getStringExtra("Response");
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this , messagePassed, duration);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, 50);
            }
        });

        // Chat Button
        button=findViewById(R.id.chatButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View W) {
                Intent intent = new Intent(StartActivity.this, ChatWindow.class);
                startActivityForResult(intent, 50);
                Log.i(ACTIVITY_NAME, "User clicked Start Chat");
                // Start a new chat activity

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