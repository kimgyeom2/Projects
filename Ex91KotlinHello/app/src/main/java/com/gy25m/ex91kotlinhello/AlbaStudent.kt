package com.gy25m.ex91kotlinhello

// 주생성자에 constructor 키워드 생략
class AlbaStudent(name:String,age:Int,major:String,var task:String):Student(name,age,major){
    init {
        println("create AlbaStudent instance")
    }

    override fun show() {
        //super.show()
        println("name: $name  age:  $age  major:  $major  task:  $task")
    }

}