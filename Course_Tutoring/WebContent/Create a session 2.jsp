<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min
.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
	box-sizing: border-box;
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
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 6px;
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
		width: 100%;
		margin-top: 0;
	}
}

body {
	background-image: url(tutor.PNG);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<h2 class="w3-center">Create a Session Form</h2>
	<div class="container">
		<form action="CreateServlet" method="Post">
			<div class="row">
				<div class="col-25">
					<label for="fname">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="fname" name="Name" placeholder="Your name.."
						required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="course">Tutor Course:</label>
				</div>
				<div class="col-75">
					<select name="course" required>
						<c:forEach items="${listTutorCourses}" var="course">
							<option value="${course.id}"
								<c:if test="${course.id eq selectedCatId}">selected="selected"</c:if>>
								${category.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="course">ClassRoom:</label>
				</div>
				<div class="col-75">
					<select name="classroom" required>
						<c:forEach items="${listClassRoom}" var="classroom">
							<option value="${classroom.id}"
								<c:if test="${category.id eq selectedCatId}">selected="selected"</c:if>>
								${classroom.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="date">Session Date:</label>
				</div>
				<div class="col-75">
					<input type="date" id="datemin" name="datemin" min="2020-05-01"
						required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="s_time">Start Time:</label>
				</div>
				<div class="col-75">
					<input type="time" id="timemin" name="timemin" min="17:00" required>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="e_time">End Time:</label>
				</div>
				<div class="col-75">
					<input type="time" id="timemin" name="timemin" min="18:00" required>
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
	</div>

</body>
</html>