package com.gy25m.ex91kotlinhello

fun main(){
    // 코틀린 언어의 주요 특징 중 하나
    // Null Pointer Exception[NPE]에 대한 안정성 보유한 언어

    // 코틀린은 null값을 저장할 수 있는 타입을 명시적으로 구분하여
    // 사용하도록 하고 있음
    // var s1:String=null //error - non nullable 변수
    var s2:String?=null //nullable 변수
    println(s2)

    // nullable 변수들을 사용할 때 특이한 멤버접근 연산자들
    var str1:String = "Hello" // non nullable variable
    var str2:String? = "Nice" // nullable variable

    // 멤버 사용법의 차이
    println("글자수 : " + str1.length)
    //println("글자수 : " + str2.length) //error - null일수도 있으니 막 사용지 말라고..에러로 표기

    //해결방법 : null이 아닐때만 하도록..
    if(str2!=null){
        //이 영역은 null이 아님이 확실
        println("글자수 : " + str2.length)
    }

    // 위 if문 처리는 번거로움.
    // 그래서 등장한 null 안정성 접근 연산자들
    //1) ?. 연산자 : null safe 연산자
    println("글자수 : " + str2?.length) //만약 null이 아니면 lenght 사용

    str2= null
    println("글자수 : " + str2?.length) //만약 null이면 그냥 null값으로 나옴

    // 객체 null일때 그냥 null로 값이 전달되는 것이 싫고..
    // 내가 원하는 값으로 나왔으면 한다면?
    // 객체가 null이면 길이값이 -1 이 나왔으면....
    val len:Int= if(str2!=null) str2.length else -1
    println(len)

    //if else문이 번거롭다면..
    //2) ?: 연산자 - 엘비스 [ Elvis ] 연산자
    val len2:Int=str2?.length ?: -1
    println(len2)


    // 이런식으로 NPE에 안전한 연산자 기능이 있지만
    // 이 기능을 사용하지 않고 그냥 null이면 예외가 났으면..
    // 즉, 원래 자바처럼 쓰고싶다면..
    // 다시말해 null이 아님을 확신할때 사용하는 연산자
    // 3) non-null asserted call 연산자 !!
    var ss:String?= "Hello"
    //println(ss.length) //error
    println("글자수 : "+ ss!!.length)


    var sss:String?=null
    //println(sss!!.length) //NPE
    println()

    // non-nullable 변수에 nullable변수를 넣을때 사용
    var mmm:String?="Nice"
    var nnn:String=mmm!! // mmm은 null일수도 있어서
    // 근데 아니니까 null아니라고 주장 !!

    var ttt:String="Good"
    var xxx:String?=ttt // 그냥 OK


    // 4) 안전한 캐스팅(형변환) 연산자 as? - 자료형이 맞지않는 타입을 억지로 형변환하는 경우
    val yyy:YYY?=YYY()

    // val zzz:ZZZ?=yyy //error
    //val zzz:ZZZ?=yyy as ZZZ // 억지로 형변환하면 에러 표시는 없지만 Exception 발생

    // 안전하게 형변환을 수행하는 연산자
    val zzz:ZZZ? = yyy as? ZZZ //형변환이 불가하면 에러가아니라 null값전달
    println(zzz)
}

class YYY{
    var a=10
}

class ZZZ{
    var a=20
}