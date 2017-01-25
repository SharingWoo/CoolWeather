package com.coolweather.app.coolweather.actiivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.coolweather.app.coolweather.R;
import com.coolweather.app.coolweather.application.MarkApplication;

public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //judge if we have to skip the welcome view.
        if (MarkApplication.SKIP_WELCOME) {
            Intent intent = new Intent(StartActivity.this, BasicShowActivity.class);
            startActivity(intent);
            finish();
        }
        //change the signal to skip the welcome view when the next time we start the app after a short duration
        MarkApplication.SKIP_WELCOME = true;

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setBackgroundColor(0);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(StartActivity.this, BasicShowActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        alphaAnimation.setFillAfter(true);
        imageView.setAnimation(alphaAnimation);
    }
}
