package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Player2Intent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2_intent);
    }

    public void returnAbut(View view) {
        Intent p2intent = new  Intent(this,MainActivity.class);

        startActivity(p2intent);
    }
}