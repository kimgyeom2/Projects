package com.gy25m.ex23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);
        //adapter=new ArrayAdapter(); 데이터가 자바에 있을때만
        //창고관리자불러서 하거나,아래기능 사용
        adapter=ArrayAdapter.createFromResource(this,R.array.city,R.layout.spinner_item );

        //드롭다운되는 아이템의 뷰 모양을 다르게 하고 싶다면
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //스피너의 드롭다운되는 뷰의 위치를 조정
        spinner.setDropDownVerticalOffset(150);


        //스피너의 아이템이 선택되었을때 반응하기
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] city=getResources().getStringArray(R.array.city);
                Toast.makeText(MainActivity.this, city[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}