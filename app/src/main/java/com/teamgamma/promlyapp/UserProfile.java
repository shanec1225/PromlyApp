package com.teamgamma.promlyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {

    Boolean viewingOwnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);


        ImageView multiFunctionButton = findViewById(R.id.multiFunctionButton);
        TextView editProfile = findViewById(R.id.editProfileButton);
        TextView editInterests = findViewById(R.id.editInterestsButton);
        LinearLayout goalResponseField = findViewById(R.id.goalResponseField);
        TextView goalText1 = findViewById(R.id.goalBox1);
        TextView goalText2 = findViewById(R.id.goalBox2);
        ImageView goalEllipses = findViewById(R.id.goalElipsesButton);
        viewingOwnProfile = false;

        editInterests.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToEditInterestsScreen = new Intent(view.getContext(), EditInterests.class);
                startActivity(segueToEditInterestsScreen);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

        });

        multiFunctionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!viewingOwnProfile) {
                    multiFunctionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_promly_navicon_elipses_circle));
                    System.out.println("switched to viewing other profile");
                    viewingOwnProfile = true;
                    editProfile.setVisibility(View.GONE);
                    editInterests.setVisibility(View.GONE);
                    goalResponseField.setVisibility(View.VISIBLE);
                    goalText1.setText(R.string.temp_goal);
                    goalText1.setTextSize((float) 17);
                    goalText2.setText(R.string.oneBy2Day);
                    goalText2.setTextSize((float) 13);
                    goalEllipses.setVisibility(View.VISIBLE);
                    viewingOwnProfile = true;

                } else {
                    multiFunctionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_promly_navicon_settings));
                    editProfile.setVisibility(View.VISIBLE);
                    System.out.println("switched to viewing own profile");
                    editInterests.setVisibility(View.VISIBLE);
                    goalResponseField.setVisibility(View.GONE);
                    goalText1.setText(R.string.oneBy2Day);
                    goalText1.setTextSize((float) 13);
                    goalText2.setText(R.string.write_something);
                    goalText2.setTextSize((float) 17);
                    goalEllipses.setVisibility(View.GONE);
                    viewingOwnProfile = false;
                }
            }

        });

    }
}
