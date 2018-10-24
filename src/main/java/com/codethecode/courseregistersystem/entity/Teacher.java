package com.codethecode.courseregistersystem.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teacher")
public class Teacher{
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

    @Column(name="branch")
    private String branch;

    @Column(name="hourly_cost")
    private Long cost;

    @Column(name="balance")
    private Long balance;

}


