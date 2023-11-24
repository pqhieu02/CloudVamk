package com.example.assignment52;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<>();

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
        final Button btnSave = findViewById(R.id.btnSave);
        final Button btnClear = findViewById(R.id.btnClear);

        actvSearchFirstName = findViewById(R.id.actvSearchFirstName);
        actvSearchLastName = findViewById(R.id.actvSearchLastName);
        actvSearchPhoneNumber = findViewById(R.id.actvSearchPhoneNumber);

        ArrayAdapter<String> firstNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                String item = getItem(position);
                if (item != null || item.isEmpty()) {
                    String[] parts = item.split(":");
                    if (parts.length > 1) {
                        textView.setText(parts[0].trim());
                    }
                }

                return view;
            }
        };
        actvSearchFirstName.setAdapter(firstNameAdapter);

        ArrayAdapter<String> lastNameAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, data) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                String item = getItem(position);
                if (item != null || item.isEmpty()) {
                    String[] parts = item.split(":");
                    if (parts.length > 1) {
                        textView.setText(parts[0].trim());
                    }
                }

                return view;
            }
        };
        actvSearchLastName.setAdapter(lastNameAdapter);

        ArrayAdapter<String> phoneNumberAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line, data){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                String item = getItem(position);
                if (item != null || item.isEmpty()) {
                    String[] parts = item.split(":");
                    if (parts.length > 1) {
                        textView.setText(parts[0].trim());
                    }
                }

                return view;
            }
        };
        actvSearchPhoneNumber.setAdapter(phoneNumberAdapter);
        actvSearchFirstName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                String[] parts = selection.split(":");
                String firstName = parts[1];
                String lastName = parts[2];
                String phone = parts[3];

                actvSearchFirstName.setText(firstName);
                actvSearchLastName.setText(lastName);
                actvSearchPhoneNumber.setText(phone);
            }
        });

        actvSearchLastName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                String[] parts = selection.split(":");
                String firstName = parts[1];
                String lastName = parts[2];
                String phone = parts[3];

                actvSearchFirstName.setText(firstName);
                actvSearchLastName.setText(lastName);
                actvSearchPhoneNumber.setText(phone);
            }
        });

        actvSearchPhoneNumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                String[] parts = selection.split(":");
                String firstName = parts[1];
                String lastName = parts[2];
                String phone = parts[3];

                actvSearchFirstName.setText(firstName);
                actvSearchLastName.setText(lastName);
                actvSearchPhoneNumber.setText(phone);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actvSearchFirstName.setText("");
                actvSearchLastName.setText("");
                actvSearchPhoneNumber.setText("");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNameAdapter.add(
                        etFirstName.getText().toString() + ":" +
                        etFirstName.getText().toString() + ":" +
                        etLastName.getText().toString() + ":" +
                        etPhoneNumber.getText().toString()
                );
                lastNameAdapter.add(
                        etLastName.getText().toString() + ":" +
                        etFirstName.getText().toString() + ":" +
                        etLastName.getText().toString() + ":" +
                        etPhoneNumber.getText().toString()
                );
                phoneNumberAdapter.add(
                        etPhoneNumber.getText().toString() + ":" +
                        etFirstName.getText().toString() + ":" +
                        etLastName.getText().toString() + ":" +
                        etPhoneNumber.getText().toString()
                );

                etFirstName.setText("");
                etLastName.setText("");
                etPhoneNumber.setText("");
            }
        });
    }

    public static void autofill(AutoCompleteTextView autoCompleteTextView, String text) {
        autoCompleteTextView.setText(text);
    }
}
