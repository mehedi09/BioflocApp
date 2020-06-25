package com.hasanmehedi.bioflocapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {

   // Timer timer;

    DatabaseHelper myDb;
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setting the title
        //toolbar.setTitle("My Toolbar");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);








        myDb =new DatabaseHelper(this);

        LinearLayout linearLayout  =findViewById(R.id.dash_animation);
        AnimationDrawable animationDrawable= (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

      //  Thread thread =new Thread();

    }


//    Animatoo.animateZoom(context);
//Animatoo.animateFade(context);
//Animatoo.animateWindmill(context);
//Animatoo.animateSpin(context);
//Animatoo.animateDiagonal(context);
//Animatoo.animateSplit(context);
//Animatoo.animateShrink(context);
//Animatoo.animateCard(context);
//Animatoo.animateInAndOut(context);
//Animatoo.animateSwipeLeft(context);
//Animatoo.animateSwipeRight(context);
//Animatoo.animateSlideLeft(context);
//Animatoo.animateSlideRight(context);
//Animatoo.animateSlideDown(context);
//Animatoo.animateSlideUp(context);

    public void details_click(View view) {
        // Do something in response to button click
      Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
       // startActivity(new Intent(context, TargetActivity.class));
        Animatoo.animateFade(this);  //fire the zoom animation
    }

    public void equipment_click(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, EquipmentlistActivity.class);
        startActivity(intent);

        Animatoo.animateFade(this);
    }


    public void calculator_click(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, CalculatorActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }
    public void fishmarket_click(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, FishmarketActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }
    public void seedplace_click(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, SeedplaceActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }


    public void video_click(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }

    public void food_click(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, FishfoodActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menuAbout:
                Toast.makeText(this, "You clicked about", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuProfile:
                Toast.makeText(this, "You clicked settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuLogout:
                //Toast.makeText(this, "You clicked logout", Toast.LENGTH_SHORT).show();

                SharedPreferences   Preferences=getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= Preferences.edit();
                editor.putString("remember","false");
                editor.apply();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);

                break;

        }
        return true;
    }

}
