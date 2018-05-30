package com.ping.thread.domain.task.producer;

import com.ping.thread.entity.enums.TaskType;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public class GiftTask extends BaseTask{

	private TaskType taskType;
	private Long count;

	public GiftTask(Long userNo, Long count) {
		super(userNo);
		taskType = TaskType.gift;
		this.count = count;
	}

	@Override
	public Long getSingleScore() {
		return count;
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
