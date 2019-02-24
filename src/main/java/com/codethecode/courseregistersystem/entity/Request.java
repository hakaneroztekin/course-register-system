package com.codethecode.courseregistersystem.entity;

import com.codethecode.courseregistersystem.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private RequestStatus requestStatus;

}

