package com.scheduling.demo.dto;

import lombok.Data;

@Data
public class CronUpdateRequest {

	private String taskName;
    private String cronExpression;
}
