package com.gy25m.ex27recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items;

    public MyAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    /*재활용할 뷰가없으면 뷰를 만들기위해 자동으로 호출되는 메소드*/
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemview=inflater.inflate(R.layout.recyclerview_item,parent,false);
        VH holder=new VH(itemview);
        return holder;
    }

    //현재 연결할 번째(position) 데이터를 view에 넣어주는 작업을 위해 호출되는 메소드
    @Override                                           //위에서 리턴한홀더
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    //첫번째 파라미터 holder가 가진뷰들 참조변수를 통해 값 설정
        VH vh=(VH)holder;

        //현재번째 아이템요소를 얻어와서 뷰들에 설정
        Item item=items.get(position);
        vh.tvName.setText(item.name);
        vh.tvNation.setText(item.nation);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //아이템 1개 뷰안에있는 자식뷰들의 참조값을 저장하는 참조변수들을 멤버로 가지는 class
    class VH extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvNation;
        public VH(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tv_name);
            tvNation=itemView.findViewById(R.id.tv_nation);
            
            
            //항목뷰를 클릭했을때 반응하는 리스너 처리
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //클릭한 아이템의 위치 인덱스 번호
                    int position=getLayoutPosition();
                    //클릭한번째 아이템요소 얻어오기
                    Item item=items.get(position);
                    Toast.makeText(context, "click : "+item.name, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}//MyAdapter class
