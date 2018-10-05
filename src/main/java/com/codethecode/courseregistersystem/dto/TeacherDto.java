package com.codethecode.courseregistersystem.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class TeacherDto {
    private String name;
    private String surname;
    private String gender;
    private String branch;
    private Long cost;
    private Long balance;
}
