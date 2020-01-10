<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete By Id</title>

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


.box input[type = "text"]{
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
}

.box input[type = "text"]:focus{
	width: 280px;
	border-color: #2ecc71;
}

.box input[type = "submit"]{
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #2ecc71;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}

.box input[type = "submit"]:hover{
	background: #2ecc71;
}

.box input[type = "button"]{
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #e74c3c;
	width: 200px;
	height: 30px;
	color: white;
	outline: none;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}

.box input[type = "button"]:hover{
	background: #e74c3c;
}

</style>

</head>
<body>


<form class = "box" method = "post" action = "detailsDeleteById">
	<h1>Delete By Id</h1><br>
	<input type = "text" name = "cid" placeholder = "Id">
	<input type = "submit" value = "Submit"><br>
	<input type = "button"  onclick = "location.href = 'Menu'" value = "Return to menu">
</form>



</body>
</html>