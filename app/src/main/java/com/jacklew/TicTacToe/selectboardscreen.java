package com.jacklew.TicTacToe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class selectboardscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectboardscreen);

        ImageButton style1=(ImageButton)findViewById(R.id.imageButton1);

        style1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentImg=new Intent(getApplicationContext(),gamescreen1.class);
                startActivity(intentImg);
            }
        });


        ImageButton style2=(ImageButton)findViewById(R.id.imageButton2);

        style2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentImg=new Intent(getApplicationContext(),gamescreen2.class);
                startActivity(intentImg);
            }
        });

    }
}
