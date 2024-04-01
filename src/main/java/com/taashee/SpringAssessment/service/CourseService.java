package com.taashee.SpringAssessment.service;

import java.util.List;

import com.taashee.SpringAssessment.entity.Course;

public interface CourseService {
	List<Course> findAll();
	Course findById(int courseId);
	Course save(Course course);
}
