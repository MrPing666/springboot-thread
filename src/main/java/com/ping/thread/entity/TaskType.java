package com.ping.thread.entity;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
public enum TaskType {

    dynamic("3", "9"),
    gift("0", "20"),
    message("3", "9"),
    reward("5", "10");

    private final String singleScore;
    private final String maxScore;

    TaskType(String singleScore, String maxScore) {
        this.singleScore = singleScore;
        this.maxScore = maxScore;
    }

	public String getSingleScore() {
		return singleScore;
	}

	public String getMaxScore() {
		return maxScore;
	}
}
