package com.codethecode.courseregistersystem.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ScheduleDto {
    private String name;
    private String surname;
    private Boolean isStudent;
    private ArrayList<String> busyDays;
}