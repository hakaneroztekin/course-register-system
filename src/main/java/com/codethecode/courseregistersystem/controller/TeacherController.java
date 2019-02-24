package com.codethecode.courseregistersystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.codethecode.courseregistersystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codethecode.courseregistersystem.RequestStatus;
import com.codethecode.courseregistersystem.dto.ScheduleDto;
import com.codethecode.courseregistersystem.entity.Course;
import com.codethecode.courseregistersystem.entity.Request;
import com.codethecode.courseregistersystem.entity.Teacher;
import com.codethecode.courseregistersystem.repository.CourseRepository;
import com.codethecode.courseregistersystem.repository.RequestRepository;
import com.codethecode.courseregistersystem.repository.StudentRepository;
import com.codethecode.courseregistersystem.repository.TeacherRepository;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	RequestRepository requestRepository;

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

	@GetMapping(value = "/getBalance/{id}")
	public ResponseEntity getBalance(@PathVariable Long id) {
		Optional<Teacher> teacher = teacherRepository.findById(id);
		return new ResponseEntity<>(
				"Balance for teacher " + teacher.get().getName() + "is " + teacher.get().getBalance(),
				HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/checkRequests/{id}")
	public ResponseEntity<ArrayList<String>> checkRequests(@PathVariable Long id) {
		// might be written as list of requests, instead of one request
		List<String> requestList = new ArrayList<>();
		Iterable<Request> it = requestRepository.findAllByTeacherId(id);
		// RequestDto requestDto = new RequestDto();
		// Optional<Course> requestedCourse =
		// courseRepository.findById(requestDto.getCourse().getId());
		// Optional<Student> requestingStudent =
		// studentRepository.findById(requestDto.getStudent().getId());
		// Optional<Teacher> requestedTeacher =
		// teacherRepository.findById(requestDto.getTeacher().getId());

		for (Request request : it) {
			request.setRequestStatus(RequestStatus.REVIEWED_BY_TEACHER);
			requestRepository.save(request);
			requestList.add("RequestId " + request.getId() + ": Request made by student"
					+ request.getStudent().getName() + " " + request.getStudent().getSurname() + " for course "
					+ request.getCourse().getName() + " for teacher " + request.getTeacher().getName());
		}

		return new ResponseEntity<>((ArrayList<String>) requestList, HttpStatus.ACCEPTED);
	}

	@PostMapping(value = "/responseRequest/id={requestId}&response={response}")
	public ResponseEntity<String> responseRequest(@PathVariable Long requestId, Long response, Long id) {
		Optional<Request> request = requestRepository.findById(requestId);
		Optional<Teacher> requestedTeacher = teacherRepository.findById(request.get().getTeacher().getId());
		Optional<Course> requestedCourse = courseRepository.findById(request.get().getCourse().getId());
		Student requesterStudent = request.get().getStudent();
		String responseMessage = "";
		responseMessage = "illegal response";
		if (id != request.get().getTeacher().getId())
			return new ResponseEntity<>(" " + responseMessage, HttpStatus.ACCEPTED);
		if (response.equals(1L)) { // Say, it's ACCEPT of the request

			request.get().setRequestStatus(RequestStatus.ACCEPTED);


			ArrayList<String> busyDays = requestedTeacher.get().getBusyDays();
			ArrayList<String> studentBusyDays = requesterStudent.getBusyDays();
			if (busyDays == null)
				busyDays = new ArrayList<String>();
			if (studentBusyDays == null)
				studentBusyDays = new ArrayList<String>();

			busyDays.add(requestedCourse.get().getDay());
			studentBusyDays.add(requestedCourse.get().getDay());

			requestedTeacher.get().setBusyDays(busyDays);
			requesterStudent.setBusyDays(studentBusyDays);

			int teachersBalance = Math.toIntExact(requestedTeacher.get().getBalance());
			teachersBalance += requestedCourse.get().getCost();
			requestedTeacher.get().setBalance(teachersBalance);

			responseMessage = "Request is accepted";
		} else if (response.equals(0L)) { // DENIAL of the request
			request.get().setRequestStatus(RequestStatus.DENIED);
			responseMessage = "Request is denied";
		} else {
			responseMessage = "Incorrect input, response have to be 1 or 0.";
			return new ResponseEntity<>(" " + responseMessage, HttpStatus.BAD_REQUEST);
		}
		requestRepository.save(request.get());

//		requestRepository.deleteById(requestId);
		return new ResponseEntity<>(" " + responseMessage, HttpStatus.ACCEPTED);
	}
}
