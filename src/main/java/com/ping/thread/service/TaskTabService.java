package com.ping.thread.service;

import com.ping.thread.task.TaskData;
import com.ping.thread.task.producer.base.Task;
import java.util.List;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public interface TaskTabService {
    /**
     * 提交积分任务
     * @param task task
     */
    void submitDayTask(Task task);

    /**
     * 积分任务批量入库
     * @param list TaskData List
     */
    void batchPutTaskTab(List<TaskData> list);

}
