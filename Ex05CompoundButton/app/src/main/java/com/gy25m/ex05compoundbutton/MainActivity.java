package com.gy25m.ex05compoundbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    CheckBox cb01,cb02,cb03;
    Button btn;
    TextView tv;
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml에서 만든 뷰들을 찾아와서 참조변수들에 대입해주기
        cb01=findViewById(R.id.cb01);
        cb01.setChecked(true);
        cb02=findViewById(R.id.cb02);
        cb03=findViewById(R.id.cb03);
        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="";
                if(cb01.isChecked()) s=s+cb01.getText().toString()+" ";
                if(cb02.isChecked()) s=s+cb02.getText().toString()+" ";
                if(cb03.isChecked()) s=s+cb03.getText().toString()+" ";
                tv.setText(s);
            }
        });
        //버튼을 클릭했을때 반응하기 위해서 버튼클릭 이벤트를 듣는 리스너 객체를 생성 및 설정


        //체크박스의 체크상태가 변경될때마다 반응하는 리스너를 설정하기
        cb01.setOnCheckedChangeListener(changeListener);
        cb02.setOnCheckedChangeListener(changeListener);
        cb03.setOnCheckedChangeListener(changeListener);

        //토글버튼 찾아서 연결하기
        tb=findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // 두번째 파라미터 b : boolean값 - 체크된상태값
                tv.setText("체크상태 : "+ b);
            }
        });
    } //oncreate mehtod

    CompoundButton.OnCheckedChangeListener changeListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            String s="";
            if(cb01.isChecked()) s=s+cb01.getText().toString()+" ";
            if(cb02.isChecked()) s=s+cb02.getText().toString()+" ";
            if(cb03.isChecked()) s=s+cb03.getText().toString()+" ";
            tv.setText(s);
        }
    };


}//Mainactivity class