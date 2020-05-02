<%@page import="ApplicationModel.Session_Detail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ApplicationModel.Session_Requests"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js">
<link rel="stylesheet" href="https://code.jquery.com/jquery-3.3.1.js">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/searchpanes/1.0.1/css/searchpanes.dataTables.min.css">
<style>
body {
	background-image: url(tutor.PNG);
	background-repeat: no-repeat;
	background-size: cover;
}

#myInput {
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 20px;
	border: 1px solid #ddd;
	margin-bottom: 10px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 80%;
	margin-left: 50px;
}

.center {
	display: block;
	margin-left: 40%;
	margin-right: auto;
	max-width: 60%;
}
</style>
</head>
<body>
	<h2 class="center" style="color: black">
		<b>Cancel a Session</b>
	</h2>
	<form action="CancelSessionServlet" method="Post">
		<table id="myTable" class="table table-bordered compact"
			style="width: 90%; background-color: white" data-page-length="25"
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
		<input type="submit" class="center"
			style="background-color: #4CAF50; color: white; padding: 8px 10px; border: none; cursor: pointer; width: auto; font-size: 16px"
			value="Cancel Session" name="submit_button">
	</form>
	<button onclick="goBack()">Go Back</button>
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
