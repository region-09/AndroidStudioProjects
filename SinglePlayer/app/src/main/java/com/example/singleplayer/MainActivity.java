package com.example.singleplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.*;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this, R.raw.m);
        Switch repeater = (Switch) findViewById(R.id.switch_loop);
        repeater.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                music.setLooping(isChecked);
            }
        });
    }

    public void musicPlay(View v) {
        music.start();
    }
    public void musicPause(View v) {
        if (music.isPlaying()) {
            music.pause();
        }
    }
}