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
	<link rel="stylesheet"
	href="https://cdn.datatables.net/searchpanes/1.0.1/css/searchpanes.dataTables.min.css">
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
body {
	background-image: url(AUS-campus.jpg);
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
.center {
	display: block;
	margin-left: 40%;
	margin-right: auto;
	max-width: 60%;
}
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 80%;
	margin-left: 50px;
}

</style>
</head>
<body>

<h2 class = "center"><b>Display a Session</b></h2>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for course.." title="Type in a course">
<table id="myTable" class="table table-white table-bordered compact" style = "width:90%; background-color:white " data-page-length="25" data-order="[[ 1, &quot;asc&quot; ]]">
    <thead>
        <tr style= "background-color:green">
          <th>Session ID</th> 
          <th>Tutor Name</th> 
          <th>Course Name</th> 
           <th>Classroom</th> 
            <th>Session Date</th> 
             <th>Start Time</th> 
              <th>End Time</th> 
               <th>No of Seats</th>
                <th>Students Attending</th>
                
        </tr>
    </thead>
    <tbody> 
        <%ArrayList<Session_Detail> listSession =  (ArrayList<Session_Detail>)request.getAttribute("session"); 
        for(Session_Detail s:listSession){%> 
        <%-- Arranging data in tabular form 
        --%>
            <tr>  
                 <td><%=s.getSession_ID()%></td>
                <td><%=s.getTutor_Name()%></td> 
                <td><%=s.getCourse_ID()%></td> 
                 <td><%=s.getClassroom_ID()%></td>
                <td><%=s.getDate_of_session()%></td>
                 <td><%=s.getStart_time()%></td>
                  <td><%=s.getEnd_time()%></td>
                   <td><%=s.getMax_Seats()%></td>
                <%ArrayList<String> student = (ArrayList<String>)s.getStudent_names();%>
                 <td>
                 	<%for(String t:student){%> 
                 		<%=t%>
                 <%}%>
                 </td>
            </tr> 
            <%}%>
            </tbody>
</table>
        <div class = "container">
         <button onclick="goBack()">Go Back</button>
         </div>
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
function goBack() {
	  window.history.back();
	}
$(document).ready(function() {
    $('#myTable').DataTable();
} );
</script>

</body>
</html>
