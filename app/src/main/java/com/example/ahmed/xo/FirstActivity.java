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


    ImageView selectedParty;

    public String selectedStranka = "";
    public String player1="";
    public String player2="";

    ImageView playerSelection;



    int [] tags = {10, 11, 12, 13, 14, 15};
    ImageView sda;
    ImageView hdz;
    ImageView sbb;
    ImageView nasaStranka;
    ImageView sdp;
    ImageView snsd;

    public void tappedParty(View view){

        selectedParty = (ImageView) view;

        selectedParty.setVisibility(View.GONE);


        String selectedStranka = (String) selectedParty.getTag();


        if (player1 == ""){

            player1=selectedStranka;

            Toast.makeText(this, "Prvi igrac je izabrao " + selectedStranka.toUpperCase(), Toast.LENGTH_SHORT).show();

        }else if (player2 ==""){

            player2 = selectedStranka;

            Toast.makeText(this,"Drugi igrac je izabrao " +  selectedStranka.toUpperCase(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Player1", player1);
            intent.putExtra("Player2", player2);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        selectedStranka = "";
        player1 = "";
        player2 = "";

        sda.setVisibility(View.VISIBLE);
        hdz.setVisibility(View.VISIBLE);
        sbb.setVisibility(View.VISIBLE);
        nasaStranka.setVisibility(View.VISIBLE);
        sdp.setVisibility(View.VISIBLE);
        snsd.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_first);


        sda = findViewById(R.id.imageView10);
        hdz = findViewById(R.id.imageView11);
        sbb = findViewById(R.id.imageView12);
        nasaStranka = findViewById(R.id.imageView13);
        sdp = findViewById(R.id.imageView14);
        snsd = findViewById(R.id.imageView15);

    }

    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
