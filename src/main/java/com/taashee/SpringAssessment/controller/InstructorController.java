package com.taashee.SpringAssessment.controller;

import java.security.Principal;
import java.util.ArrayList;
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

import com.taashee.SpringAssessment.entity.Course;
import com.taashee.SpringAssessment.entity.Instructor;
import com.taashee.SpringAssessment.entity.Student;
import com.taashee.SpringAssessment.entity.User;
import com.taashee.SpringAssessment.repository.CourseRepository;
import com.taashee.SpringAssessment.repository.CustomRepository;
import com.taashee.SpringAssessment.repository.InstructorRepository;
import com.taashee.SpringAssessment.repository.StudentRepository;
import com.taashee.SpringAssessment.service.UserService;

@Controller
public class InstructorController {

	@Autowired
	private InstructorRepository instructorService;
	@Autowired
	private CourseRepository courseService;
	@Autowired
	private CustomRepository customService;
	@Autowired
	private StudentRepository studentService;
	@Autowired
	private UserService userService;

	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/addinstructorform")
	public String getInstructorForm(ModelMap modelMap) {
		return "addInstructor";
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	@PostMapping("/addinstructor")
	public String saveInstructor(@RequestParam String instructor_name, @RequestParam String instructor_email,
			@RequestParam String instructor_contact, @RequestParam String instructor_experience, ModelMap modelmap) {
		instructorService
				.save(new Instructor(instructor_name, instructor_email, instructor_contact, instructor_experience));
		userService.save(new User(instructor_name, "$2a$10$Nxzzct89YM63qYijowqnXerao2yVmLFbDFnahPh0UQj11BpzSZ4PO",
				"INSTRUCTOR"));
		modelmap.addAttribute("message", "Instructor added successfully");
		return getInstructorForm(modelmap);
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/instructors")
	public String displayInstructors(ModelMap modelMap) {
		List<Instructor> instructors = instructorService.findAll();
		modelMap.addAttribute("instructors", instructors);
		return "admin-instructor-display";
	}

	@PreAuthorize(value = "hasRole('INSTRUCTOR')")
	@GetMapping("/instructor")
	public String getInstructors(ModelMap modelMap, Principal principal) {
		String username = principal.getName();
		Instructor instructor = instructorService.findByInstructorName(username);
		List<Course> courses = new ArrayList<>(instructor.getCourse());
		Set<Student> students = new HashSet<>();
		Set<Integer> studentId = new HashSet<>();
		for (Course course : courses) {
			List<Student> student = customService.getStudentsByCourseAndInstructor(course.getCourse_id(),
					instructor.getInstructor_id());
			for (Student st : student) {
				if (!studentId.contains(st.getStudent_id())) {
					students.add(st);
					studentId.add(st.getStudent_id());
				}
			}
		}
		List<Student> all_students = studentService.findAll();
		modelMap.addAttribute("courses", courses);
		modelMap.addAttribute("instructor", instructor);
		modelMap.addAttribute("students", students);
		modelMap.addAttribute("allstudents", all_students);
		return "instructor-display";
	}

	@PreAuthorize(value = "hasRole('INSTRUCTOR')")
	@PostMapping("/assigncoursetostudent")
	public String assignCourseToStudent(@RequestParam int studentId, @RequestParam int courseId, ModelMap modelMap,
			Principal principal) {
		Student student = studentService.findById(studentId).get();
		Course course = courseService.findById(courseId).get();
		if (student.getCourses().contains(course)) {
			modelMap.addAttribute("message", "Already Course Assigned");
			return getInstructors(modelMap, principal);
		}
		student.getCourses().add(course);
		studentService.save(student);
		modelMap.addAttribute("message", "Assigned Course Successfully");
		return getInstructors(modelMap, principal);
	}

}
