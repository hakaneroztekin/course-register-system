package com.codethecode.courseregistersystem.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class StudentDto {
    private String name;
    private String surname;
    private String gender;
    private int days;
    private String courses;
    private int grade;
}