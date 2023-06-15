package com.gy25m.ex93kotlinopenapinaversearch


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {
//    @GET("/v1/search/shop.json?display=100")  //display=100은 고정, 붙이는 순서는 상관x
//    fun searchDataByString(@Header("X-Naver-Client-Id") clientId:String,@Header("X-Naver-Client-Secret")clientScret: String,@Query("query") query:String):Call<String>
    //스트링 주면 위에 쿼리로 들어간다

    // 헤더값이 고정적이라면 굳이 매번 파라미터로 받지 말고
    @Headers("X-Naver-Client-Id:_AkiZcjxuhYuLymZibhD","X-Naver-Client-Secret:Vru6zAgJjL")
    @GET("/v1/search/shop.json?display=100")
    fun searchData2(@Query("query") query: String):Call<NaverSearchApiResponce>
}