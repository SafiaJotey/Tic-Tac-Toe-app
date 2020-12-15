package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Player1Intent extends AppCompatActivity {

public Button p1Save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1_intent);

        p1Save=findViewById(R.id.savep1);
    }

    public void SaveP1(View view) {

        Intent p1intent = new  Intent(this, MainActivity.class);

        startActivity(p1intent);


    }


}