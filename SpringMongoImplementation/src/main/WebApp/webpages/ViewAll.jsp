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
	width: 1200px;
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


.box h4{
	color: white;
	font-weight: 500;
	border: 3px solid #FFF;
	padding: 50px 40px;
	text-align: center;
}


.box input[type = "submit"]{
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #e74c3c;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}

.box input[type = "submit"]:hover{
	background: #e74c3c;
}



</style>


</head>
<body>


<form class = "box" method = "get" action = "Menu" >
	<h1>List Obtained</h1>
	<h4>${list}</h4><br>
	<input type = "submit" value = "Return to menu"><br>
</form>



</body>
</html>