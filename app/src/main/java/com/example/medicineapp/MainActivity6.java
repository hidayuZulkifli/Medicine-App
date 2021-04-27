package com.example.medicineapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    TextView viewMedicineName;
    ImageView viewMedicineImage;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        viewMedicineName = findViewById(R.id.textView18);
        viewMedicineImage = findViewById(R.id.imageView2);

        Bundle bundleimage = getIntent().getExtras();
        if (bundleimage!=null) {
            int res_image =bundleimage.getInt("output_image");
            viewMedicineImage.setImageResource(res_image);
        }

        Bundle bundle = getIntent().getExtras();
        String data_output = bundle.getString("output_data");
        //String data_output = getIntent().getStringExtra("output_data");
        viewMedicineName.setText(data_output);

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(intent);
            }
        });

    }
}