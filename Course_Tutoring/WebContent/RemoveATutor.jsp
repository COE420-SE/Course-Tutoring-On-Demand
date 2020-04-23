<%@page import="ApplicationModel.Tutor"%>
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
	margin: 0% auto 0% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 90%; /* Could be more or less, depending on screen size */
	height: auto;
}

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
    /* padding-right: 10%; */
    /*padding-left: 25%;*/
    /* margin-right: auto; */
    /* margin-left: auto; */
    align: right;
}
</style>
</head>
<body>
<div class="modal">
<h2 class = "center" style="color: black"><b>Remove a Tutor</b></h2>
<form class = "modal-content" action="RemoveATutorServlet" method = "Post">
<table id="myTable" class="table table-bordered compact" style = "width:100%; background-color:white" data-page-length="25" data-order="[[ 1, &quot;asc&quot; ]]">
    <thead>
        <tr style= "background-color:#4CAF50">
          <th>Choose</th> 
          <th>Tutor ID</th> 
          <th>Tutor Name</th> 
          <th>Tutor Email</th> 
          <th>Tutor Department</th> 
        </tr>
    </thead>
    <tbody> 
        <%ArrayList<Tutor> listTutor =  
            (ArrayList<Tutor>)request.getAttribute("tutor"); 
        for(Tutor s:listTutor){%> 
        <%-- Arranging data in tabular form 
        --%>
            <tr> 
                <td><input type="radio" name="tutor" value=<%=s.getUser_ID()%> required></td> 
                <td><%=s.getUser_name()%></td> 
                <td><%=s.getUser_email()%></td> 
                <td><%=s.getUser_department()%></td> 
            </tr> 
                
            <%}%>
            </tbody>
</table>
        <div class = "container">
        <input type="submit" style="background-color: #4CAF50; color: white;
  padding: 8px 20px;
  margin: 8px 0;
  border: none;
  align: left
  cursor: pointer;
  width: auto; font-size: 16px" value="Submit">
         <button onclick="goBack()" style="background-color: grey; color: black;
  padding: 8px 20px;
  margin: 8px 0;
  border: none;
  align: left
  cursor: pointer;
  width: auto; font-size: 16px">Go Back</button>
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
</div>
</body>
</html>
