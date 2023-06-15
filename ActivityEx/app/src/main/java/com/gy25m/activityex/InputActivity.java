package com.gy25m.activityex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class InputActivity extends AppCompatActivity {

    TextInputEditText tilName,tilNickname,tilTitle,tilBon;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        btn1=findViewById(R.id.btn_cancel);
        btn2=findViewById(R.id.btn_check);
        tilName=findViewById(R.id.et_name);
        tilNickname=findViewById(R.id.et_nickname);
        tilTitle=findViewById(R.id.et_title);
        tilBon=findViewById(R.id.et_bon);

        btn2.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setView(R.layout.writefinish);

            builder.setPositiveButton("네",(dialogInterface, i) ->{
                Intent intent=getIntent();
                String name=tilName.getText().toString();
                String nickname=tilNickname.getText().toString();
                String title=tilTitle.getText().toString();
                String bon=tilBon.getText().toString();
                intent.putExtra("name",name);
                intent.putExtra("nickname",nickname);
                intent.putExtra("title",title);
                intent.putExtra("bon",bon);
                setResult(RESULT_OK,intent);
                finish();

            } );
            builder.setNegativeButton("아니오",(dialogInterface, i) ->{

            } );
           builder.create().show();
        });


        btn1.setOnClickListener(view -> {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setView(R.layout.writecancel);

            builder.setPositiveButton("네",(dialogInterface, i) ->{
                finish();
            } );
            builder.setNegativeButton("아니오",(dialogInterface, i) ->{

            } );
            builder.create().show();
        });




    }
}