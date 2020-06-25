package com.hasanmehedi.bioflocapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class SeedplaceActivity extends AppCompatActivity {
    private AdView mAdView;

    Button btnSet;
    EditText etVal;
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(this);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seedplace);
        btnSet = (Button)findViewById(R.id.btnSetAlarm);
        etVal = (EditText)findViewById(R.id.etVal);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(etVal.getText().toString());
                Intent intent=new Intent(SeedplaceActivity.this, Alarm.class);
                PendingIntent p1=PendingIntent.getBroadcast(getApplicationContext(),0, intent,0);
                AlarmManager a=(AlarmManager)getSystemService(ALARM_SERVICE);
                a.set(AlarmManager.RTC,System.currentTimeMillis() + time*1000,p1);
                //Toast.makeText(getApplicationContext(),"Alarm set in "+time+"seconds",Toast.LENGTH_LONG).show();

            }
        });


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
//    public void startAlert() {
//        EditText text = findViewById(R.id.time);
//        int i = Integer.parseInt(text.getText().toString());
//        Intent intent = new Intent(this, MyBroadcastReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
//        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pendingIntent);
//        Toast.makeText(this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();
//    }
}