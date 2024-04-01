<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
    prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

.header {
	background-color: #007bff;
	color: #fff;
	padding: 10px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.logo {
	font-size: 24px;
	font-weight: bold;
	text-transform: uppercase;
	letter-spacing: 2px;
}

.logout-btn {
	border: none;
	background-color: #d9534f;
	color: #fff;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.logout-btn:hover {
	background-color: #c9302c;
}
</style>
</head>
<body>
	<sec:authorize access="hasRole('INSTRUCTOR')">
	<header class="header">
		<span class="logo"><i class="fas fa-user-shield"></i>&nbsp;
			Hello ${instructor.instructor_name }&#x1F44B; &nbsp; Role :
			Instructor</span> <span class="logo"> <a href="instructor"
			class="nav-link" style="color: white; text-decoration: none;"> <i
				class="fas fa-home"></i>&nbsp;Home
		</a>
		</span>
		<button class="logout-btn" onclick="location.href='logout'">
			<i class="fas fa-sign-out-alt"></i>Logout
		</button>
	</header>
	</sec:authorize>
	<sec:authorize access="hasRole('STUDENT')">
	<header class="header">
		<span class="logo"><i class="fas fa-user-shield"></i>&nbsp;
			Hello ${student.student_name }&#x1F44B; &nbsp;
			</span> 
		<button class="logout-btn" onclick="location.href='logout'">
			<i class="fas fa-sign-out-alt"></i>Logout
		</button>
	</header>
	</sec:authorize>

</body>
</html>