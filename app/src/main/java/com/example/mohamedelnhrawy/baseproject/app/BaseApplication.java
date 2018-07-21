package com.example.mohamedelnhrawy.baseproject.app;

import android.app.Application;

import android.content.res.Configuration;
import android.util.Log;

import com.example.mohamedelnhrawy.baseproject.network.ApiFactory;
import com.example.mohamedelnhrawy.baseproject.network.Service;
import com.example.mohamedelnhrawy.baseproject.util.SharedPref;

import java.util.Locale;

/**
 * Created by cems-it on 6/10/2018.
 */

public class BaseApplication extends Application{
    SharedPref ecommerceSharedPref;
    private Locale locale = null;
    public static Service service;


    public static Service getAppService() {
        service = ApiFactory.create();
        return service;
    }
    @Override
    public void onCreate() {
        super.onCreate();


        ecommerceSharedPref = new SharedPref(getApplicationContext());

        Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = ecommerceSharedPref.getLanguage();

        if (lang != null && !lang.equals("")) {
            Log.e("Lang", "lang in Applciation Class : " + lang);


            locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }else
        {
            // get default lang
            ecommerceSharedPref.setLanguage(Locale.getDefault().getLanguage());
            Log.e("Lang", "first run lang is like device : "+Locale.getDefault().getLanguage());

        }
    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (locale != null) {
            newConfig.locale = locale;
            Locale.setDefault(locale);
            getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}
