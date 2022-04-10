package com.teamgamma.promlyapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;


public class profile4 extends AppCompatActivity {

    Button mBack, mLetsGo, mSelectImage;
    ImageView mProfileImage, mCheckName, mCheckUsername, mCheckBirthday,mCheckImage,mSmile;
    EditText mName, mUsername, mBirthday;
    ActivityResultLauncher<String> mGetContent;
    private DatePickerDialog datePickerDialog;
    boolean nameEmpty = true,usernameEmpty = true, birthdayEmpty = true, imageEmpty = true ;
    private static final int STORAGE_PERMISSION_CODE = 101;
    int year,month,day;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile4);

        // Controls functionality of back button, which page to return to
        mBack = findViewById(R.id.backToProfile3Btn);
        mBack.setOnClickListener(view -> {
            // Switch MainActivity class for profile3 class name
            Intent intent = new Intent(profile4.this, MainActivity.class);
            startActivity(intent);
        });
        // Controls functionality for the Let's Go button at the bottom
        mLetsGo = findViewById(R.id.buttonLetsGo);
        mLetsGo.setEnabled(false);
        mLetsGo.setOnClickListener(view -> {
            // Switch MainActivity class for next page class name
            Intent intent = new Intent(profile4.this, MainActivity.class);
            startActivity(intent);
        });



        // The profile picture box
        mSelectImage = findViewById(R.id.buttonAddPhoto);
        mProfileImage = findViewById(R.id.selectedImage);
        mCheckImage = findViewById(R.id.imageCheck);
        mSmile = findViewById(R.id.smile);

        mSelectImage.setOnClickListener(view -> checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE));


        // Find the name input field and the check for name
        mCheckName = findViewById(R.id.nameCheck);
        mName = findViewById(R.id.nameInput);

        // Find the username input field and the check for name
        mCheckUsername = findViewById(R.id.usernameCheck);
        mUsername = findViewById(R.id.usernameInput);

        // Find the birthday input field and the check for birthday
        mCheckBirthday = findViewById(R.id.birthdayCheck);
        mBirthday = findViewById(R.id.birthdayInput);
        initDatePicker();


        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), result -> {
            mProfileImage.setImageURI(result);
            // When the image is selected, change the button properties
            mSelectImage.setBackgroundResource(R.drawable.change_photo_button);
            mSmile.setVisibility(View.INVISIBLE);
            mSelectImage.setText("change photo");

            // Sets the text color to purple using hexcode
            mSelectImage.setTextColor(Color.parseColor("#AA57FF"));

            //Set the check mark to visible
            mCheckImage.setVisibility(View.VISIBLE);
            imageEmpty = false;
            buttonDisabled();
            Log.d("image empty ", Boolean.toString(imageEmpty));

        });
        mSelectImage.setOnClickListener(view -> mGetContent.launch("image/*"));

        //Watches for changed text in the name edit text
        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String nameInput = mName.getText().toString();
                if (nameInput.length() > 0) {
                    nameEmpty = false;
                    //noinspection ConstantConditions
                    Log.d("name empty ", Boolean.toString(nameEmpty));
                    mCheckName.setVisibility(View.VISIBLE);
                    mName.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    buttonDisabled();
                } else if(nameInput.isEmpty()) {
                    nameEmpty = true;
                    Log.d("name empty ", Boolean.toString(nameEmpty));
                    mCheckName.setVisibility(View.INVISIBLE);
                    mName.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    buttonDisabled();
                }
            }
        });

        //Watches for changed text in the username edit text
        mUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String usernameInput = mUsername.getText().toString();
                if (usernameInput.length() > 0) {
                    usernameEmpty = false;
                    Log.d("username empty ", Boolean.toString(usernameEmpty));
                    mCheckUsername.setVisibility(View.VISIBLE);
                    mUsername.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    buttonDisabled();
                } else if(usernameInput.isEmpty()) {
                    usernameEmpty = true;
                    Log.d("username empty ", Boolean.toString(usernameEmpty));
                    mCheckUsername.setVisibility(View.INVISIBLE);
                    mUsername.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    buttonDisabled();
                }
            }
        });

        //Watches for changed text in the birthday edit text
        mBirthday.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String birthdayInput = mBirthday.getText().toString();
                if (birthdayInput.length() > 0) {
                    birthdayEmpty = false;
                    Log.d("birthday empty ", Boolean.toString(birthdayEmpty));
                    mCheckBirthday.setVisibility(View.VISIBLE);
                    mBirthday.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    buttonDisabled();
                } else {
                    birthdayEmpty = true;
                    Log.d("birthday empty ", Boolean.toString(birthdayEmpty));
                    buttonDisabled();
                }
            }
        });

    }

    // Using the date picker in the edit text box
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
        month = month + 1;
        String date = makeDateString(day, month, year);
        mBirthday.setText(date);
        };
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener,year,month,day);
    }

    private String makeDateString(int day, int month, int year) {
            return getMonthFormat(month) + " " + day + ", " + year;
    }

    // Displays the month using 3 char in the scroll wheel while selecting birthday
    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "Jan";
        if(month == 2)
            return "Feb";
        if(month == 3)
            return "Mar";
        if(month == 4)
            return "Apr";
        if(month == 5)
            return "May";
        if(month == 6)
            return "Jun";
        if(month == 7)
            return "Jul";
        if(month == 8)
            return "Aug";
        if(month == 9)
            return "Sep";
        if(month == 10)
            return "Oct";
        if(month == 11)
            return "Nov";
        if(month == 12)
            return "Dec";
        //default
        return "JAN";
    }

    public void openDatePicker(View view){
        datePickerDialog.show();
    }

    public void checkPermission(String permission, int requestCode){
        if(ContextCompat.checkSelfPermission(profile4.this, permission)==PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(profile4.this,new String []{permission},requestCode);
        }
        else{
            Toast.makeText(profile4.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == STORAGE_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(profile4.this, "Storage permission granted", Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(profile4.this, "Storage permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void buttonDisabled()
    {
        mLetsGo.setEnabled(!imageEmpty && !nameEmpty && !usernameEmpty && !birthdayEmpty);

    }
}







