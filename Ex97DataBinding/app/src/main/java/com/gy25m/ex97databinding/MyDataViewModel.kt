package com.gy25m.ex97databinding

import androidx.databinding.ObservableField

// MVVM패턴의 View에서 사용할 데이터(model)을 연결해주는 ViewModel역할의 클래스 정의
class MyDataViewModel{

    // 이미지뷰에서 보여줄 이미지 source URL(문자열)
    val img:ObservableField<String> = ObservableField("https://cdn.pixabay.com/photo/2015/09/05/23/54/ice-cream-926426_1280.jpg")

    // 리사이클러뷰가 사용할 대량의 데이터
    val items:ObservableField<MutableList<String>> = ObservableField(mutableListOf()) //빈 뮤터블리스트 객체 생성
}