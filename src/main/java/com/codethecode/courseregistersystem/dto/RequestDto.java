package com.codethecode.courseregistersystem.dto;

import com.codethecode.courseregistersystem.entity.Course;
import com.codethecode.courseregistersystem.entity.Student;
import com.codethecode.courseregistersystem.entity.Teacher;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RequestDto {
    // Which student requests which course from which teacher.
    private Student student;
    private Course course;
    private Teacher teacher;
}
