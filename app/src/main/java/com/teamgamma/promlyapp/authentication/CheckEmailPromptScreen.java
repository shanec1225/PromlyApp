package com.teamgamma.promlyapp.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.teamgamma.promlyapp.R;

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

        //TODO: open mail app, not segue to disco ball
        Button openEmailButton = findViewById(R.id.openMailAppButton);
        openEmailButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToDiscoBall = new Intent(view.getContext(), DiscoSplashScreen.class);
                startActivity(segueToDiscoBall);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
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
        resendLinkButton.setTextColor(getResources().getColor(R.color.promly_brand_purple));
        resendLinkButton.setText(getString(R.string.resendLink));
        resendLinkButton.setEnabled(true);

    }

    }

