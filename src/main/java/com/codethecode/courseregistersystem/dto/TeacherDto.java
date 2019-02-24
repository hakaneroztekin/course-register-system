package com.codethecode.courseregistersystem.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Data
public class TeacherDto {
    private Long id;
    private String name;
    private String surname;
    private String gender;
//    private ArrayList<String> courses;
    private String branch;
    private Integer cost;
    private Integer balance;
}
