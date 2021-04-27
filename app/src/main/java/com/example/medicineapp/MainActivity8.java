package com.example.medicineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity {

    TextView viewAppointment, viewAppointmentInfo;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        viewAppointment = findViewById(R.id.textView22);
        Bundle bundle = getIntent().getExtras();
        String data_output = bundle.getString("output_data");
        //String data_output = getIntent().getStringExtra("output_data");
        viewAppointment.setText(data_output);

        viewAppointmentInfo = findViewById(R.id.textView26);
        Bundle bundlesecond = getIntent().getExtras();
        String data_outputsecond = bundlesecond.getString("output_datasecond");
        viewAppointmentInfo.setText(data_outputsecond);

        button = findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity9.class);
                startActivity(intent);
            }
        });
    }
}