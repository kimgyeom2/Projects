package com.gy25m.ex79databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.gy25m.ex79databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // DataBinding - 뷰를 참조하지 않고 뷰가 보여주는 값을가진 변수제어
    // 안드로이드 아키텍처 구성요소 이기에 사용설정만 하면 됨

    // 뷰바인딩과 다르게 레이아웃 xml 파일의 최상위 요소가 반드시
    // <layout>이어야만 바인딩클래스들이 만들어짐

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //데이터 바인딩의 기능을 통해 액티비티에 보여줄 [내용물(View)->컨텐츠] 설정
        ActivityMainBinding binding =DataBindingUtil.setContentView(this,R.layout.activity_main);

        //이제 xml문서의 <data>요소 안에있는 <variable>의 type에 지정한
        //클래스를 객체로 만들어서 set()해주면 그와 연결한 뷰들의 값이 보여짐
        binding.setUser(new User("sam",20,true));


    }
}