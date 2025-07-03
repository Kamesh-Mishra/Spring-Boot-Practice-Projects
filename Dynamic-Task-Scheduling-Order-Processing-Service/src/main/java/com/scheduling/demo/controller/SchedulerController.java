package com.scheduling.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheduling.demo.dto.CronUpdateRequest;
import com.scheduling.demo.repository.ScheduleConfigRepository;
import com.scheduling.demo.schedulers.DynamicSchedulerService;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private ScheduleConfigRepository scheduleConfigRepository;

    @Autowired
    private DynamicSchedulerService dynamicSchedulerService;


//    {
//        "taskName" : "processPendingOrders",
//        "cronExpression" : "*/5 * * * * *"
//    }
    
    @PostMapping("/update-cron")
    public ResponseEntity<String> updateCron(@RequestBody CronUpdateRequest request) {
        dynamicSchedulerService.updateCronExpression(request.getTaskName(), request.getCronExpression());
        return ResponseEntity.ok("Cron expression updated successfully!");
    }
}