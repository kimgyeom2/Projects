package com.gy25m.pr0613

import androidx.lifecycle.MutableLiveData

class MyViewModel {
    var title:MutableLiveData<String> = MutableLiveData("메인화면")

    fun titleChange(){
        title.value="바뀐 메인화면"
    }

    var name:MutableLiveData<String> = MutableLiveData()
    var msg:MutableLiveData<String> = MutableLiveData()
    var list:MutableLiveData<MutableList<Item>> = MutableLiveData(mutableListOf())
    fun addItem(){
        var li=list.value
        li?.add(Item("gyeom","Hello"))
        list.postValue(li)
    }

}