<%@page import="ApplicationModel.Tutor_Application"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ApplicationModel.Classroom"%>

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
	background-image: url(aus_campus.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<div class="container">
		<form action='ProcessRequestServlet' method="Post">
		 <%Tutor_Application apply =  (Tutor_Application)request.getAttribute("application"); %> 
		<label for="Grades">Tutor Application: <%=apply.getSTUDENT_NAME()%></label>
			<div class="row">
				<div class="col-25">
				</div>
				<div class="col-75">
				<%
				 ArrayList<String> courses =  apply.getCOURSES();
		         ArrayList<String> grades = apply.getGRADES();
		        
		        for (int i = 0; i < courses.size(); i++){
					%>
					<label><%=courses.get(i)%></label>
					<input type="text"  name="grades"  value="<%=grades.get(i)%>" readonly><br>
					<%
						}
					%>
				</div>
			</div>
			&nbsp;&nbsp;
			<div class="row">
				<div class="col-25">
					<label for="Academic">Standing:</label>
				</div>
				<div class="col-75">
					<input type="text"
						name = "academic" value="<%=apply.getACADEMIC_STANDING()%>"readonly><br>
				</div>
			</div>
			<div class="row w3-center">
				<input type="submit" value="Approve" name="accept">
				<input type="submit" style = "background-color: red" value="Reject" name="reject">
			</div>
		</form>
	</div>

</body>
</html>
