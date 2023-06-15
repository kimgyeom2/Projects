package com.gy25m.ex47activity6systemintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(view -> {
            //다이얼화면 실행하기
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_DIAL);

            // 미리 전화번호까지 전달하려면
            intent.setData(Uri.parse("tel:01012345678"));

            startActivity(intent);
        });

        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);



        btn2.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:01012345678"));

            //문자내용을 프로그래밍
            intent.putExtra("sms_body","hello");

            startActivity(intent);
        });

        btn3.setOnClickListener(view -> {
            //크롬
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.naver.com"));  //액션+데이터
            startActivity(intent);
        });

        btn4.setOnClickListener(view -> {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });
    }
}