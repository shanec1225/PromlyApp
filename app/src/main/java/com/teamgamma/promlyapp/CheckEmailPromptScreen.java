package com.teamgamma.promlyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CheckEmailPromptScreen extends AppCompatActivity {

    Button resendLinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_email_prompt_screen);

        resendLinkButton = findViewById(R.id.resendLinkButton);
        resendLinkButton.setAlpha((float)0.5);
        resendLinkButton.setEnabled(false);
        resendLinkButton.setText(getString(R.string.resendCodeWait));

        Button backButton = findViewById(R.id.backToMagicLinkScreenFromCheckEmailPromptScreen);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueBackToMagicLinkScreen = new Intent(view.getContext(), MagicLinkScreen.class);
                startActivity(segueBackToMagicLinkScreen);
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }

        });

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countdownStarter = 5;
            //TODO: change to 60

            public void run() {
                String countdownText = getString(R.string.resendCodeWait, countdownStarter);
                resendLinkButton.setText(countdownText);
                countdownStarter--;
                System.out.println(countdownStarter);
                if (countdownStarter < 0) {
                    changeResendLinkText();
                    System.out.println("Timer Over!");
                    scheduler.shutdown();

                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }

    void changeResendLinkText() {
        resendLinkButton.setAlpha((float)1.0);
        resendLinkButton.setTextColor(getResources().getColor(R.color.purple_gradient_left));
        resendLinkButton.setText(getString(R.string.resendLink));
        resendLinkButton.setEnabled(true);

    }

    }

