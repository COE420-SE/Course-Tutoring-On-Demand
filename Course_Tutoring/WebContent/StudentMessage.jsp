<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
 <meta http-equiv = "refresh" content = "5; url = Student.html" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min
.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.modal {
	display: block; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100; /* Full width */
	height: 100; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 0px;
}

.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
	height: auto;
}

.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	max-width: 50%;
	height: auto;
}

body {
	background-image:
		url(error.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}

h2 {
	text-align: center;
}
body {
	background-image:
		url(tutor.PNG);
	background-repeat: no-repeat;
	background-size: cover;
}

label {
	background-color: white;
	color: black;
	font-weight: bold;
	padding: 4px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

</style>
<body>
	<div class="modal">
		<form class = "modal-content">
			<div class="container center">
				<div class="w3-container w3-center" style = "padding: 20px 16px">
				<%
						String message = (String)request.getAttribute("message");
					%>
					<label for="user"><%=message%></label>
	</div>
			<div class="form-group">
				<p>You will be redirected to HomePage in 5 seconds, if not please click <a class = "w3-blue" href="Student.html">here</a></p>
			</div>
		</div>
		</form>
	</div>
</body>
</html>

