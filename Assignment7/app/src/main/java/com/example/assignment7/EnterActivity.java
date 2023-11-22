package com.example.assignment7;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.util.Locale;

public class EnterActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText placeEditText;
    private EditText participantsEditText;
    private TimePicker timePicker;
    private DatePickerDialog datePicker;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_activity);

        titleEditText = findViewById(R.id.titleEditText);
        placeEditText = findViewById(R.id.placeEditText);
        participantsEditText = findViewById(R.id.participantsEditText);
        submitButton = findViewById(R.id.submitButton);

        setupUpDateTimePickers();
        setupNavigator();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEditText.getText().toString();
                String place = placeEditText.getText().toString();
                String participants = participantsEditText.getText().toString();

                TextView timeView = findViewById(R.id.timeTextView);
                TextView dateView = findViewById(R.id.dateTextView);

                String time = timeView.getText().toString();
                String date = dateView.getText().toString();

                LocalDateTime dateTime = Utils.convertToDateTime(time, date);

                MeetingService.addMeeting(title, place, participants, dateTime);

                titleEditText.setText("");
                placeEditText.setText("");
                participantsEditText.setText("");
                // Hide the keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                Toast.makeText(EnterActivity.this, "Meeting saved successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupNavigator() {
        Button summaryButton = findViewById(R.id.summaryButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button updateButton = findViewById(R.id.updateButton);

        Utils.setupBtnActivityNavigator(summaryButton, EnterActivity.this, SummaryActivity.class);
        Utils.setupBtnActivityNavigator(updateButton, EnterActivity.this, UpdateActivity.class);
        Utils.setupBtnActivityNavigator(searchButton, EnterActivity.this, SearchActivity.class);
    }

    private void setupUpDateTimePickers() {
        Button timePickerButton = findViewById(R.id.timePickerButton);
        Button datePickerButton = findViewById(R.id.datePickerButton);
        TextView dateView = findViewById(R.id.dateTextView);
        TextView timeView = findViewById(R.id.timeTextView);

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showTimePickerDialog(EnterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                        timeView.setText(selectedTime);
                    }
                });
            }
        });

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.setupDatePicker(EnterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year);
                        dateView.setText(selectedDate);
                    }
                });
            }
        });
    }
}
