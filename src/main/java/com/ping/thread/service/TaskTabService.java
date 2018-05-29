package com.ping.thread.service;

import com.ping.thread.domain.task.TaskData;
import com.ping.thread.domain.task.producer.Task;
import java.util.List;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public interface TaskTabService {

    void submitDayTask(Task task);

    void batchPutTaskTab(List<TaskData> list);

}
