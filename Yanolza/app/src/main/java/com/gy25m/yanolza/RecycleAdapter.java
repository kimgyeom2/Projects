package com.gy25m.yanolza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.VH> {
    Context context;
    ArrayList<Item> items;

    public RecycleAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemview=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
       VH holder=new VH(itemview);
       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Item item=items.get(position);
        holder.icon.setImageResource(item.icon);
        holder.tv.setText(item.tv);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView tv;
        public VH(@NonNull View itemView) {
            super(itemView);
            icon=itemView.findViewById(R.id.icon);
            tv=itemView.findViewById(R.id.tv);
        }
    }

}
