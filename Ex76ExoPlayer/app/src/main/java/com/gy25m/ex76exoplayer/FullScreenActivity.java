package com.gy25m.ex76exoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

public class FullScreenActivity extends AppCompatActivity {

    PlayerView playerView;
    ExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        playerView=findViewById(R.id.player_view);
        exoPlayer=new ExoPlayer.Builder(this).build();
        playerView.setPlayer(exoPlayer);

        //플레이시킬 동영상의 Uri가 필요함
        Intent intent=getIntent();
        Uri uri=intent.getData();
        //재생위치 얻어오기
        long position=intent.getLongExtra("current position",0);
        MediaItem mediaItem=MediaItem.fromUri(uri);
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        //재생위치로 seekbar이동
        exoPlayer.seekTo(position);
        exoPlayer.play();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        exoPlayer.stop();
        exoPlayer.release();
        exoPlayer=null;
    }
}