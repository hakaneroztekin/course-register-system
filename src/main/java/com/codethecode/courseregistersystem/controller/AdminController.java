package com.codethecode.courseregistersystem.controller;

import com.codethecode.courseregistersystem.dto.CourseDto;
import com.codethecode.courseregistersystem.dto.RequestDto;
import com.codethecode.courseregistersystem.dto.StudentDto;
import com.codethecode.courseregistersystem.dto.TeacherDto;
import com.codethecode.courseregistersystem.entity.Course;
import com.codethecode.courseregistersystem.entity.Teacher;
import com.codethecode.courseregistersystem.repository.CourseRepository;
import com.codethecode.courseregistersystem.repository.StudentRepository;
import com.codethecode.courseregistersystem.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.codethecode.courseregistersystem.entity.Student;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/checkAccess")
    public ResponseEntity checkAccess() {
        System.out.println("checkAccess is invoked"); // print to the console
        return new ResponseEntity<>("Access is successful.", HttpStatus.OK);
    }

    @PostMapping(value = "/teacher/add")
    public ResponseEntity addTeacher(@RequestBody TeacherDto teacherDto) {
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

    @GetMapping(value = "/teacher/list")
    public ResponseEntity getTeachers() {
        Iterable<Teacher> teacherDaoList = teacherRepository.findAll();
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        for(Teacher teacher : teacherDaoList){
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setId(teacher.getId());
            teacherDto.setBalance(teacher.getBalance());
            teacherDto.setBranch(teacher.getBranch());
            teacherDto.setCost(teacher.getCost());
            teacherDto.setGender(teacher.getGender());
            teacherDto.setName(teacher.getName());
            teacherDto.setSurname(teacher.getSurname());
            teacherDtoList.add(teacherDto);
        }

        return new ResponseEntity<>((ArrayList) teacherDtoList, HttpStatus.ACCEPTED);
    }


    @PostMapping(value = "/teacher/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        teacherRepository.deleteById(teacher.get().getId());

        return new ResponseEntity<String>("Teacher with id " + teacher.get().getId()
                + " deleted", HttpStatus.ACCEPTED);
    }


    @PostMapping(value = "/student/add")
    public ResponseEntity addStudent(@RequestBody StudentDto studentDto) {
        Student newStudent = new Student();
        newStudent.setName(studentDto.getName());
        newStudent.setSurname(studentDto.getSurname());
        newStudent.setGender(studentDto.getGender());
        newStudent.setGrade(studentDto.getGrade());
        newStudent.setDebt(studentDto.getDebt());

        studentRepository.save(newStudent);

        return new ResponseEntity<>("New Student added", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/student/list")
    public ResponseEntity getStudents() {
        Iterable<Student> studentDaoList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student student : studentDaoList){
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setName(student.getName());
            studentDto.setSurname(student.getSurname());
            studentDto.setDebt(student.getDebt());
            studentDto.setGrade(student.getGrade());
            studentDto.setGender(student.getGender());
            studentDtoList.add(studentDto);
        }

        return new ResponseEntity<>((ArrayList) studentDtoList, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/student/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.deleteById(student.get().getId());

        return new ResponseEntity<String>("Student with id " + student.get().getId()
                + " deleted", HttpStatus.ACCEPTED);
    }

    /* Commented Out For Fix
    // add specified course for specified student with their ID's.
    @PostMapping(value = "/student/addCourseToStudent/{studentId}/{courseId}") // take ID's as path variables
    public ResponseEntity addCourseToStudent(@PathVariable Long studentId, Long courseId) { // append ID's to the variables
        Optional<Student> student = studentRepository.findById(studentId); // find the student with specified ID
        Optional<Course> course = courseRepository.findById(courseId); // find the course with specified ID
        student.get().getCourses().add(course.get()); // add the course to the student
        // get() is used only because the type had to be Optional in repository search
        // so to cover up the case if there are more than one student, we use list, i.e. Optional.

        studentRepository.save(student.get()); // update the student in the database

        return new ResponseEntity<>("Course " + course.get().getName() + "is added " +
                                    "to the student " + student.get().getName() , HttpStatus.ACCEPTED);
    }
    */

    @PostMapping(value = "/course/add")
    public ResponseEntity addCourse(@RequestBody CourseDto courseDto) {
        Course newCourse = new Course();
        newCourse.setName(courseDto.getName());
        newCourse.setBranch(courseDto.getBranch());
        newCourse.setCost(courseDto.getCost());
        newCourse.setDay(courseDto.getDay());
//        newCourse.setStudentId();
//        newCourse.setTeacherId();

        courseRepository.save(newCourse);

        return new ResponseEntity<String>("New course added", HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/course/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);

        return new ResponseEntity<String>("Course deleted", HttpStatus.ACCEPTED);
    }
}
