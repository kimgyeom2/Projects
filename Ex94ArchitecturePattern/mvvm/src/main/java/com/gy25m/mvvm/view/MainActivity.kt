package com.gy25m.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.gy25m.mvvm.R
import com.gy25m.mvvm.databinding.ActivityMainBinding
import com.gy25m.mvvm.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {

    //3. MVVM [ Model - View - ViewModel ] : view와 model의 데이터를 연결해(data binding) 놓아서 model 데이터가 변경될때 별도의 처리코드 없이 view가 자동 갱신되는 특징
    //  1) Model - 다른 패턴의 model과 같음 [ Item, ItemModel ]
    //  2) View  - 사용자가 볼 화면. 클릭이벤트를 처리하여 ViewModel에게 model 제어를 요청 [ activity_main.xml, MainActivity.kt , fragment....]
    //  3) ViewModel - 뷰와 모델을 연결하는 역할, view 가 연결(binding)한 데이터를 제어하도록 요청하는 코드가 있는 클래스

    // ** View 는 ViewModel 을 참조하고, ViewModel 은 Model을 참조하고 있음.

    // MVVM 을 위해서는 [ dataBinding : 데이터바인딩 ] 기술을 이용하여 개발하는 것이 일반적임.
    // 데이터바인딩은 뷰바인딩과 다르게 xml파일의 root요소가 <layout> 이어야 바인딩클래스가 만들어 짐.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // view역할
        // 레이아웃 xml과 연결하는 바인딩 클래스[activity_main.xml --> ActivityMainBinding]
        // 데이터 바인딩 기능으로 액티비티에 setContentView()를 실행함
        val binding:ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        // 뷰모델 객체를 생성하여 레이아웃 변수에 대입
        binding.vm= MyViewModel(this)

    }
}

// MVVM 장점
// 1. MVP처럼 view와 Presenter가 1:1로 대응되어 있지 않아서 화면이 늘어나도 ViewModel은 재사용가능.
//    결국 전체파일 개수가 줄어듦
// 2. 사용자 이벤트를 viewModel에서 모두 하고있기 때문에 화면이 바뀌어도 이벤트 처리에대한 중복코드가 필요없음
// 3. view는 ViewModel을 참조하지만 viewModel은 view를 참조하지 않기에 view가 변경되도 viewModel은 영향이 없음
// 4. Activity나 Fragment의 코드가 가장 간결함 오로지 view역할만 하니까

// MVVM 단점
// 1. MVVM의 설계학습이 어려움
// 2. view처리가 많아지면 그만큼 viewModel의 코드가 많아져서 결국 비대해짐