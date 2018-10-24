package com.codethecode.courseregistersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "branch")
    private String branch;

    @Column(name = "day")
    private String day;

    //@OneToOne vb relation olacak
    @Column(name = "teacherId")
    private String teacherId;

    //@OneToOne vb relation olacak
    @Column(name = "studentId")
    private String studentId;

    @Column(name = "cost")
    private Long cost;


}

