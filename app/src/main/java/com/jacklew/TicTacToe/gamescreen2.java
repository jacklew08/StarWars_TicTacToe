package com.jacklew.TicTacToe;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class gamescreen2 extends AppCompatActivity {

    // 0=qui, 1=maul
    int activeplayer=0;

    boolean gameisactive=true;

    // 2 means unplayed
    int[]gamestate={2,2,2,2,2,2,2,2,2};

    int[][]winningposition={
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6},
    };

    public void dropin(View view){

        ImageView counter=(ImageView)view;

        int tappedcounter=Integer.parseInt(counter.getTag().toString());

        if (gamestate[tappedcounter]==2 && gameisactive) {
            gamestate[tappedcounter]=activeplayer;
            counter.setTranslationY(-1000f);

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.quigonjinn1);
                activeplayer = 1;

                final MediaPlayer player = MediaPlayer.create(this, R.raw.tapsound);
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);

                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });

                player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                    }
                });
            }

            else {
                counter.setImageResource(R.drawable.darthmaul2);
                activeplayer = 0;
                final MediaPlayer player = MediaPlayer.create(this, R.raw.tapsound);
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);

                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });

                player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                    }
                });
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);



            for(int[]winning:winningposition){
                if(gamestate[winning[0]]==gamestate[winning[1]]&&
                        gamestate[winning[1]]==gamestate[winning[2]]&&
                        gamestate[winning[0]]!=2){

                    // someone has won!

                    gameisactive=false;

                    String winner="Darth Maul";

                    if(gamestate[winning[0]]==0){
                        winner="Qui-Gon Jinn";
                    }

                    Button Exitbutton=(Button)findViewById(R.id.exitbutton);

                    Exitbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intentImg=new Intent(getApplicationContext(),homescreen.class);
                            startActivity(intentImg);
                        }
                    });


                    TextView winnermessage=(TextView)findViewById(R.id.winnermsg);
                    winnermessage.setText(winner+" has won!");

                    LinearLayout layout=(LinearLayout)findViewById(R.id.playagainlayout);
                    layout.setVisibility(View.VISIBLE);

                    final MediaPlayer wonsound = MediaPlayer.create(this, R.raw.wonsound);
                    wonsound.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    wonsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            wonsound.release();
                        }
                    });

                    wonsound.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });


                } else{
                    boolean gameisover=true;
                    for(int counterstate:gamestate){
                        if(counterstate==2){
                            gameisover=false;
                        }
                    }
                    if(gameisover){
                        TextView winnermessage=(TextView)findViewById(R.id.winnermsg);
                        winnermessage.setText("It is a draw!");

                        LinearLayout layout=(LinearLayout)findViewById(R.id.playagainlayout);
                        layout.setVisibility(View.VISIBLE);

                        final MediaPlayer wonsound = MediaPlayer.create(this, R.raw.wonsound);
                        wonsound.setAudioStreamType(AudioManager.STREAM_MUSIC);

                        wonsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                wonsound.release();
                            }
                        });

                        wonsound.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mp.start();
                            }
                        });


                    }
                }

            }
        }

    }

    public void playagain(View view){

        gameisactive=true;

        LinearLayout layout=(LinearLayout)findViewById(R.id.playagainlayout);
        layout.setVisibility(View.INVISIBLE);

        activeplayer=0;

        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        GridLayout grid=(GridLayout)findViewById(R.id.gridlayout);

        for(int i=0;i<grid.getChildCount();i++){
            ((ImageView) grid.getChildAt(i)).setImageResource(0);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamescreen2);
    }
}
