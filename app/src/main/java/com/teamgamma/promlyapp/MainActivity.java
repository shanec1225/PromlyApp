package com.teamgamma.promlyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button m1by2day = findViewById(R.id.button1By2Day);
        m1by2day.setOnClickListener(view -> {
            // Switch MainActivity.class with 1by2day class so that when it is pressed it goes to 1by2day
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button mHustle = findViewById(R.id.buttonHustle);
        mHustle.setOnClickListener(view -> {
            // Switch MainActivity.class with hustle class so that when it is pressed it goes to hustle
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

}