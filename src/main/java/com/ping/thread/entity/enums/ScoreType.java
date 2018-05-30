package com.ping.thread.entity.enums;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public enum ScoreType {

    dynamic("发布动态"),
    gift("送礼物"),
    message("发消息"),
    reward("发红包"),
    punchCard("连续登录"),
    vip("成为会员"),
    spread("邀请新人注册"),
    eachFans("关注30人"),
    eachOtherFans("互相关注20人"),
    barterReward("兑换抢广告红包机会"),
    barterCoupons("兑换礼品劵"),
    exchangeDiamond("钻石"),
    exchangeChat("聊天次数");


    private final String text;

    ScoreType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
