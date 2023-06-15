package com.gy25m.mvp.presenter

import com.gy25m.mvp.model.Item
import com.gy25m.mvp.model.ItemModel

// Presenter라면 가져야 할 기능을 기술한 인터페이스를 구현하여 실제 기능을 작성하는 클래스
class MainPresenter : MainContract.Presenter {

    // Presenter는 view와 model을 연결해야 하기에 각각의 참조변수를 멤버로 보유
    var view:MainContract.View?=null // view 역할을 수행하는 클래스는 MainContract.View
    // 인터페이스를 구현하고 있기에 특정 Activity/Fragment를 직접 자료형으로 참조하고 있지 않음 - 약한결합

    var model:ItemModel?=null // model 역할을 수행하는 클래스 참조변수

    // presenter가 연결한 두개의 참조변수를 생성 및 전달 받는 메소드 정의
    fun initial(view:MainContract.View){
        this.view=view
        model= ItemModel(view.getContext())
    }

    // view의 save 버튼클릭 이벤트를 대신 처리해주는 기능 메소드
    override fun clickSave(name: String, email: String) {
        model?.saveData(name, email) // model에게 저장 요청
    }

    override fun clickLoad() {
        // model에게 data를 요청
        var item: Item? =model?.loadData()

        // view에게 데이터 출력을 요청
        item?.let {
            view?.showData(it)
        }
    }

}