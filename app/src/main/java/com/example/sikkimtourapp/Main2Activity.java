package com.example.sikkimtourapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity{

    LinearLayout myView;
    boolean isUp;
    LinearLayout lp;

    CustomTextView stay, travel, bottom_menu_title;
    ConstraintLayout mainlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        stay = findViewById(R.id.stayView);
        travel = findViewById(R.id.travelView);
        mainlayout = findViewById(R.id.mainlayout);
        bottom_menu_title = findViewById(R.id.bottom_menu_title);

        myView = findViewById(R.id.my_view);

        // initialize as invisible (could also do in xml)
        myView.setVisibility(View.INVISIBLE);
        isUp = false;

        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String click = "stay";
                onSlideViewButtonClick(myView, click);
            }
        });

        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String click = "travel";
                onSlideViewButtonClick(myView, click);
            }
        });

        mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUp){
                    slideDown(myView);

                    Runnable r = new Runnable() {
                        @Override
                        public void run(){
                            View myView = findViewById(R.id.add_view);
                            ViewGroup parent = (ViewGroup) myView.getParent();
                            parent.removeView(myView);
                        }
                    };

                    Handler h = new Handler();
                    h.postDelayed(r, 500);
                    isUp = !isUp;
                }

            }
        });
    }

    // slide the view from below itself to the current position
    public void slideUp(View view){
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),  // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    // slide the view from its current position to below itself
    public void slideDown(View view){
        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                0,                 // fromYDelta
                view.getHeight()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.INVISIBLE);
    }

    public void onSlideViewButtonClick(View view, String clicked) {
        if (!isUp) {
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(clicked.equals("stay")){
                View v = vi.inflate(R.layout.item_bottom_menu_stay, null);
                myView.addView(v);
                bottom_menu_title.setText("Stay at...");

                CustomTextView hotelView = (CustomTextView) v.findViewById(R.id.hotels);
                CustomTextView homestayView = (CustomTextView) v.findViewById(R.id.homestays);

                hotelView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Main2Activity.this, "Coming Soon...", Toast.LENGTH_SHORT).show();
                    }
                });

                homestayView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Main2Activity.this, "Coming Soon...", Toast.LENGTH_SHORT).show();
                    }
                });
            } else if(clicked.equals("travel")){
                View v = vi.inflate(R.layout.item_bottom_menu_travel, null);
                myView.addView(v);
                bottom_menu_title.setText("Travel by...");
            }

            slideUp(view);
            isUp = !isUp;
        }

    }
}
