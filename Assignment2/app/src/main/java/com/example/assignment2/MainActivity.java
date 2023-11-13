package com.example.assignment2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Date; // Import Date class

public class MainActivity extends AppCompatActivity {
    String tag = "Demo: ";
    long startTime; // Variable to store the start time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hide the title
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Log.d(tag, tag + "onCreate()");
        startTime = System.currentTimeMillis();

        EditText firstNameEditText = findViewById(R.id.editTextFirstName);
        EditText lastNameEditText = findViewById(R.id.editTextLastName);
        EditText phoneNumberEditText = findViewById(R.id.editTextPhoneNumber);
        EditText commentsEditText = findViewById(R.id.editTextComments);
        Button sendButton = findViewById(R.id.buttonSend);
        Button resetButton = findViewById(R.id.buttonReset);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String confirmationMessage = "Feedback sent";
                Toast.makeText(MainActivity.this, confirmationMessage, Toast.LENGTH_LONG).show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all input fields
                firstNameEditText.getText().clear();
                lastNameEditText.getText().clear();
                phoneNumberEditText.getText().clear();
                commentsEditText.getText().clear();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        Log.d(tag, tag + "onStart() - Elapsed Time: " + elapsedTime + " ms");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        Log.d(tag, tag + "onRestart() - Elapsed Time: " + elapsedTime + " ms");
    }

    @Override
    protected void onResume() {
        super.onResume();
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        Log.d(tag, tag + "onResume() - Elapsed Time: " + elapsedTime + " ms");
    }

    @Override
    protected void onStop() {
        super.onStop();
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        Log.d(tag, tag + "onResume() - Elapsed Time: " + elapsedTime + " ms");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        Log.d(tag, tag + "onDestroy() - Elapsed Time: " + elapsedTime + " ms");
    }
}
