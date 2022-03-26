package com.teamgamma.promlyapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.RIGHT);

            getWindow().setEnterTransition(slide);
        }

    }
    public void onEmailButtonClicked(View view) {
        Intent segueToMagicLinkScreen = new Intent(view.getContext(), MagicLinkScreen.class);
        startActivity(segueToMagicLinkScreen);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }
}
