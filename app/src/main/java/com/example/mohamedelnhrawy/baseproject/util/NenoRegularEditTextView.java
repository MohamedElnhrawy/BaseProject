package com.example.mohamedelnhrawy.baseproject.util;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;


public class NenoRegularEditTextView extends EditText
{

    public NenoRegularEditTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "UniversNextArabic-Regular.ttf");
        this.setTypeface(face);
    }
    public NenoRegularEditTextView(Context context)
    {
        super(context);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "UniversNextArabic-Regular.ttf");
        this.setTypeface(face);
    }

    public NenoRegularEditTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        Typeface face= Typeface.createFromAsset(context.getAssets(), "UniversNextArabic-Regular.ttf");
        this.setTypeface(face);
    }


    @Override
    protected void onDraw (Canvas canvas)
    {
        super.onDraw(canvas);
    }
}
