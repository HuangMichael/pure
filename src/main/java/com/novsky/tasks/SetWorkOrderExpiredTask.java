package com.novsky.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 维修任务状态定时更新
 *
 * @author huangbin
 * @create 2016-09-05 14:08
 **/
@Component
public class SetWorkOrderExpiredTask {

    private static final Logger log = LoggerFactory.getLogger(SetWorkOrderExpiredTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Scheduled(cron = "0 0 0 * * *")
    public void updateFixTaskStatus() {

    }
}
