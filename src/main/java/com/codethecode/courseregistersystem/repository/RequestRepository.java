package com.codethecode.courseregistersystem.repository;

import com.codethecode.courseregistersystem.entity.Request;
import com.codethecode.courseregistersystem.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
    Optional<Request> findById(Long id);
    Optional<Request> findByTeacherId(Long teacherId);
	Iterable<Request> findAllByTeacherId(Long teacherId);
}