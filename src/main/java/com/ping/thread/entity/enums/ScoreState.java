package com.ping.thread.entity.enums;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public enum ScoreState {
    Initialize("初始化状态"),
    NoGet("未到帐"),
    Get("已到账");

    private String text;
    public String getText() {
        return text;
    }

    ScoreState(String text) {
        this.text = text;
    }
}
