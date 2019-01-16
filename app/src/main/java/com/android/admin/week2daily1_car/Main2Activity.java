package com.android.admin.week2daily1_car;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText etYear;
    EditText etMake;
    EditText etModel;
    EditText etColor;
    EditText etEngine;
    EditText etTransmissionType;
    EditText etTitleStatus;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        String getFromSharedPrefString = sharedPreferences.getString("key", "No Value Has Been Saved");
        etYear = findViewById(R.id.etYear);
        etMake = findViewById(R.id.etMake);
        etModel = findViewById(R.id.etModel);
        etColor = findViewById(R.id.etColor);
        etEngine = findViewById(R.id.etEngine);
        etTransmissionType = findViewById(R.id.etTransmissionType);
        etTitleStatus = findViewById(R.id.etTitleStatus);

        //Intent intent = getIntent();
    }


    public void onClick(View view) {
        //String passToMain = "I was in activity 2! Send help!";
        String year = etYear.getText().toString();
        String make = etYear.getText().toString();
        String model = etModel.getText().toString();
        String color = etColor.getText().toString();
        String engine = etEngine.getText().toString();
        String transmissionType = etTransmissionType.getText().toString();
        String titleStatus = etTitleStatus.getText().toString();
        Car car = new Car(year, make, model, color, engine, transmissionType, titleStatus);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("car", car);  //car    was passToMain
        setResult(666, intent);
        finish();
    }
}
