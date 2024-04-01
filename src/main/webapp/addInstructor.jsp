<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Instructor</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	margin-top: 50px;
	color: #333;
}

form {
	max-width: 400px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

input[type="text"], input[type="email"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<h2>Add Instructor</h2>
	<form action="addinstructor" method="post">
		Name:<input type="text" name="instructor_name" required><br>
		Email:<input type="email" name="instructor_email" required><br>
		Contact:<input type="text" name="instructor_contact" required><br>
		Experience:<input type="text" name="instructor_experience" required><br>
		<input type="submit" value="Add Instructor"> ${message }
	</form>
</body>
</html>
