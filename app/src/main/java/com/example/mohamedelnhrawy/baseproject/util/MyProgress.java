package com.example.mohamedelnhrawy.baseproject.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by mohamedelnhrawy on 7/21/18.
 */

public class MyProgress {

    private static ProgressDialog progress;
    public static void show(Context context){
        progress = new ProgressDialog(context);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setCancelable(false);
        progress.show();

    }
    public static void dismiss(){
        if (progress != null)
        progress.dismiss();

    }
}
