package com.gy25m.ex94architecturepattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gy25m.ex94architecturepattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Architecture pattern 없이 그냥 작성하는 Flat Design(원래 하던거)작성
    // 장점 : 구조가 간단하여 구현하기 쉽고 하나의 문서안에 대부분의 기능,UI코드가 있어서 한눈에 들어옴
    // 단점 1 : Activity, Fragment에 모든 기능 코드가 있어서 규모가 커지면 파일안에 코드가 너무많은 코드가 있어서 비대해짐. 유지보수가 어려움
    // 단점 2 : 똑같은 데이터를 제어하는 코드를 다른 화면에서 사용하게 되더라도 같은 코드를 또 작성해야함. 재사용이 어려움

    // 그래서 등장한 Architecture Pattern
    // 작성 코드의 역할에 따라 구분하여서 작성하는 방법을 규격화 한 패턴
    // 대표적인 패턴 : MVC, MVP, MVVM
    // 차례대로 실습.. 새로운 '모듈'을 만들어서 실습 및 비교
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {

        // 화면 작업
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 이벤트 처리
        binding.btnSave.setOnClickListener {clcikSave()}
        binding.btnLoad.setOnClickListener {clcikLoad()}
    }

    // Data 제어(저장/로드/삭제/변경 : CRUD) 작업을 하는 비지니스 로직 코드 기능 메소드 2개..
    // [ex.. 네트워크 통신, DB작업 등..]
    private fun clcikSave(){
        val pref=getSharedPreferences("data", MODE_PRIVATE)
        pref.edit().apply {
            this.putString("name",binding.etName.text.toString())
            this.putString("email",binding.etEmail.text.toString())
            commit()
        }
    }

    private fun clcikLoad(){
        val pref=getSharedPreferences("data", MODE_PRIVATE)
        var name:String?=pref.getString("name","")
        var email:String=pref.getString("email","")!!
        binding.tv.text="$name : $email"
    }

}