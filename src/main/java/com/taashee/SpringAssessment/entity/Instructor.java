package com.taashee.SpringAssessment.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructor_id;
	private String instructor_name;
	private String instructor_email;
	private String instructor_contact;
	private String instructor_experience;

	@ManyToMany
	@JoinTable(name = "instructor_course_rel", joinColumns = @JoinColumn(name = "instructor_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> course = new HashSet<>();

	public Instructor() {

	}

	public Instructor(int instructor_id, String instructor_name, String instructor_email, String instructor_contact,
			String instructor_experience) {
		this.instructor_id = instructor_id;
		this.instructor_name = instructor_name;
		this.instructor_email = instructor_email;
		this.instructor_contact = instructor_contact;
		this.instructor_experience = instructor_experience;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	public int getInstructor_id() {
		return instructor_id;
	}

	public void setInstructor_id(int instructor_id) {
		this.instructor_id = instructor_id;
	}

	public String getInstructor_name() {
		return instructor_name;
	}

	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}

	public String getInstructor_email() {
		return instructor_email;
	}

	public void setInstructor_email(String instructor_email) {
		this.instructor_email = instructor_email;
	}

	public String getInstructor_contact() {
		return instructor_contact;
	}

	public void setInstructor_contact(String instructor_contact) {
		this.instructor_contact = instructor_contact;
	}

	public String getInstructor_experience() {
		return instructor_experience;
	}

	public void setInstructor_experience(String instructor_experience) {
		this.instructor_experience = instructor_experience;
	}

	@Override
	public String toString() {
		return "Instructor [instructor_id=" + instructor_id + ", instructor_name=" + instructor_name
				+ ", instructor_email=" + instructor_email + ", instructor_contact=" + instructor_contact
				+ ", instructor_experience=" + instructor_experience + "]";
	}

	public Instructor(String instructor_name, String instructor_email, String instructor_contact,
			String instructor_experience) {
		this.instructor_name = instructor_name;
		this.instructor_email = instructor_email;
		this.instructor_contact = instructor_contact;
		this.instructor_experience = instructor_experience;
	}

}
