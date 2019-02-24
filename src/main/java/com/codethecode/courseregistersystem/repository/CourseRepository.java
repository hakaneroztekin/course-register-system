package com.codethecode.courseregistersystem.repository;

import com.codethecode.courseregistersystem.entity.Course;
import com.codethecode.courseregistersystem.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findById(Long id);
}