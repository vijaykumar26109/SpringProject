package com.taashee.SpringAssessment.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taashee.SpringAssessment.entity.Course;
import com.taashee.SpringAssessment.entity.Instructor;
import com.taashee.SpringAssessment.service.CourseService;
import com.taashee.SpringAssessment.service.InstructorService;

@Controller
public class AdminController {

	@Autowired
	private InstructorService instructorService;
	@Autowired
	private CourseService courseService;

	@PreAuthorize(value = "hasRole('ADMIN')")
	@GetMapping("/header")
	public String getHeaderForm(Principal principal, ModelMap modelMap) {
		String username = principal.getName();
		modelMap.addAttribute("username", username);
		List<Course> courses = courseService.findAll();
		modelMap.addAttribute("courses", courses);
		List<Instructor> instructors = instructorService.findAll();
		modelMap.addAttribute("instructors", instructors);
		return "adminheader";
	}

	@PreAuthorize(value = "hasRole('ADMIN')")
	@PostMapping("/assigncourse")
	public String assignCourseToInstructor(@RequestParam int instructorId, @RequestParam int courseId,
			ModelMap modelMap, Principal principal) {
		Course course = courseService.findById(courseId);
		Instructor inst = instructorService.findById(instructorId);
		if (inst.getCourse().contains(course)) {
			modelMap.addAttribute("message", "Already Course Assigned");
			return getHeaderForm(principal, modelMap);
		}
		inst.getCourse().add(course);
		instructorService.save(inst);
		modelMap.addAttribute("message", "Assigned Course Successfully");
		return getHeaderForm(principal, modelMap);
	}

}
