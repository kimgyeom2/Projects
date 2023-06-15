package com.gy25m.ex91kotlinhello

// 코틀린 언어의 기초문법

// 문법적 주요 특징
// A. 문장의 끝을 나타내는 ';'(세미콜론) 사용하지 않음. 써도 Error는 아님 무시됨
// B. 변수를 만들때 자료형을 먼저 쓰지 않고 var,val 키워드 사용함. 단, 자료형은 존재,
//    자동 형변환x, 즉 정적타입 언어임
// C. new 키워드 없이 객체를 생성함 new String() -> String
// D. 안전하게 null을 다룰 수 있는 문법이 제공됨
// E. 코틀린은 함수형 언어다. 즉, 함수를 객체처럼 변수에 저장하고 파라미터로 넘겨주는 등의 작업가능
//    ex) 람다식 new 안하고 v-{}로 쓰는것

// #. 프로그램의 시작함수인 main함수가 반드시 있어야 함.
fun main(){

    // .kt 코틀린 파일만 별도로 실행하려면 마우스 우클릭으로
    // 해당파일 run메뉴 실행 - 결과는 하단 [run]탭에서 실행됨

    // 1. 화면(콘솔창-run탭) 출력 : print(),println()함수
    print(10)
    print(3.14)
    print("Nice")

    // print()는 자동으로 줄바꿈 안됨
    // 자동 줄바꿈을 하는 println()
    println()
    println("Hello Kotlin")
    println(10)
    println(213.47547)
    println("A")
    println(5+3)

    // 변수명을 전달하면 변수안의 값이 출력됨
    var a:Int=10
    println(a)
    var b:String="Hello"
    println(b)
    /////////////////////////////////////

    // 2.자료형과 변수
    // *코틀린 자료형의 종류
    // 1)기초 타입 : Boolean, Byte, Char, Short, Int, Long, Float, Double
    //   기본적으로 코틀린은 모든변수가 참조형임. 즉, 모든 변수가 참조변수
    // 2)참조 타입 : String, Random, Any(Java의 Object와 비슷), Unit...
    // 그 외 Kotlin APIs, Java APIs

    // * 변수의 2가지 종류: var, val [ 문법 -- var 변수명:자료형, val 변수명:자료형 ]
    // 2.1 var [값 변경이 가능한 변수]
    var num:Int= 10
    println(num)

    var num2:Double=3.14
    println(num2)

    // 권장하지는 않지만 변수를 만들때 값을 초기화하지 않아도됨 [단, 지역변수만]
    var num3:Float
    num3=5.23f
    println(num3)
    // 변수이므로 변수가 가지고 있는 값의 변경 가능
    num=20
    num2=4.35
    num3=8.32f
    println(num)
    println(num2)
    println(num3)

    // 자료형이 정해진 변수이므로 다른 자료형의 대입은 Error
    // num=3.14 //ERROR Int에 Double대입 불가능
    // num2=50  //Java에서는 더블에 인트대입 가능했었음

    // 명시적으로 형변환하여 값 대입해보기
    // [.to~()로 변환 가능 (기초타입들만)]
    num=3.14.toInt()
    println(num) //3
    num2=50.toDouble()
    println(num2) //50.0

    var s:String="Hello"
    println(s)

    // var s2:String=String("Hello")  //ERROR - 단순 문자열 객체를 생성할때 String()생성자 사용 불가
    // String 생성자는 Buffer나 Byte배열을 String객체로 생성할때만 사용함
    println()
    println()

    // 2.2 val [값 변경이 불가능한 변수 - 읽기전용 변수]
    // #'상수'와는 조금다름 - 상수는 'const val' 키워드 사용
    val n1:Int=100
    //n1=200 //error
    println(n1)

    val n2:Boolean=true
    //n2=false
    println(n2)

    // 권장하진 않지만 지역변수 선언할떄 초기화 안해도 되는 특징은 val도 마찬가지임
    val n3:String
    n3="Nice" //이때 값이 정해짐 이제 못바꿈
    println(n3)
    println()

    // var,val 사용 Tip: 만약 데이터를 가지고있는 변수 -> var [ex) name,age]
    // 객체를 참조하는 변수 -> val [ex) TextView, NotificationManager] 글씨는 바꿔도 참조대상을 바꾸는게 아님

    // 2.3 자료형을 생략하며 변수선언 가능함- 자료형은 자동추론됨
    val aa=10 //Int로 추론됨
    println(aa)

    val bb=3.14 //Double
    println(bb)

    var cc=3.14f //Float
    println(cc)

    var dd=true //Boolean
    println(dd)

    var ee='A' //Char
    println(ee)

    var ff="Hello" //String
    println(ff)
    // 주의! 변수선언시 자료형이 표기가 없지만 값을 대입하면서 자료형이 자동 추론된것임.
    // 변수는 자료형이 있는거임

    // 자료형 명시 생략을 통해 자동 추론하려면
    // 변수 선언하면서 반드시 값을 대입해야 함
    // var gg
    // gg=10

    // 정수값 표기의 특이한점 실생활에서 숫자의 3자리마다 ',' 구분과 비슷한 표기법
    var a3=5_000_000
    println(a3)  //출력은 구분자 안나옴

    // 2.4 코틀린만의 자료형 타입

    // Any타입 [ 자바의 Object처럼 최상위 타입 ]
    // 최상위 타입은 어떤 객체든 참조가 가능 - 편해보이지만 실제 개발할때 어떤 자료형인지 예측이 어려워서
    // 필요할때만 사용해야함
    var v:Any=10
    println(v)
    v=3.14
    v=2.23f

    // 2.5 null값에 대한 자료형 [null 안정성] 별도로 추가 수업예정- 여기서는 대략적인 특징만]
    // 코틀린은 자료형을 명시하면 null값을 저장할 수 없음
    // var nn:Int =null //error
    // var nn2:String =null //error
    // 기본적으로 null을 저장할 수 없음

    // null값을 가진 변수라고 표시할 수 있음 [Nullable 변수]
    var nn:Int?=null
    var ss:String?=null
    println(nn)
    println(ss)

    // nullable 변수 사용의 특이점
    var sss:String="Hello"
    println(sss.length)
    var ssss:String?="Hello"
    //println(ssss.length)  //error   Nullable변수는 그냥 .으로 멤버사용 불가
    println(ssss?.length) // ?.연산자 - null이 아닐때만 length찍어줌
    println()
    //////////////////////////////////////////////

    // * 화면 출력의 Format 만들기
    // 문자열 결합에 대한 내용
    println("Hello "+"Kotlin")
    // 숫자 타입과 String 타입은 자동 결합 안될 수 있음
    // println(10+"명") //error
    // 하려면 number타입을 String으로 변환해서 결합해야함
    println(10.toString()+"Nike")

    // 특이점 ㅋㅋ 문자열이 먼저 있으면 결합이 됨
    println("Hello"+30)

    // 변수 2개의 값을 덧셈하여 출력하는 코드
    var nnn1:Int=50
    var nnn2:Int=30
    // "50 + 30 = 80" 모양으로 포멧팅하여 출력
    // println(nnn1+"+"+nnn2+"="+(nnn1+nnn2)) error
    // println(nnn1.toString()+"+"+nnn2+"="+(nnn1+nnn2)) //맨 앞만 toString하면됨
    // println(""+nnn1+"+"+nnn2+"="+(nnn1+nnn2))

    // 위 방법 모두 별로임 결합연산으로 포멧팅하면 코드가 지저분함
    println("$nnn1 + $nnn2 = ${nnn1+nnn2}")  //${} 중괄호 쓰는게 정식표현
    // 이렇게 문자열안에 $변수명을 사용하는 것을 [문자열 템플릿]이라고 부름

    ///////////////////////////////////////////////////////////////////

}