package com.studytracker.schedule.repository;

import com.studytracker.schedule.entity.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {

}
