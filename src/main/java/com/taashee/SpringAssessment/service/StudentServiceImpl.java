package com.taashee.SpringAssessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringAssessment.entity.Student;
import com.taashee.SpringAssessment.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student findByStudentName(String username) {
		return studentRepo.findByStudentName(username);
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student findById(int studentId) {
		return studentRepo.findById(studentId).get();
	}

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

}
