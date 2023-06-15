package com.gy25m.pr0613

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gy25m.pr0613.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding:ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.vm=MyViewModel()
        binding.lifecycleOwner=this
        supportFragmentManager.beginTransaction().add(R.id.container,MyFragment()).commit()
    }
}