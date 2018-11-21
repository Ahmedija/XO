package com.example.ahmed.xo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button button;

    ImageView selectedParty;

    int player1=0;
    int player2=0;

    ImageView playerSelection;



    int [] tags = {10, 11, 12, 13, 14, 15};

    public void tappedParty(View view){

        selectedParty = (ImageView) view;



        int selectedStranka = Integer.parseInt((String) selectedParty.getTag());

        if (player1 == 0){

            player1=selectedStranka;

        }else if (player2 ==0){

            player2 = selectedStranka;
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ImageView sda = findViewById(R.id.imageView10);
        ImageView hdz = findViewById(R.id.imageView11);
        ImageView sbb = findViewById(R.id.imageView12);
        ImageView nasaStranka = findViewById(R.id.imageView13);
        ImageView sdp = findViewById(R.id.imageView14);
        ImageView snsd = findViewById(R.id.imageView15);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
