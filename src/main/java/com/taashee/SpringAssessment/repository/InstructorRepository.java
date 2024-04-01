package com.taashee.SpringAssessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taashee.SpringAssessment.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	@Query("SELECT i FROM Instructor i WHERE i.instructor_name = :username")
	Instructor findByInstructorName(@Param("username") String username);
}
