package com.codethecode.courseregistersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "branch")
    private String branch;

    @Column(name = "day")
    private String day;

    @Column(name = "cost")
    private Integer cost;

    @OneToMany(mappedBy = "course")
    private List<Request> request;
}

