package com.gy25m.ex70photomultiplepickbyintent;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    PagerAdapter adapter;
    ViewPager2 vp;
    WormDotsIndicator dotsIndicator;
    ArrayList<Uri> images=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);

        findViewById(R.id.btn1).setOnClickListener(view -> clickBtn1());
        findViewById(R.id.btn2).setOnClickListener(view -> clickBtn2());
        findViewById(R.id.btn3).setOnClickListener(view -> clickBtn3());

        vp=findViewById(R.id.vp);
        adapter=new PagerAdapter(this,images);
        vp.setAdapter(adapter);

        dotsIndicator=findViewById(R.id.dots_indicator);
        dotsIndicator.attachTo(vp);
    }

    // 여러사진 선택결과를 돌려받는 계약 체결 대행사객체 등록
    ActivityResultLauncher<Intent> imagePickLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
       if (result.getResultCode()!=RESULT_CANCELED){
           //사진 uri들 가져온 택배기사 소환
           Intent intent=result.getData();
           ClipData clipData=intent.getClipData();
           int size=clipData.getItemCount();
           for (int i=0;i<size;i++){
               images.add(clipData.getItemAt(i).getUri());
           }
           tv.setText("선택된 개수 : "+images.size());
           adapter.notifyDataSetChanged();
       }
    });
    void clickBtn1(){
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT).setType("image/*").putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
        // setType 필수
        imagePickLauncher.launch(intent);

    }
    void clickBtn2(){
        multiplePickLauncher.launch(new PickVisualMediaRequest());
    }
    ActivityResultLauncher<PickVisualMediaRequest> multiplePickLauncher=registerForActivityResult(new ActivityResultContracts.PickMultipleVisualMedia(), new ActivityResultCallback<List<Uri>>() {
        @Override
        public void onActivityResult(List<Uri> result) {
            for (Uri uri:result){
                images.add(uri);
            }
            tv.setText(images.size()+"");
            adapter.notifyDataSetChanged();
        }
    });
    void clickBtn3(){  //편하고 이쁨
        Intent intent=new Intent(MediaStore.ACTION_PICK_IMAGES).putExtra(MediaStore.EXTRA_PICK_IMAGES_MAX,10);
        imagePickLauncher.launch(intent);
    }
}