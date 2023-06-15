package com.gy25m.ex70photomultiplepickbyintent;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

public class PagerAdapter extends RecyclerView.Adapter<PagerAdapter.VH> {
    Context context;
    ArrayList<Uri> images=new ArrayList<>();

    public PagerAdapter(Context context, ArrayList<Uri> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.page,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(context).load(images.get(position)).into(holder.pv);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class VH extends RecyclerView.ViewHolder {
    PhotoView pv;
        public VH(@NonNull View itemView) {
            super(itemView);
            pv=itemView.findViewById(R.id.pv);
        }
    }
}
