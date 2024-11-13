package com.cosmetics.schedule.controller;

import com.cosmetics.schedule.dto.ApiResponse;
import com.cosmetics.schedule.dto.request.ScheduleRequest;
import com.cosmetics.schedule.dto.response.ScheduleResponse;
import com.cosmetics.schedule.entity.Schedule;
import com.cosmetics.schedule.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScheduleController {

    ScheduleService scheduleService;

    @PostMapping("/create-schedule")
    public ApiResponse<ScheduleResponse> createSchedules(
            @Valid @RequestBody ScheduleRequest request) {
        scheduleService.createSchedule(request);
        return ApiResponse.<ScheduleResponse>builder()
                .result(scheduleService.createSchedule(request))
                .build();
    }

    @GetMapping("/get-all-categories")
    @Operation(summary = "Lấy tất cả danh mục sản phâm")
    public ResponseEntity<List<Schedule>> getAllSchedules(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "limit", required = false ) Integer limit
    ) {
        if (page == null) {
            page = 0;
        }
        if (limit == null) {
            limit = 20;
        }
        List<Schedule> categories = scheduleService.getAllSchedules(page, limit);
        return ResponseEntity.ok(categories);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Cập nhat")
    ApiResponse<ScheduleResponse> updateSchedule(@PathVariable String id, @RequestBody ScheduleRequest request) {
        return ApiResponse.<ScheduleResponse>builder()
                .result(scheduleService.updateSchedule(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Xóa danh mục")
    public void deleteCategories(@PathVariable String id) {
        scheduleService.deleteSchedule(id);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Lấy danh muc bằng id")
    public ResponseEntity<ScheduleResponse> getScheduleById(@PathVariable("id") String id) {
        ScheduleResponse schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(schedule);
    }
}
