package com.codethecode.courseregistersystem.controller;

import com.codethecode.courseregistersystem.dto.StudentDto;
import com.codethecode.courseregistersystem.dto.TeacherDto;
import com.codethecode.courseregistersystem.entity.Teacher;
import com.codethecode.courseregistersystem.repository.StudentRepository;
import com.codethecode.courseregistersystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.codethecode.courseregistersystem.entity.Student;

import java.util.Optional;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @PostMapping(value = "/teacher/add")
    public ResponseEntity addTeacher(@RequestParam("teacherDto") TeacherDto teacherDto) {
        Teacher newTeacher = new Teacher();
        newTeacher.setName(teacherDto.getName());
        newTeacher.setSurname(teacherDto.getSurname());
        newTeacher.setBranch(teacherDto.getBranch());
        newTeacher.setBalance(teacherDto.getBalance());
        newTeacher.setGender(teacherDto.getGender());
        newTeacher.setCost(teacherDto.getCost());

        teacherRepository.save(newTeacher);

        return new ResponseEntity<String>("New teacher added", HttpStatus.ACCEPTED);
    }


    @DeleteMapping(value = "/teacher/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        teacherRepository.deleteById(teacher.get().getId());

        return new ResponseEntity<String>("Teacher with id " + teacher.get().getId()
                + " deleted", HttpStatus.ACCEPTED);
    }


    @PostMapping(value = "/student/add")
    public ResponseEntity addStudent(@RequestParam("studentDto") StudentDto studentDto){
        Student newStudent = new Student();
        newStudent.setName(studentDto.getName());
        newStudent.setSurname(studentDto.getSurname());
        newStudent.setGender(studentDto.getGender());
        newStudent.setDays(studentDto.getDays());
        newStudent.setCourses(studentDto.getCourses());
        newStudent.setGrade(studentDto.getGrade());

        studentRepository.save(newStudent);

        return new ResponseEntity<String>("New Student added", HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/student/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.deleteById(student.get().getId());

        return new ResponseEntity<String>("Student with id " + student.get().getId()
                                + " deleted", HttpStatus.ACCEPTED);
    }

}
