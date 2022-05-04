package com.teamgamma.promlyapp.onboarding;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.teamgamma.promlyapp.R;

public class profile2 extends AppCompatActivity {
    Button mBack,mNext,mPlusButtonTop1,mPlusButtonTop2,mPlusButtonTop3,mPlusButtonTop4,mPlusButtonTop5,
            mPlusButtonTop6, mPlusButtonCenter1,mPlusButtonCenter2,mPlusButtonCenter3,mPlusButtonCenter4,mPlusButtonCenter5,mPlusButtonBottom1
            ,mPlusButtonBottom2,mPlusButtonBottom3,mPlusButtonBottom4,mPlusButtonBottom5;
    int top1=1,top2=1,top3=1,top4=1,top5=1,top6=1, interestsSelected,center1=1,center2=1,center3=1,center4=1,center5=1
            ,bottom1=1,bottom2=1,bottom3=1,bottom4=1,bottom5=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile2);

        // Controls functionality for the next button at the bottom
        mNext = findViewById(R.id.buttonNext);
        mNext.setOnClickListener(view -> {
            // Switch to profile 3
            Intent segueToProfile3 = new Intent(view.getContext(), profile3.class);
            startActivity(segueToProfile3);
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        });




        /*if the plus button is clicked, add 1 to the counter and switch the background to
        a check if the counter/2 = 0 else when clicked again add 1.
        odd number = + button
        even number = check button
        */
        mPlusButtonTop1 = findViewById(R.id.plusTop1);
        mPlusButtonTop1.setOnClickListener(view -> {
            top1=top1+1;
            if (top1 % 2 == 0) {
                mPlusButtonTop1.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonTop1.setText(" ");
                count();
            }
            else{
                mPlusButtonTop1.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonTop1.setText("+");
                subtract();
            }
        });
        mPlusButtonTop2 = findViewById(R.id.plusTop2);
        mPlusButtonTop2.setOnClickListener(view -> {
            top2=top2+1;
            if (top2 % 2 == 0) {
                mPlusButtonTop2.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonTop2.setText(" ");
                count();
            }
            else{
                mPlusButtonTop2.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonTop2.setText("+");
                subtract();
            }
        });

        mPlusButtonTop3 = findViewById(R.id.plusTop3);
        mPlusButtonTop3.setOnClickListener(view -> {
            top3=top3+1;
            if (top3 % 2 == 0) {
                mPlusButtonTop3.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonTop3.setText(" ");
                count();
            }
            else{
                mPlusButtonTop3.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonTop3.setText("+");
                subtract();
            }
        });
        mPlusButtonTop4 = findViewById(R.id.plusTop4);
        mPlusButtonTop4.setOnClickListener(view -> {
            top4=top4+1;
            if (top4 % 2 == 0) {
                mPlusButtonTop4.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonTop4.setText(" ");
                count();
            }
            else{
                mPlusButtonTop4.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonTop4.setText("+");
                subtract();
            }
        });

        mPlusButtonTop5 = findViewById(R.id.plusTop5);
        mPlusButtonTop5.setOnClickListener(view -> {
            top5=top5+1;
            if (top5 % 2 == 0) {
                mPlusButtonTop5.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonTop5.setText(" ");
                count();
            }
            else{
                mPlusButtonTop5.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonTop5.setText("+");
                subtract();
            }
        });
        mPlusButtonTop6 = findViewById(R.id.plusTop6);
        mPlusButtonTop6.setOnClickListener(view -> {
            top6=top6+1;
            if (top6 % 2 == 0) {
                mPlusButtonTop6.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonTop6.setText(" ");
                count();
            }
            else{
                mPlusButtonTop6.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonTop6.setText("+");
                subtract();
            }
        });

        mPlusButtonCenter1 = findViewById(R.id.plusCenter1);
        mPlusButtonCenter1.setOnClickListener(view -> {
            center1=center1+1;
            if (center1 % 2 == 0) {
                mPlusButtonCenter1.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonCenter1.setText(" ");
                count();
            }
            else{
                mPlusButtonCenter1.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonCenter1.setText("+");
                subtract();
            }
        });
        mPlusButtonCenter2 = findViewById(R.id.plusCenter2);
        mPlusButtonCenter2.setOnClickListener(view -> {
            center2=center2+1;
            if (center2 % 2 == 0) {
                mPlusButtonCenter2.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonCenter2.setText(" ");
                count();
            }
            else{
                mPlusButtonCenter2.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonCenter2.setText("+");
                subtract();
            }
        });
        mPlusButtonCenter3 = findViewById(R.id.plusCenter3);
        mPlusButtonCenter3.setOnClickListener(view -> {
            center3=center3+1;
            if (center3 % 2 == 0) {
                mPlusButtonCenter3.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonCenter3.setText(" ");
                count();
            }
            else{
                mPlusButtonCenter3.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonCenter3.setText("+");
                subtract();
            }
        });
        mPlusButtonCenter4 = findViewById(R.id.plusCenter4);
        mPlusButtonCenter4.setOnClickListener(view -> {
            center4=center4+1;
            if (center4 % 2 == 0) {
                mPlusButtonCenter4.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonCenter4.setText(" ");
                count();
            }
            else{
                mPlusButtonCenter4.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonCenter4.setText("+");
                subtract();
            }
        });
        mPlusButtonCenter5 = findViewById(R.id.plusCenter5);
        mPlusButtonCenter5.setOnClickListener(view -> {
            center5=center5+1;
            if (center5 % 2 == 0) {
                mPlusButtonCenter5.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonCenter5.setText(" ");
                count();
            }
            else{
                mPlusButtonCenter5.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonCenter5.setText("+");
                subtract();
            }
        });
        mPlusButtonCenter5 = findViewById(R.id.plusCenter5);
        mPlusButtonCenter5.setOnClickListener(view -> {
            center5=center5+1;
            if (center5 % 2 == 0) {
                mPlusButtonCenter5.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonCenter5.setText(" ");
                count();
            }
            else{
                mPlusButtonCenter5.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonCenter5.setText("+");
                subtract();
            }
        });
        mPlusButtonBottom1 = findViewById(R.id.plusBottom1);
        mPlusButtonBottom1.setOnClickListener(view -> {
            bottom1=bottom1+1;
            if (bottom1 % 2 == 0) {
                mPlusButtonBottom1.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonBottom1.setText(" ");
                count();
            }
            else{
                mPlusButtonBottom1.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonBottom1.setText("+");
                subtract();
            }
        });
        mPlusButtonBottom2 = findViewById(R.id.plusBottom2);
        mPlusButtonBottom2.setOnClickListener(view -> {
            bottom2=bottom2+1;
            if (bottom2 % 2 == 0) {
                mPlusButtonBottom2.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonBottom2.setText(" ");
                count();
            }
            else{
                mPlusButtonBottom2.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonBottom2.setText("+");
                subtract();
            }
        });
        mPlusButtonBottom3 = findViewById(R.id.plusBottom3);
        mPlusButtonBottom3.setOnClickListener(view -> {
            bottom3=bottom3+1;
            if (bottom3 % 2 == 0) {
                mPlusButtonBottom3.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonBottom3.setText(" ");
                count();
            }
            else{
                mPlusButtonBottom3.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonBottom3.setText("+");
                subtract();
            }
        });
        mPlusButtonBottom4 = findViewById(R.id.plusBottom4);
        mPlusButtonBottom4.setOnClickListener(view -> {
            bottom4=bottom4+1;
            if (bottom4 % 2 == 0) {
                mPlusButtonBottom4.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonBottom4.setText(" ");
                count();
            }
            else{
                mPlusButtonBottom4.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonBottom4.setText("+");
                subtract();
            }
        });
        mPlusButtonBottom5 = findViewById(R.id.plusBottom5);
        mPlusButtonBottom5.setOnClickListener(view -> {
            bottom5=bottom5+1;
            if (bottom5 % 2 == 0) {
                mPlusButtonBottom5.setBackgroundResource(R.drawable.ic_checkmark);
                mPlusButtonBottom5.setText(" ");
                count();
            }
            else{
                mPlusButtonBottom5.setBackgroundResource(R.drawable.plus_button);
                mPlusButtonBottom5.setText("+");
                subtract();
            }
        });

    }
    public void count(){
        interestsSelected++;
        Log.d("count", ": "+ interestsSelected);
        if(interestsSelected >= 5)
        {
            mNext.setEnabled(true);
        }
        else if (interestsSelected < 5)
        {
            mNext.setEnabled(false);
        }
    }
    public void subtract()
    {
        interestsSelected = interestsSelected - 1;
        Log.d("count", ": "+ interestsSelected);
        if(interestsSelected >= 5)
        {
            mNext.setEnabled(true);
        }
        else if (interestsSelected < 5)
        {
            mNext.setEnabled(false);
        }
    }



}