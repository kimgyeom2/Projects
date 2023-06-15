package com.gy25m.ex91kotlinhello

open class Person constructor(var name:String, var age:Int){
    init {
        println("create Person instance")
    }

    open fun show(){
        println("name : $name age: $age")
    }
}