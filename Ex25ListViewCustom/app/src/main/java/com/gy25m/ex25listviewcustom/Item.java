package com.gy25m.ex25listviewcustom;

public class Item {
    String name;     //전현무
    String nation;  //대한민국
    int imgId;     //R.drawble.korea 태극기

    //객체를 생성할때 자동으로 실행되는 특별한 메소드-Constructor
    public Item(String name,String nation,int imgId){
        this.name=name;
        this.nation=nation;
        this.imgId=imgId;
    }
}
