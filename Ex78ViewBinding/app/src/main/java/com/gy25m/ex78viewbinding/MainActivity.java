package com.gy25m.ex78viewbinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gy25m.ex78viewbinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;

    // ViewBinding은 라이브러리가 아니고 안드로이드 아키텍쳐 구성요소임
    // 그래서 그냥 기능만 on해주면 됨 - build.gradle

    //activity_main.xml과 연결되어 뷰들의 참조변수를 멤버로 가지고 있는 Binding클래스
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Binding객체가 만든 뷰를 액티비티에 보여줘야 하기에.. 주석처리
        //setContentView(R.layout.activity_main);
        //binding객체 생성 - activity_main.xml을 객체로 생성하여 액티비티에 뷰로 설정
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //1) Textview 글씨 제어 - 이미 binding객체가 textview참조중
        binding.tv.setText("Good");

        //2) Button click event
        binding.btn1.setOnClickListener(view -> {binding.tv.setText("Changed");});

        //2.1) Button longclick event - 람다식으로
        binding.btn1.setOnLongClickListener(view -> {
            Toast.makeText(this, "long~click", Toast.LENGTH_SHORT).show();
            return true; //false로하면 그냥 click도 발동함
        });

        //3) 사용자 입력받아 TextView에 보이기
        binding.btn2.setOnClickListener(view -> {
            binding.tvResult.setText(binding.et.getText());
            binding.et.setText("");
        });

        //4) 화면의 일부분을 별도로 설계하여 관리하는Fragment 에서 ViewBinding사용


        //5) 리사이클 뷰에서 뷰바인딩 사용

    }
    ArrayList<ItemVO> items=new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();

        //임의의 대량의 데이터 추가
        items.add(new ItemVO("루피",R.drawable.one_3));
        items.add(new ItemVO("나미",R.drawable.one_nami5));
        items.add(new ItemVO("로빈",R.drawable.one_nicorobin));
        items.add(new ItemVO("루피",R.drawable.one_3));
        items.add(new ItemVO("나미",R.drawable.one_nami5));
        items.add(new ItemVO("로빈",R.drawable.one_nicorobin));
        items.add(new ItemVO("루피",R.drawable.one_3));
        items.add(new ItemVO("나미",R.drawable.one_nami5));
        items.add(new ItemVO("로빈",R.drawable.one_nicorobin));


        //여기에 해도 차이x
        adapter=new MyAdapter(this,items);
        binding.recycler.setAdapter(adapter);
    }
}