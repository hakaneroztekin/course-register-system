package com.codethecode.courseregistersystem.repository;

import com.codethecode.courseregistersystem.entity.Student;
import com.codethecode.courseregistersystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentId(Long id);
}