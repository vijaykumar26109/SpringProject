<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.course {
	padding: 20px;
	margin-bottom: 10px;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

.course p {
	margin: 0;
	padding: 5px 0;
}

hr {
	border: none;
	border-top: 1px solid #ccc;
	margin: 10px 0;
}
 h2#course {
    text-align: center;
    position: absolute;
    top: 50px;
    left: 50%;
    transform: translateX(-50%);
    background-color: #f0f0f0;
    padding: 10px 20px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }
</style>
</head>
<body>
	<sec:authorize access="hasRole('ADMIN')">
		<%@include file="header.jsp"%>
		<h2 id="course">List Of Courses</h2><br /><br />
		<br/>
		<div class="container">
			<c:forEach var="course" items="${courses}">
				<div class="course">
					<p>Name: ${course.course_name}</p>
					<p>Description: ${course.course_description}</p>
				</div>
				<hr>
			</c:forEach>
		</div>
	</sec:authorize>
</body>
</html>
