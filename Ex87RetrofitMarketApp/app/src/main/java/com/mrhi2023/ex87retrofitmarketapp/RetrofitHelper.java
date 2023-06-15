package com.mrhi2023.ex87retrofitmarketapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {
    public static Retrofit getRetrofitInstance(){
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://mrhi2023.dothome.co.kr");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        return retrofit;
    }
}
