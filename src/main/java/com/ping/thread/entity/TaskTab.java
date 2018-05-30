package com.ping.thread.entity;

import com.ping.thread.entity.enums.ChangeType;
import com.ping.thread.entity.enums.ScoreState;
import com.ping.thread.entity.enums.ScoreType;
import com.ping.thread.entity.enums.TaskType;
import com.ping.thread.repository.ScoreRecordRepository;
import com.ping.thread.utils.Registry;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Entity
@Table(name = "boot_task")
public class TaskTab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**创建时间**/
    private Date crateTime = new Date();
    /**用户ID**/
    private Long userNo;
    /**类型**/
    private TaskType taskType;
    /**哪天？一天一条同类型积分任务记录（积分累加）**/
    private String punchTime;
    /**任务得分**/
    private Long taskSum;
    /**未入账得分(job)**/
    private Long notGetTaskSum;
    /**任务得分上限**/
    private Long uppTask;
    /**到账类型**/
    private ScoreState getScoreType;

    public TaskTab() {}

    public TaskTab(Long userNo, TaskType taskType, String punchTime, Long uppTask) {
        this.userNo = userNo;
        this.taskType = taskType;
        this.punchTime = punchTime;
        this.uppTask = uppTask;
        this.taskSum = 0L;
        this.notGetTaskSum = 0L;
    }

    public boolean chooseTask(TaskType taskType, Long maxScore, Long singleScore){
        return addTaskSum(maxScore,singleScore,taskType);
    }

    public boolean addTaskSum(Long maxScore,Long singleScore,TaskType taskType){
        /**每天的任务得分有最大值**/
        if(this.taskSum < maxScore){
            Long sum = this.taskSum + singleScore;
            ScoreChangeRecord scoreChangeRecord;
            if(sum > maxScore){
                Long subScore = maxScore - this.taskSum;
                this.notGetTaskSum = this.notGetTaskSum + subScore;
                scoreChangeRecord = new ScoreChangeRecord(this.userNo,subScore, ScoreType.valueOf(taskType.toString()), ChangeType.add);
                this.taskSum = maxScore;
            }else{
                this.taskSum = sum;
                this.notGetTaskSum = this.notGetTaskSum + singleScore;
                scoreChangeRecord = new ScoreChangeRecord(this.userNo,singleScore, ScoreType.valueOf(taskType.toString()), ChangeType.add);
            }
            this.getScoreType = ScoreState.NoGet;
            Registry.queryBean(ScoreRecordRepository.class).save(scoreChangeRecord);
            return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public Long getUserNo() {
        return userNo;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public String getPunchTime() {
        return punchTime;
    }

    public Long getTaskSum() {
        return taskSum;
    }

    public Long getNotGetTaskSum() {
        return notGetTaskSum;
    }

    public Long getUppTask() {
        return uppTask;
    }

    public ScoreState getGetScoreType() {
        return getScoreType;
    }
}
