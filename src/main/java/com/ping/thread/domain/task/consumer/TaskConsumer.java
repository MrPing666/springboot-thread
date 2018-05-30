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
		logger.info("消费线程" + name + "启动");
		while(isRunning) {
			try {
				if(list.size() <= 30){
					//取queue里排在首位的对象,若不能立即取出,则可以等15s,取不到时返回null
					TaskData data = queue.poll(15, TimeUnit.SECONDS);
					if(data == null) {
						//直接保存
						putData(list);
						//取queue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到Blocking有新的对象被加入为止
						data = queue.take();
					}
					list.add(data);
					continue;
				}
				putData(list);
			} catch(InterruptedException e){
				e.printStackTrace();
				logger.info("消费线程" + name + "结束");
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	private void putData(List<TaskData> list) {
		try {
			if(list == null || list.size() <= 0) {
				return;
			}
			Registry.queryBean(TaskTabService.class).batchPutTaskTab(list);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("消费线程：" + name + "积分任务入库异常，原因:" + e.getMessage());
		}
		list.clear();
	}
}
