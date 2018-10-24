package com.codethecode.courseregistersystem.controller;

import com.codethecode.courseregistersystem.dto.CourseDto;
import com.codethecode.courseregistersystem.dto.ScheduleDto;
import com.codethecode.courseregistersystem.dto.TeacherDto;
import com.codethecode.courseregistersystem.entity.Course;
import com.codethecode.courseregistersystem.entity.Student;
import com.codethecode.courseregistersystem.entity.Teacher;
import com.codethecode.courseregistersystem.repository.CourseRepository;
import com.codethecode.courseregistersystem.repository.StudentRepository;
import com.codethecode.courseregistersystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/getTeacherList")
    public ResponseEntity getTeacherList() {
        Iterable<Teacher> teacherDaoList = teacherRepository.findAll();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        for(Teacher teacher : teacherDaoList){
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setName(teacher.getName());
            teacherDto.setSurname(teacher.getSurname());
            teacherDto.setBranch(teacher.getBranch());
            teacherDto.setBalance(teacher.getBalance());
            teacherDto.setGender(teacher.getGender());
            teacherDto.setCost(teacher.getCost());
            teacherDtoList.add(teacherDto);
        }

        return new ResponseEntity<>((ArrayList) teacherDtoList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/getCourseList")
    public ResponseEntity getCourseList() {
        Iterable<Course> courseDaoList = courseRepository.findAll();
        List<CourseDto> courseDtoList = new ArrayList<>();
        for(Course course: courseDaoList){
            CourseDto courseDto = new CourseDto();
            courseDto.setName(course.getName());
            courseDto.setBranch(course.getBranch());
            courseDto.setCost(course.getCost());
            courseDto.setDay(course.getDay());
            courseDtoList.add(courseDto);
        }

        return new ResponseEntity<>((ArrayList) courseDtoList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/getSelfSchedule/{id}")
    public ResponseEntity getSelfSchedule(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        ScheduleDto studentSchedule = new ScheduleDto();
        studentSchedule.setName(student.get().getName());
        studentSchedule.setBusyDays(student.get().getBusyDays());
        studentSchedule.setIsStudent(true);

        return new ResponseEntity<>(studentSchedule, HttpStatus.ACCEPTED);
    }

}
