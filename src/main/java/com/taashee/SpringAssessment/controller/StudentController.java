package com.taashee.SpringAssessment.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taashee.SpringAssessment.entity.Instructor;
import com.taashee.SpringAssessment.entity.Student;
import com.taashee.SpringAssessment.entity.User;
import com.taashee.SpringAssessment.repository.CustomRepository;
import com.taashee.SpringAssessment.repository.StudentRepository;
import com.taashee.SpringAssessment.service.UserService;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentService;
	@Autowired
	private CustomRepository customService;
	@Autowired
	private UserService userService;

	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/addstudentform")
	public String getStudentForm(ModelMap modelMap) {
		return "addStudent";
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	@PostMapping("/addstudent")
	public String saveStudent(@RequestParam String student_name, @RequestParam String student_email,
			@RequestParam String student_phoneno, ModelMap modelmap) {
		studentService.save(new Student(student_name, student_email, student_phoneno));
		userService.save(
				new User(student_name, "$2a$10$Nxzzct89YM63qYijowqnXerao2yVmLFbDFnahPh0UQj11BpzSZ4PO", "STUDENT"));
		modelmap.addAttribute("message", "student added successfully");
		return getStudentForm(modelmap);
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/students")
	public String displayStudents(ModelMap modelMap) {
		List<Student> students = studentService.findAll();
		modelMap.addAttribute("students", students);
		return "admin-student-display";
	}

	@PreAuthorize(value = "hasRole('STUDENT')")
	@GetMapping("/student")
	public String getStudents(Principal principal, ModelMap modelmap) {
		String username = principal.getName();
		Student student = studentService.findByStudentName(username);
		List<Instructor> instructors = customService.getAllInstructorsByStudentId(student.getStudent_id());
		Set<Instructor> instructors_set = new HashSet<>();
		for (Instructor inst : instructors) {
			instructors_set.add(inst);
		}
		modelmap.put("instructors", instructors_set);
		modelmap.addAttribute("student", student);
		return "student-display";
	}

}
