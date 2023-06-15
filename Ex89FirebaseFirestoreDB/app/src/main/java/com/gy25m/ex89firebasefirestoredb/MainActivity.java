package com.gy25m.ex89firebasefirestoredb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.gy25m.ex89firebasefirestoredb.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener(view -> clickSave());
        binding.btnLoad.setOnClickListener(view -> clickLoad());
    }

    void clickSave(){
        String name=binding.etName.getText().toString();
        int age= Integer.parseInt(binding.etAge.getText().toString());
        String address=binding.etAddress.getText().toString();

        binding.etName.setText("");
        binding.etAge.setText("");
        binding.etAddress.setText("");

        //Firestore DB에 저장 [Map Collection단위로 저장] 식별자와 데이터가 있기때문
        FirebaseFirestore firestore=FirebaseFirestore.getInstance();
        //"person"이라는 이름의 컬렉션을 참조하는 참조객체 소환
        CollectionReference personRef=firestore.collection("person");//없으면 만들고 있으면 참조

        //Field값들을 Map으로 준비
        Map<String, Object> person=new HashMap<>();
        person.put("name",name);
        person.put("age",age);
        person.put("address",address);

        //personRef 참조컬렉션에 값들 넣기
        //personRef.document().set(person).addOnSuccessListener(unused -> Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show());
        //document()안에 안쓰면 랜덤

        //.document,set(person)의 축약기능
        personRef.add(person).addOnSuccessListener(documentReference -> Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show());

    }/////////////////////////
    void clickLoad(){

        FirebaseFirestore firestore=FirebaseFirestore.getInstance();
        CollectionReference personRef= firestore.collection("person");

        personRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                //Collection 안에 여러개의 Document가 있기에
                StringBuffer buffer=new StringBuffer();
                for (QueryDocumentSnapshot snapshot:queryDocumentSnapshots){
                    Map<String,Object> person=snapshot.getData();
                    String name=person.get("name").toString();
                    int age=Integer.parseInt(person.get("age").toString());
                    String address=person.get("address").toString();

                    buffer.append(name+":"+age+"-"+address+"\n");
                }//for
                binding.tv.setText(buffer.toString());
            }
        });

        //** 별외. 특정 필드값에 해당하는 데이터를 검색하고 싶다면
        //personRef.get();  //모든데이터
//        personRef.whereEqualTo("name","sam").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//
//            }
//        });

    }////////////////////////
}