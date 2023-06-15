package com.gy25m.practice

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gy25m.practice.databinding.ReItemBinding

class MyAdapter(var context:Context,var list:MutableList<Model> ) : Adapter<MyAdapter.VH>() {
    inner class VH(var binding:ReItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ReItemBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var item=list[position];
        holder.binding.name.text=item.name
        holder.binding.age.text=item.age.toString()
    }
}