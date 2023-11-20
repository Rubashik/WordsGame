package com.example.wordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.wordsgame.dialogs.UsernameDialog;

import org.w3c.dom.Text;

public class MainPageActivity extends AppCompatActivity implements UsernameDialog.UsernameDialogListener {

    private String userName;
    private Button startButton;
    private Button recordButton;
    private Button infoButton;
    private TextView usernameView;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        startButton = (Button) findViewById(R.id.startBtn);
        recordButton = (Button) findViewById(R.id.recordBtn);
        infoButton = (Button) findViewById(R.id.infoBtn);
        usernameView = (TextView) findViewById(R.id.usernameView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        openDialog();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                startButton.animate()
                        .translationY(Resources.getSystem().getDisplayMetrics().heightPixels)
                        .setInterpolator(new AccelerateInterpolator())
                        .setDuration(1700);
                startButton.animate().withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(MainPageActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordButton.animate()
                        .translationY(Resources.getSystem().getDisplayMetrics().heightPixels)
                        .setInterpolator(new AccelerateInterpolator())
                        .setDuration(1700);
                recordButton.animate().withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(MainPageActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                infoButton.animate()
                        .translationY(Resources.getSystem().getDisplayMetrics().heightPixels)
                        .setInterpolator(new AccelerateInterpolator())
                        .setDuration(1700);
                infoButton.animate().withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        intent = new Intent(MainPageActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        startButton.setTranslationY(0);
        recordButton.setTranslationY(0);
        infoButton.setTranslationY(0);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public void openDialog(){
        UsernameDialog usernameDialog = new UsernameDialog();
        usernameDialog.show(getSupportFragmentManager(), "Username Dialog");
    }

    @Override
    public void applyText(String username) {
        usernameView.setText(username);
    }
}