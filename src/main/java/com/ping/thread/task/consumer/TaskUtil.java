package com.ping.thread.task.consumer;

import com.ping.thread.task.producer.base.BaseTask;
import com.ping.thread.task.producer.base.Task;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Slf4j
public class TaskUtil {

	private static ExecutorService executorService = Executors.newFixedThreadPool(20);
	
	static {
		initConsumerThread();
	}

	public static void submitTask(Task task) {
		executorService.submit(task);
	}
	
	private static void initConsumerThread() {
		log.info("初始化积分任务消费者线程");
		TaskConsumer con1 = new TaskConsumer("consumer_1", BaseTask.getQueue());
		TaskConsumer con2 = new TaskConsumer("consumer_2", BaseTask.getQueue());
		TaskConsumer con3 = new TaskConsumer("consumer_3", BaseTask.getQueue());
		executorService.execute(con1);
		executorService.execute(con2);
		executorService.execute(con3);
	}

}
