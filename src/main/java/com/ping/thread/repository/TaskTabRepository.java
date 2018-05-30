package com.ping.thread.repository;

import com.ping.thread.entity.TaskTab;
import com.ping.thread.entity.enums.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Repository
public interface TaskTabRepository extends JpaRepository<TaskTab,Long> {

    /**
     * 入库
     * @param u
     * @return
     */
    @Override
    TaskTab save(TaskTab u);

    /**
     * 获取积分任务
     * @param userNo
     * @param dateStr
     * @param taskType
     * @return
     */
    @Query("select t from TaskTab t where t.userNo = :userNo and t.punchTime = :dateStr and t.taskType = :taskType")
    TaskTab getTaskTab(@Param("userNo") Long userNo, @Param("dateStr") String dateStr, @Param("taskType") TaskType taskType);

}
