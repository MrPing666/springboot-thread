package com.ping.thread.domain.task;

import com.ping.thread.domain.task.consumer.TaskConsumer;
import com.ping.thread.domain.task.producer.BaseTask;
import com.ping.thread.domain.task.producer.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public class TaskUtil {

	private static final Logger logger = LoggerFactory.getLogger(TaskUtil.class);

	private static ExecutorService executorService = Executors.newFixedThreadPool(20);
	
	static{
		initConsumerThread();
	}
	
	public static void submitTask(Task task) {
		executorService.submit(task);
	}
	
	private static void initConsumerThread() {
		logger.info("初始化积分任务消费者线程");
		TaskConsumer con1 = new TaskConsumer("task_consumer_1", BaseTask.getQueue());
		TaskConsumer con2 = new TaskConsumer("task_consumer_2", BaseTask.getQueue());
		TaskConsumer con3 = new TaskConsumer("task_consumer_3", BaseTask.getQueue());
		executorService.execute(con1);
		executorService.execute(con2);
		executorService.execute(con3);
	}

}
