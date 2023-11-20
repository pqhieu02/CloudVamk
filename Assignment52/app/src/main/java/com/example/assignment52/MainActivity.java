package com.example.assignment52;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> firstNames = new ArrayList<>();
    private ArrayList<String> lastNames = new ArrayList<>();
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    private AutoCompleteTextView actvSearchFirstName;
    private AutoCompleteTextView actvSearchLastName;
    private AutoCompleteTextView actvSearchPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final EditText etFirstName = findViewById(R.id.etFirstName);
        final EditText etLastName = findViewById(R.id.etLastName);
        final EditText etPhoneNumber = findViewById(R.id.etPhoneNumber);
        Button btnSave = findViewById(R.id.btnSave);

        actvSearchFirstName = findViewById(R.id.actvSearchFirstName);
        actvSearchLastName = findViewById(R.id.actvSearchLastName);
        actvSearchPhoneNumber = findViewById(R.id.actvSearchPhoneNumber);

        ArrayAdapter<String> firstNameAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, firstNames);
        actvSearchFirstName.setAdapter(firstNameAdapter);

        ArrayAdapter<String> lastNameAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, lastNames);
        actvSearchLastName.setAdapter(lastNameAdapter);

        ArrayAdapter<String> phoneNumberAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, phoneNumbers);
        actvSearchPhoneNumber.setAdapter(phoneNumberAdapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = etFirstName.getText().toString();
                String lastName = etLastName.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();

                etFirstName.setText("");
                etLastName.setText("");
                etPhoneNumber.setText("");

                firstNameAdapter.add(firstName);
                lastNameAdapter.add(lastName);
                phoneNumberAdapter.add(phoneNumber);
            }
        });
    }
}
