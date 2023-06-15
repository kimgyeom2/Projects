package com.gy25m.ex19searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;  // 참조변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // onCreate메소드가 실행된 후 Option메뉴를 만드는 작업을 하는 콜백메소드가 자동발동


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);

        MenuItem menuItem=menu.findItem(R.id.menu_search);
        searchView=(SearchView) menuItem.getActionView();

        //SearchView에 적용하는 설정
        searchView.setQueryHint("검색어를 입력하세요");

        //Searchview의 글씨변화에 반응하는 리스너 설정
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 소프트키보드의 돋보기 버튼을 클릭했을때(검색어 입력을 완료했을때)
                Toast.makeText(MainActivity.this, "검색어 : "+query, Toast.LENGTH_SHORT).show();
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 글씨가 변경될때마다 실행되는 콜백메소드
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}