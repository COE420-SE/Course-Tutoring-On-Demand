<%@page import="ApplicationModel.Session_Detail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>Give Feedback</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min
.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
* {
	box-sizing: border-box;
}

select{
	height: 25px;
	width: 250px;
	
}
input[type=text], input[type=date], input[type=time], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	resize: vertical;
}

label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
	margin-left: auto;
	margin-right: auto;
	max-width: 80%;
	height: auto
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	margin: 4% auto 15% auto;
	border-radius: 5px;
	background-color: #fefefe;
	padding: 20px;
}

.col-25 {
	float: Right;
	text-align: right;
	width: 15%;
	margin-top: 6px;
	margin-left: 10px;
}

.col-75 {
	float: left;
	width: 75%;
	margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 80%;
		margin-top: 0;
	}
}

body {
	background-image: url(Feedback.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<div class="container">
		<h2 class="w3-center">Give Feedback</h2>
		<form action="GiveFeedbackServlet" method="Post">
			<div class="row">
				<div class="col-25">
					<label for="fname">Name: </label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" name="Name" placeholder="Your name.."
						required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="session">Choose Session: </label>
				</div>
				<div class="col-75">
					<select name="session" id ="session" required>
						<%
						 ArrayList<Session_Detail> listSession =  (ArrayList<Session_Detail>)request.getAttribute("session");
							for (Session_Detail s : listSession) {
						%>
						<option value="<%=s.getSession_ID()%>"><%=s.getTutor_Name()%></option>
						<%
							}
							
						%>
					</select>
			</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="comment">Comment: </label>
				</div>
				<div class="col-75">
					<textarea rows="4" cols="30" name="comment"> Enter text here...</textarea>

			</div>
			</div>
			<br>
			<div class="row">
				<input type="submit" value="Submit" name="submit_button">

			</div>
			&nbsp;&nbsp;
		</form>
	</div>

</body>
</html>
