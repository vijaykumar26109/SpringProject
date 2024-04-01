package com.taashee.SpringAssessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taashee.SpringAssessment.entity.Instructor;
import com.taashee.SpringAssessment.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepo;

	@Override
	public Instructor findByInstructorName(String usernmae) {
		return instructorRepo.findByInstructorName(usernmae);
	}

	@Override
	public List<Instructor> findAll() {
		return instructorRepo.findAll();
	}

	@Override
	public Instructor findById(int instructorId) {
		return instructorRepo.findById(instructorId).get();
	}

	@Override
	public Instructor save(Instructor instructor) {
		// TODO Auto-generated method stub
		return instructorRepo.save(instructor);
	}

}
