package com.gy25m.ex04imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    // 액티비티가 보여주는 뷰들의 참조변수는 가급적 멤버변수에 선언..
    ImageView iv;
    Button btnaus,btnita,btnfra,btnger;
    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=findViewById(R.id.iv);
        btnaus=findViewById(R.id.btn01);
        btnita=findViewById(R.id.btn02);
        btnfra=findViewById(R.id.btn03);
        btnger=findViewById(R.id.btn04);

        btnaus.setOnClickListener(listener);
        btnita.setOnClickListener(listener);
        btnfra.setOnClickListener(listener);
        btnger.setOnClickListener(listener);


        //이미지뷰 클릭했을때 그림을 차례대로 변경해보기
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImageResource(R.drawable.flag_australia+num);
                num++;
                if(num>12)num=0;
            }
        });

    }//onCreate method..
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) { //파라미터 view : 클릭을 한 버튼을 참조하는 참조변수

            // 어떤 뷰(버튼)을 클릭하였는지 알아내기
            int id=view.getId();

            // 아이디에 따라 해당 버튼의 기능을 구현- 이미지뷰의 이미지를 변경해보기
            if(id==R.id.btn01) iv.setImageResource(R.drawable.flag_australia);
            else if (id==R.id.btn02)iv.setImageResource(R.drawable.flag_italy);
            else if (id==R.id.btn03)iv.setImageResource(R.drawable.flag_france);
            else if (id==R.id.btn04)iv.setImageResource(R.drawable.flag_germany);

        }
    };

}// MainActivity class..