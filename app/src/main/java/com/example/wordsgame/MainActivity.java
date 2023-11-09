package com.example.wordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int score = 0;
    final private int startingSpeed = 12000;
    private int speed=startingSpeed;

    private TextView falling_text;
    private EditText enteredText;
    private TextView scoreText;
    private Button retryButton;
    private RelativeLayout gameZone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falling_text = (TextView) findViewById(R.id.falling_text);
        enteredText = (EditText) findViewById(R.id.editText);
        scoreText = (TextView) findViewById(R.id.score);
        retryButton = (Button) findViewById(R.id.retryButton);
        gameZone = (RelativeLayout) findViewById(R.id.gameZone);



        ViewTreeObserver viewTreeObserver = gameZone.getViewTreeObserver();

        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                gameZone.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                View fallingText = findViewById(R.id.falling_text);

                int gameZoneHeight = gameZone.getHeight();
                int fallingTextHeight = fallingText.getHeight();
                float bottomOfScreen = gameZoneHeight - fallingTextHeight;

                FallingText fallingClass = new FallingText();
                fallingClass.CreateNewText(falling_text, bottomOfScreen, retryButton, speed);



                enteredText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                        if (falling_text.getText().toString().equalsIgnoreCase(s.toString())) {
                            // Update the score, reset the EditText and create new word
                            score++;
                            scoreText.setText("Score: " + score);
                            enteredText.setText("");
                            speed=speed-300;
                            fallingClass.CreateNewText(falling_text, bottomOfScreen, retryButton, speed);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                retryButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Reset the game state
                        score = 0;
                        speed = startingSpeed;
                        enteredText.setText("");
                        scoreText.setText("Score: " + score);
                        fallingClass.CreateNewText(falling_text, bottomOfScreen, retryButton, speed);
                        retryButton.setVisibility(View.GONE); // Hide the retry button again
                    }
                });
            }
        });


    }
}