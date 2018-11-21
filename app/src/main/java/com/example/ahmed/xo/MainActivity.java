package com.example.ahmed.xo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0=green player, 1=red player, 2=empty

    Button playAgainButton;
    TextView winnerTextView;
    android.support.v7.widget.GridLayout gridLayout;
    ImageView counter;


    int activePlayer = 0;
    boolean gameActive = true;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    /*Biranje stranke*/



    public void dropIn(View view) {

        counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {


                counter.setImageResource(R.drawable.green);

                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.red);

                activePlayer = 0;
            }

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    String winner = "";

                    gameActive = false;

                    if (activePlayer == 1) {

                        winner = "SDA";

                    } else {

                        winner = "SDP";
                    }


                    winnerTextView.setText(winner + " je apsolutni pobjednik.");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }


            counter.animate().translationYBy(1500).setDuration(400);
        }
    }



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

        gameActive = true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        gridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.gridLayout);


    }
}
