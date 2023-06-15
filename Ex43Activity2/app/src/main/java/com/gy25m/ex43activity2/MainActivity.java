package com.gy25m.ex43activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName,etAge;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.et_name);
        etAge=findViewById(R.id.et_age);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            //SecondActivity로 보낼 데이터
            String name=etName.getText().toString();
            int age=Integer.parseInt(etAge.getText().toString());

            //새로운 액티비티를 실행시켜줄 택배기사님 생성
            Intent intent=new Intent(this,SecondActivity.class);
            //새로운 액티비티에 보낼 데이터를 택배기사님에게 넣기
            intent.putExtra("name",name);   //"식별자",값  -->String
            intent.putExtra("age",age);     //            -->int

            startActivity(intent);
            
        });
    }
}