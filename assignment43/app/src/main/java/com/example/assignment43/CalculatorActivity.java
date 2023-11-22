package com.example.assignment43;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder currentNumber;
    private double num1, num2;
    private String currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultTextView = findViewById(R.id.resultTextView);
        currentNumber = new StringBuilder();
        resetOperationButtonColor();
    }

    public void onDigitClick(View view) {
        String digit = ((Button) view).getText().toString();
        currentNumber.append(digit);
        updateDisplay();
    }

    public void onOperationClick(View view) {
        if (!currentNumber.toString().isEmpty()) {
            if (currentOperation != null) {
                // If an operation is already selected, calculate and display the result
                num2 = Double.parseDouble(currentNumber.toString());
                calculateResult();
            }
            num1 = Double.parseDouble(currentNumber.toString());
            currentOperation = ((Button) view).getText().toString();
            currentNumber.setLength(0); // Clear
            view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        }
    }

    public void onEqualClick(View view) {
        // Handle equal button click
        if (!currentNumber.toString().isEmpty() && currentOperation != null) {
            num2 = Double.parseDouble(currentNumber.toString());
            calculateResult();
            currentOperation = null;
        }
    }

    public void onResetClick(View view) {
        currentOperation = null;
        num1 = 0d;
        num2 = 0d;
        currentNumber.setLength(0);
        resetOperationButtonColor();
        resultTextView.setText("");
    }

    private void calculateResult() {
        double result = 0;
        System.out.println(num1 + " " + num2 + " " + currentOperation);
        switch (currentOperation) {
            case "+":
                result = num1 + num2;
                System.out.println("+" + result);
                break;
            case "-":
                System.out.println("-" + result);
                result = num1 - num2;
                break;
            case "*":
                System.out.println("x" + result);
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    System.out.println("-" + result);
                    result = num1 / num2;
                } else {
                    resultTextView.setText("Error");
                    resetOperationButtonColor();
                    return;
                }
                break;
        }

        resetOperationButtonColor();
        currentNumber.setLength(0);
        currentNumber.append(result);
        updateDisplay();
    }

    public void onPercentClick(View view) {
        if (!currentNumber.toString().isEmpty()) {
            double number = Double.parseDouble(currentNumber.toString());
            double result = number / 100.0;
            currentNumber.setLength(0);
            currentNumber.append(result);
            updateDisplay();
        }
    }

    private void updateDisplay() {
        resultTextView.setText(currentNumber.toString());
    }

    private void resetOperationButtonColor() {
        findViewById(R.id.plus).setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        findViewById(R.id.substract).setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        findViewById(R.id.multiply).setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        findViewById(R.id.division).setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
    }
}
