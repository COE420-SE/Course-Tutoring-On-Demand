
<html>
<head>
<title>Create a Session</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min
.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<style>
body {
	background-image: url(tutor.PNG);
	background-repeat: no-repeat;
	background-size: cover;
}

label {
	display: block;
	font: 1rem 'Fira Sans', sans-serif;
}

input, label {
	margin: .4rem 0;
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
	margin: 3% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
	height: auto;
}

.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	max-width: 40%;
	height: auto;
}
</style>
<body>
	<div align="center">
		<h2><b>Create a Session</b></h2>
		<form class="modal-content" action="createasession" method="post">
			Select a Course: <select name="course" class="w3-black w3center"
				required>
				<c:forEach items="${listTutorCourses}" var="course">
				</c:forEach>
			</select> <label for="Tutor Name">Tutor Name</label> <input type="text"
				class="w3-black w3-center" placeholder="enter name" required>
			<label for="datemin">Choose a session date:</label> <input
				type="date" class="w3-black w3-center" id="datemin" name="datemin"
				min="2020-05-01" required> <label for="timemin">Choose
				a session start time:</label> <input type="time" class="w3-black w3-center"
				id="timemin" name="timemin" min="17:00" required> <label
				for="timemin">Choose a session end time:</label> <input type="time"
				class="w3-black w3-center" id="timemin" name="timemin" min="18:00"
				required> Select a Classroom:&nbsp; <select name="classroom"
				class="w3-black w3-center" required>
				<c:forEach items="${listClassRoom}" var="classroom">
				</c:forEach>
			</select> <label for="Number">Number of Seats</label> <input type="text"
				class="w3-black w3-center" placeholder="enter number" required>
			<div class="container">
				<input type="submit" class="w3-button w3-grey" value="Submit">
			</div>
		</form>
	</div>
</body>
</html>