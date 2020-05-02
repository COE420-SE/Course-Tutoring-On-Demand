
<%@page import="ApplicationModel.Session_Detail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<style>
body {
	background-image: url(tutor.PNG);
	background-repeat: no-repeat;
	background-size: cover;
}

tfoot input {
	width: 100%;
	padding: 3px;
	box-sizing: border-box;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 80%;
	margin-left: 50px;
}

#myInput {
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 20px;
	border: 1px solid #ddd;
	margin-bottom: 10px;
}

.center {
	display: block;
	margin-left: 40%;
	margin-right: auto;
	max-width: 60%;
}

.container {
	padding-right: 10%;
	padding-left: 25%;
	margin-right: auto;
	margin-left: auto;
}
</style>
</head>
<body>
		<form action="BookSessionServlet" method="Post">
			<h2 class="center" style="color: black">
				<b>Book a Session</b>
			</h2>
			<input type="text" id="myInput" onkeyup="myFunction()"
				placeholder="Search for course.." title="Type in a course">
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
					<%-- Arranging data in tabular form 
        --%>
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
					style="background-color: #4CAF50; color: white; padding: 8px 20px; margin: 8px 0; border: none; cursor: pointer; width: auto; font-size: 16px"
					value="Submit">
			</div>
		</form>
		<button onclick="goBack()" style = "margin-left: 20px">Go Back</button>
	<script>
		function myFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[2];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>
