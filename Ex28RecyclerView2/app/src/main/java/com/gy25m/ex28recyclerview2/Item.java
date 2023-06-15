package com.gy25m.ex28recyclerview2;

public class Item {
    String name;       //"루피"
    String role;       //"선장"
    int profileImgId;  //R.drawble.crew_luffy
    int ImgId;          //R.drawble.bg_one01

    public Item(String name, String role, int profileImgId, int imgId) {
        this.name = name;
        this.role = role;
        this.profileImgId = profileImgId;
        ImgId = imgId;
    }
}
