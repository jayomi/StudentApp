<%@page import="com.jayomi.student.model.Student"%>
<%@page import="com.jayomi.student.resources.StudentService"%>
<%@page import="com.jayomi.student.resources.StudentServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>

	<h4>Adding New Student</h4>
	<div id="menubar">
		<a href="welcome.jsp">Home</a>
		<a href="addStudent.jsp">Add</a>
		<a href="getStudent.jsp">Get</a>
		<a href="deleteStudent.jsp">Delete</a>
		<a href="updateStudent.jsp">Update</a>
	</div>
	<%-- <%
		String requestName="addSt";
		//request.setAttribute("addstudent", requestName);
		session.setAttribute("addstudent", requestName);
	%> --%>
	
	<form action="StudentData">
		<fieldset>
			Id:<input type="text" name="stId"/><br/><br/>
			Name: <input type="text" name="stName"/><br/><br/>
			Age: <input type="text" name="stAge"/><br/><br/>
		</fieldset>		
		
		
		<input type="submit" value="save" name="addSt"/><br/><br/>
	</form>
</body>
</html>