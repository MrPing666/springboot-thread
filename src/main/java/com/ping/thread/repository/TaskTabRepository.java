package com.ping.thread.repository;

import com.ping.thread.entity.TaskTab;
import com.ping.thread.entity.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr.Ping on 2018/5/29.
 * @author Mr.Ping
 * @version 1.0
 */
@Repository
public interface TaskTabRepository extends JpaRepository<TaskTab,Long> {

    @Override
    TaskTab save(TaskTab u);

    @Query("select t from TaskTab t where t.name = :name")
    TaskTab getTaskTab(Long userNo, String dateStr, TaskType taskType, Long uppTask);

}
