package com.example.neha.attendancesystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private  static int SPLASH_TIME_OUT= 4000;
    ImageView splImg;
    TextView splTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splImg=(ImageView)findViewById(R.id.splImg);
        splTv=(TextView)findViewById(R.id.splTv);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        splImg.startAnimation(myanim);

            Animation myanim1 = AnimationUtils.loadAnimation(this, R.anim.mytransition1);
            myanim1.reset();
            splTv.clearAnimation();
            splTv.startAnimation(myanim1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent I= new Intent(Splash.this,MainActivity.class);
                startActivity(I);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
