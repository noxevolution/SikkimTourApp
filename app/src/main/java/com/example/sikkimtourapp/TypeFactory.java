package com.example.sikkimtourapp;

import android.content.Context;
import android.graphics.Typeface;

public class TypeFactory {
    final String OPENSANS_REGULAR="fonts/OpenSans-Regular.ttf";
    final String OPENSANS_SEMIBOLD="fonts/OpenSans-SemiBold.ttf";
    final String OPENSANS_BOLD="fonts/OpenSans-Bold.ttf";
    final String OPENSANS_HEAVY="fonts/OpenSans-ExtraBold.ttf";

    Typeface regular;
    Typeface bold;
    Typeface heavy;
    Typeface semibold;

    public TypeFactory(Context context){
        regular = Typeface.createFromAsset(context.getAssets(),OPENSANS_REGULAR);
        bold = Typeface.createFromAsset(context.getAssets(),OPENSANS_BOLD);
        heavy = Typeface.createFromAsset(context.getAssets(),OPENSANS_HEAVY);
        semibold = Typeface.createFromAsset(context.getAssets(),OPENSANS_SEMIBOLD);
    }

    public Typeface getRegular(){
        return regular;
    }

    public Typeface getBold() {
        return bold;
    }

    public Typeface getHeavy() {
        return heavy;
    }

    public Typeface getSemibold() {
        return semibold;
    }
}
