package com.gy25m.ex46activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            Intent intent=new Intent();
            intent.setAction("bbbb");  //예제45번의 세컨드실행
            startActivity(intent);
        });

    }
}