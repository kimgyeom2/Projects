package com.gy25m.ex22listview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 대량의 데이터를 저장할 리스트 객체
    ArrayList<String> datas=new ArrayList<>();

    // 대량의 데이터(String)를 적절한 view(textview)객체로 만들어주는 adapter객체의 참조변수
    ArrayAdapter adapter;
    EditText et;
    Button btn;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터들 추가
        datas.add(new String("aaa"));
        datas.add(new String("bbb"));
        datas.add("ccc");


        // 아답터객체 생성
        adapter=new ArrayAdapter(this,R.layout.listview_item,datas);
        listView=findViewById(R.id.listview);
        listView.setAdapter(adapter);

        // list의 항목을 클릭했을때 반응하기
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //3번째 파라미터- 클릭된 아이템 인덱스
                Toast.makeText(MainActivity.this, datas.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        // list의 item을 long클릭했을때 반응하기 -그 데이터 삭제하기
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //대량의 데이터 datas 리스트객체에서 현재 롱클릭한 아이템의 위치요소를 제거
                datas.remove(i);
                adapter.notifyDataSetChanged();


                return true;  //false로하면 터치를 땔떼 short클릭한것이 발동함
            }
        });

        et=findViewById(R.id.et);
        btn=findViewById(R.id.btn);

        //새로운 데이터를 추가
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Edittext에있는 글씨를 얻어와서 대량의 데이터인 datas(리스트객체)에 추가하기
                datas.add(et.getText().toString());
                et.setText("");
                //adater에게 데이터의 개수가 변경되었다는것을 공지해줘야 갱신됨
                adapter.notifyDataSetChanged();
                //리스트 뷰의 스크롤위치 지정
                listView.setSelection(datas.size()-1);
            }
        });

    }
}