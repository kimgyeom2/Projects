package com.gy25m.ex98databindingbindingadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gy25m.ex98databindingbindingadapter.databinding.RecyclerItemBinding

class RecyclerItemAdapter(val context: Context,val items:List<Item>):Adapter<RecyclerItemAdapter.VH>() {
                        //아답터는 보여주기만 하면되서 값이 안변하는 List사용가능
    inner class VH(val binding:RecyclerItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH= VH(DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.recycler_item,parent,false))


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        // 데이터 바인딩 되어 있기에 xml에 선언한 변수 item에 객체 값만 설정해주면 알아서 모든 뷰들에 바인딩됨
        holder.binding.item=items[position]
    }

}