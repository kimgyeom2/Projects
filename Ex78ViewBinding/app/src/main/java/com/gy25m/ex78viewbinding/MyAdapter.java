package com.gy25m.ex78viewbinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gy25m.ex78viewbinding.databinding.RecyclerItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {
    Context context;
    ArrayList<ItemVO> items;

    public MyAdapter(Context context, ArrayList<ItemVO> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        return new VH(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        holder.binding.tv.setText(items.get(position).title);
        holder.binding.iv.setImageResource(items.get(position).imgResId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        //recycler_item.xml과 연결되는 바인딩 클래스 참조변수

        RecyclerItemBinding binding;
        public VH(@NonNull View itemView) {
            super(itemView);
            //이미 만든 뷰객체 안에있는 자식뷰들과 연결하기는 바인딩객체
            binding=RecyclerItemBinding.bind(itemView);

        }
    }
}
