package com.gy25m.ex35navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawertoggle;
    CircleImageView civ;  //헤더뷰안에있는 둥근 이미지뷰
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.tollbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navi);

        //드로우어 토글 버튼객체생성
        drawertoggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        //액션바에 홈or업 버튼의 위치에 아이콘이 보이게하려면..
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

       //  삼선아이콘 (햄버거모양)으로 보이도록 토글버튼동기 맞추기
        drawertoggle.syncState();

         //삼선아이콘 모양과 화살표아이콘이 자동으로 변환되도록
        drawerLayout.addDrawerListener(drawertoggle);

        //NavigationView의 메뉴항목들을 선택했을때 반응하기
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.menu_gallery){
                    Toast.makeText(MainActivity.this,"gallery",Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.menu_send) {
                    Toast.makeText(MainActivity.this,"send",Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.menu_aa) {
                    Toast.makeText(MainActivity.this,"aa",Toast.LENGTH_SHORT).show();
                } else if (item.getItemId()==R.id.menu_bb){
                    Toast.makeText(MainActivity.this,"bb",Toast.LENGTH_SHORT).show();
                }
                //드로우어 메뉴 닫기
                drawerLayout.closeDrawer(navigationView);
                return false;
            }
        });


        //네비게이션뷰 안에있는 헤더뷰안에있는 둥근이미지 찾아오기
        View headerview=navigationView.getHeaderView(0);
        civ=headerview.findViewById(R.id.civ);
        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                civ.setImageResource(R.drawable.howl049);
            }
        });
    }



}