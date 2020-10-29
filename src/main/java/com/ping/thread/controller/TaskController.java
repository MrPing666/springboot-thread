package com.ping.thread.controller;

import com.ping.thread.service.TaskTabService;

import com.ping.thread.task.producer.DynamicTask;
import com.ping.thread.task.producer.GiftTask;
import com.ping.thread.task.producer.MessageTask;
import com.ping.thread.task.producer.RewardTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;


/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/task")
@Slf4j
public class TaskController {

    @Resource
    private TaskTabService taskTabService;

    @RequestMapping("/dynamic.html")
    public String publishDynamic(){
        try{
            taskTabService.submitDayTask(new DynamicTask(232323L));
            log.info("发动态---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            log.info("发动态---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }

    @RequestMapping("/giveGift.html")
    public String giveGift(){
        try{
            taskTabService.submitDayTask(new GiftTask(232323L, 5L));
            log.info("送礼物---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            log.info("送礼物---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }

    @RequestMapping("/sendMessage.html")
    public String sendMessage(){
        try{
            taskTabService.submitDayTask(new MessageTask(232323L));
            log.info("发消息---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            log.info("发消息---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }

    @RequestMapping("/giveReward.html")
    public String giveReward(){
        try{
            taskTabService.submitDayTask(new RewardTask(232323L));
            log.info("发红包---积分任务提交成功！时间："+System.currentTimeMillis());
            return "success";
        }catch (Exception e){
            log.info("发红包---积分任务提交异常！时间："+System.currentTimeMillis());
            return "fail";
        }
    }
}
