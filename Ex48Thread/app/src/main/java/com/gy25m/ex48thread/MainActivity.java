package com.gy25m.ex48thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(view -> {

            //오래 걸리는 작업[ex. Network, DB작업 등]
            for (int i=0;i<20;i++){

                num++;
                tv.setText(num+""); //1씩올라가는게 보이지않고 클릭 작업이 끝나면 한번에 올라가있음
                //스레드를 1초가 잠재우기
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        findViewById(R.id.btn2).setOnClickListener(view -> {
            //오래걸리는 작업을 별도의 Thread에게 수행하도록
            MyThread t=new MyThread(); //직원 채용
            t.start(); //스레드 작업 시작명령 - Thread클래스의 run()메소드 실행됨

        });


    }//onCreate method

    //오래걸리는 작업을 수행할 Thread의 작업내역을 설계
    class MyThread extends Thread{
        @Override
        public void run() { //스레드가 실행할 코드를 작성하는 영역
            for(int i=0;i<20;i++){
                num++;

                // 화면에 num 출력
                // tv.setText(num+"");   error - 화면작업은 반드시 메인스레드가 하도록 강제함
                // 즉 별도의 Thread는 UI작업이 불가능함

                // MainThread에게 UI변경작업 요청
                // 방법1. Handler 객체를 이용 - 스레드가 한작업을 메인으로 가져옴+메인이 할일까지함
                // handler.sendEmptyMessage(0);

                // 방법2. Activity클래스의 runOnUiThread() 메소드를 이용
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(num+"");
                        }
                    });

                //1초간 잠재우기Zz..
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // 별도 Thread가 MainThread에게 UI변경작업을 요청할때
    // 그 메세지를 전달하는 역할을 하는 객체 생성
    Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //sendMessage()를 통해 메세지가 전달되면 자동으로 실행되는 영역
            //이 영역에서는 UI작업 가능함
            tv.setText(num+"");
        }
    };

}//MainActivity class