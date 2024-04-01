package com.taashee.SpringAssessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringAssessment.entity.Course;
import com.taashee.SpringAssessment.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Course> findAll() {
		return courseRepo.findAll();
	}

	@Override
	public Course findById(int courseId) {
		return courseRepo.findById(courseId).get();
	}

	@Override
	public Course save(Course course) {
		return courseRepo.save(course);
	}

}
