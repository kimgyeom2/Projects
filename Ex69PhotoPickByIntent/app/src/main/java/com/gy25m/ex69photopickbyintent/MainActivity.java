package com.gy25m.ex69photopickbyintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ///ImageView iv;  //photoview는 이미지뷰 상속받은거라 안바꿔도되긴함
    PhotoView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        iv=findViewById(R.id.iv);

        findViewById(R.id.btn1).setOnClickListener(v->clcickBtn1());
        findViewById(R.id.btn2).setOnClickListener(v->clcickBtn2());
        findViewById(R.id.btn3).setOnClickListener(v->clcickBtn3());
        findViewById(R.id.btn4).setOnClickListener(v->clcickBtn4());
        findViewById(R.id.btn5).setOnClickListener(v->clcickBtn5());

    }

    // 사진 선택결과를 받아오는 계약을 체결하는 대행사 객체 등록
    ActivityResultLauncher<Intent> imagePickResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()!=RESULT_CANCELED){
                //선택된 사진정보를 가진 택배기사를 소환
                Intent intent=result.getData();
                //택배기사에게 사진정보 uri데이터를 달라고 요청
                Uri uri=intent.getData();
                tv.setText(uri.toString());
                //이미지 로드 라이브러리[Glide,Picasso]
                Glide.with(MainActivity.this).load(uri).into(iv);
            }
        }
    });
    void clcickBtn1(){
        //ACTION_PICK : 갤러리 및 포토 앱에서만 선택            선호
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*"); //settype 필수
        imagePickResultLauncher.launch(intent);

    }
    void clcickBtn2(){
        //ACTION_GET_CONTENT : 모든 미디어 앱에서 선택
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
        imagePickResultLauncher.launch(intent);
    }
    void clcickBtn3(){
        //ACTION_OPEN_DOCUMENT : 모든문서 선택앱에서 선택-GET CONTENT의 대체용
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT).setType("image/*");
        imagePickResultLauncher.launch(intent);
    }
    void clcickBtn4(){
        //명시적인 Intent 생성없이 사진선택 화면이 BottomSheet 형식으로 보여짐
        //PickVisualMedia
        pickMediaLauncher.launch(new PickVisualMediaRequest());
    }
    ActivityResultLauncher<PickVisualMediaRequest> pickMediaLauncher=registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new ActivityResultCallback<Uri>() {
        @Override
        public void onActivityResult(Uri result) {
            tv.setText(result.toString());
            Glide.with(MainActivity.this).load(result).into(iv);
        }
    });
    void clcickBtn5(){
        //MediaStore ACTION_PICK
        Intent intent=new Intent(MediaStore.ACTION_PICK_IMAGES); //settype필요 없음
        imagePickResultLauncher.launch(intent);
    }
}