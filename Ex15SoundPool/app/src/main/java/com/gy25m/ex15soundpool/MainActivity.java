package com.gy25m.ex15soundpool;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;

    SoundPool sp;
    int sdStart,sdAgain,sdGood,sdSelect;   //음원 ID저장용 변수
    int sdmusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //사운드풀 객체를 만들어서 음원들을 등록
        // 사운더풀을 만들어주는 건축가객체 생성
        SoundPool.Builder builder=new SoundPool.Builder();
        builder.setMaxStreams(10); //한번에 플레이가능한 음원 수 - 우선순위가 낮은 음원은 안들림
        sp=builder.build();

        //음원등록 --> 음원만의 고유 ID발급받음
        sdStart=sp.load(this,R.raw.s_sijak,0); //등록할때는 우선순위 모두 0권장
        sdAgain=sp.load(this,R.raw.s_again,0);
        sdGood=sp.load(this,R.raw.s_goodjob,0);
        sdSelect=sp.load(this,R.raw.s_select,0);

        sdmusic=sp.load(this,R.raw.kalimba,0);


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sp.play(sdStart,0.9f,0.9f,3,0,1.0f);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdAgain,0.8f,0.8f,2,0,1.0f);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdGood,1,1,1,0,1.0f);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdSelect,0.9f,0.9f,3,0,1.0f);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.play(sdmusic,1,1,5,0,1);
            }
        });
    }


}