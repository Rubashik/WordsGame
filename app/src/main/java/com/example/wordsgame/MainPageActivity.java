package com.example.wordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

public class MainPageActivity extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button startButton = (Button) findViewById(R.id.startBtn);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startButton.animate()
                        .translationY(Resources.getSystem().getDisplayMetrics().heightPixels)
                        .setInterpolator(new AccelerateInterpolator())
                        .setDuration(2000);
                startButton.animate().withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(MainPageActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });


    }
}