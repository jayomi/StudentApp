
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.jayomi.student.model.Student" %>
<%@page import="com.jayomi.student.resources.StudentService"%>
<%@page import="com.jayomi.student.resources.StudentServiceImpl"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" type="text/css">
<title>get students</title>
</head>
<body>
	get students..........
	<div id="menubar">
		<a href="welcome.jsp">Home</a>
		<a href="addStudent.jsp">Add</a>
		<a href="getStudent.jsp">Get</a>
		<a href="deleteStudent.jsp">Delete</a>
		<a href="updateStudent.jsp">Update</a>
	</div>
	<%
		List<Student> stList=new ArrayList<Student>();
		StudentService studentService=new StudentServiceImpl();
		stList=studentService.getStudents(); 
	%>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
		</tr>
		
	
	<%for(int i=0;i<stList.size();i++){ %>
	
		<tr><td><%=stList.get(i).getId() %></td>
		<td><%=stList.get(i).getName() %></td>
		<td><%=stList.get(i).getAge() %></td>
		</tr>
	<%} %>
	</table>
	
</body>
</html>