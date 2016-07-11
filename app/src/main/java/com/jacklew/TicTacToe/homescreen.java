package com.jacklew.TicTacToe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;

public class homescreen extends AppCompatActivity {

    MediaPlayer bgmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        bgmusic=MediaPlayer.create(this,R.raw.bgmusic);
        bgmusic.setLooping(true);
        bgmusic.start();

        ImageButton Enterbtn=(ImageButton)findViewById(R.id.enterbtn);

        Enterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentImg=new Intent(getApplicationContext(),selectboardscreen.class);
                startActivity(intentImg);
            }
        });
    }

}



