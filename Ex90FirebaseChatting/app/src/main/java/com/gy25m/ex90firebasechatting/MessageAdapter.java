package com.gy25m.ex90firebasechatting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.VH> {

    Context context;
    ArrayList<MessageItem> messageitems;
    final int TYPE_MY=0;
    final int TYPE_OTHER=1;

    public MessageAdapter(Context context, ArrayList<MessageItem> messageitems) {
        this.context = context;
        this.messageitems = messageitems;
    }

    //리사이클러뷰의 항목뷰가 경우에따라 다른모양으로 보여야할때 사용하는 콜백메소드
    //이 메소드에서 해당 position에 따른 식별값(ViewType 번호)을 정하여 리턴..하면
    //그 값이 onCreateViewHolder() 두번째 파라미터에 전달됨
    //onCreatViewHolder() 메소드 안에서 그값에 따라 다른 xml문서를inflate함
    @Override
    public int getItemViewType(int position) {
        if (messageitems.get(position).name.equals(G.nickName)) {
            return TYPE_MY;
        }else{
            return TYPE_OTHER;
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=null;
        if (viewType==TYPE_MY) itemView= LayoutInflater.from(context).inflate(R.layout.my_messagebox,parent,false);
        else itemView=LayoutInflater.from(context).inflate(R.layout.other_messagebox,parent,false);

        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
       MessageItem item=messageitems.get(position);
       holder.tvName.setText(item.name);
       holder.tvMsg.setText(item.message);
       holder.tvTime.setText(item.time);
       Glide.with(context).load(item.profileUrl).into(holder.civ);
    }

    @Override
    public int getItemCount() {
        return messageitems.size();
    }

    class VH extends RecyclerView.ViewHolder{

        //메세지 타입에따라 뷰가 다르기에 바인딩클래스를 고정하지 못함
        //[MyMessageboxBinding,OtherMessageboxBinding ...]
        //ViewHolder를 2개만들어 사용하기도함 [MyVH,OtherVH..]
        //홀더를 두개만들면 onBind에서도 나눠서 처리해야되기에 이번에는
        //뷰바인딩을 안쓰고 제작해보기.
        CircleImageView civ;
        TextView tvName;
        TextView tvMsg;
        TextView tvTime;
        public VH(@NonNull View itemView) {
            super(itemView);
            civ=itemView.findViewById(R.id.civ);
            tvName=itemView.findViewById(R.id.tv_name);
            tvMsg=itemView.findViewById(R.id.tv_msg);
            tvTime=itemView.findViewById(R.id.tv_time);
        }
    }
}
