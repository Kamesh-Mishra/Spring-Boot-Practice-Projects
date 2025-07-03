package com.scheduling.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scheduling.demo.entity.ScheduleConfig;

@Repository
public interface ScheduleConfigRepository extends JpaRepository<ScheduleConfig, Long> {

	Optional<ScheduleConfig> findByTaskName(String taskName);
	
}
