package com.codethecode.courseregistersystem.controller;

import com.codethecode.courseregistersystem.dto.StudentDto;
import com.codethecode.courseregistersystem.repository.StudentRepository;
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
    StudentRepository studentRepository;

    @PostMapping(value = "/student/add")
    public ResponseEntity addStudent(@RequestParam("studentDto") StudentDto){
        Student newStudent = new Student();
        newStudent.setName();
        newStudent.setSurname();
        newStudent.setGender();
        newStudent.setDays();
        newStudent.setCourses();
        newStudent.setGrade();

        studentRepository.save(newStudent);

        return new ResponseEntity<String>("New Student added", HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/student/delete")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.deleteById(student.get().getId());

        return new ResponseEntity<String>("Student with id " + student.get().getId()
                                + " deleted", HttpStatus.ACCEPTED);
    }

}
