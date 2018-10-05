package com.codethecode.courseregistersystem.repository;

import com.codethecode.courseregistersystem.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
