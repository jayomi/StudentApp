<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css" type="text/css">
<title>update student</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="bootstrap/css/styles.css" type="text/css">
<link rel="stylesheet" href="css/styles.css" type="text/css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css">
</head>
<body>
	<!-- 	------------------------------------------------------------------------------------------- -->
	<nav class="navbar navbar-inverse navbar-static-top no-margine" role="navigation">
		<div class="container-fluid" >
			<div class="navbar-header" >
				
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-test-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand " href="#"><!-- <img src="bootstrap/img/images1.jpg"> --></a>
			</div>	
				<!-- <img src="img/images1.jpg" > -->
				<!-- <a class="navbar-brand" href="#">Sujata Vidyalaya Matara</a> -->			
				<!-- <div class="navbar-header navbar-right" > -->
				<div class="collapse navbar-collapse navbar-right" id="bs-test-navbar-collapse-1">
					<ul class="nav nav-pills navbar-nav">
					
						<li class="active"><a href="welcome.jsp">Home</a></li>
						<li><a href="addStudent.jsp">Add Student</a></li>
						<li><a href="getStudent.jsp">Get Student</a></li>
						<li><a href="deleteStudent.jsp">Remove Student</a></li>
						<li><a href="updateStudent.jsp">Update Student</a></li>
						
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#"  aria-haspopup="true" aria-expanded="true">
								TestDropdown
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="#">Link1</a></li>
								<li><a href="#">Link2</a></li>
								<li><a href="#">Link3</a></li>
								<li><a href="#">Link4</a></li>

								<li class="divider"></li>
								<li><a href="#">Seperated Link</a></li>
								<li class="divider"></li>
								<li><a href="#">one more seperated Link</a></li>
								<li></li>

							</ul>
						</li>
						<li><a href="#">h</a></li>	
					</ul>
				</div>

			
		</div>
	</nav>
	
	<!-- 	------------------------------------------------------------------------------------------- -->
	
	<form action="StudentData">
		id:<input type="text" name="id"/>
		<input type="submit" value="Enter" name="updateSt">
	</form>
	
<script type="text/javascript" src="bootstrap/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src=bootstrap/js/bootstrap.min.js></script>	
</body>
</html>