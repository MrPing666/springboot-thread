package com.ping.thread.domain.task.consumer;

import com.ping.thread.domain.task.TaskData;
import com.ping.thread.service.TaskTabService;
import com.ping.thread.utils.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public class TaskConsumer implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(TaskConsumer.class);

	private BlockingQueue<TaskData> queue;
	private Boolean isRunning;
	private String name;

	public TaskConsumer(String name, BlockingQueue queue) {
		this.name = name;
		this.queue = queue;
		this.isRunning = true;
	}
	
	@Override
	public void run() {

		List<TaskData> list = new ArrayList<TaskData>(30);
		logger.info("线程" + name + "启动");
		while(isRunning) {

			try {
				if(list.size() <= 30){
					TaskData data = queue.poll(15, TimeUnit.SECONDS);
					if(data == null) {
						//直接保存
						putData(list);
						data = queue.take();
					}
					list.add(data);
					continue;
				}
				putData(list);
			} catch(InterruptedException e){
				e.printStackTrace();
				logger.info("线程" + name + "结束");
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	private void putData(List<TaskData> list) {
		try {
			logger.info("多线程：" + name + "批量保存每日任务数据");
			if(list == null || list.size() <= 0) {
				return;
			}
			Registry.queryBean(TaskTabService.class).batchPutTaskTab(list);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("多线程：" + name + "批量保存每日任务数据异常，原因:" + e.getMessage());
		}
		list.clear();
	}
}
