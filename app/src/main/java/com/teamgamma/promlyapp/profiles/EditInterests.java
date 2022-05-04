package com.teamgamma.promlyapp.profiles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.teamgamma.promlyapp.MainActivity;
import com.teamgamma.promlyapp.R;

public class EditInterests extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interests);

        //Save button in top right
        TextView save = findViewById(R.id.saveEditedInterests);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent segueBackToUserProfile = new Intent(view1.getContext(), UserProfile.class);
                startActivity(segueBackToUserProfile);
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
            };
        });

    }
}
