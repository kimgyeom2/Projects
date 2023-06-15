package com.gy25m.ex25listviewcustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Item> items;
    Context context;
    //생성자
    public MyAdapter(Context context,ArrayList<Item> items) {
        this.context=context;
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //리스트뷰가 보여줄아이템 1개의 뷰객체를 생성하여 리턴해주는 메소드
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // 1. create view :  xml모양으로 View객체를 생성

        // 혹시 재활용할 View가 없는가? - 이 메소드의 두번째 파라미터
        if(view == null){
            // xml파일을 읽어서 View객체로 만들어주는 객체를 운영체제로부터 소환: LayoutInflater
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.listview_item,null);
        }

        // 2. bind View : 생성된 View객체 안에 정보값들을 설정(연결)
        // 이 메소드의 첫번째 파라미터 i - 현재 만들어야할 번째 인덱스번호

        // 현재번째 데이터(item객체) 얻어오기
        Item item=items.get(i);

        // 아이템뷰안에있는 자식뷰들을 참조
        ImageView iv=view.findViewById(R.id.iv);
        TextView tv_name=view.findViewById(R.id.tv_name);
        TextView tv_nation=view.findViewById(R.id.tv_nation);

        // 각 뷰들의 현재번째 데이터를 연결
        tv_name.setText(item.name);
        tv_nation.setText(item.nation);
        iv.setImageResource(item.imgId);

        return view;  //리스트뷰가 이 리턴된 뷰를 화면에 목록으로 추가해줌
    }
}
