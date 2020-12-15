package com.example.myintent;
        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentTransaction;

        import android.content.DialogInterface;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,restart,Save,View ;

    TextView headerText;
    DatabaseHelpe mydb;
    String name;


    String name1="Player1";
    String symbl1="O";
    String name2="Player2";
    String symbl2="X";

    int PLAYER_O = 0;
    int PLAYER_X = 1;

    int activePlayer = PLAYER_O;

    int[] filledPos = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    boolean isGameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        mydb = new DatabaseHelpe(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name1 = bundle.getString("name1");
            symbl1 = bundle.getString("symbl1");
            name2 = bundle.getString("name2");
            symbl2 = bundle.getString("symbl2");


        }

        headerText = findViewById(R.id.header_text);
        headerText.setText("turn of   "+name1);


        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        restart=findViewById(R.id.restart);
        Save=findViewById(R.id.savedata);
        View=findViewById((R.id.viewdata));

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        // logic for button press

        if(!isGameActive)
            return;

        Button clickedBtn = findViewById(v.getId());
        int clickedTag = Integer.parseInt(v.getTag().toString());

        if(filledPos[clickedTag] != -1){
            return;
        }

        filledPos[clickedTag] = activePlayer;

        if(activePlayer == PLAYER_O){
            clickedBtn.setText(symbl1);
            clickedBtn.setBackground(getDrawable(android.R.color.holo_blue_bright));
            activePlayer = PLAYER_X;
            headerText.setText("Turn of  "+name2);


        }else{
            clickedBtn.setText(symbl2);
            clickedBtn.setBackground(getDrawable(android.R.color.holo_orange_light));
            activePlayer = PLAYER_O;
            headerText.setText("Turn of  "+name1);
        }

        checkForWin();

    }

    private void checkForWin(){
        int count=0;
        //we will check who is winner and show
        int[][] winningPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        for(int i =0 ;i<8;i++){
            int val0  = winningPos[i][0];
            int val1  = winningPos[i][1];
            int val2  = winningPos[i][2];

            if(filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]){
                if(filledPos[val0] != -1){
                    //winner declare

                    isGameActive = false;

                    if(filledPos[val0] == PLAYER_O) {
                        headerText.setText(" The winner is  " + name1);
                        name=name1;
                    }
                    else {
                        name=name2;
                        headerText.setText(" The winner is  " + name2);
                    }
                }
            }
        }

        for(int i=0;i<9;i++) {
            if(filledPos[i] != -1) {
                count++;
            }


            if (count==9) {
                name="The match is drawn";
                headerText.setText(name);

            }

        }



    }





    public void GameRestart(View view) {
        activePlayer = PLAYER_O;
        headerText.setText("Turn of  "+name1);
        filledPos = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");

        btn0.setBackground(getDrawable(android.R.color.darker_gray));
        btn1.setBackground(getDrawable(android.R.color.darker_gray));
        btn2.setBackground(getDrawable(android.R.color.darker_gray));
        btn3.setBackground(getDrawable(android.R.color.darker_gray));
        btn4.setBackground(getDrawable(android.R.color.darker_gray));
        btn5.setBackground(getDrawable(android.R.color.darker_gray));
        btn6.setBackground(getDrawable(android.R.color.darker_gray));
        btn7.setBackground(getDrawable(android.R.color.darker_gray));
        btn8.setBackground(getDrawable(android.R.color.darker_gray));
        isGameActive = true;
    }


    public void ResultSave(View view) {
        if(mydb.insertData(name)==-1){
            Toast.makeText(this, "Insertion Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Insertation Done", Toast.LENGTH_SHORT).show();
        }

    }


    public void ViewData(android.view.View view) {
        Cursor result = mydb.ViewData();
        if (result.getCount() == 0) {
            Toast.makeText(this, "no data found", Toast.LENGTH_SHORT).show();
        } else {
            StringBuffer mybuffer = new StringBuffer();
            while (result.moveToNext()){
                mybuffer.append(result.getString(1)+"\n" );

            }
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
            builder.setCancelable(true);
            builder.setTitle("Match winners:");
            builder.setMessage(mybuffer.toString());
            builder.show();
        }


    }


}




