package com.example.wordsgame;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class FallingText {


    private ObjectAnimator fallAnimation;
    private AnimatorSet animatorSet;
    private boolean isEntered = false;

    private String[] randomText = new String[]{"Hello","Father","Mother","Chicken","Frog","Elephant","Car","Sun","Relation","Burger",
            "Building","Pig","Server","Cloud","People","Sofa","Bug",
            "Bird","Guitar","Phone","Rainbow","Accuracy","Android","Flower","Modern","Like",
            "Drum","Lobster","Wheel","Dialog","Farm","Levitation","Engine","Heart","Lake","River",
            "Boat","Block","Meat","Tree","Clutch","Brake","Pause","Jeans","Shirt","Hair","Football","Ball",
            "Beach","Sand","Soap","Beaver","Bear","Snake","Sea","Sandstorm","Motherland"};

    protected void CreateNewText(TextView fallingText, float bottomOfScreen, Button retryButton, int speed){
        fallingText.findViewById(R.id.falling_text);
        retryButton.findViewById(R.id.retryButton);
        setEntered(false);

        int criticalChance = new Random().nextInt(100);
        int randomIndex = new Random().nextInt(randomText.length);
        fallingText.setText(randomText[randomIndex]);
        randomIndex = new Random().nextInt(Resources.getSystem().getDisplayMetrics().widthPixels*85/100);

        fallingText.setVisibility(View.VISIBLE);
        fallingText.setTranslationY(0);
        fallingText.setTranslationX(randomIndex);

        animatorSet = new AnimatorSet();
        fallAnimation = ObjectAnimator.ofFloat(fallingText, "translationY", bottomOfScreen);
        ObjectAnimator shakeAnimation = ObjectAnimator.ofFloat(fallingText, "translationX", -5+randomIndex, 5+randomIndex);

        if(criticalChance>80){
            fallingText.setTextColor(Color.parseColor("#FF0000"));
            shakeAnimation.setDuration(30);
            shakeAnimation.setRepeatCount(ObjectAnimator.INFINITE);
            shakeAnimation.setInterpolator(new LinearInterpolator());

            // Falling animation
            fallAnimation.setInterpolator(new AccelerateInterpolator());
            fallAnimation.setDuration(speed - 3000);

            // Play both animations simultaneously
            animatorSet.playTogether(shakeAnimation, fallAnimation);
            animatorSet.start();
        }else {
            fallingText.setTextColor(Color.parseColor("#FF000000"));
            fallAnimation.setInterpolator(new AccelerateInterpolator());
            fallAnimation.setDuration(speed);
            fallAnimation.start();
        }

        fallAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if(isEntered == false) {
                    retryButton.setVisibility(View.VISIBLE);
                    fallingText.setText("restartTheGame");
                    fallingText.setVisibility(View.GONE);
                }
            }

        });
    }

    public void stopAnimation(){
        fallAnimation.cancel();
        animatorSet.cancel();
    }

    public boolean isEntered() {
        return isEntered;
    }

    public void setEntered(boolean entered) {
        isEntered = entered;
    }
}
