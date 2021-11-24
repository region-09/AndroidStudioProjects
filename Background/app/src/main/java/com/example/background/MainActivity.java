package com.example.background;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        final RelativeLayout lay = (RelativeLayout) findViewById(R.id.layo);
        if (preferences.contains("colorId")) {
            lay.setBackgroundColor(preferences.getInt("colorId", 0));
        }

        RadioGroup radioGroup_colors = findViewById(R.id.radio_group_colors);
        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int color = 0;
                switch (checkedId) {
                    case R.id.r_b_blue:
                        color = Color.BLUE;
                        break;
                    case R.id.r_b_red:
                        color = Color.RED;
                        break;
                    case R.id.r_b_yellow:
                        color = Color.YELLOW;
                        break;
                    case R.id.r_b_green:
                        color = Color.GREEN;
                        break;
                    default:
                        break;
                }
                lay.setBackgroundColor(color);
                editor.putInt("colorId", color);
                editor.commit();
            }
        });
    }
}