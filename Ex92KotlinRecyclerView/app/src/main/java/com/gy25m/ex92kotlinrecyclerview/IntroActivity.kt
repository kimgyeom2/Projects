package com.gy25m.ex92kotlinrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class IntroActivity : AppCompatActivity() {

    // 코틀린은 멤버변수(프로퍼티)를 초기화하지 않으면 error
    var btn:Button?=null   // 멤버변수가 Oncreate전에 만들어짐으로 find해도 못찾음

    // 늦은 초기화 문법
    lateinit var btn2:Button  // 다 이거씀

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        btn=findViewById(R.id.btn)
        // nullable변수는 null일수도 있기에 안전하게 멤버에 접근하는 연산자(?-null이 아니면)를 사용해야함
        btn?.setOnClickListener(object : OnClickListener{
            override fun onClick(p0: View?) {
                var intent:Intent=Intent(this@IntroActivity,MainActivity::class.java)
                startActivity(intent)
            }
        })

        btn2=findViewById(R.id.exit)
        // 리스너 설정 람다로해보기
        // btn2.setOnClickListener({v->finish()})
        // 파라미터가 1개라면 생략가능  자동 it키워드로 파라미터명 지정됨
//        btn2.setOnClickListener({
//            finish()
//        })
        // 람다를 더 줄여서 SAM(Single abstract method)변환
        btn2.setOnClickListener{
            finish()
        }


    }
}