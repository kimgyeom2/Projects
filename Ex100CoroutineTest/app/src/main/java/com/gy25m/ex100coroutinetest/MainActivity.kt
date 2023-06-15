package com.gy25m.ex100coroutinetest

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.gy25m.ex100coroutinetest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Coroutine[코루틴] - 경량스레드 : 스레드를 멈추지 않고 비동기처리
        // 하나의 스레드안에 여러개의 코루틴 실행
        // 스레드가 요리사라면 멀티스레드는 여러 요리사가 화구(CPU)를 번갈아 사용하는 기술.
        // 다른 요리사가 사용중에는 기존 요리사는 동작을 멈춤
        // 코루틴은 요리사 한명이 파스타를 만들면서 스테이크도 굽는 느낌. 팬이2개
        // 자리를 비켜가면서 멈추는행동이 없어서 속도가 좀더 빠르게 동시작업가능

        // 코루틴을 구동하는 2개의 범위(scope)가 존재함
        // 1. GlobalScope : 앱 전체의 생명주기와 함께 관리되는 범위
        // 2. CoroutineScope : 버튼 클릭같은 특정이벤트 순간에 해야할 Job을 위해 실행되는 범위 [ex)네크워크 통신,DB CRUD, 특정연산 수행]

        // 실습 1) GlobalScope 코드연습
        binding.btn.setOnClickListener { 
            //코루틴 없이 오래걸리는 작업 실행해보기
//            for (n in 0..9){
//                Log.d("Tag","n:$n")
//                Thread.sleep(500)
//            }

            // 비동기 작업으로 위 작업을 수행 - 코루틴을 사용해보기
            GlobalScope.launch {
                for (n in 0..9){
                  Log.d("Tag","n:$n - ${Thread.currentThread().name}")
                    delay(500)
                }
            }
            Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show()
        }

        // 실습2) Coroutine 비동기 실행
        // CoroutineScope는 GlobalScope와 다르게 해당작업을 어떤 스레드에게 보낼지
        // 결정하는 Dispatcher[디스패처]를 지정해야함
        // 1] Dispatchers.Default - 기본 스레드풀의 스레드를 사용[cpu작업이 많은 연산작업에 적합]
        // 2] Dispatchers.IO  - DB나 네트워크 IO 스레드를 사용
        // 3] Dispatchers.Main - Main스레드를 사용 [UI작업등에 적합]
        // 4] Dispatchers.Uncomfiled - 특별한 디스패처[해당 코루틴을 호출하는 스레드에서 실행]
        binding.btn2.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                for (n in 100..110){
                    Log.d("TAG","n:$n - ${Thread.currentThread().name}")
                   // binding.tv.text="n:${n}" 원래 디스패처.메인 말고는 UI변경이안되는데 얘 왜됨? 오류임
                    delay(500)
                }
            }
            Toast.makeText(this,"bbb",Toast.LENGTH_LONG).show()
        }

        binding.btn3.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                for (n in 200..210){
                    binding.tv.text="n:$n"
                    delay(500)
                }
            }
            Toast.makeText(this, "ccc", Toast.LENGTH_SHORT).show()
        }

        binding.btn4.setOnClickListener {
            // 메인으로 서버작업시도.. 서버는 무조건 별도
            CoroutineScope(Dispatchers.Main).launch {
                //네트워크 이미지 불러오기 - error 메인스레드는 네트워크 작업 불가능
                val url=URL("https://cdn.pixabay.com/photo/2023/05/18/19/56/crocodile-8003179__340.jpg")
                val bm:Bitmap=BitmapFactory.decodeStream(url.openStream())
                binding.iv.setImageBitmap(bm)
            }
        }


        binding.btn5.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val url=URL("https://cdn.pixabay.com/photo/2023/05/18/19/56/crocodile-8003179__340.jpg")
                val bm:Bitmap=BitmapFactory.decodeStream(url.openStream())
                //binding.iv.setImageBitmap(bm)//UI변경 불가능
                withContext(Dispatchers.Main){
                    binding.iv.setImageBitmap(bm)
                }
            }
        }

        binding.btn6.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {

                //동시에 여러작업하기
                //작업 1
                launch {
                    for (n in 1000..1010) {
                        Log.d("TAG", "n:$n")
                        delay(500)
                    }
                }

                //작업2
                launch {
                    for (n in 2000..2010) {
                        Log.d("TAG", "n:$n")
                        delay(500)
                    }
                }
            }
        }

        binding.btn7.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {

                //순차적 작업하기
                //작업 1
                launch {
                    for (n in 1000..1010) {
                        Log.d("TAG", "n:$n")
                        delay(500)
                    }
                }.join() //작업1이 끝날때까지 다른 코루틴 대기함

                //작업2
                launch {
                    for (n in 2000..2010) {
                        Log.d("TAG", "n:$n")
                        delay(500)
                    }
                }
            }
        }

        binding.btn8.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                someTask()
            }
        }

        // 코루틴의 제어
        var job:Job?=null
        binding.btn9.setOnClickListener {
            job=CoroutineScope(Dispatchers.Default).launch {
                for (n in 300..310){
                    Log.d("TAG","n : $n")
                    delay(500)
                }
            }
        }

        binding.btn10.setOnClickListener {
            job?.cancel()
        }

    }//oncreate

    // 코루틴 스코프 범위 밖에서 코루틴의 기능을 사용할때 suspend함수로 만들면 해결할 수 있음
    suspend fun someTask(){
        for(n in 1000..1010){
            Log.d("TAG","someTask:$n")
            delay(500)  //딜레이는 코루틴기능임 suspend써야함
        }
    }
}