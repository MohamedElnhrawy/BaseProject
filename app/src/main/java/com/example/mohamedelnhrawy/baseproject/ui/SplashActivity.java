package com.example.mohamedelnhrawy.baseproject.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mohamedelnhrawy.baseproject.R;
import com.example.mohamedelnhrawy.baseproject.ui.main.MainActivity;
import com.example.mohamedelnhrawy.baseproject.util.SharedPref;

public class SplashActivity extends AppCompatActivity {

    public static int SPLASH_DISPLAY_LENGTH=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash();
    }

    private void splash()
    {

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                if(SharedPref.getUserLogin()){
                    Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();

                }
                else {
                    Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }

            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
