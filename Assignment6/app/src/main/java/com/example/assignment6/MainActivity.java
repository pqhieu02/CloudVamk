package com.example.assignment6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button continueButton, finalizeButton, backButton;

    private TextView userInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        usernameEditText = findViewById(R.id.usernameEditText);
        continueButton = findViewById(R.id.continueButton);
        passwordEditText = findViewById(R.id.passwordEditText);
        finalizeButton = findViewById(R.id.finalizeButton);
        backButton = findViewById(R.id.backButton);
        userInfoTextView = findViewById(R.id.userInfoTextView);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordEditText.setVisibility(View.VISIBLE);
                finalizeButton.setVisibility(View.VISIBLE);

                continueButton.setVisibility(View.GONE);
            }
        });

        finalizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                usernameEditText.setVisibility(View.GONE);
                continueButton.setVisibility(View.GONE);
                finalizeButton.setVisibility(View.GONE);
                passwordEditText.setVisibility(View.GONE);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                String currentTime = sdf.format(new Date());;
                String userInfo = "Username: " + username + "\nPassword: " + password + "\nTime: " + currentTime;
                userInfoTextView.setVisibility(View.VISIBLE);
                userInfoTextView.setText(userInfo);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameEditText.setVisibility(View.VISIBLE);
                usernameEditText.setText("");

                continueButton.setVisibility(View.VISIBLE);

                finalizeButton.setVisibility(View.GONE);

                passwordEditText.setText("");
                passwordEditText.setVisibility(View.GONE);

                userInfoTextView.setText("");
                userInfoTextView.setVisibility(View.GONE);
            }
        });
    }
}
