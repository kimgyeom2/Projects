package com.gy25m.activityex;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RecyclerView recyclerView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(view -> {
            Intent intent=new Intent();
            intent.setAction("input");

            launcher.launch(intent);
        });
    }
    ActivityResultLauncher launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            recyclerView=findViewById(R.id.recycle);
            if(result.getResultCode()== RESULT_OK){
                Intent intent=result.getData();
                String name=intent.getStringExtra("name");
                String nickname=intent.getStringExtra("nickname");
                String title=intent.getStringExtra("title");
                String bon=intent.getStringExtra("bon");
                adapter=new MyAdapter(MainActivity.this,name,nickname,title,bon);
                recyclerView.setAdapter(adapter);
            }
        }
    });
}