package com.taashee.SpringAssessment.service;

import java.util.List;

import com.taashee.SpringAssessment.entity.Instructor;
import com.taashee.SpringAssessment.entity.Student;

public interface CustomService {
	List<Instructor> getAllInstructorsByStudentId(int studentId);
	List<Student> getStudentsByCourseAndInstructor(int courseId, int instructorId);
}
