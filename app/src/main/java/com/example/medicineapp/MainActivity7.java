package com.example.medicineapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity7 extends AppCompatActivity {

    ImageView medicineImage;
    EditText addMedicineName;
    Button addImage, sendButton;
    TextView outputthree;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        addMedicineName = findViewById(R.id.editTextTextPersonName2);
        medicineImage = findViewById(R.id.imageView6);
        sendButton = findViewById(R.id.button8);
        outputthree = findViewById(R.id.textView19);
        sendButton.setOnClickListener((v) -> {

            StringBuilder outputimage = new StringBuilder();
            outputimage.append(medicineImage.getResources().toString());

            StringBuilder outputthree = new StringBuilder();
            outputthree.append(addMedicineName.getText().toString() + "\n");

            Intent intenttwo = new Intent(this, MainActivity6.class);

            Bundle bundle = new Bundle();
            bundle.putString("output_image", outputimage.toString());
            bundle.putString("output_data", outputthree.toString());
            intenttwo.putExtras(bundle);
            //intenttwo.putExtra("output_data", output.toString());
            startActivity(intenttwo);

        });

        addImage = findViewById(R.id.button9);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check runtime permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED) {
                        //permission not granted, request it
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else {
                        //permission already granted
                        pickImageFromGallery();
                    }
                }
                else {
                    //system os is less than marshmallow
                    pickImageFromGallery();
                }
            }
        });

    }

    private void pickImageFromGallery() {
        //intent to pick image
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);

    }

    //handle result of runtime permisson
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length >0 && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED) {
                    //permission was granted
                    pickImageFromGallery();
                }
                else {
                    //permission was denied
                    Toast.makeText(this, "Permission denied !", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    //handel result of picked image

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            medicineImage.setImageURI(data.getData());
        }
    }
}