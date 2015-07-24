<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update student</title>
</head>
<body>

	<form action="StudentData">
		<input type="text" value=<%=request.getAttribute("sId")%> name="id"/>
		<input type="text" value=<%=request.getAttribute("sName")%> name="name"/>
		<input type="text" value=<%=request.getAttribute("sAge") %> name="age"/>
		<input type="submit" value="save" name="update_St">
	</form>
	
</body>
</html>