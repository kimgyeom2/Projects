package com.gy25m.traveldestination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH>{

    Context context;
    ArrayList<Item> items;

    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lay=LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        VH holder=new VH(lay);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Item item=items.get(position);
        holder.iv.setImageResource(item.iv);
        holder.iv_nation.setImageResource(item.iv2);
        holder.location.setText(item.location);
        holder.nation.setText(item.nation);
        holder.hash.setText(item.hash);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{
        ImageView iv,iv_nation;
        TextView location,hash,nation;
        public VH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            iv_nation=itemView.findViewById(R.id.iv_nation);
            location=itemView.findViewById(R.id.location);
            hash=itemView.findViewById(R.id.hash);
            nation=itemView.findViewById(R.id.nation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Item item=items.get(getLayoutPosition());
                    Toast.makeText(context, item.location, Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
