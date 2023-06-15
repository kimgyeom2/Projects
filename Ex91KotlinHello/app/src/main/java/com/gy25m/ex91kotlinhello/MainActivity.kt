package com.gy25m.ex91kotlinhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

//Kotlin에서 상속에 관한 키워드는 ":"이며 상속하는 클래스명 옆에 '주생성자'를 호출하는 ()가 필수임
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //대략적인 코틀린의 코딩방식 살펴보기- 자바와의 차이점 기반으로 소개

        //변수는 var키워드 사용
        var btn:Button = findViewById(R.id.btn)
        
        //버튼에 리스너 설정 Java의 람다식과 비슷한 SAM변환 제공
        btn.setOnClickListener{
            clickBtn()
        }
    }

    //Kotlin에서의 메소드(함수)는 fun키워드 사용
    fun clickBtn(){
        //변수 선언시 자료형을 생략할 수 있음
        var tv=findViewById<TextView>(R.id.tv)
        //tv.setText("text changed")

        //Kotlin에서는 set~() 메소드를 권장하지 않고 멤버변수에 값 대입을 선호함
        tv.text="Text changed"  //내부적으로는 setText함
    }

    // 오버라이드 메소드가 Java에서는 @override 어노테이션 사용했지만
    // 코틀린에서는 메소드 앞에 override 키워드 삽입
    // 오버라이드 메소드 앞에 명시적으로 override 키워드가 없으면 에러
    override fun onResume() {
        super.onResume()

        // 코틀린에서는 소문자로 toast를 써야 자동완성
        Toast.makeText(this, "안농", Toast.LENGTH_SHORT).show()
    }







}