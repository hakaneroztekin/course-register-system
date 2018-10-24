package com.codethecode.courseregistersystem.dto;

import lombok.Data;

@Data
public class CourseDto {
    private String name;
    private String branch;
    private String day;
    private String teacherId;
    private String studentId;
    private Long cost;
}