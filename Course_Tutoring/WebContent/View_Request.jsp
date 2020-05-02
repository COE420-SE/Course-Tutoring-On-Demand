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
		<link rel="stylesheet"
	href="https://code.jquery.com/jquery-3.3.1.js">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/searchpanes/1.0.1/css/searchpanes.dataTables.min.css">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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

<h2 class = "center"><b>Session Requests</b></h2>
<table id="myTable" class="table table-white table-bordered compact" style = "width:90%; background-color:white " data-page-length="25" data-order="[[ 1, &quot;asc&quot; ]]">
    <thead>
        <tr style= "background-color:green">
          <th>Student ID</th> 
          <th>Course Name</th> 
            <th>Session Date</th> 
             <th>Type of Session</th> 
              <th>Comment</th> 
        </tr>
    </thead>
    <tbody> 
        <%ArrayList<Session_Requests> listSession =  
            (ArrayList<Session_Requests>)request.getAttribute("request"); 
        for(Session_Requests s:listSession){%> 
        <%-- Arranging data in tabular form 
        --%>
            <tr>  
                <td><%=s.getSTUDENT_ID()%></td> 
                <td><%=s.getCOURSE_ID()%></td> 
                <td><%=s.getDATE()%></td>
                <td><%=s.getTYPE()%></td>
                <td><%=s.getCOMMENT()%></td>
            </tr> 
            <%}%>
            </tbody>
</table>
<button onclick="goBack()" style = "margin-left: 20px">Go Back</button>
<script>
function goBack() {
	  window.history.back();
	}
$(document).ready(function() {
    $('#myTable').DataTable();
} );
</script>

</body>
</html>
