package com.taashee.SpringAssessment.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.taashee.SpringAssessment.entity.Instructor;
import com.taashee.SpringAssessment.entity.Student;

@Repository
public class CustomRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String getAllInstructorsByStudentId = "SELECT DISTINCT i.* FROM student_course_rel sc \r\n"
			+ "JOIN instructor_course_rel icr ON sc.course_id = icr.course_id \r\n"
			+ "JOIN instructor i ON icr.instructor_id = i.instructor_id \r\n" + "WHERE sc.student_id = ?;";

	private static final String GET_STUDENTS_BY_COURSE_AND_INSTRUCTOR = "SELECT DISTINCT s.* "
			+ "FROM student_course_rel sc " + "JOIN student s ON sc.student_id = s.student_id "
			+ "JOIN instructor_course_rel icr ON sc.course_id = icr.course_id "
			+ "JOIN instructor i ON icr.instructor_id = i.instructor_id "
			+ "WHERE sc.course_id = ? AND i.instructor_id = ?";
	
	public List<Instructor> getAllInstructorsByStudentId(int studentId) {
		return jdbcTemplate.query(getAllInstructorsByStudentId, new Object[] { studentId }, new InstructorRowMapper());
	}

	private static class InstructorRowMapper implements RowMapper<Instructor> {
		@Override
		public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
			int instructor_id = rs.getInt("instructor_id");
			String instructor_name = rs.getString("instructor_name");
			String instructor_email = rs.getString("instructor_email");
			String instructor_contact = rs.getString("instructor_contact");
			String instructor_experience = rs.getString("instructor_experience");

			return new Instructor(instructor_id, instructor_name, instructor_email, instructor_contact,
					instructor_experience);
		}
	}

	public List<Student> getStudentsByCourseAndInstructor(int courseId, int instructorId) {
		return jdbcTemplate.query(GET_STUDENTS_BY_COURSE_AND_INSTRUCTOR, new Object[] { courseId, instructorId },
				new StudentRowMapper());
	}

	private static class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudent_id(rs.getInt("student_id"));
			student.setStudent_name(rs.getString("student_name"));
			student.setStudent_email(rs.getString("student_email"));
			student.setStudent_phoneno(rs.getString("student_phoneno"));
			return student;
		}
	}

}
