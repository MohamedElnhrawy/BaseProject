package com.example.mohamedelnhrawy.baseproject.base;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.mohamedelnhrawy.baseproject.ui.SplashActivity;
import com.example.mohamedelnhrawy.baseproject.util.SharedPref;

import java.util.Locale;

/**
 * Created by cems-it on 6/10/2018.
 */

public class AppBaseActivity extends AppCompatActivity{
    SharedPref ecommerceSharedPref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ecommerceSharedPref = new SharedPref(getApplicationContext());
    }

    // use these two message when change lang .....
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void setLocale(String lang)
    {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        config.setLayoutDirection(locale);
        getBaseContext().getResources().updateConfiguration(config,  getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(this, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
        setLanguage(lang);
    }

    public void setLanguage(String language)
    {
        // Add UserID to the prefs....
        ecommerceSharedPref.setLanguage(language);
        Log.e("Lang", "Language in the prefs is : " + ecommerceSharedPref.getLanguage());
    }

    ////////////////////////////////////////////////////////////////////////
    public String getLanguage()
    {
        return ecommerceSharedPref.getLanguage();
    }

}
