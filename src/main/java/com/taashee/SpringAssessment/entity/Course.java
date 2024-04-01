package com.taashee.SpringAssessment.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	private String course_name;
	private String course_description;

	public Course(int course_id, String course_name, String course_description, Set<Student> students,
			Set<Instructor> instructors) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_description = course_description;
		this.students = students;
		this.instructors = instructors;
	}

	public Course(String course_name, String course_description) {
		super();
		this.course_name = course_name;
		this.course_description = course_description;
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
	Set<Student> students = new HashSet<>();

	public Course() {

	}

	@JsonIgnore
	@ManyToMany(mappedBy = "course")
	Set<Instructor> instructors = new HashSet<>();

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_description="
				+ course_description + "]";
	}

	public Course(int course_id, String course_name, String course_description) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_description = course_description;
	}

}
