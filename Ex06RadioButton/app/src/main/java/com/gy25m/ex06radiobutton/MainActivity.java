package com.gy25m.ex06radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button btn;
    TextView tv;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=findViewById(R.id.rg);
        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //radio 버튼중 선택된녀석의 글씨를 얻어오기

                //radiogroup에게 체크된녀석의 아이디 얻어오기
                int id=rg.getCheckedRadioButtonId();

                //체크된 아이디의 radio버튼 객체 참조
                RadioButton rb=findViewById(id);
                tv.setText(rb.getText().toString());
            }
        });

        // radio버튼의 체크상태가 변경될떄마다 반응하는 리스너는 버튼들에 붙이지 말고
        // radio그룹에 붙여서 한번에 제어하는것을 권장
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // 두번째 파라미터 i = 선택된 radio버튼의 id
                RadioButton radioButton=findViewById(i);
                tv.setText(radioButton.getText().toString());
            }
        });


        //다른 뷰들의 이벤트처리도 똑같음
        rb=findViewById(R.id.rating);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                //두번째 파라미터 v =레이팅값
                tv.setText("별점 : "+v);
            }
        });
    }
}