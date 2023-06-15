package com.gy25m.traveldestination;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items=new ArrayList<>();
    MyAdapter adapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(new Item(R.drawable.indo,"타지마할","인도","#이슬람 #아그라",R.drawable.ind));
        items.add(new Item(R.drawable.dubi,"버즈칼리파","아랍 에미레이트","#에미레이트 #두바이",R.drawable.ara));
        items.add(new Item(R.drawable.greece,"아테네","그리스","#유적 #파르테논신전",R.drawable.gr));
        items.add(new Item(R.drawable.bosnia,"사라예보","보스니아","#시장 #프란츠페르디난트",R.drawable.bos));
        items.add(new Item(R.drawable.sydny,"오페라하우스","호주","#엘리자베스",R.drawable.ho));
        items.add(new Item(R.drawable.italy,"베니스","이탈리아","#보트 #바다도시",R.drawable.ita));
        items.add(new Item(R.drawable.indo,"타지마할","인도","#이슬람 #아그라",R.drawable.ind));
        items.add(new Item(R.drawable.dubi,"버즈칼리파","아랍 에미레이트","#에미레이트 #두바이",R.drawable.ara));
        items.add(new Item(R.drawable.greece,"아테네","그리스","#유적 #파르테논신전",R.drawable.gr));
        items.add(new Item(R.drawable.bosnia,"사라예보","보스니아","#시장 #프란츠페르디난트",R.drawable.bos));
        items.add(new Item(R.drawable.sydny,"오페라하우스","호주","#엘리자베스",R.drawable.ho));
        items.add(new Item(R.drawable.italy,"베니스","이탈리아","#보트 #바다도시",R.drawable.ita));items.add(new Item(R.drawable.indo,"타지마할","인도","#이슬람 #아그라",R.drawable.ind));
        items.add(new Item(R.drawable.dubi,"버즈칼리파","아랍 에미레이트","#에미레이트 #두바이",R.drawable.ara));
        items.add(new Item(R.drawable.greece,"아테네","그리스","#유적 #파르테논신전",R.drawable.gr));
        items.add(new Item(R.drawable.bosnia,"사라예보","보스니아","#시장 #프란츠페르디난트",R.drawable.bos));
        items.add(new Item(R.drawable.sydny,"오페라하우스","호주","#엘리자베스",R.drawable.ho));
        items.add(new Item(R.drawable.italy,"베니스","이탈리아","#보트 #바다도시",R.drawable.ita));

        recyclerView=findViewById(R.id.recyclerview123);
        adapter=new MyAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }
}