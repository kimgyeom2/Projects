package com.gy25m.ex80activitylifecyclemethod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    // Activity클래스의 Lifecycle Method
    // 액티비티가 객체로 만들어져서 화면에 보여지고
    // 종료되어 메모리에서 사라질때 까지 상황에 따라 자동으로 실행되는
    // 생명주기 콜백메소드 주요 6개 메소드

    // 1. 액티비티가 처음 메모리에 만들어질때 자동으로 실행되는 메소드
    // 이 메소드가 실행되는 동안에는 어떤UI도 그려지지 않은 상태임
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("TAG","onCreate");

        findViewById(R.id.btn).setOnClickListener(view -> {
            Intent intent=new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
    }

    // 2. 액티비티에 뷰들이 보이기 시작할때 자동 호출 [ 이 메소드 실행중에는 터치해도 반응없음. ]


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","onStart");
    }

    // 3. 액티비티가 완전 보이고 터치도 가능한 상태

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG","onResume");
    }

    /////////////////////////////////////////////////////////////////
    // 위 1,2,3 메소드가 실행된 후 액티비티는 실행중인 상태가 됨[Running] //
    /////////////////////////////////////////////////////////////////

    // 4. 어떤 이유에서든 액티비티가 화면에서 안보이기 시작할때 자동 실행되는 메소드
    // 화면에 UI는 아직 안보이지만 터치는 안되는 상태가됨- 보통 이곳에서 스레드를 pause함
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG","onPause");
    }

    // 5. 완전히 안보일때 자동 실행되는 메소드

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG","onStop");
    }


    ///////////////////////////////////////////////////////////////
    // 액티비티가 다른액티비티에 의해 가려진 상태라면 4,5 메소드까지만 발동함
    ///////////////////////////////////////////////////////////////

    // 6. 폰의 '뒤로가기'버튼이나 finish() 메소드로 액티비티를 종료했을때
    // 액티비티가 메모리에서 소멸될때 자동으로 실행되는 메소드
    // 안드로이드 12버전(api 31)부터는 처음실행되는 액티비티는 [뒤로가기]버튼을 눌러도
    // finish안됨 왜? 다시실행시 속도개선 목적
    // 만약 뒤로가기로 종료시키고 싶다면.. onBackpressed재정의하여 finish하기 or 최신앱목록에서 swipe하여 제거
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG","onDestroy");
    }
}