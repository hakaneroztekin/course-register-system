package com.codethecode.courseregistersystem.repository;

import org.springframework.data.repository.CrudRepository;
import com.codethecode.courseregistersystem.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Optional<Teacher> findById(Long id);
}