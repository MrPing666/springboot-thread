package com.ping.thread.task.producer.base;

import com.ping.thread.task.TaskData;
import com.ping.thread.entity.enums.TaskType;
import com.ping.thread.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Slf4j
public abstract class BaseTask extends Task {

    private static BlockingQueue<TaskData> queue = new LinkedBlockingQueue<>(100);

    private Long userNo;

    public abstract Long getMaxScore();

    public abstract Long getSingleScore();

    public abstract TaskType getTaskType();

    public BaseTask(Long userNo) {
        this.userNo = userNo;
    }

    public Long getUserNo() {
        return this.userNo;
    }

    public static BlockingQueue getQueue() {
        return queue;
    }

    @Override
    public void scoreAdd() {
        try {
            if(userNo == null) {
                return;
            }
            String day = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
            TaskData data = new TaskData(day, userNo, getSingleScore(), getMaxScore(), getTaskType());
            queue.put(data);
            log.info("{}积分任务入缓存---数量:{}", getTaskType(), queue.size());
        } catch (Exception e) {
            log.error("添加积分异常:{}", e.getMessage());
        }
    }
}
