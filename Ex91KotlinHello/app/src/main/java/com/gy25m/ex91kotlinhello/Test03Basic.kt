package com.gy25m.ex91kotlinhello

fun main(){

    // 6.배열 Array & 컬렉션 Collection
    // 6.1 배열 - 요소의 개수변경이 불가능한 배열 : Array
    // var aaa = arrayOf(10,20,30) 자동추론
    // 제네릭사용할때 주의점!! 제네릭<>다음에 대입연산자가 붙어있으면 안됨 <>=   >=랑헷갈림
    var aaa: Array<Int> = arrayOf(10,20,30)
    // 요소값 출력
    println(aaa[0])
    println(aaa[1])
    println(aaa[2])
    println()

    // 요소 값 변경도 특별한거 없음 개수만 못바꿈
    aaa[0]=100
    println(aaa[0])
    println()

    // 배열의 길이값 멤버변수 [Java의 배열은 length]
    println("배열의 길이 : ${aaa.size}")
    println()

    // 요소값을 일일이 접근하는거 짜증. 반복문 이용
    for (i in 0 until aaa.size){
        println(aaa[i])
    }
    println()

    // 배열은 어차피 연속된 인덱스 번호의 나열이니까
    // 0..2 나 배열변수를 놓으나 같은 개념처럼 접근가능
    // 마치 Java의 확장된 for문처럼
    for (t in aaa){ //t는 인덱스번호가 아님 요소값임
        println(t)
    }
    println()

    // 향상된 for문법을 사용하면서도 index번호로 반복하고 싶다면
    for (i in aaa.indices){
        println("$i : ${aaa[i]}")
    }
    println()

    // 혹시 인덱스와 값을 동시에 가져오고 싶다면
    for((i,v) in aaa.withIndex()){
        println("$i : $v")
    }
    println()

    // 배열 객체 멤버안에 요소값 각각을 반복적으로 접근할때마다
    // {}안에 있는 코드가 자동으로 발동하는 forEach기능 있음
    // 중괄호안에 it이라는 특별한 매개변수가 존재함
    // 그 it이 각요소 참조변수임
    aaa.forEach {
        println(it)
    }
    println()

    var bbb :Array<String> = arrayOf("aaa","bbb","ccc")
    bbb.forEach {
        println(it)
    }
    println()

    // 배열을 만들면서 자동추론을 적용할때 타입을 명시하는데
    // 기본형 타입에 대해서는 별도의 생성 함수가 존재함
    var ccc= arrayOf<Int>(10,20,30)

    var ddd= intArrayOf(10,20,30)
    var eee= doubleArrayOf(3.14,2.65)
    // stringArrayof같은건 없음

    // 빈 배열 5개짜리 만드는 형태
    var fff= arrayOf<Int>() // 0개짜리 배열
    var ggg= arrayOf<Int>(0,0,0,0,0)

    // 배열의 요소값의 시작을 그냥 null값을 주며 개수를 지정가능
    var hhh= arrayOfNulls<Double>(5)
    for (t in hhh) println(t)
    println()

    //즉, 배열은 요소의 개수변경이 불가한 특징!


    //6.2 컬렉션 - List, Set, Map 특성의 대량의 데이터들
    // 1) List : 요소가 순서대로 저장됨. 인덱스번호 자동부여. 중복데이터 허용
    // 2) Set  : 요소 순서 X         . 인덱스번호 X     . 중복데이터 X
    // 3) Map  : 요소 순서 X. 인덱스번호 대신에 키값 사용. 중복 키X,중복 값O

    // 코틀린의 Collection 들은 모두 요소의 추가/삭제 및 변경이 불가한 종류가 가능한 종류나 나뉘어 짐.
    // 6.2.1 요소개수 추가/삭제 및 변경이 모두 불가한 컬렉션 : listOf(), setOf(), mapOf()
    // 6.2.2 요소개수 추가/삭제 및 변경이 모두 가능한 컬렉션 : mutableListOf(), mutableSetOf(), mutableMapOf()

    // 6.2.1
    // 1) List
    val list: List<Int> = listOf(10,20,30)
    for(i in list){
        println(i)
    }
    println()

    // 값의 추가/삭제/변경에 관련된 어떤 기능메소드 없음
    // list.add()
    // list.set()
    // list.remove()

    // 2) Set
    val set:Set<Double> = setOf(3.14,5.35,6.78,5.35) // 중복데이터는 자동 무시
    for (e in set){
        println(e)
    }
    println()

    // 3) Map
    // 3-1) Pair()객체를 이용하여 키-밸류 지정
    val map:Map<String,String> = mapOf(Pair("title","Hello"), Pair("msg","Nice to meet you"))
    println("요소의 개수 : ${map.size}")
    for ((key,value) in map){
        println("$key : $value")
    }
    println()

    // 3-2) to연산자를 이용하여 키-밸류 지정
    val map2:Map<String,String> = mapOf("id" to "kg5832","password" to "1234")
    for ((k,v) in map2){
        println("$k : $v")
    }
    println()
    println()

    // 6.2.2 요소의 추가/삭제/변경이 모두 자유로운 Mutable~ - 가장많이 사용@@@@
    // 1) MutableList
    val aaaa:MutableList<Int> = mutableListOf(10,20,30)
    println("요소개수 : ${aaaa.size}")
    aaaa.add(40)
    aaaa.add(0,50)
    println("요소개수 : ${aaaa.size}")
    //aaaa.set(1,200) // 1번방의 값을 200으로 변경 10->200
    aaaa[1]=200 // 마치 배열처럼 요소값에 접근하는걸 권장
    for(e in aaaa){
        println(e)
    }
    println()


    println("2번방의 값 : ${aaaa[2]}")   // <-권장 , 원래 aaaa.get(2)

    //2) MutableSet
    val bbbb:MutableSet<Double> = mutableSetOf()
    println("요소의 개수 : ${bbbb.size}")
    bbbb.add(5.55)
    bbbb.add(3.14)
    bbbb.add(5.55)  //중복데이터 무시
    println("요소의 개수 : ${bbbb.size}")
    for (e in bbbb){
        println(e)    //set은 순서랜덤
    }
    println()

    //3) MutableMap
    val cccc:MutableMap<String,String> = mutableMapOf("id" to "kg","pass" to "1234")
    println("요소의 개수 : ${cccc.size}")
    cccc.put("email","qwer@naver.com")
    for((k,v) in cccc){
        println("$k : $v")
    }
    println()
    println()

    // 6.2.3 별외! mutable에 익숙하지 않으면 Java의 ArrayList,HashSet,HashMap에 대응하는 클래스
    var arrList : ArrayList<Any> = arrayListOf(10,"HEllO",true)
    // 사용법은 Java나 Mutable과 같음

    var arrSet:HashSet<Any> = hashSetOf(100,"good")
    val hashMap:HashMap<String,Any> = hashMapOf("id" to "qwer")

    // 나머지는 안드로이드 수업하면서 추가 소개..

}
