package com.mrhi2023.ex83jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import com.mrhi2023.ex83jsonparsing.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Item> items= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn.setOnClickListener(view -> clickBtn());
        binding.btn2.setOnClickListener(view -> clickBtn2());
    }

    void clickBtn2(){
        AssetManager assetManager= getAssets();
        try {
            InputStream is= assetManager.open("bbb.json");
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader reader= new BufferedReader(isr);

            StringBuffer buffer= new StringBuffer();
            while (true){
                String line= reader.readLine();
                if(line==null) break;

                buffer.append(line+"\n");
            }

            binding.tv.setText(buffer.toString());

            JSONArray jsonArray= new JSONArray(buffer.toString());
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jo= jsonArray.getJSONObject(i);

                int no= jo.getInt("no");
                String name= jo.getString("name");
                String msg= jo.getString("msg");

                items.add( new Item(no, name, msg) );
            }

            binding.tv.setText( "아이템 개수 : " + items.size() );


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    void clickBtn(){
        // assets폴더의 파일을 가져오기 위해 창고관리자 소환
        AssetManager assetManager= getAssets();

        //assets/aaa.json 파일을 읽어오기 위한 InputStream
        try {
            InputStream is= assetManager.open("aaa.json");
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader reader= new BufferedReader(isr);

            StringBuffer buffer= new StringBuffer();
            while (true){
                String line= reader.readLine();
                if(line==null) break;

                buffer.append(line+"\n");
            }

            String jsonStr= buffer.toString();

            //읽어온 json문자열 확인
            binding.tv.setText(jsonStr);

            // Json문자열을 분석(parse)
            JSONObject jo= new JSONObject(jsonStr);
            String name= jo.getString("name");
            String message= jo.getString("msg");
            int age= jo.getInt("age");
            JSONObject address= jo.getJSONObject("address");
            String nation= address.getString("nation");
            String city= address.getString("city");

            binding.tv.setText(name+"\n"+message+"\n"+age);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}