package com.gy25m.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gy25m.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var arr= mutableListOf<Model>()
        arr.add(Model("kim",22))
        arr.add(Model("Lee",23))
        arr.add(Model("park",45))
        arr.add(Model("jung",24))
        arr.add(Model("kang",62))
        arr.add(Model("song",82))

        Log.i("zzz",arr.toString())
        binding.recycler.adapter=MyAdapter(this,arr)
    }
}