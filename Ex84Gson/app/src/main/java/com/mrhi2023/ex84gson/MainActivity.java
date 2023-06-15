package com.mrhi2023.ex84gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.mrhi2023.ex84gson.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn.setOnClickListener(v->clickbtn());
        binding.btn2.setOnClickListener(v->clickbtn2());
        binding.btn3.setOnClickListener(v->clickbtn3());
    }

    void clickbtn3(){
        // jsonArray --> Person object array
        String jsonStr="[{'name':'sam', 'age':20},{'name':'robin','age':25}]";

        Gson gson= new Gson();
        Person[] people= gson.fromJson(jsonStr, Person[].class);
        binding.tv.setText("객체 수 : " + people.length);

    }

    void clickbtn2(){
        // Person객체 --> json 문자열
        Person person= new Person("Robin", 25);

        Gson gson= new Gson();
        String jsonStr= gson.toJson(person);
        binding.tv.setText(jsonStr);
    }

    void clickbtn(){
        // GSON library를 이용하여 편하게 json문자열을 분석하여 객체로 생성
        // json문자열
        String jsonStr="{'name':'sam', 'age':20}";

        // GSON을 이용하여
        // name, age를 멤버로 가지는 Person클래스 객체로 한방에 분석하여 변환
        Gson gson= new Gson();
        Person person= gson.fromJson(jsonStr, Person.class);
        binding.tv.setText(person.name +" : " + person.age);
    }
}