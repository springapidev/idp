package com.codebd.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.media.MediaPlayer;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Instantiating the MediaPlayer class
    MediaPlayer music;
    private boolean isStop=false;

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding the music file to our
        // newly created object music
        music = MediaPlayer.create(this, R.raw.sound);
    }

    // Plaing the music
    public void musicplay(View v) {
        music.start();
        System.out.println("START: "+isStop);
    }

    // Pausing the music
    public void musicpause(View v) {

        if (music.isPlaying()){
            music.pause();
            System.out.println("PAUSE: "+isStop);
        }else if (isStop == false){
            music.start();
            System.out.println("AFTER PAUSE RESTART: "+isStop);
        }
    }

    // Stoping the music
    public void musicstop(View v) {
        music.stop();
        isStop =true;
        System.out.println("STOP: "+isStop);
        music = MediaPlayer.create(this, R.raw.sound);
    }
}
