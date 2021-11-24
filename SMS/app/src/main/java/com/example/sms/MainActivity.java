package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enter(View v) {
        String message = ((EditText) (findViewById(R.id.editText_message))).getText().toString();
        Uri destination = Uri.parse("smsto:5556");
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, destination);
        smsIntent.putExtra("sms_body", message);
        startActivity(smsIntent);
    }
}