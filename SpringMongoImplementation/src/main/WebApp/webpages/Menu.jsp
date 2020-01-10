<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: #34495e;
	background: #191919;
}

.box{
	width: 300px;
	padding: 40px;
	position: absolute;
	top: 50%;
  	left: 50%;
  	transform: translate(-50%, -50%);
	background: #191919;
	text-align: center;
}

.box h1{
	color: white;
	text-transform: uppercase;
	font-weight: 500;
}

.button{
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #e74c3c;
	padding: 14px 40px;
	color: white;
	outline: none;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}

.btnCreate{border: 2px solid #16a085;transition: 0.4s;}		.btnCreate:hover{background: #16a085; width: 300px;}
.btnObtainPeople{border: 2px solid #27ae60;transition: 0.4s;}	.btnObtainPeople:hover{background: #27ae60; width: 300px;}
.btnObtainPerson{border: 2px solid #2980b9;transition: 0.4s;}	.btnObtainPerson:hover{background: #2980b9; width: 300px;}
.btnUpdatePerson{border: 2px solid #f39c12;transition: 0.4;}	.btnUpdatePerson:hover{background: #f39c12; width: 300px;}
.btnDeletePerson{border: 2px solid #e67e22;transition: 0.4s;}	.btnDeletePerson:hover{background: #e67e22; width: 300px;}
.btnDeleteAll{border: 2px solid #e74c3c;transition: 0.4s;}		.btnDeleteAll:hover{background: #e74c3c; width: 300px;}

</style>



</head>
<body>

<form class = "box" method = "get" action = "Create" >

	<h1>People Menu</h1>
	<input type = "button"  value = "Create Person" class = "button btnCreate"			onclick = "location.href = 'Create'" >
	<input type = "button"  value = "Obtain People" class = "button btnObtainPeople" 	onclick = "location.href = 'ObtainAll'" >
	<input type = "button"  value = "Obtain Person" class = "button btnObtainPerson" 	onclick = "location.href = 'ObtainById'">
	<input type = "button"  value = "Update Person" class = "button btnUpdatePerson"	onclick = "location.href = 'UpdateById'">
	<input type = "button"  value = "Delete Person" class = "button btnDeletePerson"	onclick = "location.href = 'DeleteById'">
	<input type = "button"  value = "Delete All"	class = "button btnDeleteAll"		onclick = "location.href = 'DeleteAll'">
	
	
	
</form>

</body>
</html>