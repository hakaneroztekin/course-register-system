package com.codethecode.courseregistersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Email
    //@Column(name="email", unique = true)
    //private String email;

    //@NotNull
    //@Size(max = 128)
    //@Column(name="password")
    //private String password;


    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="gender")
    private String gender;

    @Column(name="busy_days")
    private ArrayList<String> busyDays;

    @Column(name="debt")
    private Long debt;

    @Column(name="courses")
    private ArrayList<Course> courses;

    @Column(name="grade") // which year
    private int grade;

    @OneToMany(mappedBy = "student")
    private List<Request> request;
}
