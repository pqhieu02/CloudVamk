package com.example.assignment7;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class EnterActivity extends AppCompatActivity {

    private Button timePickerButton;
    private Button datePickerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_activity);

        // Initialize UI elements
        Button summaryButton = findViewById(R.id.summaryButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button updateButton = findViewById(R.id.updateButton);
        Button submitButton = findViewById(R.id.submitButton);

        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText placeEditText = findViewById(R.id.placeEditText);
        EditText participantsEditText = findViewById(R.id.participantsEditText);
        DatePicker datePicker = findViewById(R.id.datePicker);
        Button timePickerButton = findViewById(R.id.timePickerButton);
        Button datePickerButton = findViewById(R.id.datePickerButton);

        // Summary button
//        summaryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Navigate to SummaryActivity
//                Intent intent = new Intent(EnterActivity.this, SummaryActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        // Search button
//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Navigate to SearchActivity
//                Intent intent = new Intent(EnterActivity.this, SearchActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        // Update button
//        updateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Navigate to UpdateActivity
//                Intent intent = new Intent(EnterActivity.this, UpdateActivity.class);
//                startActivity(intent);
//            }
//        });

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showTimePickerDialog(EnterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

//                        textView.setText(hourOfDay + ":" + minute);
                    }
                });
            }
        });

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showDatePickerDialog(EnterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        textView.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                });
            }
        });
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Get data from EditText and DatePicker
//                String title = titleEditText.getText().toString();
//                String place = placeEditText.getText().toString();
//                String participants = participantsEditText.getText().toString();
//                // Get date from DatePicker
//                int year = datePicker.getYear();
//                int month = datePicker.getMonth();
//                int day = datePicker.getDayOfMonth();
//
//                // Create a Meeting object with the entered data
//                String date = year + "-" + (month + 1) + "-" + day;
//                Meeting newMeeting = new Meeting(title, place, participants, date, "", dateTime);
//
//                // Save the meeting data
//                saveMeeting(newMeeting);
//
//                // Show a toast message to indicate successful submission
//                Toast.makeText(EnterActivity.this, "Meeting saved successfully!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
