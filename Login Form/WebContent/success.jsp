<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful Login</title>
</head>
<body>
<%
String username = request.getParameter("username");
System.out.println(username); %>
Welcome <% out.println(username); %>
</body>
</html>