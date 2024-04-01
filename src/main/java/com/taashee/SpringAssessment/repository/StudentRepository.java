package com.taashee.SpringAssessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taashee.SpringAssessment.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("SELECT s FROM Student s WHERE s.student_name = :username")
	Student findByStudentName(@Param("username") String username);

}
