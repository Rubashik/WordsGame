package com.example.wordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView falling_text = (TextView) findViewById(R.id.falling_text);
        EditText enteredText = (EditText) findViewById(R.id.editText);
        TextView scoreText = (TextView) findViewById(R.id.score);
        Button retryButton = (Button) findViewById(R.id.retryButton);

        float bottomOfScreen = getResources().getDisplayMetrics()
                .heightPixels - (falling_text.getHeight() * 4);
        //bottomOfScreen is where you want start animate to

        FallingText fallingClass = new FallingText();
        fallingClass.CreateNewText(falling_text, bottomOfScreen, retryButton);



        enteredText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (falling_text.getText().toString().equalsIgnoreCase(s.toString())) {
                    // Update the score and reset the EditText
                    score++;
                    scoreText.setText("Score: " + score);
                    enteredText.setText("");
                    fallingClass.CreateNewText(falling_text, bottomOfScreen, retryButton);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });





    }
}