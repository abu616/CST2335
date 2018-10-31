package com.example.andrew.androidlabs;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import static com.example.andrew.androidlabs.ChatDatabaseHelper.TABLE_NAME;

public class ChatWindow extends Activity {

    protected static final String ACTIVITY_NAME="ChatWindow";

    ListView myList;
    EditText inputText;
    Button sendButton;
    ArrayList <String> chatMessages;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        chatMessages = new ArrayList<>();

        // SQL content
        final ChatDatabaseHelper dbOpener = new ChatDatabaseHelper( this); // helper obj
        db = dbOpener.getWritableDatabase(); // writable database
        Cursor c = db.rawQuery("SELECT * from " + TABLE_NAME,  null);
        c.moveToFirst();
            while (!c.isAfterLast()){
                Log.i(ACTIVITY_NAME, "Cursor's column count= " + c.getColumnCount());
                Log.i(ACTIVITY_NAME, "SQL MESSAGE: " + c.getString(
                        c.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE)));
                chatMessages.add( c.getString( c.getColumnIndex( ChatDatabaseHelper.KEY_MESSAGE)));
                c.moveToNext();
            for (int i=0; i < c.getColumnCount(); i++) {
                Log.i(ACTIVITY_NAME, "Column Name= " + c.getColumnName(i));
            }
        }

        // initialize variables
        myList=findViewById(R.id.myList);
        inputText=findViewById(R.id.inputText);
        sendButton=findViewById(R.id.sendButton);

        final ChatAdapter messageAdapter = new ChatAdapter( this);
        myList.setAdapter(messageAdapter);

        // Click to add text to ArrayList<>
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                chatMessages.add(inputText.getText().toString());
                ContentValues cv = new ContentValues();
                cv.put(dbOpener.KEY_MESSAGE, inputText.getText().toString());
                db.insert(TABLE_NAME, "NullColumnName", cv);
                messageAdapter.notifyDataSetChanged();
                inputText.setText("");
            }
        });
    }

    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        public int getCount() {
            return chatMessages.size();
        }

        public String getItem(int position) {
            return chatMessages.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result = null;
            if (position % 2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position));
            return result;
        }

        public long getID(int position) {
            return position;
        }
    }

    public void onDestroy(){
        super.onDestroy();
        db.close();
    }
}
