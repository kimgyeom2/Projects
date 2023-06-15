package com.gy25m.mvvmlivedata

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


object RecyclerAdapter {

    @BindingAdapter("itemList")
    @JvmStatic
    fun setItemList(view: RecyclerView, items:Any){
        view.adapter=RecyclerItemAdapter(items as List<Item>)
    }
}