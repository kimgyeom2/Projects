package com.gy25m.ex90firebasechatting;

public class MessageItem {
    //Firebase에서 사용하려면 반드시 public이어야함
    public String name;
    public String message;
    public String profileUrl;
    public String time;

    public MessageItem() {
    }

    public MessageItem(String name, String message, String profileUrl, String time) {
        this.name = name;
        this.message = message;
        this.profileUrl = profileUrl;
        this.time = time;
    }
}
