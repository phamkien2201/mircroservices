package com.cosmetics.schedule.mapper;


import com.cosmetics.schedule.dto.request.ScheduleRequest;
import com.cosmetics.schedule.dto.response.ScheduleResponse;
import com.cosmetics.schedule.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    Schedule toSchedule(ScheduleRequest request);

    ScheduleResponse toScheduleResponse(Schedule schedule);

    void updateSchedule(@MappingTarget Schedule schedule, ScheduleRequest request);
}
