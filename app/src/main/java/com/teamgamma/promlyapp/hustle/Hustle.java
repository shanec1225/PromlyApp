package com.teamgamma.promlyapp.hustle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.teamgamma.promlyapp.R;
import com.teamgamma.promlyapp.onboarding.profile3;

public class Hustle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hustle);

        // Main Serve button on top
        ImageView serveButton = findViewById(R.id.serveButton);
        serveButton.setOnClickListener(view -> {
            // Switch to serve screen
            Intent segueToServe = new Intent(view.getContext(), Serve.class);
            startActivity(segueToServe);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        });

        // "more" button above serve section
        TextView moreServe = findViewById(R.id.moreServeButton);
        moreServe.setOnClickListener(view -> {
            // Switch to serve screen
            Intent segueToServe = new Intent(view.getContext(), Serve.class);
            startActivity(segueToServe);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        });

    }
}
