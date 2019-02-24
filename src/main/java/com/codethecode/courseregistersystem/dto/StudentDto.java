package com.codethecode.courseregistersystem.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String surname;
    private String gender;
    private Long debt;
//    private int days;
//    private ArrayList<String> courses;
    private int grade;
}