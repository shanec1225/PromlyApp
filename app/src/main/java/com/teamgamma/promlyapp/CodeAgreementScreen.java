package com.teamgamma.promlyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;


public class CodeAgreementScreen extends AppCompatActivity {

    ToggleButton ageCheckBox;
    Button iAgreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_agreement);
        iAgreeButton = findViewById(R.id.iAgreeButton);
        iAgreeButton.setAlpha((float)0.4);
        iAgreeButton.setEnabled(false);
        ageCheckBox = findViewById(R.id.ageCheckBox);
        TextView textView = findViewById(R.id.respectCodeTitle);

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("Respect Code");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#AA57FF"),
                        Color.parseColor("#FF1696"),
                        Color.parseColor("#FA880C")
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        iAgreeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent segueToLoginScreen = new Intent(view.getContext(), LoginScreen.class);
                startActivity(segueToLoginScreen);
            }

        });
    }

    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            ageCheckBox.setBackground(getResources().getDrawable(R.drawable.ic_promly_check_empty));
            iAgreeButton.setAlpha((float)0.4);
            iAgreeButton.setEnabled(false);
        } else {
            ageCheckBox.setBackground(getResources().getDrawable(R.drawable.ic_promly_check_small));
            iAgreeButton.setAlpha((float)1.0);
            iAgreeButton.setEnabled(true);
        }
    }
}