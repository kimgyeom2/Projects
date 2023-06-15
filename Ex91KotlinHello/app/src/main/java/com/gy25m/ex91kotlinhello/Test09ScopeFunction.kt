package com.gy25m.ex91kotlinhello

import android.app.AlertDialog

fun main(){
    // scope function : apply, let, run, also

    // 어떤 객체의 여러개의 멤버를 사용해야 할때
    var member= Member()
    member.name="sam"
    member.age=20
    member.address="seoul"
    member.show()

    // 멤버 4개를 사용할때 객체명.~라고 쓰는게 은근 번거로움
    // 실수의 여지도 많음
    // 이를위해 등장한 Scope 함수
    val member2=Member()
    member2.apply {
        //이 영역안에서는 this가 member2임
        this.name="robin"
        // this 생략가능
        age=25
        address="부산"

        show() // 메소드 호출도 가능
    }
    // 위처럼 영역을 묶었기 때문에 참조변수명을 잘못 기입하는 실수를 줄일수 있으며
    // 개발자가 볼때 member2에 대한 설정을 하나의 영역에 묶어서 가독성이 개선됨

    // scope function의 크게 2가지 분류
    // 1) 영역안에서 this키워드로 본인을 참조하는 scope function : apply, run
    // 2) 영역안에서 it키워드로 본인을 참조하는 scope funciton : also, let
    val member3=Member()
    member3.also {
        it.name="hong"
        //it은 생략안됨
        it.age=30
        it.address="paris"
        it.show()
    }
    member3.let {m->
        m.name="lee"
        m.age=35
        m.address="tokyo"
        m.show()
    }

    // apply와 run의 차이는 return값이 다름
    // also와 let의 차이도 return값이 다름

    // 안드로이드에서 사용하는 모습 샘플
//    val builder: AlertDialog.Builder= AlertDialog.Builder(this)
//    builder.setTitle("aaa")
//    builder.setMessage("bbbb")
//    builder.setPositiveButton("OK",null)
//    builder.setNegativeButton("aa", null)
//    val dialog= builder.create()
//    dialog.show()
//
//    val builder2: AlertDialog.Builder= AlertDialog.Builder(this)
//
//    //run function의 마지막실행문의 결과가 리턴값
//    val dialog2= builder2.run {
//        setTitle("sss")
//        setMessage("asdfasdfa")
//        setPositiveButton("OK",null)
//        setNegativeButton("ss",null)
//        create()
//    }
//    dialog2.show()
//
//    //apply function의 리턴값을 this임
//    val builder3= builder2.apply {
//        setTitle("sss")
//        setMessage("asdfasdfa")
//        setPositiveButton("OK",null)
//        setNegativeButton("ss",null)
//        create()
//    }

}

class Member{
    var name:String?=null
    var age:Int?=null
    var address:String?=null

    fun show(){
        println("$name $age $address")
    }
}