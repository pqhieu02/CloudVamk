package com.example.assignment3;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText birthdayEditText;
    private EditText addressEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private long lastOrientationChangeTime;
    private TextView randomLabel;
    private Handler handler;
    private final int UPDATE_INTERVAL = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        birthdayEditText = findViewById(R.id.birthdayEditText);
        addressEditText = findViewById(R.id.addressEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        randomLabel = findViewById(R.id.randomLabel);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateRandomNumber();
                handler.postDelayed(this, UPDATE_INTERVAL);
            }
        }, UPDATE_INTERVAL);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("firstName", firstNameEditText.getText().toString());
        outState.putString("lastName", lastNameEditText.getText().toString());
        outState.putString("birthday", birthdayEditText.getText().toString());
        outState.putString("address", addressEditText.getText().toString());
        outState.putString("email", emailEditText.getText().toString());
        outState.putString("phone", phoneEditText.getText().toString());
        lastOrientationChangeTime = System.currentTimeMillis();
        outState.putLong("lastOrientationChangeTime", lastOrientationChangeTime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("MainActivity", "Restoring states");
        firstNameEditText.setText(savedInstanceState.getString("firstName"));
        lastNameEditText.setText(savedInstanceState.getString("lastName"));
        birthdayEditText.setText(savedInstanceState.getString("birthday"));
        addressEditText.setText(savedInstanceState.getString("address"));
        emailEditText.setText(savedInstanceState.getString("email"));
        phoneEditText.setText(savedInstanceState.getString("phone"));
        lastOrientationChangeTime = savedInstanceState.getLong("lastOrientationChangeTime");
    }

    @Override
    protected void onResume() {
        super.onResume();

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "Landscape orientation " + getFormattedTime(lastOrientationChangeTime), Toast.LENGTH_SHORT).show();
        } else if (orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "Portrait orientation " + getFormattedTime(lastOrientationChangeTime), Toast.LENGTH_SHORT).show();
        }
    }

    private String getFormattedTime(long timeMillis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date(timeMillis));
    }

    private void updateRandomNumber() {
        // Generate a random number and display it in the TextView
        int randomNumber = (int) (Math.random() * 1000); // Change this range as needed
        randomLabel.setText("Random Number: " + randomNumber);
    }
}
