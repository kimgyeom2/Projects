package com.gy25m.mvp.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gy25m.mvp.R
import com.gy25m.mvp.databinding.ActivityMainBinding
import com.gy25m.mvp.model.Item
import com.gy25m.mvp.presenter.MainContract
import com.gy25m.mvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    // MVP [Model - View - Presenter] - view와 model의 완전 분리 특징이 가장 두드러짐
    // 뷰와 Presenter가 해야할 작업을 미리 인터페이스로 규격화 한 것이 특징.
    // 모듈화된 작업 템플릿을 만들때 용이한 구조
    // 1. Model : MVC패턴의 모델과 같은 역할 [ 데이터 취급: Item,Person,ItemModel.. ]
    // 2. View : 사용자가 볼 화면 및 이벤트 처리[ activitiy_main.xml, MainActivity.kt, fragment]
    // 3. Presenter : 뷰와 모델의 중계 역할. 컨트롤러와 비슷하지만 인터페이스로 역할을 정해 놓음

    // 주요특징 : 뷰와 프레젠터가 해야할 작업들을 미리 interface를 통해 규격화 해놓기

    // view 참조변수
    lateinit var binding:ActivityMainBinding

    // presenter 참조변수
    lateinit var presenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // present 객체생성 및 초기화
        presenter= MainPresenter()
        presenter.initial(this)

        // view로서의 역할
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // view로서 사용자 이벤트 처리
        binding.btnSave.setOnClickListener {presenter.clickSave(binding.etName.text.toString(),binding.etEmail.text.toString())}
        binding.btnLoad.setOnClickListener { presenter.clickLoad() }
    }

    override fun showData(item: Item) {
        binding.tv.text=item.name+" : "+item.email
    }

    override fun getContext(): Context {
        return this
    }


}

// MVP의 장점
// 1. MVC처럼 데이터를 제어하는 코드가 Activity안에 없어서 간결함(3개 패턴 모두 model은 존재하기에 동일함)
// 2. MVC보다 조금 더 명확하게 각 영역 역할별 코드가 잘 분리되어 있음
// 3. 각 역할이 인터페이스로 규격화되어서 유지보수나 인수인계가 용이함.
// 4. View 안에서 model을 참조하고 있지않아서 model의 변화에 영향을 받지 않음

// MVP의 단점
// 1. MVC보다 만들어야할 기본 파일들이 많아서 구조가 더 복잡해보임
// 2. view와 presenter가 1:1로 대응되어 파일들이 만들어지기에 파일이 엄청 많아짐
// 3. 규모가 커지면 결국 presenter가 해야할 작업이 많아서 결국 비대해짐