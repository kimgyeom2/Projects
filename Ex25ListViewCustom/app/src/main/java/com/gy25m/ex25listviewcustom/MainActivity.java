package com.gy25m.ex25listviewcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터
    ArrayList<Item> items=new ArrayList<>();
    ListView listView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 대량의 데이터들 추가하기
        items.add(new Item("전현무","대한민국",R.drawable.flag_korea));
        items.add(new Item("기욤 페트리","캐나다",R.drawable.flag_canada));
        items.add(new Item("타쿠야","일본",R.drawable.flag_japan));
        items.add(new Item("타일러","미국",R.drawable.flag_usa));
        items.add(new Item("알베르토","이탈리아",R.drawable.flag_italy));
        items.add(new Item("샘 오취리","가나",R.drawable.flag_ghana));

        items.add(new Item("전현무","대한민국",R.drawable.flag_korea));
        items.add(new Item("기욤 페트리","캐나다",R.drawable.flag_canada));
        items.add(new Item("타쿠야","일본",R.drawable.flag_japan));
        items.add(new Item("타일러","미국",R.drawable.flag_usa));
        items.add(new Item("알베르토","이탈리아",R.drawable.flag_italy));
        items.add(new Item("샘 오취리","가나",R.drawable.flag_ghana));

        //아답터 객체를 생성하여 리스트뷰에 설정
        listView=findViewById(R.id.listview);
        myAdapter=new MyAdapter(this,items);
        listView.setAdapter(myAdapter);

        //listview의 아이템을 클릭했을때 반응하기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item=items.get(i);
                Toast.makeText(MainActivity.this,item.name+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}