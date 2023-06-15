package com.gy25m.ex64alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(v->clickBtn());
        findViewById(R.id.btn2).setOnClickListener(v->clickBtn2());
        findViewById(R.id.btn3).setOnClickListener(v->clickBtn3());
    }

    void clickBtn(){
        // 알람시계 시스템 앱을 통해 알람 설정 [ 퍼미션 필요 ]
        Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_HOUR, 14);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 30);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "TEST ALARM");
        intent.putExtra(AlarmClock.EXTRA_DAYS ,new int[]{Calendar.MONDAY, Calendar.WEDNESDAY});
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        startActivity(intent);
    }

    void clickBtn2(){
        // 알람 매니저를 이용하여 직접 알람을 설정해보기
        AlarmManager alarmManager= (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        //알람시간이 되었을때 실행될 컴포넌트[Activity, BR, Service] 지정
        Intent intent= new Intent(this, AlarmReciever.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(this, 100, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+10000, pendingIntent);

    }

    void clickBtn3(){
        // 사용자가 원하는 날짜/시간을 선택하여 알람 지정해보기
        // 날짜 선택 다이얼로그 보이기
        DatePickerDialog dialog= new DatePickerDialog(this);
        dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                // 파라미터 i, i1, i2 : year, month, day
                year= i;
                month= i1;
                day= i2;

                //이번에 시간 선택기 보이기
                //현재시간을 기준시간으로 설정
                Calendar calendar= Calendar.getInstance();
                hour= calendar.get(Calendar.HOUR_OF_DAY);
                minute= calendar.get(Calendar.MINUTE);
                new TimePickerDialog(MainActivity.this, timeSetListener, hour, minute, true).show();
            }
        });
        dialog.show();
    }

    int year, month, day;
    int hour, minute;

    // 시간 설정에 반응하는 리스너객체 생성
    TimePickerDialog.OnTimeSetListener timeSetListener= new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            //파라미터 i , i1 : hour, min
            hour= i;
            minute= i1;

            // 정해진 날짜로 Calendar 객체 생성
            Calendar calendar= Calendar.getInstance();
            calendar.set(year, month, day, hour, minute, 0);

            // 정한 시간으로 알람 설정
            AlarmManager alarmManager= (AlarmManager)getSystemService(Context.ALARM_SERVICE);

            //알람설정 시간에 실행할 컴포넌트[Activity, BR, Service] 지정
            Intent intent= new Intent(MainActivity.this, AlarmReciever.class);
            PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this, 200, intent, PendingIntent.FLAG_IMMUTABLE);

            //알람 설정
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pendingIntent);



        }
    };

}