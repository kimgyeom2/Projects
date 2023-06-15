package com.gy25m.testgooglemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {

    // 구글 개발자 사이트의 가이드 문서를 참고하여 개발.
    // 단, 구글지도는 결재계정이 필요함. 즉. 카드번호 필요.

    // 연습으로.. 라이브러리 추가 모습만 확인해보기
    // play-services-maps
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment= (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_googlemap);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                // 여기까지만 해도 지도가 보여짐.. 단, 키발급 되었을때.
            }
        });
    }
}