package com.gy25m.ex54datastorageinternal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);
        tv=findViewById(R.id.tv);

        findViewById(R.id.btn_save).setOnClickListener(view -> clickSave());
        findViewById(R.id.btn_load).setOnClickListener(view -> clickLoad());

    }
    void clickSave(){
        String data=et.getText().toString();
        et.setText("");

        //내부 저장소(Internal Storage)의 앱전용 공간에 Data.txt라는 파일에
        //위 문자열 데이터를 저장하기

        //파일쪽으로 데이터를 내보내는 스트림을 열기
        //액티비티 클래스 안에 이미 내부저장소의 파일을 여는 기능 메소드가 존재함
        try {
            FileOutputStream fos=openFileOutput("Data.txt",MODE_APPEND);
            // fos는 바이트단위로 데이터를 저장해야 하기에 불편함
            // 그래서 문자스트림으로 변환. 여기서 한단계 더 나아가서 보조문자스트림을 쓰면 더편함
            PrintWriter writer=new PrintWriter(fos);

            writer.println(data);
            writer.flush(); //물 내기리기
            writer.close(); //보조를 닫으면 스트림도 닫힘

            tv.setText("Saved");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    void clickLoad(){

        //내부저장소의 Data.txt라는 파일에서 데이터 읽어오기
        try {
            FileInputStream fis=openFileInput("Data.txt");
            //바이트 스트림을 문자 스트림으로 변환
            InputStreamReader isr=new InputStreamReader(fis);
            //문자스트림을-->보조 문자스트림 [한줄 단위로 문자열 읽기 기능]
            BufferedReader reader=new BufferedReader(isr);  //아웃풋은 한번에 바이트->보조로 가능

            StringBuffer buffer=new StringBuffer();

            while (true){
                String line=reader.readLine();  //줄바꿈 문자를 제외하고 읽어옴
                if(line==null)break;

                buffer.append(line+"\n");
            }
            tv.setText(buffer.toString());

        } catch (FileNotFoundException e) {
            Toast.makeText(this, "파일을 찾을 수 없습니다", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}