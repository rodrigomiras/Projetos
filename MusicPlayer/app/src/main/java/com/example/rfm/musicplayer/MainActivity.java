package com.example.rfm.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.the_walking_dead_abertura);

        Button playButton = (Button)findViewById(R.id.button_play);
        Button pauseButton = (Button)findViewById(R.id.button_pause);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "Play apertado !", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Pause apertado !", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });
    }

}
