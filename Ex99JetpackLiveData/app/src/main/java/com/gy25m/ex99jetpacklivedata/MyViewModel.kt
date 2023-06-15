package com.gy25m.ex99jetpacklivedata

import androidx.lifecycle.MutableLiveData
import java.util.Date

class MyViewModel {
    // LiveData : ObservableXXX 와 다르게 라이프 사이클에 따라 효율적으로 UI를 갱신

    val name:MutableLiveData<String> = MutableLiveData("sam")
    val age:MutableLiveData<Int> = MutableLiveData(20)

    // 1.1 데이터 변경 콜백메소드
    fun changeName(){
        name.value="robin"
        // Observable과 다르게 값을 변경해도 자동갱신x
        // 자동 갱신 방법 2가지
        // 1. LiveData 변수를 관찰하는 observe() 메소드를 통해서 관찰 및 UI갱신

        // 2. LiveData의 변화를 반영할 LifecycleOwner를 미리 지정
    }

    fun increaseAge(){
        name.value="robin"
        age.value=age.value!!.toInt()+1
    }

    // 2. 리사이클러 뷰에 LiveData변수를 적용
    val items:MutableLiveData<MutableList<Item>> = MutableLiveData(mutableListOf(Item("title","message")))

    // 2.1 아이템 추가하면 화면 자동 갱신
    fun addItem(){
        val list=items.value
        list?.add(0,Item("new",Date().toString()))
        //items.value=list
        items.postValue(list) //별도 thread로 설정작업  규모가 큰작업일경우 이거로
    }

}