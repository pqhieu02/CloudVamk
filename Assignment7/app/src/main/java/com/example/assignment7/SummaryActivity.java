package com.example.assignment7;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SummaryActivity extends AppCompatActivity {
    private ListView allMeetingsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_activity);

        allMeetingsView = findViewById(R.id.allMeetingsView);

        setupNavigator();

        List<Meeting> searchResults = MeetingService.getAll();

        List<String> stringList = new ArrayList<>();
        for(Meeting meeting: searchResults) {
            stringList.add(meeting.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                SummaryActivity.this,
                android.R.layout.simple_list_item_1,
                stringList
        );

        allMeetingsView.setAdapter(adapter);
    }

    private void setupNavigator() {
        Button enterButton = findViewById(R.id.enterButton);
        Button searchButton = findViewById(R.id.searchButton);
        Button updateButton = findViewById(R.id.updateButton);

        Utils.setupBtnActivityNavigator(enterButton, SummaryActivity.this, EnterActivity.class);
        Utils.setupBtnActivityNavigator(updateButton, SummaryActivity.this, UpdateActivity.class);
        Utils.setupBtnActivityNavigator(searchButton, SummaryActivity.this, SearchActivity.class);
    }
}
