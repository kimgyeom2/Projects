package com.gy25m.ex93kotlinopenapinaversearch

import android.app.Notification.Action
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.gy25m.ex93kotlinopenapinaversearch.databinding.RecyclerItemBinding


class MyAdapter(var context:Context,var items:MutableList<ShoppingItem>) : Adapter<MyAdapter.VH>() {

    inner class VH(var binding: RecyclerItemBinding) : ViewHolder(binding.root) // 끝

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(RecyclerItemBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount():Int= items.size  //리턴문 한줄일때만 가능

    override fun onBindViewHolder(holder: VH, position: Int) {
        var item:ShoppingItem= items[position]

        // 제목글씨중에 HTML 태그문이 포함되어있어서 지저분함.. 이를 제거
        var title:String=HtmlCompat.fromHtml(item.title,HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
        holder.binding.tvTitle.text=title
        holder.binding.tvLprice.text="${item.lprice}원"
        holder.binding.tvMall.text=item.mallName
        Glide.with(context).load(item.image).into(holder.binding.iv)

        holder.binding.root.setOnClickListener{
            // 디바이스의 인터넷앱 실행
            var intent=Intent(Intent.ACTION_VIEW)
            intent.data=Uri.parse(item.link)
            context.startActivity(intent)
        }
    }
}