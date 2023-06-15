package com.gy25m.ex97databinding

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

class User{
    // 값 변경이 관찰되는 멤버변수 ObservalbeXXXX : primitive type && List or Map && Reference type --> ObservableField<>
    var name:ObservableField<String> = ObservableField()
    var age:ObservableInt=ObservableInt(0) //초기값
    var fav:ObservableBoolean= ObservableBoolean()


    constructor(name:String,age:Int,fav:Boolean=true){ //디폴트값을 정해놓으면 전달을 안해도됨
        this.name.set(name)
        this.age.set(age)
        this.fav.set(fav)
    }

    // change name 버튼 callBack Method - 클릭 콜백메소드가 되려면 반드시 파라미터가 있어야함
    fun changeName(view:View){
        name.set("robin")
    }

    // age변수값을 1증가시키는 기능 콜백메소드
    fun increaseAge(view:View){
        age.set(age.get()+1)
    }

    // 좋아요 표시 true/false값 변경하기 - 콜백용 메소드가 아닌 일반 메소드
    // 이 메소드를 xml 버튼의 onclick 속성으로 지정한 익명 콜백함수에서 대신 호출
    fun toggleFav(){ //파라미터가 없음!!!
        fav.set( !fav.get() )
    }

    // check상태가 변경되는 것에 반응하는 콜백메소드 - 파라미터 중요
    fun changeFav(v:CompoundButton,ischecked:Boolean){
        Toast.makeText(v.context, ischecked.toString(), Toast.LENGTH_SHORT).show()
        //체크상태값을 관리하는 fav변수값도 변경해야됨 이걸안하면 거꾸로 했을때 값이안맞을수도 있음
        fav.set(ischecked)
    }

    //EditText의 글씨 변화값을 가지고 있을 관찰가능한 변수
    var message:ObservableField<String> = ObservableField()

    //EditText의 글씨 변화 이벤트에 반응하는 콜백메소드
    fun textChange(s:CharSequence?,start:Int,end:Int,count:Int){
        this.message.set(s.toString())
    }

    //EditText의 글씨를 입력하고 버튼을 눌러 텍스트뷰에 보여주기
    private var inputValue:String=""
    val value:ObservableField<String> = ObservableField(inputValue)

    //EditText의 글씨변경 이벤트 콜백메소드에 의해 호출될 일반 메소드
    fun changeInputValue(s:CharSequence){
        inputValue=s.toString()
    }

    //작성완료버튼 클릭에 반응하는 콜백메소드에의해 호출될 일반 메소드
    fun clcickBtn(){
        value.set(inputValue)
    }

}