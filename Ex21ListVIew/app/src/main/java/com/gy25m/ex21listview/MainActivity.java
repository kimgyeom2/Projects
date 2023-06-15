package com.gy25m.ex21listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //세번째 파라미터 i -> 클릭한 아이템의 위치 인덱스번호 0,1,2..


                // arrays.xml에 datas라는 이름으로 작성된 String배열을 참조하기
                // res폴더 안에 파일이 있기에 res폴더(창고)의 관리자(창고관리자)를 소환하기
                Resources res=getResources();
                String[] datas=res.getStringArray(R.array.datas);

                Toast.makeText(MainActivity.this, datas[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}