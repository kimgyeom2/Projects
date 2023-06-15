package com.gy25m.ex26listviewholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터
    ArrayList<String> items=new ArrayList<>();
    ListView listView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add("손흥민");
        items.add("황희찬");
        items.add("이강인");
        items.add("백승호");
        items.add("김민재");
        items.add("손흥민");
        items.add("황희찬");
        items.add("이강인");
        items.add("백승호");
        items.add("김민재");
        items.add("손흥민");
        items.add("황희찬");
        items.add("이강인");
        items.add("백승호");
        items.add("김민재");
        items.add("손흥민");
        items.add("황희찬");
        items.add("이강인");
        items.add("백승호");
        items.add("김민재");
        items.add("손흥민");
        items.add("황희찬");
        items.add("이강인");
        items.add("백승호");
        items.add("김민재");

        listView=findViewById(R.id.listview);
        adapter=new MyAdapter(this,items);  //보내주는거임
        listView.setAdapter(adapter);
    }
}