package com.ping.thread.domain.task;

import com.ping.thread.entity.TaskType;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public class TaskData {

	private String day;
	private Long userNo;
	private Long singleScore;
	private Long maxScore;
	private TaskType taskType;
	
	public TaskData(String day, Long userNo, Long singleScore, Long maxScore, TaskType taskType) {
		this.day = day;
		this.userNo = userNo;
		this.singleScore = singleScore;
		this.maxScore = maxScore;
		this.taskType = taskType;
	}

	public String getDay() {
		return day;
	}

	public Long getUserNo() {
		return userNo;
	}

	public Long getSingleScore() {
		return singleScore;
	}

	public Long getMaxScore() {
		return maxScore;
	}

	public TaskType getTaskType() {
		return taskType;
	}
	
	
}
