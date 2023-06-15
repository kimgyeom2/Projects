package com.mrhi2023.ex85retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mrhi2023.ex85retrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    // HTTP 통신 라이브러리 : OkHttp, Retrofit2, Volley
    // 3개 중에서 가장 많이 사용 되는 Retrofit2 실습

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn1.setOnClickListener(view -> clickBtn1());
        binding.btn2.setOnClickListener(view -> clickBtn2());
        binding.btn3.setOnClickListener(view -> clickBtn3());
        binding.btn4.setOnClickListener(view -> clickBtn4());
        binding.btn5.setOnClickListener(view -> clickBtn5());
        binding.btn6.setOnClickListener(view -> clickBtn6());
        binding.btn7.setOnClickListener(view -> clickBtn7());
        binding.btn8.setOnClickListener(view -> clickBtn8());
    }

    void clickBtn8(){
        // 서버의 응답결과가 json이 아닐때 사용..
        // 서버의 응답결과를 그냥 String 으로 받아보기 [ NO Parse ]
        // 결과를 String으로 받으려면 ScalarsConverter 필요 - 추가 라이브러리
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://mrhi2023.dothome.co.kr");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        Retrofit retrofit= builder.build();

        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<String> call= retrofitService.getJsonString();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s= response.body();
                binding.tv.setText(s);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }




    void clickBtn7(){
        // json array를 읽어와서 곧바로 ArrayList<Item>으로 파싱
        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<ArrayList<Item>> call= retrofitService.getBoardArray();
        call.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                ArrayList<Item> items= response.body();
                binding.tv.setText("아이템 개수 : " + items.size());
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {

            }
        });
    }



    void clickBtn6(){
        // POST방식으로 개별 데이터 전송
        String name= "ROSA";
        String message= "Have a good day.";

        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<Item> call= retrofitService.postMethodTest2(name, message);
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item item= response.body();
                binding.tv.setText(item.name+" ~ " +item.msg);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {

            }
        });

    }


    void clickBtn5(){
        //POST방식으로 전달 값 객체 - retrofit 이 자동으로 객체를 json문자열로 변환하여 전송함
        Item item= new Item("kim","Good afternoon");

        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        Call<Item> call= retrofitService.postMethodTest(item);
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item i= response.body();
                binding.tv.setText(i.name +"   " +i.msg);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {

            }
        });

    }


    void clickBtn4(){
        //GET방식으로 전달할 데이터들을 Map Collection으로 한방에 보내기

        //보낼데이터들을 Map객체로 만들기
        HashMap<String, String> datas= new HashMap<>();
        datas.put("name", "Robin");
        datas.put("msg", "Nice to meet you");

        //1) Retrofit객체 생성
        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();
        //2) Service 인터페이스와 추상메소드 설계 - getMethodTest2()
        //3) Service 인터페이스 객체 생성
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);
        //4) 원하는 작업 추상메소드 호출
        Call<Item> call= retrofitService.getMethodTest2(datas);
        //5) 작업시작
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item item= response.body();
                binding.tv.setText(item.name+" , " +item.msg);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {

            }
        });
    }


    void clickBtn3(){
        //GET 방식으로 값을 서버에 전달해보기

        //서버에 보낼 데이터들
        String name= "홍길동";
        String message="안녕하세요.";

        //1) Retrofit객체 생성
        Retrofit retrofit= RetrofitHelper.getRetrofitInstance();

        //2) Service 인터페이스 설계 - 요구 명세 추상 메소드
        //getMethodTest()

        //3) Service 인터페이스 객체 생성
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        //4) 원하는 작업 추상메소드 호출 [서버로 보낼 값 파라미터로 전달]
        Call<Item> call= retrofitService.getMethodTest(name, message);

        //5) 작업시작
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item item= response.body();
                binding.tv.setText(item.name+ " - "+item.msg);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                binding.tv.setText("error : " + t.getMessage());
            }
        });


    }



    void clickBtn2(){
        //경로의 이름을 고정하지 않고 파라미터로 전달하여 지정해보기

        //1) Retrofit 객체 생성
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://mrhi2023.dothome.co.kr");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        //2) Service 인터페이스 설계 [원하는 GET, POST 동작을 하는 추상메소드 설계 - 작업 요구서]
        //getBoardJsonByPath()

        //3) Service 인터페이스 객체 생성
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        //4) 추상메소드를 호출하여 네트워크 작업 수행 Call 객체 받기
        Call<Item> call= retrofitService.getBoardJsonByPath("Retrofit", "board.json");

        //5) 네트워크 작업 시작!!
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item item= response.body();
                binding.tv.setText(item.name+"\n"+item.msg);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                binding.tv.setText("error : " + t.getMessage());
            }
        });
    }

    void clickBtn1(){
        // 단순하게 GET방식으로 서버에 있는 json파일을 읽어오기

        //retrofit library를 이용하여 서버에서 json파일을 읽어와서 Item객체로 곧바로 파싱

        //1. Retrofit 객체 생성
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://mrhi2023.dothome.co.kr");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        //2. 원하는 GET, POST 동작을 하는 인터페이스(작업 요구서)를 설계
        //   RetrofitService.java 인터페이스를 설계 및 추상메소드 : getBoardJson()

        //3. 위 2단계에서 설계한 RetrofitService 인터페이스 객체를 생성
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        //4. 위에서 만튼 서비스객체의 추상메소드를 호출하여 실제 서버작업을 수행하는 Call 이라는 객체를 리턴받기
        Call<Item> call= retrofitService.getBoardJson();

        //5. 위 4단계에서 리턴된 Call객체에게 네트워크 작업을 수행하도록 요청 - 비동기방식으로..
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {

                // 파라미터로 전달된 응답객체로 부터 GSON 라이브러리에 의해
                // 자동으로 Item객체로 파싱되어 있는 데이터 값 얻어오기
                Item item= response.body();
                binding.tv.setText(item.name +" : " + item.msg);
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                binding.tv.setText("failure : " + t.getMessage());
            }
        });


    }
}