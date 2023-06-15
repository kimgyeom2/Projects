package com.gy25m.ex60broadcastrecieverbooting;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

//4대 컴포넌트는 반드시 Manifest에 등록
public class MyBootingReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // Android 13버전부터 액티비티가 없으면 Toast의 발동을 제한함
        Log.i("Ex60", "booting receive");

        // Android의 N버전(api 25)부터 부팅완료를 들으려면 적어도 앱을 설치한 후
        // 적어도 1회 사용자가 직접 런처화면(앱 목록)에서 아이콘을 클릭하여 실행한
        // 이력이 있는 앱만 부팅완료 들을 수 있음 (해커들 때문에)

        // 부팅완료되면 MainActivity화면이 실행되도록
        String action = intent.getAction(); //리시버 액션값이 여러개일때 뭔지알려고
        if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {

            // Android 10버전부터 리시버에서 직접
            // 액티비티 실행하는것을 금지함
            // 대신 알림(Notification)을 통해 사용자에게 신호를 주고
            // 액티비티 실행할지 여부를 선택하도록 변경됨
            if (Build.VERSION.SDK_INT >= 29) {

                NotificationManagerCompat manager = NotificationManagerCompat.from(context);

                // 알림객체를 만들어주는 건축가 객체 생성
                NotificationChannelCompat channel = new NotificationChannelCompat.Builder("ch01", NotificationManagerCompat.IMPORTANCE_HIGH).setName("Ex60").build();
                manager.createNotificationChannel(channel);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "ch01");

                builder.setSmallIcon(R.drawable.ic_stat_noti);
                builder.setContentTitle("부팅완료");
                builder.setContentText("부팅이 완료되었습니다");

                // 13버전부터 알림에대한 동적 퍼미션이 생김
                if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                manager.notify(100, builder.build());

            }else{
                Intent i=new Intent(context,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }

//            Intent i=new Intent(context,MainActivity.class);
//            // 지금까지한 start액티비티는 메인이 열려있을때 2번째 액티비티를 백스택에 연것
//            // 지금 하는건 아예 안열려있는 상태에서 여는거
//            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //이 앱에서 액티비티가 첨실행되는거라면 필요함
//            context.startActivity(i);
        }



    }
}
