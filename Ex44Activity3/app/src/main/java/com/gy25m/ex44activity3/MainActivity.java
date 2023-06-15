package com.gy25m.ex44activity3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);

        btn.setOnClickListener(view -> {
            Intent intent=new Intent(this,SecondActivity.class);
            resultLauncher.launch(intent);
        });
    }//oncreate
   
   // 결과를 받기위한 액티비티를 대신 실행시켜 주기위한 하청업체 객체 생성 및 등록
   ActivityResultLauncher<Intent> resultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
       @Override
       public void onActivityResult(ActivityResult result) {
           
           //혹시 실행시켰던 액티비티에서 [뒤로가기 버튼]으로 취소했을 수도 있어서..
           if(result.getResultCode()== RESULT_OK){
              Intent intent=result.getData();
              //택배기사에게 넣었던 Extra데이터들 빼오기
               String name=intent.getStringExtra("name");
               int age=intent.getIntExtra("age",0);

               tv.setText("이름 :"+name+"\n"+"나이 :"+age);

           } else if (result.getResultCode()==RESULT_CANCELED) {
               Toast.makeText(MainActivity.this, "취소", Toast.LENGTH_SHORT).show();
           }
       }
   }); 
   
}//Main