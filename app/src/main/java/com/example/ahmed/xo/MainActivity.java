package com.example.ahmed.xo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // 0=green player, 1=red player, 2=empty

    Button playAgainButton;
    Button difrentPartyButton;
    TextView winnerTextView;
    android.support.v7.widget.GridLayout gridLayout;
    ImageView counter;

    String pl1;
    String pl2;
    String winner = "";

    int activePlayer = 0;
    boolean gameActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int tieCounter=0;
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    /*Biranje stranke*/




    public void dropIn(View view) {

        counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            tieCounter++;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {

                switch (pl1){
                    case "sda":
                        counter.setImageResource(R.drawable.sda);
                        break;
                    case "sdp":
                        counter.setImageResource(R.drawable.sdp);
                        break;
                    case "snsd":
                        counter.setImageResource(R.drawable.snsd);
                        break;
                    case "hdz":
                        counter.setImageResource(R.drawable.hdz);
                        break;
                    case "sbb":
                        counter.setImageResource(R.drawable.sbb);
                        break;
                    case "nasastranka":
                        counter.setImageResource(R.drawable.nasastrankaa);
                        break;
                }

                activePlayer = 1;

            } else {

                switch (pl2){
                    case "sda":
                        counter.setImageResource(R.drawable.sda);
                        break;
                    case "sdp":
                        counter.setImageResource(R.drawable.sdp);
                        break;
                    case "snsd":
                        counter.setImageResource(R.drawable.snsd);
                        break;
                    case "hdz":
                        counter.setImageResource(R.drawable.hdz);
                        break;
                    case "sbb":
                        counter.setImageResource(R.drawable.sbb);
                        break;
                    case "nasastranka":
                        counter.setImageResource(R.drawable.nasastrankaa);
                        break;
                }

                activePlayer = 0;
            }

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {


                    gameActive = false;

                    if (activePlayer == 1) {

                        winner = pl1.toUpperCase();

                    } else {

                        winner = pl2.toUpperCase();
                    }


                    winnerTextView.setText(winner + " je apsolutni pobjednik.");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);

                    difrentPartyButton.setVisibility(View.VISIBLE);

                } else if(tieCounter==9 && winner == "") {

                    winnerTextView.setText("Nerijeseno je.");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);

                    difrentPartyButton.setVisibility(View.VISIBLE);

                }
            }

            counter.animate().translationYBy(1500).rotation(360).setDuration(500);
        }
    }


    /*Play again button method*/

    public void playAgain(View view) {

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {

            counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }


        for (int i = 0; i < gameState.length; i++) {

            gameState[i] = 2;
        }

        activePlayer = 0;

        tieCounter = 0;

        gameActive = true;

        winner = "";

        difrentPartyButton.setVisibility(View.INVISIBLE);
    }


    /*Restart with different parties button method */

    public void restartWithDifferentParty (View view){

        pl1="";
        pl2="";

        finish();



    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        gridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.gridLayout);
        difrentPartyButton = (Button) findViewById(R.id.difrentPartyButton);


        Intent intent = getIntent();

        getSupportActionBar().hide();

        pl1 = intent.getStringExtra("Player1");
        pl2 = intent.getStringExtra("Player2");

        playAgainButton.setVisibility(View.INVISIBLE);
        difrentPartyButton.setVisibility(View.INVISIBLE);



    }
}
