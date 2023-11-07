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
            "Building","Pig","Server","Cloud","People","Sofa","Bird","Guitar","Phone","Rainbow","Accuracy"};

    protected void CreateNewText(TextView fallingText, float bottomOfScreen, Button retryButton){
        fallingText.findViewById(R.id.falling_text);
        retryButton.findViewById(R.id.retryButton);


        int score = 0;
        int randomIndex = new Random().nextInt(randomText.length);
        fallingText.setText(randomText[randomIndex]);
        randomIndex = new Random().nextInt(Resources.getSystem().getDisplayMetrics().widthPixels-40);

        fallingText.setVisibility(View.VISIBLE);
        fallingText.setTranslationY(0);
        fallingText.setTranslationX(randomIndex);


        fallingText.animate()
                .translationY(bottomOfScreen)
                .setInterpolator(new AccelerateInterpolator())
                .setDuration(7200);


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
