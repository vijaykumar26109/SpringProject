package com.taashee.SpringAssessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taashee.SpringAssessment.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
