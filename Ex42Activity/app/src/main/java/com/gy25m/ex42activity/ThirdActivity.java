package com.gy25m.ex42activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //제목줄 제목글씨변경
        getSupportActionBar().setTitle("Third");

        //제목왼쪽에 돌아가는 버튼(업버튼)보이도록하기
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //[업버튼]이 클릭되었을때 자동으로 발동하는 콜백메소드(자동으로 불러짐)
    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed(); //뒤로가기
        return super.onSupportNavigateUp();
    }


}
