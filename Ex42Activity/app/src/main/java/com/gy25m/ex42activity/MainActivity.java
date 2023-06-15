package com.gy25m.ex42activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 두번째 화면[SecondActivity]으로 이동

                // SecondActivity를 실행시켜줄 택배기사님 객체 생성
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);

                // 택배기사를 통해 새로운 액티비티를 실행
                startActivity(intent);

                // 현재 액티비티를 종료 (안쓰면 세컨드에서 뒤로가기하면 메인나옴)
                finish();

            }
        });

        btn2=findViewById(R.id.btn2);
        // 람다식 표기 - 익명클래스의 축약표현
        btn2.setOnClickListener( view -> {
            //ThirdActivity를 실행 시켜줄 택배기사 객체 생성
            //익명클래스를 생략함으로 인해 this만 쓰면됨
            Intent intent=new Intent(this,ThirdActivity.class);
            startActivity(intent);
        } );

    }
}