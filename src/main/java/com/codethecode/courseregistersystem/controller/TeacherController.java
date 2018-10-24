package com.codethecode.courseregistersystem.controller;

import com.codethecode.courseregistersystem.dto.ScheduleDto;
import com.codethecode.courseregistersystem.entity.Student;
import com.codethecode.courseregistersystem.entity.Teacher;
import com.codethecode.courseregistersystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(value="/teacher")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping(value = "/getSelfSchedule/{id}")
    public ResponseEntity getSelfSchedule(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        ScheduleDto teacherSchedule = new ScheduleDto();
        teacherSchedule.setName(teacher.get().getName());
        teacherSchedule.setSurname(teacher.get().getSurname());
        teacherSchedule.setBusyDays(teacher.get().getBusyDays());
        teacherSchedule.setIsStudent(false);

        return new ResponseEntity<>(teacherSchedule, HttpStatus.ACCEPTED);
    }
}
