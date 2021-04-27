package com.example.medicineapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    EditText editMedicineName, editDosage;
    Spinner spinnerdosage, spinneroccurence;
    CheckBox checkBoxBefore, checkBoxAfter;
    Button buttonthree;
    Button buttonfour;
    TextView output;
    TextView outputsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        output = findViewById(R.id.textView10);
        editMedicineName = findViewById(R.id.editTextTextPersonName4);
        editDosage = findViewById(R.id.editTextNumberDecimal3);

        spinnerdosage = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dosage, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerdosage.setAdapter(adapter);

        spinneroccurence = findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adaptertwo = ArrayAdapter.createFromResource(this, R.array.occurrence, android.R.layout.simple_spinner_item);
        adaptertwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneroccurence.setAdapter(adaptertwo);

        checkBoxBefore = findViewById(R.id.checkBox);
        checkBoxAfter = findViewById(R.id.checkBox2);

        buttonfour = findViewById(R.id.button4);
        buttonfour.setOnClickListener((V) -> {
            StringBuilder output = new StringBuilder();
            output.append(editMedicineName.getText().toString() + "\n");
            output.append("\n");
            StringBuilder outputsecond = new StringBuilder();
            outputsecond.append("Dosage : " + editDosage.getText().toString() + " " + spinnerdosage.getSelectedItem() + "\n");
            outputsecond.append("Occurrence : " + spinneroccurence.getSelectedItem() + "\n");
            outputsecond.append("Instruction : " + "\n");
            if (checkBoxBefore.isChecked()) {
                outputsecond.append("Take before meals" + "\n");
            }
            if (checkBoxAfter.isChecked()) {
                outputsecond.append("Take after meals" + "\n");
            }

            Intent intenttwo = new Intent(this, MainActivity5.class);

            Bundle bundle = new Bundle();
            bundle.putString("output_data", output.toString());
            bundle.putString("output_datasecond", outputsecond.toString());
            intenttwo.putExtras(bundle);
            //intenttwo.putExtra("output_data", output.toString());
            startActivity(intenttwo);

        });

    }
}