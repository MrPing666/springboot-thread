package com.ping.thread.task.producer.base;

import java.util.concurrent.Callable;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public abstract class Task implements Callable<Object>{

    /**
     * 积分增加
     */
    public abstract void scoreAdd();

    @Override
    public Object call() {
        scoreAdd();
        return null;
    }
}
