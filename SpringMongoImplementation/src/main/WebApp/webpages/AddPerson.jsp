<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Person</title>
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
.box h5{
	color: white;
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


	<form class = "box" method = "post" action = "detailsCreate" onsubmit = "return fvalidator()">
		<h1>New person</h1>
		<h5 id = "message">Add data</h5>
		<input type = "text" name = "cname" id = "fname" placeholder = "Name">
		<input type = "text" name = "cemail" id = "femail" placeholder = "Email">
		<input type = "text" name = "cphone" id = "fphone" placeholder = "Phone">
		<input type = "submit" id = "action" value = "Submit"><br>
		<input type = "button"  onclick = "location.href = 'Menu'" value = "Return to menu">
		
	</form>
		
	<script type="text/javascript">


		function fvalidator(){
			var email = document.getElementById("femail").value;
			var flag = true;

			
			if(email.substring(email.indexOf('@') - 1,email.indexOf('@')) == '.') 		flag = false;
			if(email.substring(email.indexOf('@') + 1,email.indexOf('@')+2) == '.') 	flag = false;
			if(email.indexOf('@') <= 0 || email.indexOf('@') == email.length-1)			flag = false;
			if(email.indexOf('.') <= 0 || email.indexOf('.') == email.length-1)			flag = false;
			if(email.indexOf('@',email.indexOf('@')+1) != -1)							flag = false;
			if(email.substring(email.length-1, email.lenght) == '.')					flag = false;
			
			if(!flag){
				document.getElementById("femail").focus();
				document.getElementById("message").innerHTML = "Invalid email. Please enter a valid email.";
				return flag;
				}	
			
			

			
			var phone = document.getElementById("fphone").value;

			if(phone.indexOf('.') != -1) 				flag = false 
			if(isNaN(phone)||phone.indexOf(" ")!=-1) 	flag = false;
			if(!(phone.length == 10)) 					flag = false;


			
			if(!flag){
				document.getElementById("fphone").focus();
				document.getElementById("message").innerHTML = "Invalid phone. Please enter a valid phone. Format XXXXXXXXXX";
				return flag;
				}	

			return flag;
		
			
		}
	</script>




</body>
</html>