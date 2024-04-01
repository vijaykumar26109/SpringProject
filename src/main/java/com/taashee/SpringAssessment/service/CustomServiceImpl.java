package com.taashee.SpringAssessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringAssessment.entity.Instructor;
import com.taashee.SpringAssessment.entity.Student;
import com.taashee.SpringAssessment.repository.CustomRepository;

@Service
public class CustomServiceImpl implements CustomService {

	@Autowired
	private CustomRepository customRepo;

	@Override
	public List<Instructor> getAllInstructorsByStudentId(int studentId) {
		return customRepo.getAllInstructorsByStudentId(studentId);
	}

	@Override
	public List<Student> getStudentsByCourseAndInstructor(int courseId, int instructorId) {
		return customRepo.getStudentsByCourseAndInstructor(courseId, instructorId);
	}

}
