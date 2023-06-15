package com.gy25m.ex73cameraappvideo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv=findViewById(R.id.vv);
        tv=findViewById(R.id.tv);

        findViewById(R.id.btn).setOnClickListener(view -> clickBtn());
    }
    void clickBtn(){
        //비디오는 용량이 커서 자동파일로 저장됨 28버전이하는 동적 퍼미션 필요
        Intent intent=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        launcher.launch(intent);
    }
    ActivityResultLauncher<Intent> launcher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
        if (result.getResultCode()==RESULT_CANCELED) return;

        Uri uri=result.getData().getData();
        tv.setText(uri.toString());
        vv.setVideoURI(uri);
        //비디오가 로딩하는 시간이 소요됨 그래서 로딩원료 리스너로 터리
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                vv.start();
            }
        });


    });

}