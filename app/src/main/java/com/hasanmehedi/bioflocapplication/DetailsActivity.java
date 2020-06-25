package com.hasanmehedi.bioflocapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.ConstraintTableLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.hasanmehedi.bioflocapplication.details.detail_1;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    private AdView mAdView;
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(this);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        LinearLayout linearLayout  =findViewById(R.id.animation);
        AnimationDrawable animationDrawable= (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

       // MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        }

        @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnQ1:
                Toast.makeText(getApplicationContext(),
                        "BUTTON 1  CLICKED", Toast.LENGTH_LONG)
                        .show();
                Intent intent = new Intent(this, detail_1.class);
                startActivity(intent);
                // do your code
                break;

            case R.id.btnQ2:
                // do your code
                Toast.makeText(getApplicationContext(),
                        "BUTTON 2  CLICKED", Toast.LENGTH_LONG)
                        .show();

                break;

            case R.id.btnQ4:
                // do your code

                Toast.makeText(getApplicationContext(),
                        "BUTTON 3  CLICKED", Toast.LENGTH_LONG)
                        .show();
                break;

            default:
                break;
        }

    }


}

