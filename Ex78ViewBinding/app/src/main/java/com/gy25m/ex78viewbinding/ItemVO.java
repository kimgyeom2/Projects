package com.gy25m.ex78viewbinding;

public class ItemVO {  //VO  - value용으로 만들었다 라는 뜻

    String title;  //제목 글씨
    int imgResId;  //이미지의 리소스 아이디

    public ItemVO() {
    }

    public ItemVO(String title, int imgResId) {
        this.title = title;
        this.imgResId = imgResId;
    }
}
