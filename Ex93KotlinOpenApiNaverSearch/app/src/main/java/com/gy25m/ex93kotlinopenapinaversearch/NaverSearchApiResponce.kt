package com.gy25m.ex93kotlinopenapinaversearch

data class NaverSearchApiResponce (var total:Int,var display:Int,var items:MutableList<ShoppingItem>){ //Int자료형이 맞긴한데 String으로 쓰는게 안전함

}

// 아이템 1개의 클래스
data class ShoppingItem (   //@@@@@@@@@@@@@이렇게만 써도 xml에서하던 if ~면 텍스트가져와라 이런거 안써도됨
                            //레트로핏은 네트워크를 해주는애고 이걸 해주는건 JSON임
    var title:String,
    var link:String,
    var image:String,
    var lprice:String,  // 읽어온 Integer값이 빈값으로 오면 에러가 날 수 있기에 타입을 그냥 String
    var hprice:String,
    var mallName:String

    // 더 있지만 필요한것만
)