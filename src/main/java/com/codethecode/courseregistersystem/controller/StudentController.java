package com.codethecode.courseregistersystem.controller;

import com.codethecode.courseregistersystem.dto.TeacherDto;
import com.codethecode.courseregistersystem.entity.Teacher;
import com.codethecode.courseregistersystem.repository.StudentRepository;
import com.codethecode.courseregistersystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


}
