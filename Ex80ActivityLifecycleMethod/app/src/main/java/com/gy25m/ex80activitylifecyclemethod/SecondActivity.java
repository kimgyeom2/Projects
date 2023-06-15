package com.gy25m.ex80activitylifecyclemethod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("TAG","second_onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","second_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG","second_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG","second_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG","second_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG","second_onDestroy");
    }
}