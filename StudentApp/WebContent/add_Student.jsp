<%@page import="com.jayomi.student.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" style="text/css">
<title>added student</title>
</head>
<body>

	<div id="menubar">
		<a href="welcome.jsp">Home</a>
		<a href="addStudent.jsp">Add</a>
		<a href="getStudent.jsp">Get</a>
		<a href="deleteStudent.jsp">Delete</a>
		<a href="updateStudent.jsp">Update</a>
	</div>
 successfully added
	<ul>
		<li>Id: <%=	request.getAttribute("st_Id").toString()   %></li>
		<li>Name:<%= request.getAttribute("st_Name").toString() %></li>
		<li>Age:<%= request.getAttribute("st_Age").toString() %>	</li>
	</ul>
	
	
	
		
	
</body>
</html>