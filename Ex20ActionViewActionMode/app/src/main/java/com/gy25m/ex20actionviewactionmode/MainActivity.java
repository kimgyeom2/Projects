package com.gy25m.ex20actionviewactionmode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText actionViewEt;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 액션모드 메뉴: 새로운 액션바를 만들어서 옵션메뉴를 붙이는 방식

                // 액션모드 시작
                startActionMode(new ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                        //액션모드가  '처음' 실행될떄 메뉴항목들을 만들기 위해 자동실행되는 메소드
                        actionMode.getMenuInflater().inflate(R.menu.actionmode,menu);

                        //액션모드에 의해 만들어진 제목줄(ActionBar)의 제목글씨 표시
                        actionMode.setTitle("action mode");
                        actionMode.setSubtitle("sub title");

                        // 액션모드의 배경생을 테마(theme.xml)에서 지정

                        return true;  //리턴값이 true여야만 액션모드가 발동함
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                        //액션모드가 실행될때마다 실생되는 콜백메소드
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                        //메뉴 항목이 클릭되었을때 자동 실행되는 콜백메소드
                        if(menuItem.getItemId()==R.id.menu_aa)
                            Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();
                        else if(menuItem.getItemId()==R.id.menu_bb)
                            Toast.makeText(MainActivity.this, "map", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode actionMode) {

                    }
                });


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);

        // ActionView로 지정한 커스텀뷰안에 있는 EditText를 찾아오기
        MenuItem item=menu.findItem(R.id.menu_action);
        LinearLayout layout =(LinearLayout) item.getActionView();
         actionViewEt=layout.findViewById(R.id.actionview_et);


         // EditText의 소프트 키보드중에서 작성완료버튼(Search모양 버튼)을 클릭하는것에
         // 반응하는 리스너객체 생성 및 설정
        actionViewEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                //키보드에서 어떤키를 눌렀는지를 가지고있는 변수 - 두번째 파라미터 i
                if(i== EditorInfo.IME_ACTION_SEARCH){
                    String msg=actionViewEt.getText().toString();
                    Toast.makeText(MainActivity.this, "검색어 : "+msg, Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}