package com.example.medicineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    EditText editappointmenttype, editvenue, editdrname;
    Button buttonfive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        editappointmenttype = findViewById(R.id.editTextTextPersonName);
        editvenue = findViewById(R.id.editTextTextPersonName3);
        editdrname = findViewById(R.id.editTextTextPersonName5);
        buttonfive = findViewById(R.id.button11);

        buttonfive.setOnClickListener((v) -> {
            StringBuilder output = new StringBuilder();
            output.append(editappointmenttype.getText().toString() + "\n");
            output.append("\n");
            StringBuilder outputsecond = new StringBuilder();
            outputsecond.append("Venue : " + editvenue.getText().toString() + "\n");
            outputsecond.append("Doctor Name : " + editdrname.getText().toString() + "\n");

            Intent intenttwo = new Intent(this, MainActivity8.class);

            Bundle bundle = new Bundle();
            bundle.putString("output_data", output.toString());
            bundle.putString("output_datasecond", outputsecond.toString());
            intenttwo.putExtras(bundle);
            //intenttwo.putExtra("output_data", output.toString());
            startActivity(intenttwo);
        });
    }
}