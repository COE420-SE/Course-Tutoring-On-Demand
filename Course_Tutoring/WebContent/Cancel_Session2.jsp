<%@page import="ApplicationModel.Session_Detail"%>
<%@page import="java.util.List"%>
<!-- do we need to include this?? -->
<%@page import="java.util.ArrayList"%>

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

input[type=text], input[type=date], input[type=time], input[type=number],
	select, textarea {
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
	background-image: url(tutor.PNG);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
		<h2 class="center" style="color: black">
			<b>Cancel a Session</b>
		</h2>
		<form action="CancelSessionServlet"
			method="Post">
			<table id="myTable" class="table table-bordered compact"
				style="width: 100%; background-color: white" data-page-length="25"
				data-order="[[ 1, &quot;asc&quot; ]]">
				<thead>
					<tr style="background-color: #4CAF50">
						<th>Choose</th>
						<th>Tutor Name</th>
						<th>Course Name</th>
						<th>Classroom</th>
						<th>Session Date</th>
						<th>StartTime</th>
						<th>EndTime</th>
						<th>No of Seats</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Session_Detail> listSession = (ArrayList<Session_Detail>) request.getAttribute("session");
						for (Session_Detail s : listSession) {
					%>
					<%-- Arranging data in tabular form --%>
					<tr>
						<td><input type="radio" name="session"
							value=<%=s.getSession_ID()%> required></td>
						<td><%=s.getTutor_Name()%></td>
						<td><%=s.getCourse_ID()%></td>
						<td><%=s.getClassroom_ID()%></td>
						<td><%=s.getDate_of_session()%></td>
						<td><%=s.getStart_time()%></td>
						<td><%=s.getEnd_time()%></td>
						<td><%=s.getMax_Seats()%></td>
					</tr>

					<%
						}
					%>
				</tbody>
			</table>
			<div class="container">
				<input type="submit"
					style="background-color: #4CAF50; color: white; padding: 8px 20px; margin: 8px 0; border: none; align: left cursor: pointer; width: auto; font-size: 16px"
					value="Cancel Session">
			</div>
		</form>
		<script>
			function goBack() {
				window.history.back();
			}
			$(document).ready(function() {
				$('#myTable').DataTable();
			});
		</script>
</body>
</html>
