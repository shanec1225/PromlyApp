package com.teamgamma.promlyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.view.View;


import com.teamgamma.promlyapp.onboarding.profile2;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button m1by2day = findViewById(R.id.button1By2Day);
        m1by2day.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent segueTo1by2day = new Intent(view1.getContext(), profile2.class);
                startActivity(segueTo1by2day);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            };
        });

        Button mHustle = findViewById(R.id.buttonHustle);
        mHustle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent segueToHustle = new Intent(view1.getContext(), profile2.class);
                startActivity(segueToHustle);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            };
        });

    }

}