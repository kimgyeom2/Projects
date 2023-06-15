package com.gy25m.ex59broadcastreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(view -> clickBtn());
    }

    void clickBtn(){

        // Broadcast 보내기
        // 원래 방송은 안드로이드라는 운영체제가 보내는 것임. 이 예제에서는 실습목적으로..

        // 방송 : 실제 전파를 쏜다는 느낌이 아니라.. Intent 라는 객체가 모든 앱에게 전달되는 모습
        // 즉, 방송을 보낸다는 것은 Intent를 모든 앱에게 보내는 것임

        // 1. 명시적 인텐트 - 특정 리시버에게만 보내는 방송 (본인 앱안에 있는 리시버만 수신)
        //Intent intent=new Intent(this,MyReciever.class);
        //sendBroadcast(intent);

        // 2. 암시적 인텐트 - 디바이스에 설치된 모든 앱안에 있는 리시버가 듣는 방송 Intent
        // 안드로이드 OS에서 보내는 방송은 대부분 90%이상.. 암시적 인텐트임
        // Oreo버전부터 암시적 인텐트 방송은 system만 가능 고로 아래꺼 실행안됨-> 리시버만 만들줄 알면됨
        // 그럼에도 꼭 암시적 인텐트를 보내고 싶다면 리시버를 manifest가 아닌 자바에서 동적으로 등록하면 테스트가능
        Intent intent=new Intent();
        intent.setAction("aaa");  // 방송을 구별하는 식별자 역할[action]

        sendBroadcast(intent);
    }

    MyReciever myReciever;

    // 액티비티가 화면에 보여질때 자동으로 실행되는 콜백 메소드
    @Override
    protected void onResume() {
        super.onResume();

        // 리시버 등록
        myReciever=new MyReciever();
        IntentFilter filter=new IntentFilter();
        filter.addAction("aaa");

        // 리시버를 등록하면서 필터도 설정
        registerReceiver(myReciever,filter);
    }
    // 액티비티가 화면에서 안보이기 시작할 때 자동으로 실행되는 콜백 메소드


    @Override
    protected void onPause() {
        super.onPause();

        //리시버 등록해제
        unregisterReceiver(myReciever);
    }
}