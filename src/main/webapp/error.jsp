<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        #container {
            margin: 50px auto;
            width: 80%;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
            color: #007bff;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        th {
            text-align: right;
            width: 30%;
            font-weight: bold;
            color: #28a745;
        }
        td {
            text-align: left;
        }
        a {
            text-decoration: none;
            color: #007bff;
            transition: color 0.3s ease;
        }
        a:hover {
            color: #0056b3;
        }
        h3 {
            text-align: center;
            margin-top: 20px;
            color: #dc3545;
        }
        .button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease, color 0.3s ease;
        }
        .button.admin:hover {
            background-color: #ff0000;
        }
        .button.instructor:hover {
            background-color: #00ff00;
        }
        .button.student:hover {
            background-color: #ffff00;
        }
    </style>
</head>
<body>
<div id="container">
    <h1>Error Details</h1>
    <table>
        <tr>
            <th>Message :</th>
            <td>OOPS Something Went Wrong</td>
        </tr>
        <tr>
            <th>Error:</th>
            <td>${error}</td>
        </tr>
        <tr>
            <th>Status :</th>
            <td>${status}</td>
        </tr>
        <tr>
            <th>Date :</th>
            <td>${timestamp}</td>
        </tr>
    </table>
    <sec:authorize access="hasRole('ADMIN')">
        <h3><a href="/header" class="button admin">Go To Safety</a></h3>
    </sec:authorize>
    <sec:authorize access="hasRole('INSTRUCTOR')">
        <h3><a href="/instructor" class="button instructor">Go To Safety</a></h3>
    </sec:authorize>
    <sec:authorize access="hasRole('STUDENT')">
        <h3><a href="/student" class="button student">Go To Safety</a></h3>
    </sec:authorize>
</div>
</body>
</html>
