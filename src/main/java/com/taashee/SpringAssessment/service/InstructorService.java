package com.taashee.SpringAssessment.service;

import java.util.List;

import com.taashee.SpringAssessment.entity.Instructor;

public interface InstructorService {
	Instructor findByInstructorName(String usernmae);
	List<Instructor> findAll();
	Instructor findById(int instructorId);
	Instructor save(Instructor instructor);
}
