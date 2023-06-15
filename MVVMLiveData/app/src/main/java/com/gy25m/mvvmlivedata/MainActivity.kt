package com.gy25m.mvvmlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gy25m.mvvmlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding:ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        var vm=MyViewModel()
        binding.vm=vm
        binding.lifecycleOwner=this
    }
}