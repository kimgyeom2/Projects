package com.gy25m.ex16optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // onCreate()메소드가 실행된 후 자동으로 Option Menu를 만드는 작업을 하는
    // 이 메소드가 자동 발동함 - 콜백메소드

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // menu객체에게 MenuItem 객체를 추가하기

        //1. java언어로 추가해보기 - 아이콘이나 id같은 식별자를 지정할때 번거로워짐[특히 메뉴가 많아지면]
        // menu.add("menu1");
        // menu.add("menu2");

        //2. XML언어로 menu를 설계하고 객체로 만들어서 사용해보기

        // menu폴더안에 option.mxl 문서를 읽어와서 Menu객체로 만들어주는(부풀려주는 inflate) 객체 얻어오기
        MenuInflater inflater=getMenuInflater();

        inflater.inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);

    }

    // Option menu의 메뉴항목(item)이 선택되었을때 자동으로 발동하는 콜백메소드

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.menu_search){
            Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.menu_add) {
            Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();
        }else if (item.getItemId()==R.id.menu_help) {
            Toast.makeText(this,"help",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}