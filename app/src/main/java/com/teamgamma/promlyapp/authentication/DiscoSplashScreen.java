package com.teamgamma.promlyapp.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.teamgamma.promlyapp.R;
import com.teamgamma.promlyapp.onboarding.profile1;

public class DiscoSplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disco_splash_screen);

        //TODO: Check for successful Login before segue to onboarding

        ImageView discoBall = findViewById(R.id.discoBallButton);
        discoBall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToOnboarding = new Intent(view.getContext(), profile1.class);
                startActivity(segueToOnboarding);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

        });
    }
}
