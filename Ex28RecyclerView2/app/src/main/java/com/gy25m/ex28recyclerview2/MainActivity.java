package com.gy25m.ex28recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터 준비
    ArrayList<Item> items=new ArrayList<>();

    RecyclerView recyclerView;
    MyAdapter adapter;
    Button btnAdd,btnDelete,btnLinear,btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 대량의 데이터 추가 [실무에서는 DB or 서버에서 데이터를 얻어옴]
        items.add(new Item("루피","해적단 선장",R.drawable.crew_luffy,R.drawable.bg_one01));
        items.add(new Item("조로","해적단 부선장",R.drawable.crew_zoro,R.drawable.bg_one02));
        items.add(new Item("나미","해적단 항해사",R.drawable.crew_nami,R.drawable.bg_one03));
        items.add(new Item("우솝","해적단 저격수",R.drawable.crew_usopp,R.drawable.bg_one04));
        items.add(new Item("상디","해적단 요리사",R.drawable.crew_sanji,R.drawable.bg_one05));
        items.add(new Item("쵸파","해적단 의사",R.drawable.crew_chopper,R.drawable.bg_one06));
        items.add(new Item("니코로빈","해적단 고고학자",R.drawable.crew_nicorobin,R.drawable.bg_one07));
        items.add(new Item("루피","해적단 선장",R.drawable.crew_luffy,R.drawable.bg_one01));
        items.add(new Item("조로","해적단 부선장",R.drawable.crew_zoro,R.drawable.bg_one02));
        items.add(new Item("나미","해적단 항해사",R.drawable.crew_nami,R.drawable.bg_one03));
        items.add(new Item("우솝","해적단 저격수",R.drawable.crew_usopp,R.drawable.bg_one04));
        items.add(new Item("상디","해적단 요리사",R.drawable.crew_sanji,R.drawable.bg_one05));
        items.add(new Item("쵸파","해적단 의사",R.drawable.crew_chopper,R.drawable.bg_one06));
        items.add(new Item("니코로빈","해적단 고고학자",R.drawable.crew_nicorobin,R.drawable.bg_one07));
        items.add(new Item("루피","해적단 선장",R.drawable.crew_luffy,R.drawable.bg_one01));
        items.add(new Item("조로","해적단 부선장",R.drawable.crew_zoro,R.drawable.bg_one02));
        items.add(new Item("나미","해적단 항해사",R.drawable.crew_nami,R.drawable.bg_one03));
        items.add(new Item("우솝","해적단 저격수",R.drawable.crew_usopp,R.drawable.bg_one04));
        items.add(new Item("상디","해적단 요리사",R.drawable.crew_sanji,R.drawable.bg_one05));
        items.add(new Item("쵸파","해적단 의사",R.drawable.crew_chopper,R.drawable.bg_one06));
        items.add(new Item("니코로빈","해적단 고고학자",R.drawable.crew_nicorobin,R.drawable.bg_one07));

        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,items);
        recyclerView.setAdapter(adapter);

        //리사이클러뷰는 아이템클릭 리스너 처리가 없음 아답터에서 Itemview에 직접 click이벤트 처리

        btnAdd=findViewById(R.id.btn_add);
        btnDelete=findViewById(R.id.btn_delete);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대량의 데이터 list에 새로운 데이터 추가
                items.add(0,new Item("NEW","해적단 막내",R.drawable.bg_one10,R.drawable.one_ace));
                //데이터가 변경된걸 아답터에게 공지해야함
                // adapter.notifyDataSetChanged();  전체뷰를 다시갱신하여 낭비임
                // 데이터아이템 1개
                adapter.notifyItemInserted(0);
                // 스크롤 위치 조정
                recyclerView.scrollToPosition(0);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    items.remove(0);
                adapter.notifyItemRemoved(0);
                recyclerView.scrollToPosition(0);

            }
        });

        btnLinear=findViewById(R.id.btn_linear);
        btnGrid=findViewById(R.id.btn_Grid);
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // 리사이클러뷰의 레이아웃 매니저를 새로이 선정
                LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
            }
        });
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,2,RecyclerView.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
            }
        });
    }
}