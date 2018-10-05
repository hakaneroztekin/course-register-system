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

    @Column(name = "branch")
    private String branch;

    @Column(name = "date")
    private String date;

    @Column(name = "beginningTime")
    private String beginningTime;

    @Column(name = "period") //dersin kaç saat süreceği
    private String period;

    @Column(name = "teacherName") //Dersi verecek hocanın adı
    private String teacherName;

    @Column(name = "teacherSurname")
    private String teacherSurname;

    @Column(name = "studentName") //Dersi alacak öğrencinin adı
    private String studentName;

    @Column(name = "studentSurname")
    private String studentSurname;

    @Column(name = "teacherID")// ID ler öğrenci ve öğretmenle dersin bağlantısını göstermek için.
    private String teacherID;  // Ad soyad da var ama, aynı isimde öğrenci ve öğretmenler olabilir diye ID de ekledim.

    @Column(name = "studentID")
    private String studentID;

}

