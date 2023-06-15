package com.gy25m.ex27recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터
    ArrayList<Item> items=new ArrayList<>();

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가
        items.add(new Item("손흥민","대한민국"));
        items.add(new Item("메시","아르헨티나"));
        items.add(new Item("음바페","프랑스"));
        items.add(new Item("호날두","포르투갈"));
        items.add(new Item("네이마르","브라질"));
        items.add(new Item("홀란드","노르웨이"));
        items.add(new Item("미나미노","일본"));
        items.add(new Item("손흥민","대한민국"));
        items.add(new Item("메시","아르헨티나"));
        items.add(new Item("음바페","프랑스"));
        items.add(new Item("호날두","포르투갈"));
        items.add(new Item("네이마르","브라질"));
        items.add(new Item("홀란드","노르웨이"));
        items.add(new Item("미나미노","일본"));
        items.add(new Item("손흥민","대한민국"));
        items.add(new Item("메시","아르헨티나"));
        items.add(new Item("음바페","프랑스"));
        items.add(new Item("호날두","포르투갈"));
        items.add(new Item("네이마르","브라질"));
        items.add(new Item("홀란드","노르웨이"));
        items.add(new Item("미나미노","일본"));

        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,items);
        recyclerView.setAdapter(adapter);


        //리사이클러뷰의 아이템뷰 1개를 클릭했을때 반응하는 리스너 처리 불가능
        //그래서 처리하려면 itemview 1개를 만드는 MyAdapter에서 Onclick처리 해야함

    }
}