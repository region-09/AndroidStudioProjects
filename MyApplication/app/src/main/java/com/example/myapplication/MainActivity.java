package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button kmToMile = (Button) findViewById(R.id.convKm);
        kmToMile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText km = (EditText) findViewById(R.id.ekm);
                EditText mile = (EditText) findViewById(R.id.eml);
                double kilometer = Double.parseDouble(km.getText().toString());
                double mil = kilometer / 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                mile.setText(formatVal.format(mil));
            }
        });

        Button mileToKm = (Button) findViewById(R.id.convMile);
        mileToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText km = (EditText) findViewById(R.id.ekm);
                EditText mile = (EditText) findViewById(R.id.eml);
                double mil = Double.parseDouble(mile.getText().toString());
                double kilometer = mil * 0.62137;
                DecimalFormat formatVal = new DecimalFormat("##.##");
                km.setText(formatVal.format(kilometer));
            }
        });
    }
}