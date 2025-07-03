package com.scheduling.demo.schedulers;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import com.scheduling.demo.entity.ScheduleConfig;
import com.scheduling.demo.repository.ScheduleConfigRepository;

@Service
public class DynamicSchedulerService {

    @Autowired
    private ScheduleConfigRepository scheduleConfigRepository;
    
    @Autowired
    private OrderScheduler orderScheduler;
    
    private final ThreadPoolTaskScheduler taskScheduler = new  ThreadPoolTaskScheduler();
    
    private ScheduledFuture<?> scheduledTask;

    public DynamicSchedulerService() {
        taskScheduler.initialize();
    }

    public void updateCronExpression(String taskName, String newCron) {
        ScheduleConfig config = scheduleConfigRepository.findByTaskName(taskName)
                .orElse(new ScheduleConfig());
        config.setTaskName(taskName);
        config.setCronExpression(newCron);
        scheduleConfigRepository.save(config);

        restartScheduledTask(newCron);
    }

    private void restartScheduledTask(String cronExpression) {
        if (scheduledTask != null) {
            scheduledTask.cancel(false);
        }
        scheduledTask = taskScheduler.schedule(orderScheduler::processPendingOrders, new CronTrigger(cronExpression));
    }


}