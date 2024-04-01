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
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String student_name;
	private String student_email;
	private String student_phoneno;

	@ManyToMany
	@JoinTable(name = "student_course_rel", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses = new HashSet<>();

	public Student(int student_id, String student_name, String student_email, String student_phoneno,
			Set<Course> courses) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_email = student_email;
		this.student_phoneno = student_phoneno;
		this.courses = courses;
	}

	public Student() {

	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_phoneno() {
		return student_phoneno;
	}

	public void setStudent_phoneno(String student_phoneno) {
		this.student_phoneno = student_phoneno;
	}

	public Student(String student_name, String student_email, String student_phoneno) {
		this.student_name = student_name;
		this.student_email = student_email;
		this.student_phoneno = student_phoneno;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_email="
				+ student_email + ", student_phoneno=" + student_phoneno + "]";
	}

}
