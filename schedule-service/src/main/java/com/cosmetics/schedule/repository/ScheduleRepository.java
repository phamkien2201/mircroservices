package com.cosmetics.schedule.repository;

import com.cosmetics.schedule.entity.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {

}
