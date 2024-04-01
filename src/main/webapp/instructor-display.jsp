<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Instructor Dash board</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #fff;
}

.container {
	max-width: 1200px;
	margin: 20px auto;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.8);
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.dashboard-header {
	text-align: center;
	margin-bottom: 20px;
	background-color: transparent; 
	padding: 10px;
	border-radius: 5px;
	color: #333; 
}

.grid-container {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
	grid-gap: 20px;
}

.card {
	background-color: #fff;
	border-radius: 5px;
	padding: 20px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	transition: box-shadow 0.3s;
}

.card:hover {
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

.card h2 {
	margin-top: 0;
	color: #333;
}

.card p {
	margin: 5px 0;
}

.card-list {
	list-style: none;
	padding: 0;
	margin: 0;
}

.card-list li {
	margin-bottom: 5px;
}

.button {
	padding: 10px 20px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
<%@include file="headerforuser.jsp" %>
	<div class="container">
		<div class="grid-container">
			<div class="card">
				<h2>Instructor Details</h2>
				<p>Id: ${instructor.instructor_id}</p>
				<p>Name: ${instructor.instructor_name}</p>
				<p>Email: ${instructor.instructor_email}</p>
				<p>Contact: ${instructor.instructor_contact}</p>
				<p>Experience: ${instructor.instructor_experience}</p>
			</div>
			<div class="card">
				<h2>Courses</h2>
				<ul class="card-list">
					<c:forEach var="course" items="${instructor.course}">
						<li>${course.course_name}</li>
					</c:forEach>
				</ul>
			</div>
			<div class="card">
				<h2>Students</h2>
				<ul class="card-list">
					<c:forEach var="student" items="${students}">
						<li>${student.student_name}</li>
					</c:forEach>
				</ul>
			</div>
			<div class="card">
				<h2>Assign Course to Student</h2>
				<form action="/assigncoursetostudent" method="post">
					Select Student : <select name="studentId">
						<c:forEach var="student" items="${allstudents}">
							<option value="${student.student_id}">${student.student_name}</option>
						</c:forEach>
					</select> <br>
					<br> Select Course:<select name="courseId">
						<c:forEach var="course" items="${courses}">
							<option value="${course.course_id}">${course.course_name}</option>
						</c:forEach>
					</select> <br>
					<br>
					<button class="button" type="submit">Assign Course</button>
				</form>
				${message}
			</div>
		</div>
	</div>
</body>
</html>
