package com.gy25m.ex50threadprogressdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_wheel).setOnClickListener(view ->clickBtn()); //실행문 1줄이면 중괄호+세미콜론 생략가능
        findViewById(R.id.btn_bar).setOnClickListener(view -> clickBtn2());

    }

    ProgressDialog dialog;
    int gauge=0;

    void clickBtn(){
        //wheel type progress dialog
        if(dialog != null) return;

        dialog=new ProgressDialog(this);
        dialog.setTitle("wheel type dialog");
        dialog.setMessage("downloading..");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        // 테스트 목적으로 3초뒤에 다이얼로그 종료
        handler.sendEmptyMessageDelayed(0,3000);

    }

    Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            dialog.dismiss();
            dialog=null;
        }
    };


    void clickBtn2(){
        if(dialog!=null)return;

        dialog=new ProgressDialog(this);
        dialog.setTitle("bar type dialog");
        dialog.setMessage("다운로드중..");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        dialog.setMax(100);

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        //막대바의 게이지값을 증가시키는 별도의 Thread만들기
        new Thread(){
            @Override
            public void run() {
                gauge=0;

                while (gauge<100){
                    gauge++;
                    dialog.setProgress(gauge);

                    //0.05초 대기
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                dialog.dismiss();
                dialog=null;
            }
        }.start();


    }

}