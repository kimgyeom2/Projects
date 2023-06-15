package com.gy25m.mvvmlivedata

import android.content.Context
import androidx.lifecycle.MutableLiveData
import java.util.Date

class MyViewModel() {
    var items:MutableLiveData<MutableList<Item>> = MutableLiveData(mutableListOf())

    fun addItem(){
        var list=items.value
        list?.add(0,Item("gyeom", Date().toString()))
        items.postValue(list)
    }

}