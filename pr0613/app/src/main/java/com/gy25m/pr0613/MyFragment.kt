package com.gy25m.pr0613

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gy25m.pr0613.databinding.FragmentMyBinding

class MyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding:FragmentMyBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_my,container,false)
       binding.fvm=FragmentViewModel()
        binding.lifecycleOwner=this
        return binding.root


    }
}