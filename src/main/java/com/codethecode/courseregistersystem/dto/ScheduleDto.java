package com.codethecode.courseregistersystem.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ScheduleDto {
    private ArrayList<String> busyDays;
    private String name;
    private Boolean isStudent;
}