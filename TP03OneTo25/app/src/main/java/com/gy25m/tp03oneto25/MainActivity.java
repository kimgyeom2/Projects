package com.gy25m.tp03oneto25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btnRetry;

    // Button 참조변수 25개짜리 배열객체
    Button[] btns=new Button[25];

    int num=1;  //현재 눌러야할 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        btnRetry=findViewById(R.id.btn_retry);

        ArrayList<Integer> nums=new ArrayList<>();
        for(int n=1;n<=25;n++) nums.add(n);
        Collections.shuffle(nums);

        for(int i=0;i<btns.length;i++){
            btns[i]=findViewById( R.id.b01+i);
            btns[i].setText(nums.get(i)+"");
            btns[i].setOnClickListener(listener);
            btns[i].setTag(nums.get(i));
        }
    }//onCreateMethod

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) { //파라미터 view : 클릭된 버튼 참조변수 - 업캐스팅

            //클릭된 버튼에 있는 글씨가 num과 같은지 비교
//            Button btn=(Button) view;  //다운 캐스팅 - 버튼의 고유기능 get.text를 하기 위해
//            String s=btn.getText().toString();
//            int n=Integer.parseInt(s);

            //버튼뷰에 저장된 tag값을 읽어와서 num과 같은지 비교
            String s=view.getTag().toString();
            int n=Integer.parseInt(s);
            Button btn=(Button) view;

            if(n==num){
                btn.setText("OK");
                btn.setTextColor(0xFFFF0000);  // ARGB
                btn.setBackground(null); //버튼은 배경이 그림임(그림을 없앤거임)
                num++;//다음번호 증가
                tv.setText(num+"");
            }

            if(num>25){
                tv.setText("Stage Clear");
                btnRetry.setEnabled(true);
            }
        }
    };


}//Mainactivity class