package com.gy25m.ex97databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gy25m.ex97databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 데이터 바인딩에서는 뷰 바인딩과 다르게 레이아웃 xml 파일의
    // root 요소가 <layout>이어야만 바인딩 클래스가 만들어짐

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        // 레이아웃 xml에서  <data>요소 안에있는 <variable>의
        // 타입으로 지정한 User클래스를 객체로 생성하여 값을 지정

        binding.user=User("sam",20)


    }
}