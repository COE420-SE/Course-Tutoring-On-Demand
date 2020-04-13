<%@page import="ApplicationModel.Department"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<title>AUS Course Tutoring</title>
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
		url(aus_campus.jpg);
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
	<div class="modal">
		<form class="modal-content" method="Post" action="AddDepartServlet">
			<div class="container center">
				<h2>Adding Department Admin</h2>
				<img src="https://www.w3schools.com/howto/img_avatar.png"
					class="center" style="width: 40%; border-radius: 50%;">
					<div class="form-group">
					<label for="psw">Name:</label> <input type="text"
						name = "name" class="form-control"
						placeholder="Enter Admin Name" required />
				</div>
					<div class="form-group">
					<label for="psw">Username:</label> <input type="text"
						name = "username" class="form-control"
						placeholder="Enter AUS EMAIL" required />
				</div>
				<div class="form-group">
					<label for="dept">Department: </label>
						<select name="department" required>
						<%
							List<Department> listDepartment = (ArrayList<Department>) request.getAttribute("department");
							for (Department : listDepartment) {
						%>
						<option value="<%=s.DepartmentID%>"><%=s.departmentNameString%></option>
						<%
							}
						%>
						</select>
				</div>
				<div class="form-group">
					<label for="psw">Password:</label> <input type="password"
						id="psw" name="psw" class="form-control" pattern="{6,}"
						placeholder="Enter password"
						title="Must contain atleast six characters" required />
				</div>
				<div id="message">
					<p id="length" class="invalid">Minimum 6 characters </p>
				</div>
				<div class="form-group">
					<label for="pwd_r">Confirm Password:</label> <input type="password"
						class="form-control" id="r_pwd" placeholder="Enter password again"
						name="r_pwd" title="Must match the created password" required>
				</div>
				<div id="message2">
					<p id="match" class="invalid">Both Passwords Must Match</p>
				</div>
				<div id="button">
					<button type="submit" name="register_button" class="w3-green center">Submit</button>
				</div>
			</div>
			</form>
	</div>
	<script>
		var myInput = document.getElementById("psw");
		var reInput = document.getElementById("r_pwd");
		var length = document.getElementById("length");
		var match = document.getElementById("match");

		// When the user clicks on the password field, show the message box
		myInput.onfocus = function() {
			document.getElementById("message").style.display = "block";
		}
		reInput.onfocus = function() {
			document.getElementById("message2").style.display = "block";
		}
		// When the user starts to type something inside the password field
		myInput.onkeyup = function() {

			// Validate length
			if (myInput.value.length >= 6) {
				length.classList.remove("invalid");
				length.classList.add("valid");
			} else {
				length.classList.remove("valid");
				length.classList.add("invalid");
				document.getElementById("button").style.display = "none";
				match.classList.remove("valid");
				match.classList.add("invalid");
			}
		}
		reInput.onkeyup = function() {
			//Validate if matches
			if (document.getElementById("psw").value == document
					.getElementById("r_pwd").value) {
				match.classList.remove("invalid");
				match.classList.add("valid");
			} else {
				match.classList.remove("valid");
				match.classList.add("invalid");
				document.getElementById("button").style.display = "none";
			}
			if (myInput.value.length >= 6
					&& document.getElementById("psw").value == document
							.getElementById("r_pwd").value) {
				document.getElementById("button").style.display = "block";
			}
		}
	</script>
</body>
</html>
