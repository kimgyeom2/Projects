package com.gy25m.activityex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {

    Context context;
    String name;
    String nickname;
    String title;
    String bon;

    public MyAdapter(Context context, String name, String nickname, String title, String bon) {
        this.context = context;
        this.name = name;
        this.nickname = nickname;
        this.title = title;
        this.bon = bon;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(context).inflate(R.layout.recycleritem,parent,false);
        VH holder=new VH(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        holder.tv.setText(name+"  "+ nickname+"\n"+ title+"\n"+bon);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class VH extends RecyclerView.ViewHolder{

        TextView tv;


        public VH(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);

        }
    }

}
