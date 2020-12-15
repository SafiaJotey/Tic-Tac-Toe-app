package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner mySpinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner=findViewById(R.id.spinnerID);
        ArrayAdapter<CharSequence> myAdapter=ArrayAdapter.createFromResource(this,R.array.menu, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals(("Menu"))){
                         //nothing
                }
                else{

                    if(parent.getItemAtPosition(position).equals("Edit Name")){
                        Intent intent = new  Intent(MainActivity.this,EditName.class);
                        startActivity(intent);
                    }
                    else if(parent.getItemAtPosition(position).equals("How to play?")){
                        Intent intent = new  Intent(MainActivity.this,Player1Intent.class);
                        startActivity(intent);
                    }
                    else {
                        Intent intent = new  Intent(MainActivity.this,Player2Intent.class);
                        startActivity(intent);

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void starBtn(View view) {
        Intent intent = new  Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}