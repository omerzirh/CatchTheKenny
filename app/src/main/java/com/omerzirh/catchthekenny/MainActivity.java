package com.omerzirh.catchthekenny;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button oyunButton;
    TextView scoreText;
    TextView timeText;
    TextView finalScore;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
        int score;
    ImageView [] arrayImage;

    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        score=0;

        hideImages();

        new CountDownTimer(60000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

                timeText = findViewById(R.id.textTime);
                timeText.setText("Time:"+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText = findViewById(R.id.textTime);
                timeText.setText("Game Over");
                oyunButton.setVisibility(View.VISIBLE);

                handler.removeCallbacks(runnable);
                for (ImageView image:arrayImage){

                    image.setVisibility(View.INVISIBLE);

                }


            }
        }.start();
    }

    public void increaseScore(View view){

        scoreText = findViewById(R.id.textScore);

        score++;

        scoreText.setText("Score:"+score);

    }
    public void hideImages(){

        oyunButton = findViewById(R.id.oyun);
        arrayImage = new ImageView[]{imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12};
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image:arrayImage){

                   image.setVisibility(View.INVISIBLE);

                }
                Random rand = new Random();
                int r = rand.nextInt(8-0);
                arrayImage[r].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }
    public  void anaMenu(){

        Intent intent = getIntent();
        finish();

        startActivity(intent);

    }
}
