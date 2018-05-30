package com.ping.thread.entity.enums;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public enum  ChangeType {
    add("加"),
    subtract("减");

    private final String text;

    ChangeType(String text)
    {
        this.text=text;
    }
    public String getText() {
        return text;
    }
}
