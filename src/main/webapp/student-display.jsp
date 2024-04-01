 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
    prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #dae0e8; 
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .student-info {
            text-align: left;
            margin-bottom: 20px;
            padding: 10px;
            border-radius: 5px;
            background-color: #f2f2f2;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        .instructors {
            text-align: left;
            margin-top: 20px;
            padding: 10px;
            border-radius: 5px;
            background-color: #f2f2f2;
        }

        .instructors h2 {
            color: #333;
            margin-top: 0;
        }

   
        .header {
            height: 2cm; 
            background-color: #e4e8da; 
            color: #333; 
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            margin: 0 auto; 
        }

        .student-name {
            font-weight: bold;
            margin: 0;
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
    <%@include file="headerforuser.jsp" %>

    <div class="container">
        <div class="student-info">
            <p><strong>Student ID:</strong> ${student.student_id}</p>
            <p><strong>Name:</strong> ${student.student_name}</p>
            <p><strong>Email:</strong> ${student.student_email}</p>
            <p><strong>Phone Number:</strong> ${student.student_phoneno}</p>
        </div>

        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
            </tr>
            <c:forEach items="${student.courses}" var="course">
                <tr>
                    <td>${course.course_id}</td>
                    <td>${course.course_name}</td>
                </tr>
            </c:forEach>
        </table>

        <div class="instructors">
            <h2>Instructors</h2>
            <table>
                <tr>
                    <th>Instructor ID</th>
                    <th>Instructor Name</th>
                </tr>
                <c:forEach items="${instructors}" var="instructor">
                    <tr>
                        <td>${instructor.instructor_id}</td>
                        <td>${instructor.instructor_name}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>