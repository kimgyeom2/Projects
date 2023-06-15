package com.gy25m.ex92kotlinrecyclerview

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class MyAdapter(var cotext:Context,var items:MutableList<Item>):Adapter<MyAdapter.VH>() {

    inner class VH (itemView:View):ViewHolder(itemView){
        val tvName:TextView by lazy { itemView.findViewById(R.id.tv_name) }
        val tvMsg:TextView by lazy { itemView.findViewById(R.id.msg) }
        val iv:ImageView by lazy { itemView.findViewById(R.id.iv) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        var itemView:View=LayoutInflater.from(cotext).inflate(R.layout.recycler_item,parent,false)
        return VH(itemView)
    }

    // return 실행문을 = (할당연산자)로 단순화
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        // var item:Item=items.get(position)
        // 코틀린은 리스트의 get대신에 배열처럼 []권장
        var item:Item=items[position]
        holder.tvName.setText(item.name)
        // 코틀린은 get,set 권하지 않음
        holder.tvMsg.text=item.msg
        Glide.with(cotext).load(item.imgId).into(holder.iv)


        // 아이템뷰를 클릭했을때 화면이동  VH에서 해도됨
        holder.itemView.setOnClickListener {
            val intent:Intent= Intent(cotext,ItemDetailActivity::class.java)
            intent.putExtra("name",item.name)
            intent.putExtra("msg",item.msg)
            intent.putExtra("imgId",item.imgId)

            // 액티비티 전환시 뷰들에 효과주기 ActivityOptionsCompat. 종류많음                          vvv - 현재 액티비티(컨텍스트가 올때 액티비티줬다고 생각하면됨)
            // Pair()객체 - 전환효과를 줄 뷰에게 별칭을 연결. 실행될 액티비티에도 같은 별칭을 특정 뷰에게 주면 둘이 연결됨
            val options:ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(cotext as MainActivity, Pair(holder.iv,"iii"))
            cotext.startActivity(intent, options.toBundle())
        }
    }
}