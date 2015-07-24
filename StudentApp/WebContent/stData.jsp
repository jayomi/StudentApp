<%@page import="com.jayomi.student.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jayomi.student.resources.StudentService"%>
<%@page import="com.jayomi.student.resources.StudentServiceImpl"%>
<%@page import="com.jayomi.student.model.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<title>student data</title>
</head>
<body>

	<h4>Added New Student</h4>
	<div id="menubar">
		<a href="welcome.jsp">Home</a>
		<a href="addStudent.jsp">Add</a>
		<a href="getStudent.jsp">Get</a>
		<a href="deleteStudent.jsp">Delete</a>
		<a href="updateStudent.jsp">Update</a>
	</div>
	
	
		
	<%-- <fieldset>
	<legend>Student Details</legend>
	<h4>Id:<%=request.getAttribute("st_Id")%></h4>
	<h3>Name of the sdtudent: <%=request.getAttribute("st_Name") %></h3>
	<h3>Age of the Student: <%=request.getAttribute("st_Age") %></h3>
	
	</fieldset> --%>
	
	<% int id=Integer.parseInt(request.getAttribute("st_Id").toString()); %>
	<% String name=request.getAttribute("st_Name").toString(); %>
	<% int age=Integer.parseInt(request.getAttribute("st_Age").toString()); %>

	<%
		StudentService studentServiceImpl=new StudentServiceImpl();
		studentServiceImpl.addStudent(new Student(id,name,age));
	%>

</body>
</html>