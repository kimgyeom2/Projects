package com.gy25m.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gy25m.mvc.R
import com.gy25m.mvc.databinding.ActivityMainBinding
import com.gy25m.mvc.model.ItemModel

class MainActivity : AppCompatActivity() {

    // 1. MVC [ Model - View - Controller ] - 각 파일의 역할을 구분하여 작성하는 것이 특징

    // 1) Model - 데이터를 저장하는 클래스나 데이터를 DB/네트워크/파일 등에서 저장/로드 등의
    //            작업을 하는 코드를 작성하는 파일들
    //            [ex) Item클래스, Person 클래스, Retrofit작업 클래스, DB작업 클래스]

    // 2) View  - 사용자가 볼 화면을 구현하는 목적의 코드가 있는 파일들
    //            [ activity_main.xml, MainActivity.kt, fragment_my.kt ]

    // 3) Controller - 뷰와 모델 사이에서 연결하는 역할, 클릭같은 이벤트를 처리하여 뷰의 요청에
    //                 따라 Model의 데이터를 제어하여 뷰에게 보여주는 역할[Actiivty, Fragment]
    //                 Activit,Fragment는 뷰의 역할도 같이함 (안드로이드는 뷰,컨트롤 분류가 거의안됨)

    // app 모듈에서 만든 Flat Design에서 MainActivity.kt에 작성한 코드들을 크게 3가지 역할로 분류
    // #1 화면구현                                         -- View 역할
    // #2 이벤트처리                                        -- Controller 역할
    // #3 SharedPreferences를 이용하여 데이터를 저장하는 기능  -- Model 역할

    // 역할별 파일에 대한 구분을 쉽게 하기 위해 java폴더 안에 파일의 역할별로 package를 나누기도 함

    // # view 참조변수
        lateinit var binding:ActivityMainBinding
    // # model 참조변수
        lateinit var model:ItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View 역할
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Model 객체 생성
        model=ItemModel(this)

        // Controller역할 - 클릭 이벤트 처리[view 와 model 연결작업 수행]
        binding.btnSave.setOnClickListener {
            model.saveData(binding.etName.text.toString(),binding.etEmail.text.toString())
        }
        binding.btnLoad.setOnClickListener {
            var item=model.loadData()
            binding.tv.text=item.name+":"+item.email
        }
    }
}

// ## MVC의 장점 ##
// 1. 데이터를 제어하는 코드가 Activity/Fragment 클래스안에 모두 있지 않아서 간결해짐
// 2. 역할별로 코드가 분리되어 있어서 가독성이 좋고 기능 코드 위치를 찾기 수월해서 유지보수하기 좋음
// 3. model 역할을 하는 클래스안에 어떤 View도 참조하고 있지않아서 view를 변경해도
//    model 코드는 전혀 변경되지 않기에 다른 view에서도 재사용 가능

// ## MVC의 단점 ##
// 1. 안드로이드에서는 View와 Controller의 완전분리가 어려움. Activity는 view이면서 Controller임
// 2. View에서 결국 model객체를 참조하고 있어서 model이 바뀌면 view도 바꿔야함
// 3. 규모가 커지면 controller 역할을 하는 Activity의 코드는 여전히 비대해짐