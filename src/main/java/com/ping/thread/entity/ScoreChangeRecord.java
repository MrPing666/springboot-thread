package com.ping.thread.entity;

import com.ping.thread.entity.enums.ChangeType;
import com.ping.thread.entity.enums.ScoreType;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Entity
@Table(name = "boot_score_record")
public class ScoreChangeRecord{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**创建时间**/
    private Date crateTime = new Date();
    /**用户ID**/
    private Long userNo;
    /**积分变动数量**/
    private Long scoreChangeCount;
    /**类型**/
    private ScoreType scoreType;
    /**积分变化类型**/
    private ChangeType changeType;

    public ScoreChangeRecord() {}

    public ScoreChangeRecord(Long userNo, Long scoreChangeCount, ScoreType scoreType, ChangeType changeType) {
        this.userNo = userNo;
        this.scoreChangeCount = scoreChangeCount;
        this.scoreType = scoreType;
        this.changeType = changeType;
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

    public Long getScoreChangeCount() {
        return scoreChangeCount;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }

    public ChangeType getChangeType() {
        return changeType;
    }
}
