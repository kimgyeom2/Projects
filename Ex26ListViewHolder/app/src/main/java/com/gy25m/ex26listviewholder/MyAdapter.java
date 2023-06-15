package com.gy25m.ex26listviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> items;

    public MyAdapter(Context context, ArrayList<String> items) {
        this.context = context;
        this.items = items;
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // 1. create view
        // 재활용할 View가 있는지 확인
        if(view==null){
            //listview_item.xml문서를 읽어와서 View객체로 생성해주는 inflator객체 소환
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.listview_item,viewGroup,false);

            // 만들어진 view안에 있는 자식 뷰들의 참조값을 tag로 저장하기
            // 자식뷰들의 참조변수를 멤버로 가지는 별도의 클래스를 설계하여 객체로 생성
            ViewHolder holder=new ViewHolder(view);
            view.setTag(holder);
        }

        // 2. bind view
        // 현재 보여줄 데이터를 얻어오기
        String item=items.get(i);

        // 아이템뷰안에 tag로 저장되어있던 viewHolder객체 빼오기
        ViewHolder holder=(ViewHolder) view.getTag();
        holder.tv.setText(item);

        return view;
    }//getview  method..

    //항목 1개의 뷰(item view)안에있는 자식뷰들 참조변수를 멤버로 가지는 이너class
    class ViewHolder{
        TextView tv;

        //생성자
        public ViewHolder(View itemview) {
            tv=itemview.findViewById(R.id.tv);
        }
    }

} //Myadapter class
