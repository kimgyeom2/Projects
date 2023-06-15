package com.gy25m.ex93kotlinopenapinaversearch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.gy25m.ex93kotlinopenapinaversearch.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/* implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.google.code.gson:gson:2.10.1'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.retrofit2:converter-scalars:2.9.0'
    implementation 'com.github.bumptech.glide:glide:4.15.1'
    라이브러리 추가
    */

class MainActivity : AppCompatActivity() {
    val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn.setOnClickListener{searchData()}
    }

    fun searchData(){

        // 소프트키보드 없애기
        var imm:InputMethodManager= getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken,0)

        // Naver (쇼핑)검색 Open Api 사용해보기

        // 네트워크 작업을 편하게 대신 작성해주는 library활용 Retrofit ( 코드를 대신써주는거지 네트워크작업을 대신해주는건 아님)

        // 1) 코딩을 대신해주는 retrofit 생성, 해임달 버퍼드 스트림 이런거 안해도됨^^
        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("https://openapi.naver.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 2) 레트로핏이 해줄 작업에대한 요구 명세( 인터페이스 설계 및 추상메소드 정의 )
        // RetrofitService.kt 설계 RetrofitService인터페이스에 함

        // 3) 레트로핏 서비스 객체 생성
        val retrofitService:RetrofitService=retrofit.create(RetrofitService::class.java)

        // ##찐 4) 원하는 작업요청하여 네트워크 작업 실행 객체 리턴받기
        val call:Call<NaverSearchApiResponce> = retrofitService.searchData2(binding.et.text.toString())

        // 5) 네트워크 작업을 시작
        call.enqueue(object : Callback<NaverSearchApiResponce>{
            override fun onResponse(
                call: Call< NaverSearchApiResponce>,
                response: Response<NaverSearchApiResponce>
            ) {
                val naverResponce:NaverSearchApiResponce?=response.body()
                // Toast.makeText(this@MainActivity, "아이템 개수: ${naverResponce?.items?.size}", Toast.LENGTH_SHORT).show()

                // 응답받은 객체의 items 리스트를 리사이클러뷰에 보이기
                binding.recycler.adapter=MyAdapter(this@MainActivity,naverResponce!!.items)
            }

            override fun onFailure(call: Call<NaverSearchApiResponce>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error : "+ t.message, Toast.LENGTH_SHORT).show()
            }
        })


        // 4) 원하는 작업요청하여 네트워크 작업 실행 객체 리턴받기
        /*val call:Call<String> = retrofitService.searchDataByString("_AkiZcjxuhYuLymZibhD","Vru6zAgJjL",binding.et.text.toString())

        // 5) 작업시작
        call.enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>, response: Response<String>) {
                var s:String?=response.body()

                AlertDialog.Builder(this@MainActivity).setMessage(s).show()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@MainActivity,"error", Toast.LENGTH_SHORT).show()
            }
        })
*/
    }

}