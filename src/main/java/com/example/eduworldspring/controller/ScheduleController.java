package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.schedule.ScheduleCreateUpdateDto;
import com.example.eduworldspring.model.Schedule;
import com.example.eduworldspring.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Long id) {
        return scheduleService.getSchedule(id);
    }

    @PostMapping
    public Schedule addSchedule(@RequestBody ScheduleCreateUpdateDto scheduleCreateUpdateDto) {
        return scheduleService.createSchedule(scheduleCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public Boolean updateSchedule(@RequestBody ScheduleCreateUpdateDto scheduleCreateUpdateDto, @PathVariable Long id) {
        return scheduleService.updateSchedule(id, scheduleCreateUpdateDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteSchedule(@PathVariable Long id) {
        return scheduleService.deleteSchedule(id);
    }
}
