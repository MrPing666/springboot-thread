package com.ping.thread.domain.task.producer;

import com.ping.thread.domain.task.TaskData;
import com.ping.thread.entity.TaskType;
import com.ping.thread.utils.DateUtils;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public abstract class BaseTask extends Task{

    private static BlockingQueue<TaskData> queue = new LinkedBlockingQueue<TaskData>();

    private Long userNo;

    public BaseTask(Long userNo)
    {
        this.userNo = userNo;
    }

    public abstract Long getMaxScore();

    public abstract Long getSingleScore();

    public TaskType getTaskType()
    {
        return null;
    }

    public Long getUserNo()
    {
        return this.userNo;
    }

    public static BlockingQueue getQueue()
    {
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
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
