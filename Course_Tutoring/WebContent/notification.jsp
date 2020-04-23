<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<style>
* {
	box-sizing: border-box;
}

.center {
	display: block;
	margin-left: 40%;
	margin-right: auto;
	max-width: 60%;
}

#myInput {
	width: 100%;
	font-size: 16px;
	padding: 12px 20px 12px 20px;
	border: 1px solid #ddd;
	margin-bottom: 10px;
}

body {
	background-image: url(AUS-campus.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}

#myTable {
	border-collapse: collapse;
	width: 100%;
	border: 1px solid #ddd;
	font-size: 16px;
}

#myTable th, #myTable td {
	text-align: left;
	padding: 12px;
}

#myTable tr {
	border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
	background-color: #f1f1f1;
}
</style>
</head>
<body>

	<h2 class="w3-center">
		<b>Notification DashBoard</b>
	</h2>
	<%
		ArrayList<String> listnotification = (ArrayList<String>) request.getAttribute("notification");
		for (String s : listnotification) {
	%>
	<div class="alert alert-info alert-dismissible">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<strong>Information!</strong>
		<%=s%>
	</div>
	<%
		}
	%>
	<div class="w3-center container">
		<button onclick="goBack()">Go Back</button>
	</div>
<script>
	function goBack() {
	window.history.back();
</script>
</body>
</html>
