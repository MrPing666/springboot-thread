package com.ping.thread.entity;

import javax.persistence.*;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Entity
@Table(name = "boot_taskTab")
public class TaskTab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**用户ID**/
    private Long userNo;
    /**类型**/
    private TaskType taskType;
    /**打卡时间**/
    private String punchTime;
    /**任务得分**/
    private Long taskSum;
    /**未入账得分**/
    private Long notGetTaskSum;
    /**任务得分上限**/
    private Long uppTask;
    /**到账类型**/
    private GetScoreType getScoreType;

    public TaskTab() {}

    public long getId() {
        return id;
    }


}
