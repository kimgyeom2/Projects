package com.gy25m.ex59broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


// 안드로이드의 4대 컴포넌트 클래스들은 반드시 AndroidManifest.xml에 등록해야만 함
public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 방송을 수신했을때 자동으로 실행되는 콜백메소드

        Toast.makeText(context, "recieved", Toast.LENGTH_SHORT).show();
        
    }
}
