package com.example.medicineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    ImageButton buttonone, buttontwo, buttonthree, buttonfour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonone = findViewById(R.id.imageButton);
        buttonone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });

        buttontwo = findViewById(R.id.imageButton2);
        buttontwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intenttwo = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(intenttwo);
            }
        });

        buttonthree = findViewById(R.id.imageButton3);
        buttonthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentthree = new Intent(getApplicationContext(), MainActivity9.class);
                startActivity(intentthree);
            }
        });

        buttonfour = findViewById(R.id.imageButton4);
        buttonfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentfour = new Intent(getApplicationContext(), MainActivity10.class);
                startActivity(intentfour);
            }
        });

    }
}