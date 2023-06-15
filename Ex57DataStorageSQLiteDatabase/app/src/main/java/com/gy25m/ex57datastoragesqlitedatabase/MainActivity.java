package com.gy25m.ex57datastoragesqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName,etAge,etEmail;

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.et_name);
        etAge=findViewById(R.id.et_age);
        etEmail=findViewById(R.id.et_email);

        findViewById(R.id.btn1).setOnClickListener(view -> clickInsert());
        findViewById(R.id.btn2).setOnClickListener(view -> clickUpdate());
        findViewById(R.id.btn3).setOnClickListener(view -> clickDelete());
        findViewById(R.id.btn4).setOnClickListener(view -> clickSelectAll());
        findViewById(R.id.btn5).setOnClickListener(view -> clickSelectByName());

        // test.db라는 이름으로 데이터 베이스 파일 열기 또는 생성
        // 액티비티 클래스에 이미 이 기능이 존재함
        // 아래 메소드를 실행하면 test.db를 제어할 수 있는 능력을 가진 객체(SQLiteDatabase)가 리턴됨
        db=openOrCreateDatabase("test.db",MODE_PRIVATE,null);

        // 만들어진 DB파일에 테이블(표)를 생성하는 작업 수행
        // SQL언어를 이용해서 원하는 명령어를 Database에 수행함
        db.execSQL("CREATE TABLE IF NOT EXISTS member(num INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20) NOT NULL,age INTEGER,email TEXT)");

    }//oncreate


    void clickInsert(){
        String name= etName.getText().toString();
        int age=Integer.parseInt(etAge.getText().toString());
        String email=etEmail.getText().toString();

        //member라는 이름의 테이플(표)에 값 삽입하는 쿼리문(SQL) 작성
        db.execSQL("INSERT INTO member (name, age,email) VALUES ('"+name+"','"+age+"','"+email+"')");

    }
    void clickUpdate(){
        //업데이트할 데이터의 이름
        String name= etName.getText().toString();
        db.execSQL("UPDATE member SET age=30 WHERE name=?",new String[]{name});

    }
    void clickDelete(){
        String name= etName.getText().toString();
        db.execSQL(" DELETE FROM member WHERE name=?",new String[]{name});
    }
    void clickSelectAll(){
        //member 테이블의 모든 데이터들을 검색하여 가져오기
        Cursor cursor=db.rawQuery("SELECT * FROM member",null);   //* ->모든 '칸' 줄말고
        if(cursor==null)return; //조건에 맞는게 없어도 null인게 아님 명령어가 잘못됐을때 null인거임

            int cnt=cursor.getCount(); //총 줄(row: 레코드) 수
        cursor.moveToFirst(); // 첫 레코드(줄)로 이동

        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<cnt;i++){
            int num=cursor.getInt(0);
            String name=cursor.getString(1);
            int age=cursor.getInt(2);
            String email=cursor.getString(3);

            buffer.append(num+": "+name+" "+age+" "+email+"\n");
            cursor.moveToNext(); //다음 row(행)로 이동
        }

        //화면에 결과 보여주기
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(buffer.toString());
        builder.create().show();

    }
    void clickSelectByName(){
        String name=etName.getText().toString();
        Cursor cursor=db.rawQuery("SELECT name,age FROM member WHERE name=?",new String[]{name});
        if(cursor==null)return;

        int cnt=cursor.getCount();
        cursor.moveToFirst();

        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<cnt;i++){
            String name2=cursor.getString(0);
            int age=cursor.getInt(1);

            buffer.append(name2+" : "+age+"\n");
            cursor.moveToNext();
        }
        new AlertDialog.Builder(this).setMessage(buffer.toString()).create().show();

    }
}