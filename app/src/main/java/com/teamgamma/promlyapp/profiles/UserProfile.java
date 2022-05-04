package com.teamgamma.promlyapp.profiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.teamgamma.promlyapp.R;
import com.teamgamma.promlyapp.profiles.EditInterests;

public class UserProfile extends AppCompatActivity {

    //Boolean for if user is viewing own profile
    Boolean viewingOwnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        //XML Element References
        ImageView multiFunctionButton = findViewById(R.id.multiFunctionButton);
        TextView editProfile = findViewById(R.id.editProfileButton);
        TextView editInterests = findViewById(R.id.editInterestsButton);
        LinearLayout goalResponseField = findViewById(R.id.goalResponseField);
        TextView goalText1 = findViewById(R.id.goalBox1);
        TextView goalText2 = findViewById(R.id.goalBox2);
        ImageView goalEllipses = findViewById(R.id.goalElipsesButton);
        viewingOwnProfile = true;

        //Hide edit profile and edit interests buttons on initial load
        editInterests.setVisibility(View.GONE);
        editProfile.setVisibility(View.GONE);

        //Segue to edit interests screen
        editInterests.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToEditInterestsScreen = new Intent(view.getContext(), EditInterests.class);
                startActivity(segueToEditInterestsScreen);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

        });

        //TODO: Implement edit profile screen and segue to the respective xml (Change UserProfile.class to (EditProfile).class)
        editProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToEditProfile = new Intent(view.getContext(), UserProfile.class);
                startActivity(segueToEditProfile);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }

        });

        multiFunctionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!viewingOwnProfile) {
                    //If user is viewing a different user profile, hide edit buttons, show elipses icon on top right, and expand 1by2day with response box
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
                    //TODO: Implement ellipses function (report goal?)
                    viewingOwnProfile = true;

                } else {
                    //If user is viewing their own profile, show edit buttons, show settings icon on top right, and close 1by2day to create goal mode
                    multiFunctionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_promly_navicon_settings));
                    editProfile.setVisibility(View.VISIBLE);
                    System.out.println("switched to viewing own profile");
                    editInterests.setVisibility(View.VISIBLE);
                    goalResponseField.setVisibility(View.GONE);
                    goalText1.setText(R.string.oneBy2Day);
                    goalText1.setTextSize((float) 13);
                    goalText2.setText(R.string.write_something);
                    goalText2.setTextSize((float) 17);
                    //TODO: Implement transition to 1by2day goal entry
                    goalEllipses.setVisibility(View.GONE);
                    viewingOwnProfile = false;
                }
            }

        });

    }
}
