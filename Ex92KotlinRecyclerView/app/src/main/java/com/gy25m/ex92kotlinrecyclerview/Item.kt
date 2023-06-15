package com.gy25m.ex92kotlinrecyclerview

// data class: 데이터만 저장하는 목적의 클래스 - 일반 클래스와 다르게
// 자동으로 equals()할때 객체 주소를 비교하지 않고 멤버값들을 비교해주도록 오버라이드 된 클래스
// 주생성자에 있는거만 equals함
data class Item constructor (var name:String,var msg:String,var imgId:Int ) {   //constructor라는 말은 생략가능 ()이거말고

}