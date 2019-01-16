package com.android.admin.week2daily1_car;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvYear;
    TextView tvMake;
    TextView tvModel;
    TextView tvColor;
    TextView tvEngine;
    TextView tvTransmissionType;
    TextView tvTitleStatus;

    public static final String TAG = "tag_act_one";
    public static final int RESULT_CODE = 666;
    SharedPreferences sharedPreferences;
    double d = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key", "sharedPrefValue");
        editor.commit();

        tvYear = findViewById(R.id.tvYear);
        tvMake = findViewById(R.id.tvMake);
        tvModel = findViewById(R.id.tvModel);
        tvColor = findViewById(R.id.tvColor);
        tvEngine = findViewById(R.id.tvEngine);
        tvTransmissionType = findViewById(R.id.tvTransmissionType);
        tvTitleStatus = findViewById(R.id.tvTitleStatus);

        if (savedInstanceState != null) {
            d = savedInstanceState.getDouble("d");
        }

        Log.d(TAG, "onCreate: ");
    }

    public void onClick1(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, RESULT_CODE);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivityForResult(intent, RESULT_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null){
            Intent passedIntent = data;
            Car passedCar = passedIntent.getParcelableExtra("car");
            tvYear.setText(passedCar.getYear());
            tvMake.setText(passedCar.getMake());
            tvModel.setText(passedCar.getModel());
            tvColor.setText(passedCar.getColor());
            tvEngine.setText(passedCar.getEngine());
            tvTransmissionType.setText(passedCar.getTransmissionType());
            tvTitleStatus.setText(passedCar.getTitleStatus());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putDouble("d", d);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.equals(Configuration.ORIENTATION_LANDSCAPE)){
            d = 2.0;
        } else {
            //something
        }
    }


}
