package com.codethecode.courseregistersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="gender")
    private String gender;

    @Column(name="busy_days")
    private ArrayList<String> busyDays;

    @Column(name="courses")
    private String courses;

    @Column(name="grade")//notları değil, kaçıncı sınıf olduğu.
    private int grade;  //hoca öğrencinin istediği dersin hangi sınıf dersi olduğu bu değerden anlayacak
}
