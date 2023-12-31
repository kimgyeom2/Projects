package com.gy25m.ex32fragmentpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    //프래그먼트 참조변수 3개짜리 배열객체
    Fragment[] fragments=new Fragment[3];
    public MyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragments[0]=new Tab1Fragment();
        fragments[1]=new Tab2Fragment();
        fragments[2]=new Tab3Fragment();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
