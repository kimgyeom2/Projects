package com.gy25m.ex81webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.gy25m.ex81webservice.databinding.ActivityMainBinding;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    //activity_main.xml 문서와 연결되어 뷰들을 제어할 수 있도록 설계된
    //Binding 클래스 참조변수
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn.setOnClickListener(view->clickBtn());
        binding.btn2.setOnClickListener(view->clickBtn2());
    }

    void clickBtn2(){
        // 웹서버의 이미지를 읽어오기 - 스레드와 스트림이용 해야 함.
        // 이미지 로드 라이브러리를 활용 : Glide or Picasso
        String address="http://gyeom2.dothome.co.kr/a_lion.png";
        Glide.with(this).load(address).into(binding.iv);

//        new Thread(){
//            @Override
//            public void run() {
//
//                String address="http://mrhi2023.dothome.co.kr/newyork.jpg";
//
//                try {
//                    URL url= new URL(address);
//                    InputStream is= url.openStream();
//
//                    Bitmap bm= BitmapFactory.decodeStream(is);
//                    runOnUiThread(()->{
//                        binding.iv.setImageBitmap(bm);
//                    });
//
//                } catch (MalformedURLException e) {
//                    throw new RuntimeException(e);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        }.start();

    }


    void clickBtn(){
        // 웹서버에 접속하여 index.html 문서를 읽어와서
        // TextView에 보여주기
        // 네트워크작업은 별도의 Thread가 해야만 함.
        Thread t= new Thread(){
            @Override
            public void run() {

                String address="http://gyeom2.dothome.co.kr/index.html";

                // 무지개로드(Stream)를 열어주는 해임달(URL)객체 생성
                try {
                    URL url= new URL(address);
                    InputStream is= url.openStream();//바이트 스트림
                    InputStreamReader isr= new InputStreamReader(is);//문자 스트림 변환
                    BufferedReader reader= new BufferedReader(isr);//보조문자 스트림

                    StringBuffer buffer= new StringBuffer();
                    while (true){
                        String line= reader.readLine();
                        if(line==null) break;

                        buffer.append(line +"\n");
                    }

                    // 별도 Thread는 UI변경 불가능.
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.tv.setText(buffer.toString());
                        }
                    });


                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        };
        t.start();
    }
}