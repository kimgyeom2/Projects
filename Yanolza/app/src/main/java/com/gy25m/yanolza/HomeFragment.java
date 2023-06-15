package com.gy25m.yanolza;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<Item> items=new ArrayList<>();
    RecycleAdapter adapter;
    RecyclerView recyclerView;
    ImageView iv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        items.add(new Item(R.drawable.ic_action_primium,"프리미엄블랙"));
        items.add(new Item(R.drawable.ic_action_motel,"모텔"));
        items.add(new Item(R.drawable.ic_action_hotel,"호텔•리조트"));
        items.add(new Item(R.drawable.ic_action_pan,"팬션•풀빌라"));
        items.add(new Item(R.drawable.ic_action_hombil,"홈&빌라"));
        items.add(new Item(R.drawable.ic_action_camp,"캠핑•글램핑"));
        items.add(new Item(R.drawable.ic_action_guest,"게하•한옥"));
        items.add(new Item(R.drawable.ic_action_gong,"공간대여"));
        items.add(new Item(R.drawable.ic_action_air,"국내항공"));
        items.add(new Item(R.drawable.ic_action_car,"렌터카"));
        items.add(new Item(R.drawable.ic_action_reger,"레저•티켓"));
        items.add(new Item(R.drawable.ic_action_food,"맛집"));
        items.add(new Item(R.drawable.ic_action_air2,"해외 항공"));
        items.add(new Item(R.drawable.ic_action_sook,"해외 숙소"));
        items.add(new Item(R.drawable.ic_action_shop,"해외 특가"));


        recyclerView=view.findViewById(R.id.recycler);
        adapter=new RecycleAdapter(getActivity(),items);
        recyclerView.setAdapter(adapter);

        iv=view.findViewById(R.id.iv);
        Glide.with(this).load(R.drawable.rain).into(iv);
    }
}
