package com.gy25m.ex29viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> imgIds=new ArrayList<>();
    ViewPager2 vp;
    MyAdapter adapter;
    Button btn_prev,btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가[실무에서는 DB나 서버에서 데이터를 읽어옴]
        imgIds.add(R.drawable.bg_one01);
        imgIds.add(R.drawable.bg_one02);
        imgIds.add(R.drawable.bg_one03);
        imgIds.add(R.drawable.bg_one04);
        imgIds.add(R.drawable.bg_one05);
        imgIds.add(R.drawable.bg_one06);
        imgIds.add(R.drawable.bg_one07);
        imgIds.add(R.drawable.bg_one08);
        imgIds.add(R.drawable.bg_one09);
        imgIds.add(R.drawable.bg_one10);
        btn_prev=findViewById(R.id.btn_prev);
        btn_next=findViewById(R.id.btn_next);

        vp=findViewById(R.id.pager);
        adapter=new MyAdapter(this,imgIds);
        vp.setAdapter(adapter);

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //뷰페이저의 현재위치인덱스 얻어오기
                int position=vp.getCurrentItem();
                //현재위치 이전번호로 지정
                vp.setCurrentItem(position-1,true);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=vp.getCurrentItem();
                vp.setCurrentItem(position+1,false);
            }
        });
    }
}