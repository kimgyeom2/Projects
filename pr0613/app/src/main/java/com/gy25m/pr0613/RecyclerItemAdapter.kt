package com.gy25m.pr0613

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gy25m.pr0613.databinding.RecyclerItemBinding

class RecyclerItemAdapter(val items:List<Item>):Adapter<RecyclerItemAdapter.VH>(){
    inner class VH(var binding:RecyclerItemBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding:RecyclerItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.recycler_item,parent,false)
        return VH(binding)
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.item=items[position]
    }
}