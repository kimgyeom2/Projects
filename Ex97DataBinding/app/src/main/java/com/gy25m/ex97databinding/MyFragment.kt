package com.gy25m.ex97databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gy25m.ex97databinding.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_my, container, false)
        return binding.root
    }

    lateinit var binding: FragmentMyBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //xml 레이아웃에서사용할 데이터클래스 객체 생성 밒 설정
        binding.vm=MyDataViewModel()
    }

}