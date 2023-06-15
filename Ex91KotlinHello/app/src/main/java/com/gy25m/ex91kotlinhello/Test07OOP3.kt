package com.gy25m.ex91kotlinhello

fun main(){


    // 안드로이드에서 많이사용하는..
    // 1) 이너클래스
    // 2) 인터페이스 및 익명클래스
    // 3) static 키워드를 대체한 companion object[동반객체]
    // 4) 늦은 초기화 - lateinit, by lazy

    // 1. 이너클래스
    val obj=AAA()
    // 이너클래스는 외부에서 직접 객체생성 불가능
    // 이너클래스 객체는 아우터 클래스만 만들 수 있음
    val obj2:AAA.BBB=obj.getBBBinstance()
    obj2.show()

    // 2. 인터페이스
    // 인터페이스는 객체 생성 불가 -  기능설계가 안되어있어서
    // var c: Clickable=Clickable()  //error
    // 인터페이스를 구현한 Test클래스를 객체로 생성
    var c:Clickable=Test() //upcasting     var c:Test=Test()로 해도되지만 clcick용으로 만들었다는걸 알려주기위해
    c.onClick()
    println()

    // 2.1 익명클래스
    // 다른기능을 하는 또 다른 Clickable필요
    // 또 다시 Test같은 새로운 class를 명명하는것이 짜증
    // 객체생성하면서 인터페이스를 그 자리에서 구현하는 이름없는 클래스 사용
    // 익명클래스 객체를 만드는 키워드 object
    var c2:Clickable= object : Clickable{
        override fun onClick() {
            println("apple")
        }
    }
    c2.onClick()
    println()

    // 3. 동반객체 : 정적멤버 static 키워드의 대체문법
    // 클래스(설계도면)에 붙어 있는 객체같은 녀석
    // 별도의 객체생성없이 클래스명만으로 접근가능한 녀석
    // println(Sample.a) //error
    println(Sample.title)
    Sample.show()

    // 4. 늦은초기화
    // 4.1 lateinit [var변수만 사용]
    var h:Hello= Hello()
    //println(h.name)  //Exception발동
    h.onCreate()
    println(h.name)

    // 4.2 by lazy  [val변수만 사용가능]
    println(h.add) //add변수는 객체생성할때 초기화
    println(h.address) // 이 순간 초기화
    println(h.tel) // 이 순간 초기화

}// main

class Hello {
    // 4.1) lateinit
    // var name:Sttring //ERROR - 초기화 없으면

    // 만약나중에 하고 싶다면
    lateinit var name:String

    fun onCreate(){
        name="sam"  //이때 초기화됨
    }

    // lateinit 사용 특징
    // 1) nullable 변수는 lateinit 불가
    // lateinit var title:String? //error

    // 2) 기본자료형(8개)은 사용불가
    // lateinit var age:Int //error 기본값을 넣어놓으면 되기때문

    // 3) val에는 사용불가

    // 4.2) by lazy
    //val address:String //error 초기화 안해서
    val address:String by lazy {"Seoul"} // 이 변수가 처음 사용될 때 초기화
    val add:String ="Busan" // 이 순간 초기화

    val tel:String by lazy {
        println("늦은 초기화")
        "01012345678"
    }

    // by lazy의 특징
    // 1) 기본형 자료형도 가능함
    val age:Int by lazy { 20 }

    // 2) nullable도 가능함
    val message:String by lazy { "Hello" }
    val message2:String? by lazy { "Hello" }

    // 3) 조건값으로 값대입도 가능함
    val message3:String by lazy {
        if (age<20) "미성년자"
        else "성인"
    }

    // 4) var에는 사용불가
    // var sss:String by lazy( " Nice ") //error
}

class Sample{
     var a:Int=10 // 인스턴스 변수는 객체생성 할때만 사용가능
    // static var b:Int=20   static없음

    companion object{
        // 이 안에 있는 멤버들은 이미 객체화 되었기에
        // 그냥사용가능 [단, Sample클래스에 동반되었기에 클래스명이 요구됨]
        var title:String="Hello"
        fun show(){
            println("동반 객체의 show")
        }
    }
}


    // 인터페이스의 추상메소드를 구현하는 별도의 class를 설계하고
    // 이 클래스를 객체로 만들어서 사용해야함
    // implement 키워드 대신 상속처럼 :기호 사용
    // 인터페이스를 구현할때는 상속과 다르게 인터페이스명 옆에 ()생성자 호출문 없음
    class Test:Clickable{
        override fun onClick() {
            println("Clicked")
        }
    }

    // 인터페이스는 특별한것이 없음 - 추상메소드만 가진 class
    interface Clickable{
        // 추상메소드만 가짐  - 이름만 가진 메소드
        fun onClick()    // 앞에 abstract생략가능
    }

class AAA{
    var a:Int=0

    fun show(){
        println("AAA클래스의 show : $a")
    }

    // 이너클래스 객체를 생성하여 리턴해주는 기능메소드

    fun getBBBinstance():BBB{
        return BBB()
    }

    // 이너클래스 - inner키워드가 있어야 inner클래스
    inner class BBB{
        fun show(){  // 위 show랑 아무상관없음
            // 이너클래스의 장점 - 아우터의 멤버를 내것인양 사용가능
            a=100   // inner없으면 이거 안됨
            println("아우터 클래스의 멤버 a : $a")

            // 아우터의 show메소드 호출하기
            // show() // 이건 내 show()
            this@AAA.show()  // 진짜 많이씀 MainActivity.this이게 이거임
            println()
        }
    }
}