package com.gy25m.ex90firebasechatting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.gy25m.ex90firebasechatting.databinding.ActivityChattingBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ChattingActivity extends AppCompatActivity {
    ActivityChattingBinding binding;
    FirebaseFirestore firestore;
    CollectionReference chatRef;
    String chatName="chat01";
    ArrayList<MessageItem> messageItems=new ArrayList<>();
    MessageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChattingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //제목줄에 채팅방 이름이 표시됨
        getSupportActionBar().setTitle(chatName);
        getSupportActionBar().setSubtitle("상대방 이름");

        //마지막에한거
        adapter=new MessageAdapter(this,messageItems);
        binding.recycler.setAdapter(adapter);

        //FireBaseFireStrore 관리 객체 및 (채팅방 이름)참조객체 소환
        firestore=FirebaseFirestore.getInstance();
        chatRef=firestore.collection(chatName);

        //'채팅방이름' 컬렉션에 저장되어 있는 데이터들 읽어오기
        //chatRef의 데이터가 변경될때마다 반응하는 리스너 추가
        chatRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                //변경된 Document만 찾아달라고 요청
                List<DocumentChange> documentChanges=value.getDocumentChanges();
                for(DocumentChange documentChange:documentChanges){
                    //변경된 문서내역의 데이터를 촬영한 SnapShot 얻어오기
                    DocumentSnapshot snapshot=documentChange.getDocument();

                    //Document에 있는 필드값가져오기
                    Map<String,Object> msg=snapshot.getData();
                    String name=msg.get("name").toString();
                    String message=msg.get("message").toString();
                    String profileurl=msg.get("profileUrl").toString();
                    String time=msg.get("time").toString();

                    //읽어온 메세지를 리스트에 추가
                    messageItems.add(new MessageItem(name,message,profileurl,time));

                    //아답터에게 데이터가 추가되었다고 공지해야 화면이 갱신됨
                    adapter.notifyItemInserted(messageItems.size()-1); //마지막에 추가되기때문
                    //리사이클러 뷰의 스크롤 위치가 가장 아래로 이동해야함
                    binding.recycler.scrollToPosition(messageItems.size()-1);
                }//for
                Toast.makeText(ChattingActivity.this, ""+messageItems.size(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.btn.setOnClickListener(view -> clickSend());

    }////////////////////
    void clickSend(){
        //firebase DB에 저장할 데이터들(닉네임, 메세지, 프로필 이미지Url, 작성시간)
        String nickName=G.nickName;
        String message=binding.et.getText().toString();
        String profileUrl=G.profileUrl;

        //메세지를 작성한 시간을 문자열[시:분]
        Calendar calendar=Calendar.getInstance();
        String time=calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);

        //Field에 넣을 값들을 MessageItem객체로 만들어서 한방에 입력
        MessageItem item=new MessageItem(nickName,message,profileUrl,time);

        // '채팅방이름' 컬렉션에 채팅메세지들을 저장
        // 단, 시간순으로 정렬되도록 document의 이름은 현재시간(1970년부터 카운드된 ms)으로 지정
        chatRef.document("MSG_"+System.currentTimeMillis()).set(item);

        // 다음메세지를 입력하기 수월하도록 et글씨 없애기
        binding.et.setText("");

        // 소프트키보드 숨기기
        InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
}