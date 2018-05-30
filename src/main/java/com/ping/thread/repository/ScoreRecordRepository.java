package com.ping.thread.repository;

import com.ping.thread.entity.ScoreChangeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Repository
public interface ScoreRecordRepository extends JpaRepository<ScoreChangeRecord,Long> {

    /**
     * 入库
     * @param scoreChangeRecord
     * @return
     */
    @Override
    ScoreChangeRecord save(ScoreChangeRecord scoreChangeRecord);
}
