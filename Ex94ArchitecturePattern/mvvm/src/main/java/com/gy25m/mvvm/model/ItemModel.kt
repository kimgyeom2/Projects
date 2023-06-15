package com.gy25m.mvvm.model

import android.content.Context

// 데이터를 제어하는 기능 2개를 가진 클래스
class ItemModel constructor(var context: Context) { // 데이터를 제어하기위해 context능력이
                                                    // 필요하다면 주생성자로 받기

    // 1. 데이터를 전달 받아서 sharedPreference에 데이터를 저장하는 기능
    fun saveData(name:String,email:String){
        var pref=context.getSharedPreferences("data",Context.MODE_PRIVATE)// 다른앱이라 이름똑같아도됨
        pref.edit().apply{
            putString("name",name)
            putString("email",email)
            commit()
        }
    }
    // 2. SharedPreference에서 데이터를 읽어와서 리턴하는 기능
    fun loadData(): Item{
        var pref=context.getSharedPreferences("data",Context.MODE_PRIVATE)
        var name=pref.getString("name","") as String
        var email=pref.getString("email","") as String
        return Item(name, email)
    }
}