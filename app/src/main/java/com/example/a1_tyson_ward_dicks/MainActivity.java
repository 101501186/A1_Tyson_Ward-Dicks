package com.example.a1_tyson_ward_dicks;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText workHoursInput, hourlyRateInput;
    Button btnSubmit, btnViewList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the UI references
        workHoursInput = findViewById(R.id.work_Hours);
        hourlyRateInput = findViewById(R.id.hours_Rate);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnViewList = findViewById(R.id.btnView_List);


        btnSubmit.setOnClickListener(v -> calculatePay());
    }

    private void calculatePay() {
        String hoursStr = workHoursInput.getText().toString().trim();
        String rateStr = hourlyRateInput.getText().toString().trim();

        if (hoursStr.isEmpty() || rateStr.isEmpty()) {
            Toast.makeText(this, "Please enter both hours and hourly rate", Toast.LENGTH_SHORT).show();
            return;
        }

        double hoursWorked, hourlyRate;
        try {
            hoursWorked = Double.parseDouble(hoursStr);
            hourlyRate = Double.parseDouble(rateStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input. Please enter numbers only.", Toast.LENGTH_SHORT).show();
            return;
        }

    }

}