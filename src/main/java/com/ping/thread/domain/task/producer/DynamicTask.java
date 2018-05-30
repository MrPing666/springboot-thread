package com.ping.thread.domain.task.producer;

import com.ping.thread.entity.enums.TaskType;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public class DynamicTask extends BaseTask{

	private TaskType taskType;

	public DynamicTask(Long userNo) {
		super(userNo);
		taskType = TaskType.dynamic;
	}

	@Override
	public Long getSingleScore() {
		// TODO Auto-generated method stub
		return Long.parseLong(taskType.getSingleScore());
	}

	@Override
	public Long getMaxScore() {
		// TODO Auto-generated method stub
		return Long.parseLong(taskType.getMaxScore());
	}

	@Override
	public TaskType getTaskType()
	{
		return this.taskType;
	}
}
