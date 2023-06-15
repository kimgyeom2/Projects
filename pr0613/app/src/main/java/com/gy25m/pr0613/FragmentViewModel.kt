package com.gy25m.pr0613

import androidx.lifecycle.MutableLiveData

class FragmentViewModel {
    var title=MutableLiveData<String>("Fragment")

    fun change(){
        title.value="change"
    }
}