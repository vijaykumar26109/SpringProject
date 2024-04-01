package com.taashee.SpringAssessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taashee.SpringAssessment.entity.Course;
import com.taashee.SpringAssessment.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/addcourseform")
	public String getCourseForm(ModelMap modelMap) {
		return "addCourse";
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	@PostMapping("/addcourse")
	public String addCourse(@RequestParam String course_name, @RequestParam String course_description,
			ModelMap modelmap) {
		courseService.save(new Course(course_name, course_description));
		modelmap.addAttribute("message", "Course added successfully");
		return getCourseForm(modelmap);
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/courses")
	public String displayCourses(ModelMap modelMap) {
		List<Course> courses = courseService.findAll();
		modelMap.addAttribute("courses", courses);
		return "admin-course-display";
	}

}
