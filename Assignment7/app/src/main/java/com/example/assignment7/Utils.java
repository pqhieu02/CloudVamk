package com.example.assignment7;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Utils {
    public static void showTimePickerDialog(Context context, final TimePickerDialog.OnTimeSetListener listener) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, listener, hour, minute, true);
        timePickerDialog.show();
    }

    public static void setupDatePicker(Context context, final DatePickerDialog.OnDateSetListener listener) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener, year, month, dayOfMonth);
        datePickerDialog.show();
    }

    public static LocalDateTime convertToDateTime(String timePart, String datePart) {
        if (timePart == null || timePart.isEmpty() || datePart == null || datePart.isEmpty()) {
            return LocalDateTime.now();
        }
        String dateTimeString = timePart + " " + datePart;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    public static void setupBtnActivityNavigator(Button btn, Context context, Class<?> destination) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to SearchActivity.java
                Intent intent = new Intent(context, destination);
                context.startActivity(intent);
            }
        });
    }
}
