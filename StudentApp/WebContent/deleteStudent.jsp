<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" type="text/css">
<title>delete student</title>
</head>
<body>
	deleteing student
	<div id="menubar">
		<a href="welcome.jsp">Home</a>
		<a href="addStudent.jsp">Add</a>
		<a href="getStudent.jsp">Get</a>
		<a href="deleteStudent.jsp">Delete</a>
		<a href="updateStudent.jsp">Update</a>
	</div>
	
	<%-- <%
		String requestName="deleteSt";
		session.setAttribute("deletestudent", "deleteSt");
	%>
	 --%>
	<form action="StudentData">
		Student Id: <input type="text" name="id">
		Student Name: <input type="text" name="name">
		<input type="submit" value="save" name="delete_St">
	</form>
</body>
</html>