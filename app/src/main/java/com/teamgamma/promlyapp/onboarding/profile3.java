package com.teamgamma.promlyapp.onboarding;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.teamgamma.promlyapp.R;

public class profile3 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile3);

        Button next = findViewById(R.id.profile3_Next);

        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent segueToProfile4 = new Intent(view1.getContext(), profile4.class);
                startActivity(segueToProfile4);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            };
        });

    }
}
