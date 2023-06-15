package com.gy25m.ex14toastanddialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn01,btn02;
    String[] items =new String[]{"Apple","Banana","Orange"};
    boolean[] checkedItems=new boolean[]{true,false,true};

    int selectedItemPosition=1;

    TextView dialogtv;
    Button dialogbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        btn01=findViewById(R.id.btn01);
        btn02=findViewById(R.id.btn02);

        // Toast
        // MainActivity안에 있는 이너클래스인 익명'클래스'
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast 객체생성
                Toast t=Toast.makeText(MainActivity.this,"Hello toast",Toast.LENGTH_SHORT);
                t.show();
            }
        });



        //   Dialog
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AlertDialog를 만들어주는 건축가객체(Builder) 생성
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

                //건축가에게 원하는 모양 의뢰(설정)
                builder.setTitle("다이얼로그");
                builder.setIcon(R.drawable.baseline_kebab_dining_24);

                //1. 단순 메세지 1개 보여줄때
                //builder.setMessage("DO you wanna build a Snowman?");

                //2. 목록으로 항목들 보여줄때
//                builder.setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        //두번째 파라미터 i : 클릭된 항목의 위치 인덱스번호 : 0,1,2..
//                        Toast.makeText(MainActivity.this,items[i],Toast.LENGTH_SHORT).show();
//                    }
//                });

                //3. Single choice 항목들 보여줄 때
//                builder.setSingleChoiceItems(items, selectedItemPosition, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        selectedItemPosition=i;
//                    }
//                });

                //4. Multiple CHice 항목들보여줄떄
//                builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                        // 두번째 파라미터 i=클릭된 항목의 인덱스번호
//                        // 세번째 파라미터 b=클릭된 항목의 true/false 여부
//                        checkedItems[i]=b;
//                    }
//                });

                // 5. Custom view 보여주기
                // 직접 java로 뷰를 만들어서 설정하면 코드가 너무복잡
                // xml언어로 view를 설계하면 편하게 적용가능
                // 그래서 res안에 화면의 배치를 관리해주는 전용폴더  layout안에 dialog.xml파일 다이얼로그의 커스텀뷰 모양 설계
                builder.setView(R.layout.dialog);



                builder.setPositiveButton("수락", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       // Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();

                        //singlechoice를 통해 선택한 아이템 문자열 출력
                       // Toast.makeText(MainActivity.this,items[selectedItemPosition],Toast.LENGTH_SHORT).show();

                        //multiplechice 를 통해 선택된 아이템들의 문자열을 출력해보기
                        String s="";
                        for(int k=0;k<checkedItems.length;k++){
                            if (checkedItems[k]) s+=items[k]+" ";
                        }
                        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("거절", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"cancel",Toast.LENGTH_SHORT).show();
                    }
                });
                //건축가에게 의뢰한 다이얼로그를 만들어달라고 요청
                AlertDialog dialog=builder.create();

                //다이얼로그의 바깥쪽을 클릭했을때 없어지지 않도록 하기
                dialog.setCanceledOnTouchOutside(false);
                //이전버튼으로 못나가게하는법
                dialog.setCancelable(false);

                dialog.show();

                //다이얼로그 안에있는 custom view의 뷰들을 찾아서 제어하기
                dialogtv=dialog.findViewById(R.id.dialog_tv);
                dialogbtn=dialog.findViewById(R.id.dialog_btn);
                dialogbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogtv.setText("Nice");
                    }
                });
            }
        });



    }
}