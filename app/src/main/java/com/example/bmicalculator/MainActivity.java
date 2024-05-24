package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight,edtHeightFt,edtHeightI;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeight);
        edtHeightI = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain  = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightI.getText().toString());

                int totalIn = ft*12 + in;
                double totalCm = totalIn*2.54; // Changed 2.53 to 2.54 for accurate conversion
                double totalM  = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if (bmi < 18.5) {
                    txtResult.setText("Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Un));
                } else if (bmi >= 18.5 && bmi <= 24.9) { // Changed || to &&
                    txtResult.setText("Normal");
                    llMain.setBackgroundColor(getResources().getColor(R.color.N));
                } else if (bmi >= 25 && bmi <= 29.9) { // Changed || to &&
                    txtResult.setText("Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Ow));
                } else {
                    txtResult.setText("Obese");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Ob));
                }

            }
        });

    }
}