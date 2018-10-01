package com.example.andrew.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ChatWindow extends Activity {

    protected static final String ACTIVITY_NAME="ChatWindow";

    ListView myList;
    EditText inputText;
    Button sendButton;
    ArrayList <String> chatMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        chatMessages = new ArrayList<>();

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
            chatMessages.add(inputText.toString());
            messageAdapter.notifyDataSetChanged();
            inputText.setText("");
            }
        });
    }

    class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx) {super(ctx, 0);}

        public int getCount(){
            return chatMessages.size();
        }

        public String getItem(int position){
            return chatMessages.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result = null;
            if (position%2 ==0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = result.findViewById(R.id.message_text);
            message.setText( getItem(position) );
            return result;
        }

        public long getItemID(int position){
            return position;
        }
    }

}
