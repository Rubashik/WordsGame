package com.example.wordsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wordsgame.dialogs.InfoDialog;
import com.example.wordsgame.dialogs.UsernameDialog;
import com.example.wordsgame.dialogs.records.Records;

public class MainPageActivity extends AppCompatActivity implements UsernameDialog.UsernameDialogListener {

    private String userName;
    private Button startButton;
    private Button recordButton;
    private Button infoButton;
    private ImageButton changeNameBtn;
    private TextView usernameView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        startButton = (Button) findViewById(R.id.startBtn);
        recordButton = (Button) findViewById(R.id.recordBtn);
        infoButton = (Button) findViewById(R.id.infoBtn);
        changeNameBtn = (ImageButton) findViewById(R.id.changeNameBtn);
        usernameView = (TextView) findViewById(R.id.usernameView);


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (usernameView.getText().toString().isEmpty()) {
            openUsernameDialog();
        }


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
                        intent = new Intent(MainPageActivity.this, GameActivity.class);
                        intent.putExtra("USER_NAME", usernameView.getText().toString());
                        startActivity(intent);
                    }
                });

            }
        });//Running game

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
                        intent = new Intent(MainPageActivity.this, Records.class);
                        startActivity(intent);
                    }
                });

            }
        });//Opening records table

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
                        InfoDialog infoDialog = new InfoDialog();
                        infoDialog.show(getSupportFragmentManager(), "Info Dialog");
                        infoButton.setTranslationY(0);
                    }
                });

            }
        }); //Running InfoDialog

        changeNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUsernameDialog();
            }
        });//Button to change name of player
    }

    @Override
    protected void onResume() {
        super.onResume();
        startButton.setTranslationY(0);
        recordButton.setTranslationY(0);
        infoButton.setTranslationY(0);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    public void openUsernameDialog() {
        UsernameDialog usernameDialog = new UsernameDialog();
        usernameDialog.show(getSupportFragmentManager(), "Username Dialog");
    }

    @Override
    public void applyText(String username) {
        usernameView.setText("Hi,"+username+"!");
    }


}