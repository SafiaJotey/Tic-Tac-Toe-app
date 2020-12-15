package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EditName extends AppCompatActivity {
    public EditText editName1, editName2;
    public RadioGroup radioGroup1,radioGroup2;
    public RadioButton radioButton1,radioButton2;
  public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);



        editName1 = findViewById(R.id.editText1);
        editName2 = findViewById(R.id.editText2);
        radioGroup1=findViewById(R.id.radio1);
        radioGroup2=findViewById(R.id.radio2);
        Button button = findViewById(R.id.savebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioButton1=findViewById((radioGroup1.getCheckedRadioButtonId()));
                String symbl1=radioButton1.getText().toString();
                radioButton2=findViewById((radioGroup2.getCheckedRadioButtonId()));
                String symbl2=radioButton2.getText().toString();
                String name1 = editName1 .getText().toString();
                String name2 = editName2.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name1", name1);
                bundle.putString("symbl1",symbl1);

                bundle.putString("name2", name2);
                bundle.putString("symbl2",symbl2);
                Intent intent = new Intent(EditName.this, MainActivity2.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}