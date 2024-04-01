<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.nav-links {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
}

.nav-item {
	margin-right: 20px;
	position: relative;
}

.nav-item:last-child {
	margin-right: 0;
}

.nav-link {
	color: #fff;
	text-decoration: none;
	padding: 10px;
	border-radius: 5px;
	transition: background-color 0.3s;
}

.nav-link:hover {
	background-color: #0056b3;
}

.dropdown {
	position: absolute;
	top: 100%;
	left: 0;
	display: none;
	background-color: #007bff;
	min-width: 160px;
	z-index: 1;
	border-radius: 0 0 5px 5px;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
}

.dropdown-content a {
	color: #fff;
	padding: 10px;
	text-decoration: none;
	display: block;
	transition: background-color 0.3s;
}

.dropdown-content a:hover {
	background-color: #0056b3;
}

.nav-item:hover .dropdown {
	display: block;
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

.main-content {
	padding: 20px;
	text-align: center;
}

.form-container {
	max-width: 400px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-group select {
	width: 100%;
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.form-group button {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: #fff;
	cursor: pointer;
	transition: background-color 0.3s;
}

.form-group button:hover {
	background-color: #0056b3;
}

.message {
	text-align: center;
	margin-top: 20px;
	color: #007bff;
}
</style>
</head>
<body>

	<header class="header">
		<span class="logo"><i class="fas fa-user-shield"></i>&nbsp;
			${ username}&#x1F44B;ADMIN</span>
		<nav>
			<ul class="nav-links">
				<li class="nav-item"><a href="header" class="nav-link"><i
						class="fas fa-home"></i>&nbsp;Home</a></li>
				<li class="nav-item"><a href="#" class="nav-link"><i
						class="fas fa-book"></i> &nbsp;Courses</a>
					<div class="dropdown">
						<div class="dropdown-content">
							<a href="addcourseform">Add Courses</a> <a href="courses">Get
								Courses</a>
						</div>
					</div></li>

				<li class="nav-item"><a href="#" class="nav-link"><i
						class="fas fa-chalkboard-teacher"></i>&nbsp;Instructors</a>
					<div class="dropdown">
						<div class="dropdown-content">
							<a href="addinstructorform">Add Instructor</a> <a
								href="instructors">Get Instructors</a>
						</div>
					</div></li>
				<li class="nav-item"><a href="#" class="nav-link"><i
						class="fas fa-user-graduate"></i>&nbsp;Students</a>
					<div class="dropdown">
						<div class="dropdown-content">
							<a href="addstudentform">Add Student</a> <a href="students">Get
								Students</a>
						</div>
					</div></li>
			</ul>
		</nav>
		<button class="logout-btn" onclick="location.href='logout'">
			<i class="fas fa-sign-out-alt"></i>Logout
		</button>
	</header>

</body>
</html>