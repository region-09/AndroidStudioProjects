package com.example.rating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void enter(View v) {
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        float rating = ratingBar.getRating();
        //Toast.makeText(getApplicationContext(), rating + " stars", Toast.LENGTH_SHORT).show();
        Intent goToSecond = new Intent();
        goToSecond.putExtra("nbStars", rating);
        goToSecond.setClass(this, SecondActivity.class);
        startActivity(goToSecond);
        finish();
    }
}
