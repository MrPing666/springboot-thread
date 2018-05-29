package com.ping.thread.service;

import com.ping.thread.domain.task.TaskData;
import com.ping.thread.domain.task.TaskUtil;
import com.ping.thread.domain.task.producer.Task;
import com.ping.thread.entity.TaskTab;
import com.ping.thread.entity.TaskType;
import com.ping.thread.repository.TaskTabRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Service
public class TaskTabServiceImpl implements TaskTabService{

    @Resource
    private TaskTabRepository taskTabRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void submitDayTask(Task task) {
        TaskUtil.submitTask(task);
    }

    @Override
    public void batchPutTaskTab(List<TaskData> list) {

        logger.info("批量添加每日积分任务开始");
        if(list == null || list.size() <= 0){
            return;
        }

        for (TaskData taskData : list) {
            try {

                putTaskTab(taskData);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("积分任务异常，信息：" + e.getMessage());
            }

        }
        logger.info("批量添加每日积分任务结束");
    }


    /**
     * 每日积分任务
     * @param taskData
     */
    private void putTaskTab(TaskData taskData)
    {
        String day = taskData.getDay();
        TaskType taskType = taskData.getTaskType();

        TaskTab taskTab = taskTabRepository.getTaskTab(taskData.getUserNo(), day, taskType, taskData.getMaxScore());

        if(taskTab != null){
            boolean result = taskTab.chooseTask(taskType, taskData.getMaxScore(), taskData.getSingleScore());
            if(result){
                taskTabRepository.save(taskTab);
            }
        }
    }
}