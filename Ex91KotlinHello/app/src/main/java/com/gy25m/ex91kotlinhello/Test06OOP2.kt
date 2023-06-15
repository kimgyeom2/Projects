package com.gy25m.ex91kotlinhello

fun main(){

    // 코틀린의 상속
    val obj:Second= Second()
    obj.a=10
    obj.b=30
    obj.show()
    println()

    // 업캐스팅, 다운캐스팅
    var f:First=Second() // 업캐스팅
    f.show() // 실제 참조하는 객체의 show가 호출
    println()

    // 형변환 연산자 as
    var s:Second=f as Second//다운캐스팅
    s.b=500
    s.show()
    println()

    // 상속 마무리 연습 Person-Student-Professor-Albasang
    var p= Person("sam", 20)
    p.show()
    println()

    var stu= Student("robin", 22, "android")
    stu.show()
    println()

    var pro=Professor("kim",45,"game")
    pro.show()
    println()

    var alb=AlbaStudent("hong",25,"ios","과제")
    alb.show()
    println()

}// main

// First를 상속하는 클래스
// 상속하는 클래스명 옆에 반드시 생성자호출문이 명시되어야함
class Second: First() {   // 디폴트가 final이라 open이라는 키워드가 있어야 상속가능
    // First의 멤버 a,show()를 보유한 상태
    var b:Int=20
    // 상속받은 show 메소드의 기능 개선 - override
    // 코틀린은 반드시 오버라이드임을 명시해야만 함
    override fun show(){
        super.show()
        println("b : $b")
    }

}

// 상속해줄 클래스 - open있어야 상속해줄 수 있음
open class First{
    var a:Int= 10

    // 기본이 final이여서 오버라이드 안됨
    // 허용하려면 open..
    open fun show(){
        println("a : $a")
    }
}

