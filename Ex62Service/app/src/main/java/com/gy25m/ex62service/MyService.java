package com.gy25m.ex62service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

//Service는 Android 4대 주요구성요소임. 반드시 Manifest에 등록해야 함
public class MyService extends Service {

    MediaPlayer mp;
    //startService()로 서비스가 시작되면 자동으로 실행되는 메소드
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();

        // Oreo 버전부터 "Foreground Service(전경)"라는 개념이 도입됨
        // Foreground Service - 사용자에게 서비스가 동작중임을 인식하도록 반드시
        // 알림(Notification)을 보이도록 강제하는 서비스 개념
        // startFiregroundService()로 실행된 서비스객체는 반드시
        // startForeground()라는 메소드를 호출해야만함

        // 알림 객체 만들고 Foreground서비스로 실행하라고 요청!
        NotificationManagerCompat manager=NotificationManagerCompat.from(this);
        NotificationCompat.Builder builder=null;
        if(Build.VERSION.SDK_INT>=26){
            NotificationChannelCompat channel=new NotificationChannelCompat.Builder("ch1",NotificationManagerCompat.IMPORTANCE_HIGH).setName("Ex62 알림채널").build();
            manager.createNotificationChannel(channel);

            builder=new NotificationCompat.Builder(this,"ch1");
        }else {
            builder=new NotificationCompat.Builder(this,"");
        }

        builder.setSmallIcon(R.drawable.ic_noti_run);
        builder.setContentTitle("Ex62 Music Service");
        builder.setContentText("뮤직 서비스가 실행중입니다");

        // 음악 재생/정지 버튼을을가진 Mainactivity를
        // 알림창이 클릭되었을때 실행되도록
        Intent i=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,11111,i,PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(pendingIntent);

        // 알림객체 생성
        Notification notification=builder.build();
        // 포어그라운드로 실행하도록..
        startForeground(1,notification);

        if(mp==null){
            mp=MediaPlayer.create(this,R.raw.kalimba);   //음악이 res폴더에 있다면
            mp.setVolume(0.7f,0.7f);
            mp.setLooping(true);
        }
        mp.start();

        //메모리 문제로 프로세스가 강제로 서비스를 kill 시켜버리는 경우가 있음
        //다시 메모리 문제가 해결되면 자동으로 다시 서비스를 실행시키도록 설정
        return START_STICKY;
    }

    //stopService()를 실행하여 서비스가 종료되면 자동으로 실행되는 메소드

    @Override
    public void onDestroy() {

        if(mp!=null){
            mp.stop();
            mp.release();  //미디어 파일은 따로 지워줘야함
        }

        super.onDestroy();
    }


    //bindService()로 서비스가 시작되면 자동으로 실행되는 메소드
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
