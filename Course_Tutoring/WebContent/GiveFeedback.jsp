<%@page import="ApplicationModel.Session_Detail"%>
<%@page import="ApplicationModel.Student"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<title>Give Feedback Form</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min
.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	max-width: 80%;
	height: auto
}

h2 {
	text-align: center;
}

body {
	background-image:
		url(Feedback.jpg);
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
	margin: 4% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 40%;
	height: auto /* Could be more or less, depending on screen size */
}
button {
  background-color: #4CAF50;
  color: white;
  padding: 8px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: auto;
}

#message {
	display: none;
	color: #000;
	position: relative;
	margin-top: 10px;
}

#message2 {
	display: none;
	color: #000;
	position: relative;
	margin-top: 10px;
}

#button {
	display: none;
}

#message p {
	padding: 10px 55px;
	font-size: 14px;
}

#message2 p {
	padding: 10px 55px;
	font-size: 14px;
}
/* Add a green text color and a checkmark when the requirements are right */
.valid {
	color: green;
}

.valid:before {
	position: relative;
	left: -35px;
	content: "✔";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
	color: red;
}

.invalid:before {
	position: relative;
	left: -35px;
	content: "✖";
}
</style>
<body>
	<div class="row">
				<div class="col-25">
					<label for="department">Department: </label>
				</div>
				<div class="col-75">
					<select name="department" required>
						<%
							List<Session_Detail> listSession_Detail = (ArrayList<Session_Detail>) request.getAttribute("course");
							for (Session_Detail s : listSession_Detail) {
						%>
						<option value="<%=s.getSession_ID()%>"><%=s.getCourse_ID()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
</body>
</html>