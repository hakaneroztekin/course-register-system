package com.codethecode.courseregistersystem.repository;

import org.springframework.data.repository.CrudRepository;
import com.codethecode.courseregistersystem.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findById(Long id);
}