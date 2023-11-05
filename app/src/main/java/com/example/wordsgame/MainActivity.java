package com.example.wordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView falling_text = (TextView) findViewById(R.id.falling_text);

        float bottomOfScreen = getResources().getDisplayMetrics()
                .heightPixels - (falling_text.getHeight() * 4);
        //bottomOfScreen is where you want start animate to

        FallingText fallingClass = new FallingText();



        fallingClass.CreateNewText(falling_text, bottomOfScreen);

    }
}