
package com.teamgamma.promlyapp.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.teamgamma.promlyapp.R;

public class profile1 extends AppCompatActivity
{
    LinearLayout p1_Button1;
    LinearLayout check1;
    LinearLayout p1_Button2;
    LinearLayout check2;
    LinearLayout p1_Button3;
    LinearLayout check3;
    LinearLayout p1_Button4;
    LinearLayout check4;
    LinearLayout p1_Button5;
    LinearLayout check5;
    LinearLayout p1_Button6;
    LinearLayout check6;
    LinearLayout p1_Button7;
    LinearLayout check7;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile1);

        Button next = findViewById(R.id.profile1_Next);
        TextView skip = findViewById(R.id.profile1Skip);

        p1_Button1 = findViewById(R.id.p1_Button1);
        check1 = findViewById(R.id.check1);
        p1_Button1.setEnabled(false);
        p1_Button2 = findViewById(R.id.p1_Button2);
        check2 = findViewById(R.id.check2);
        p1_Button2.setEnabled(false);
        p1_Button3 = findViewById(R.id.p1_Button3);
        check3 = findViewById(R.id.check3);
        p1_Button3.setEnabled(false);
        p1_Button4 = findViewById(R.id.p1_Button4);
        check4 = findViewById(R.id.check4);
        p1_Button4.setEnabled(false);
        p1_Button5 = findViewById(R.id.p1_Button5);
        check5 = findViewById(R.id.check5);
        p1_Button5.setEnabled(false);
        p1_Button6 = findViewById(R.id.p1_Button6);
        check6 = findViewById(R.id.check6);
        p1_Button6.setEnabled(false);
        p1_Button7 = findViewById(R.id.p1_Button7);
        check7 = findViewById(R.id.check7);
        p1_Button7.setEnabled(false);

        p1_Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent MeetNewPeople = new Intent(view1.getContext(), profile1.class);
                startActivity(MeetNewPeople);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            };
        });

        //Todo: Make disabled until options are selected
        //Next button pressed
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent segueToProfile2 = new Intent(view1.getContext(), profile2.class);
                startActivity(segueToProfile2);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            };
        });

        //Skip Button Pressed
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent skipToProfile2 = new Intent(view1.getContext(), profile2.class);
                startActivity(skipToProfile2);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            };
        });

    }
        public void onToggleClicked(View view1) {
            // Is the toggle on?
            boolean on = ((ToggleButton) view1).isChecked();

            if (on) {
                p1_Button1.setAlpha((float)1.0);
                check1.setBackground(getResources().getDrawable(R.drawable.ic_check_button));
                p1_Button1.setEnabled(true);
            } else {
                p1_Button1.setAlpha((float)0.2);
                check1.setBackground(getResources().getDrawable(R.drawable.ic_profile1_white_circle));
                p1_Button1.setEnabled(false);
            }
        };
}