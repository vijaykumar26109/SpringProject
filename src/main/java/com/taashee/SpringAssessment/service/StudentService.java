package com.taashee.SpringAssessment.service;

import java.util.List;

import com.taashee.SpringAssessment.entity.Student;

public interface StudentService {
	Student findByStudentName(String username);
	List<Student> findAll();
	Student findById(int studentId);
	Student save(Student student);
	
}
