package com.gy25m.ex08framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btn01,btn02,btn03;
    LinearLayout layout01,layout02,layout03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01=findViewById(R.id.btn1);
        btn02=findViewById(R.id.btn2);
        btn03=findViewById(R.id.btn3);
        layout01=findViewById(R.id.layout01);
        layout02=findViewById(R.id.layout02);
        layout03=findViewById(R.id.layout03);

        btn01.setOnClickListener(listener);
        btn02.setOnClickListener(listener);
        btn03.setOnClickListener(listener);
    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) { //파라미터로 전달된 view=클릭된 버튼 참조변수
            int id=view.getId();
            layout01.setVisibility(View.GONE);
            layout02.setVisibility(View.GONE);
            layout03.setVisibility(View.GONE);
            if(id==R.id.btn1) layout01.setVisibility(View.VISIBLE);
             else if (id==R.id.btn2)  layout02.setVisibility(View.VISIBLE);
             else if (id==R.id.btn3)  layout03.setVisibility(View.VISIBLE);


        }
    };
}