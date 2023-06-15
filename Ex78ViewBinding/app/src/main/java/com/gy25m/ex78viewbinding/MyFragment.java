package com.gy25m.ex78viewbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gy25m.ex78viewbinding.databinding.FragmentMyBinding;

public class MyFragment extends Fragment {

    //fragment_my.xml 파일과 연결되어 있는 바인딩 클래스 참조변수
    FragmentMyBinding binding;

    // 이 프래그먼트가 보여줄 뷰를 리턴해주는 기능메소드 재정의

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentMyBinding.inflate(inflater,container,false);
        return binding.getRoot(); //bind은 뷰가아님
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btn.setOnClickListener(v -> binding.tv.setText("Good day")); //한줄이면 괄호,; 생략가능
    }
}
