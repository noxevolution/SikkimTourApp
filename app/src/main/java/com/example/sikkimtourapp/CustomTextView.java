package com.example.sikkimtourapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView extends TextView {

    private int typefaceType;

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView,
                0, 0);
        try {
            typefaceType = array.getInteger(R.styleable.CustomTextView_font_name,0);
        }finally {
            array.recycle();
        }
        if(!isInEditMode()){
            setTypeface(CustomApp.getApp().getTypeFace(typefaceType));
        }
    }
}
