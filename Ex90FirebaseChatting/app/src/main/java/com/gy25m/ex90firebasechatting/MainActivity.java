package com.gy25m.ex90firebasechatting;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.gy25m.ex90firebasechatting.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    //프로필 이미지 Uri
    Uri imgUri=null;
    Boolean isFirst=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.civ.setOnClickListener(view -> clcickImg());
        binding.btn.setOnClickListener(view -> clcickBtn());

        //디바이스에 저장되어있는 로그인정보(프로필)가 있는지 확인해보기
        //SharedPreferences에 저장되어 있는 닉네임,프로필 이미지가 있다면 읽어와라.
        loadData();

        if (G.nickName!=null){
            binding.et.setText(G.nickName);
            Glide.with(this).load(G.profileUrl).into(binding.civ);

            isFirst=false;
        }
    }///////////////////////////////

    void loadData(){
        SharedPreferences pref=getSharedPreferences("profile",MODE_PRIVATE);
        G.nickName=pref.getString("nickName",null);
        G.profileUrl=pref.getString("profileUrl",null);
    }

    void clcickImg(){
        Intent intent=new Intent(MediaStore.ACTION_PICK_IMAGES);
        resultLauncher.launch(intent);
    }////////////////////////
    ActivityResultLauncher<Intent> resultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {
        if (result.getResultCode()==RESULT_CANCELED) return;
        imgUri=result.getData().getData();
        Glide.with(this).load(imgUri).into(binding.civ);
    });
    void clcickBtn(){

        if (isFirst){
            //채팅화면 가기전에 프로필이미지와 닉네임을 서버에 저장해야함
            saveData();
        }else {
            startActivity(new Intent(this,ChattingActivity.class));
        }


    }///////////////////////

    void saveData(){
        //이미지를 선택하지 않으면 채팅 불가하도록..
        if (imgUri==null)return;

        //EditText에 있는 닉네임 가져와서 전역변수 역할의 G클래스에 대입
        G.nickName=binding.et.getText().toString();
        
        //이미지 업로드가 오래걸리므로 FirebaseStorage에 먼저 업로드
        FirebaseStorage storage=FirebaseStorage.getInstance();
        //참조위치명이 중복되지 않도록 날짜이용
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String name="IMG_"+sdf.format(new Date());
        StorageReference imgRef=storage.getReference("profileImage/"+name);
        imgRef.putFile(imgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                //업로드가 성공되었으니
                //업로드된 파일의 [다운로드URL]주소를 얻어오도록
                imgRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        G.profileUrl=uri.toString();
                        Toast.makeText(MainActivity.this, "프로필 이미지 저장완료", Toast.LENGTH_SHORT).show();

                        // 1. 서버의 FireStoreDB에 닉네임과 이미지의 url저장
                        FirebaseFirestore firestore=FirebaseFirestore.getInstance();
                        //'profiles'라는 이름의 컬렉션 참조객체 소환
                        CollectionReference profileRef=firestore.collection("profiles");//없으면 만들고 있으면 참조

                        // 닉네임을 Document 이름으로 정하고 필드 '값'으로 이미지경로 url저장
                        Map<String, Object> profile=new HashMap<>();
                        profile.put("profileUrl",G.profileUrl);

                        profileRef.document(G.nickName).set(profile);

                        // 2. 앱을 처음 실행할때만 닉네임과 사진을 입력하도록 하기위해
                        // 디바이스에 영구적으로 데이터를 저장 [sharedPreferance로 저장]
                        SharedPreferences pref=getSharedPreferences("profile",MODE_PRIVATE);//private밖에안됨
                        SharedPreferences.Editor editor=pref.edit();

                        editor.putString("nickName",G.nickName);
                        editor.putString("profileUrl",G.profileUrl);

                        editor.commit();

                        //저장이 완료되었으니 채팅화면으로 이동
                        Intent intent=new Intent(MainActivity.this, ChattingActivity.class);
                        startActivity(intent);

                        finish();//로그인화면 끄기
                    }
                });
            }
        });
        
    }
}//MainActivity class