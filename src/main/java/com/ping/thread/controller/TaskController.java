package com.ping.thread.controller;

import com.ping.thread.domain.task.producer.DynamicTask;
import com.ping.thread.domain.task.producer.GiftTask;
import com.ping.thread.domain.task.producer.MessageTask;
import com.ping.thread.domain.task.producer.RewardTask;
import com.ping.thread.service.TaskTabService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @Resource
    private TaskTabService taskTabService;

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @RequestMapping("/pDynamic.html")
    public String publishDynamic(){
        try{
            taskTabService.submitDayTask(new DynamicTask(232323L));
            logger.info("发动态---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            logger.info("发动态---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }

    @RequestMapping("/giveGift.html")
    public String giveGift(){
        try{
            taskTabService.submitDayTask(new GiftTask(232323L, 5L));
            logger.info("送礼物---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            logger.info("送礼物---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }

    @RequestMapping("/sendMessage.html")
    public String sendMessage(){
        try{
            taskTabService.submitDayTask(new MessageTask(232323L));
            logger.info("发消息---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            logger.info("发消息---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }

    @RequestMapping("/giveReward.html")
    public String giveReward(){
        try{
            taskTabService.submitDayTask(new RewardTask(232323L));
            logger.info("发红包---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            logger.info("发红包---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }
}
