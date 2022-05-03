package com.teamgamma.promlyapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.profile2);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,profile2.class);
            startActivity(intent);
        });

        button = findViewById(R.id.profile4);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,profile4.class);
            startActivity(intent);
        });

        button = findViewById(R.id.one_by_2day);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,OneBy2day.class);
            startActivity(intent);
        });

    }
}