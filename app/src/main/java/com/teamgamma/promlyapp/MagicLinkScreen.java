package com.teamgamma.promlyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MagicLinkScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magic_link_screen);

        Button sendMagicLinkButton = findViewById(R.id.sendMagicLinkButton);
        sendMagicLinkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToCheckEmailPromptScreen = new Intent(view.getContext(), CheckEmailPromptScreen.class);
                startActivity(segueToCheckEmailPromptScreen);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

        });

        Button backButton = findViewById(R.id.backToLoginScreenFromMagicLinkScreen);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueBackToLoginScreen = new Intent(view.getContext(), LoginScreen.class);
                startActivity(segueBackToLoginScreen);
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }

        });
    }
}
