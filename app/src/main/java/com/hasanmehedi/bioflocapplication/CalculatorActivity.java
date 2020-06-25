package com.hasanmehedi.bioflocapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;


public class CalculatorActivity extends AppCompatActivity {
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(this);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
}