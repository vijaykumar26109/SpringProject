<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
    prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instructor List</title>
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

        .instructor {
            padding: 20px;
            border-bottom: 1px solid #ddd;
            transition: background-color 0.3s;
        }

        .instructor:hover {
            background-color: #f2f2f2;
        }

        .instructor-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .instructor-info h3 {
            margin: 0;
            color: #333;
        }

        .instructor-info p {
            margin: 0;
            color: #777;
        }

        h2#instructor {
            text-align: center;
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
        <h2 id="instructor">List Of Instructors</h2>
        <div class="container">
            <c:forEach items="${instructors}" var="instructor">
                <div class="instructor">
                    <div class="instructor-info">
                        <h3>${instructor.instructor_name}</h3>
                       
                    </div>
                    <p>Email: ${instructor.instructor_email}</p>
                    <p>Contact: ${instructor.instructor_contact}</p>
                    <p>Experience: ${instructor.instructor_experience}</p>
                </div>
            </c:forEach>
        </div>
    </sec:authorize>
</body>
</html>
