package com.example.wordsgame;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class FallingText {


    String[] randomText = new String[]{"Hello","Father","Mother","Chicken","Frog","Elephant","Car","Sun","Relation","Burger",
            "Building","Pig","Server","Cloud","People","Sofa",
            "Bird","Guitar","Phone","Rainbow","Accuracy","Android","Flower","Modern","Like",
            "Drum","Lobster","Wheel","Dialog","Farm","Levitation","Engine","Heart","Lake","River",
            "Boat","Block","Meat","Tree","Clutch","Brake","Pause","Jeans","Shirt","Hair","Football","Ball",
            "Beach","Sand","Soap","Beaver","Bear","Snake","Sea","Sandstorm","Motherland"};

    protected void CreateNewText(TextView fallingText, float bottomOfScreen, Button retryButton, int speed){
        fallingText.findViewById(R.id.falling_text);
        retryButton.findViewById(R.id.retryButton);


        int randomIndex = new Random().nextInt(randomText.length);
        fallingText.setText(randomText[randomIndex]);
        randomIndex = new Random().nextInt(Resources.getSystem().getDisplayMetrics().widthPixels*85/100);

        fallingText.setVisibility(View.VISIBLE);
        fallingText.setTranslationY(0);
        fallingText.setTranslationX(randomIndex);


        fallingText.animate()
                .translationY(bottomOfScreen)
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(speed);


        fallingText.animate().withEndAction(new Runnable() {

            @Override
            public void run() {
                retryButton.setVisibility(View.VISIBLE);
                fallingText.animate().cancel();
                fallingText.setText("restartTheGame");
            }
        });

    }

}
