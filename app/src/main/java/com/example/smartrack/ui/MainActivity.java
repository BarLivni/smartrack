package com.example.smartrack.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartrack.R;

public class MainActivity extends AppCompatActivity {
    private static int TIME_OUT=2000;

    ImageView image;
    TextView appName, slogan;
    Animation topAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animation
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation_splashscreen);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation_spashscreen);

        //Hooks
        image=findViewById(R.id.imageLogo);
        appName=findViewById(R.id.textViewTitle);
        slogan=findViewById(R.id.textViewSlogan);

        appName.setAnimation(topAnim);
        image.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,MainLandingPage.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);


/*
        //Wellcome logo screen
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(TIME_OUT);
                        Intent intent = new Intent (MainActivity.this,LoginPage.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



*/


    }
}