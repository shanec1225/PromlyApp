package com.teamgamma.promlyapp;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class GoalFullscreen extends AppCompatActivity {

    ToggleButton onlyMeCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_fullscreen);

        LinearLayout onlyMeStack = findViewById(R.id.onlyMeStack);
        onlyMeCheck = findViewById(R.id.onlyMeCheck);
        TextView setButton = findViewById(R.id.setButton);
        EditText goalText = findViewById(R.id.goalText);
        LinearLayout bottomStack = findViewById(R.id.bottomStack);

        onlyMeStack.setVisibility(View.GONE);
        setButton.setVisibility(View.GONE);


        goalText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                bottomStack.setVisibility(View.GONE);
                onlyMeStack.setVisibility(View.VISIBLE);
                setButton.setVisibility(View.VISIBLE);
            }
        });

    }
    public void onlyMeToggle(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            onlyMeCheck.setBackground(getResources().getDrawable(R.drawable.promly_check_empty));
        } else {
            onlyMeCheck.setBackground(getResources().getDrawable(R.drawable.promly_check_small));
        }
    }

}
