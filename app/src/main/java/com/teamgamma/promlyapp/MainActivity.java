package com.teamgamma.promlyapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,profile2.class);
            startActivity(intent);
        });

        button = (Button)findViewById(R.id.profile4);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,profile4.class);
            startActivity(intent);
        });

        button = (Button)findViewById(R.id.one_by_2day);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,one_by_2day.class);
            startActivity(intent);
        });

    }
}