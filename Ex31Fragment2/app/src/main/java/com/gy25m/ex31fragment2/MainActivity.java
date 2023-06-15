package com.gy25m.ex31fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);

        //프레그먼트 관리자 소환
        fragmentManager=getSupportFragmentManager();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //id가 container_fragment인 뷰그룹에 MyFragmnet붙이기

                //프레그먼트에 동적(add,remove,replace)작업을 시작 //작업완료할때까지는 적용안됨
                FragmentTransaction tran=fragmentManager.beginTransaction();

                //프레그먼트 동적추가
                tran.add(R.id.container_fragment,new MyFragment());

                //뒤로가기 버튼 눌렀을때 프레그먼트 추가 이전상태로 돌아가려면..
                tran.addToBackStack(null);
                //작업완료  필수!!!!
                tran.commit();
            }
        });
    }
}