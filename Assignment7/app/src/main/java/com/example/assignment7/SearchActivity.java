package com.example.assignment7;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {
    private ListView searchResultListView;
    private EditText titleEditText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        titleEditText = findViewById(R.id.searchTitleEditText);
        searchButton = findViewById(R.id.searchSubmitButton);
        searchResultListView = findViewById(R.id.searchResultListView);

        setupNavigator();
        setupUpDateTimePickers();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchTitle = titleEditText.getText().toString().trim();
                TextView timeView = findViewById(R.id.timeTextView);
                TextView dateView = findViewById(R.id.dateTextView);

                String time = timeView.getText().toString();
                String date = dateView.getText().toString();

                LocalDateTime dateTime = Utils.convertToDateTime(time, date);
                List<Meeting> searchResults = MeetingService.search(searchTitle, dateTime);

                //parse Meetings to string
                List<String> stringList = new ArrayList<>();
                for(Meeting meeting: searchResults) {
                    stringList.add(meeting.toString());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        SearchActivity.this,
                        android.R.layout.simple_list_item_1,
                        stringList
                );

                searchResultListView.setAdapter(adapter);

                if (stringList.isEmpty()) {
                    Toast.makeText(SearchActivity.this, "No meeting found", Toast.LENGTH_SHORT).show();
                } else {
                    titleEditText.setText("");
                    // Hide the keyboard
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }

    private void setupNavigator() {
        Button summaryButton = findViewById(R.id.summaryButton);
        Button enterButton = findViewById(R.id.enterButton);
        Button updateButton = findViewById(R.id.updateButton);

        Utils.setupBtnActivityNavigator(summaryButton, SearchActivity.this, SummaryActivity.class);
        Utils.setupBtnActivityNavigator(updateButton, SearchActivity.this, UpdateActivity.class);
        Utils.setupBtnActivityNavigator(enterButton, SearchActivity.this, EnterActivity.class);
    }

    private void setupUpDateTimePickers() {
        Button timePickerButton = findViewById(R.id.timePickerButton);
        Button datePickerButton = findViewById(R.id.datePickerButton);
        TextView timeView = findViewById(R.id.timeTextView);
        TextView dateView = findViewById(R.id.dateTextView);

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showTimePickerDialog(SearchActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
                Utils.setupDatePicker(SearchActivity.this, new DatePickerDialog.OnDateSetListener() {
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
