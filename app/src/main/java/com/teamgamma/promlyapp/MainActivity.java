package com.teamgamma.promlyapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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

        button = (Button) findViewById(R.id.p1_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToProfile1 = new Intent(view.getContext(), profile1.class);
                startActivity(segueToProfile1);

            }

        });
        button = (Button)findViewById(R.id.p3_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,profile3.class);
                startActivity(intent);

            }

        });

    }

}