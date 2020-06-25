package com.hasanmehedi.bioflocapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

            LinearLayout linearLayout  =findViewById(R.id.Welcomeanimation);
            AnimationDrawable animationDrawable= (AnimationDrawable) linearLayout.getBackground();
            animationDrawable.setEnterFadeDuration(1000);
            animationDrawable.setExitFadeDuration(2000);
            animationDrawable.start();

        Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i =new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(i);

                finish();

            }
        },5000);
        //Animatoo.animateFade(this);
        //animationDrawable.stop();
    }
}


