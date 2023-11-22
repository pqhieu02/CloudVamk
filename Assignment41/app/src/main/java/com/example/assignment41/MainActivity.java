package com.example.assignment41;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText, commentEditText, searchText;
    private DatePicker datePicker;
    private TextView resultTextView;
    private LinearLayout linearEntries;
    private List<Comment> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        userNameEditText = findViewById(R.id.editTextUserName);
        commentEditText = findViewById(R.id.editTextComment);
        searchText = findViewById(R.id.editTextSearchText);
        datePicker = findViewById(R.id.datePicker);
        resultTextView = findViewById(R.id.textViewEntries);
        linearEntries = findViewById(R.id.linearEntries);

        comments = new ArrayList<>();

        Button submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addComment();
            }
        });

        Button searchButton = findViewById(R.id.buttonSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchComment();
            }
        });
    }

    private void addComment() {
        String userName = userNameEditText.getText().toString().trim();
        String comment = commentEditText.getText().toString().trim();

        if (userName.isEmpty()) {
            userNameEditText.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            return;
        }

        if (comment.isEmpty()) {
            commentEditText.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            return;
        }

        userNameEditText.setBackgroundColor(getResources().getColor(android.R.color.white));
        commentEditText.setBackgroundColor(getResources().getColor(android.R.color.white));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateAndTime = sdf.format(new Date());

        Comment entry = new Comment(currentDateAndTime, userName, comment);
        comments.add(0, entry);

        display();

        userNameEditText.setText("");
        commentEditText.setText("");
    }

    private void searchComment() {
        String searchTextValue = searchText.getText().toString().trim().toLowerCase();
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        String dateValue = new SimpleDateFormat("yyyy-MM-dd").format(new Date(calendar.getTimeInMillis()));

        List<Comment> searchResults = new ArrayList<>();

        for (Comment entry : comments) {
            if (entry.getUserName().toLowerCase().contains(searchTextValue) &&
                    entry.getDate().toLowerCase().contains(dateValue)) {
                searchResults.add(entry);
            }
        }

        displaySearchResults(searchResults);
    }

    private void display() {
        linearEntries.removeAllViews();
        if (comments.size() == 0) {
            TextView entryTextView = new TextView(this);
            entryTextView.setText("Not found");
            linearEntries.addView(entryTextView);
        }
        for (int i = 0; i < comments.size(); i++) {
            Comment entry = comments.get(i);
            TextView entryTextView = new TextView(this);
            entryTextView.setText(String.format("%d. %s - %s: %s", i + 1, entry.getDate(), entry.getUserName(), entry.getComment()));
            linearEntries.addView(entryTextView);
        }
    }

    private void displaySearchResults(List<Comment> searchResults) {
        StringBuilder result = new StringBuilder();

        for (Comment entry : searchResults) {
            result.append(entry.toString()).append("\n");
        }

        resultTextView.setText(result.toString());
    }
}
