
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
		<link rel="stylesheet"
	href="https://code.jquery.com/jquery-3.3.1.js">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
body {
	background-image: url(aus_campus.PNG);
	background-repeat: no-repeat;
	background-size: cover;
}
tfoot input {
        width: 100%;
        padding: 3px;
        box-sizing: border-box;
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
</style>
</head>
<body>

<h2 class = "center"><b>Tutor Applications</b></h2>
<form action="ProcessRequestServlet" method = "Post">
<table id="myTable" class="table table-bordered compact" style = "width:100%; background-color:white" data-page-length="25" data-order="[[ 1, &quot;asc&quot; ]]">
    <thead>
        <tr style= "background-color:green">
          <th>Choose</th> 
          <th>Tutor Name</th> 
        </tr>
    </thead>
    <tbody> 
        <%ArrayList<Tutor_Application> listApplication =  
            (ArrayList<Tutor_Applicatiom>)request.getAttribute("application"); 
        for(Tutor_Application s:listApplication){%> 
        <%-- Arranging data in tabular form 
        --%>
            <tr> 
                <td><input type="radio" name="tutor_id" value=<%=s.getTutor_ID()%> required></td> 
                <td><%=s.getTutor_Name()%></td> 
            </tr> 
            <%}%>
            </tbody>
</table>
        <div class = "container">
        <input type="submit" style="background-color:green; color:white; font-size: 16px" value="Submit">
         <button onclick="goBack()">Go Back</button>
         </div>
</form>
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