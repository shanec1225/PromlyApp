package com.teamgamma.promlyapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ViewGoals extends AppCompatActivity {
    Button mSet1By2Day;
    ImageView mPinkCheck,mPinkGradient;
    TextView mDate;
    FrameLayout mFrameLayout;
    int buttonClickCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);

        // setting and formatting the date
        mDate=findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("E, MMM dd", Locale.forLanguageTag("US"));
        String currentDateandTime = sdf.format(new Date());

        //Button that sets 1by2day and changes button text
        mSet1By2Day = findViewById(R.id.buttonSet1By2Day);
        mSet1By2Day.setOnClickListener(view -> {
            // button click count is used for counting number of times it is clicked and
            // setting the correct button text/text view
            buttonClickCount++;
            Log.d("button count ",""+buttonClickCount);
            mDate.setText(currentDateandTime);
            // buttonClick count is when the user has already pressed set goal once
            if(buttonClickCount == 1)
            {
                mSet1By2Day.setText("I did this!");
            }
            // if the user clicks that they did their 1by2day the set a goal frame becomes visible
            else
            {
                mSet1By2Day.setVisibility(View.INVISIBLE);
                mPinkCheck = findViewById(R.id.pinkCheck);
                mPinkCheck.setVisibility(View.VISIBLE);

                mPinkGradient = findViewById(R.id.pinkGradient);
                mFrameLayout = findViewById(R.id.frameLayout);
                mFrameLayout = findViewById(R.id.goalsDone);
                mFrameLayout.setVisibility(View.VISIBLE);
            }
        });
    }
}