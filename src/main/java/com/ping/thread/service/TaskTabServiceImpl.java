package com.ping.thread.service;

import com.ping.thread.task.TaskData;
import com.ping.thread.task.producer.base.Task;
import com.ping.thread.entity.TaskTab;
import com.ping.thread.entity.enums.TaskType;
import com.ping.thread.repository.TaskTabRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Service
@Slf4j
public class TaskTabServiceImpl implements TaskTabService {

    @Resource
    private TaskTabRepository taskTabRepository;

    @Override
    public void submitDayTask(Task task) {
        TaskUtil.submitTask(task);
    }

    @Override
    public void batchPutTaskTab(List<TaskData> list) {

        log.info("消费线程---积分任务批量入库Start");
        if(list == null || list.size() <= 0){
            return;
        }
        for (TaskData taskData : list) {
            try {
                putTaskTab(taskData);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("消费线程---积分任务批量入库异常:{}", e.getMessage());
            }
        }
        log.info("消费线程---积分任务批量入库End");
    }

    /**
     * 每日积分任务
     * @param taskData
     */
    private void putTaskTab(TaskData taskData) {
        String day = taskData.getDay();
        TaskType taskType = taskData.getTaskType();

        TaskTab taskTab = taskTabRepository.getTaskTab(taskData.getUserNo(), day, taskType);
        if(taskTab == null){
            taskTab = new TaskTab(taskData.getUserNo(), taskType, day, taskData.getMaxScore());
        }
        boolean result = taskTab.chooseTask(taskType, taskData.getMaxScore(), taskData.getSingleScore());
        if(result){
            taskTabRepository.save(taskTab);
        }
    }
}
