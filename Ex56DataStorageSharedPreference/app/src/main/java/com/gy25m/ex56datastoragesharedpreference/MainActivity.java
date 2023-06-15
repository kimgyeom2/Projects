package com.gy25m.ex56datastoragesharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText etName,etAge;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.et_name);
        etAge=findViewById(R.id.et_age);
        tv=findViewById(R.id.tv);

        findViewById(R.id.btn_save).setOnClickListener(view -> clickSave());
        findViewById(R.id.btn_load).setOnClickListener(view -> clickLoad());
    }

    void clickSave(){
        //저장할 데이터
        String name=etName.getText().toString();
        int age=Integer.parseInt(etAge.getText().toString());

        // SharedPreferences로 저장하기
        // "Data.xml"파일에 데이터를 저장하기 위해 객체 얻어오기
        SharedPreferences pref=getSharedPreferences("Data",MODE_PRIVATE);  //Shared는 무조건 xml

        //저장작업 시작
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("name",name);
        editor.putInt("age",age);
        //작업완료
        editor.commit();
    }
    void clickLoad(){

        SharedPreferences pref=getSharedPreferences("Data",MODE_PRIVATE); //하나만 저장가능

        String name=pref.getString("name","보여줄게 없으면 이거보여줌");  //두번째- 저장된게 없으면 보여줄글씨
        int age=pref.getInt("age",0);
        tv.setText(name+": "+age);
    }
}