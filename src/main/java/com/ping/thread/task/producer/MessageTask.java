package com.ping.thread.task.producer;

import com.ping.thread.entity.enums.TaskType;
import com.ping.thread.task.producer.base.BaseTask;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public class MessageTask extends BaseTask {

	private TaskType taskType;

	public MessageTask(Long userNo) {
		super(userNo);
		taskType = TaskType.message;
	}

	@Override
	public Long getSingleScore() {
		return Long.parseLong(taskType.getSingleScore());
	}

	@Override
	public Long getMaxScore() {
		return Long.parseLong(taskType.getMaxScore());
	}

	@Override
	public TaskType getTaskType() {
		return this.taskType;
	}

}
