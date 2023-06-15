package com.gy25m.ex18popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 팝업메뉴 객체 생성
               // PopupMenu popupMenu=new PopupMenu(MainActivity.this,btn);  //두번째 파라미터 : 메뉴가 보여질뷰
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,tv);
                // 팝업메뉴가 보여줄 메뉴설계 [menu폴더 popup.xml안에]
                MenuInflater inflater=getMenuInflater();
                inflater.inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.show();

                // 팝업메뉴의 아이템이 클릭될때
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId()==R.id.info) Toast.makeText(MainActivity.this,"info",Toast.LENGTH_SHORT).show();
                        else if(menuItem.getItemId()==R.id.delete)
                            Toast.makeText(MainActivity.this, "delete", Toast.LENGTH_SHORT).show();
                       else if(menuItem.getItemId()==R.id.modify)
                            Toast.makeText(MainActivity.this, "modify", Toast.LENGTH_SHORT).show();

                        return false;
                    }
                });
            }
        });
    }
}