<%@page import="ApplicationModel.Session_Detail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	background-image: url(tutor.PNG);
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

<h2 class = "center"><b>Session List</b></h2>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for course.." title="Type in a course">

<table id="myTable" border ="1" width="500" align="center">
         <tr bgcolor="00FF7F"> 
          <th><b>Session ID</b></th> 
          <th><b>Tutor Name</b></th> 
          <th><b>Course Name</b></th> 
           <th><b>Classroom</b></th> 
            <th><b>Session Date</b></th> 
             <th><b>StartTime</b></th> 
              <th><b>EndTime</b></th> 
               <th><b>No of Seats</b></th> 
         </tr> 
         <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <%ArrayList<Session_Detail> listSession =  
            (ArrayList<Session_Detail>)request.getAttribute("session"); 
        for(Session_Detail s:listSession){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.Session_ID%></td> 
                <td><%=s.Tutor_Name%></td> 
                <td><%=s.Course_Name()%></td> 
                <td><%=s.Classroom_ID%></td> 
                <td><%=s.date_of_session%></td>
                 <td><%=s.start_time%></td>
                 <td><%=s.end_time%></td>
                 <td><%=s.end_time%></td>
            </tr> 
            <%}%>
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
    td = tr[i].getElementsByTagName("td")[0];
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
</script>

</body>
</html>
