<%@ page import="java.sql.*,java.util.*,com.Bean.*, javax.ws.rs.client.Client,
 javax.ws.rs.client.ClientBuilder,
 javax.ws.rs.client.Entity,
 javax.ws.rs.client.Invocation,
 javax.ws.rs.client.WebTarget,
 javax.ws.rs.core.MediaType,
 javax.ws.rs.core.Response,com.DAO.*,org.glassfish.jersey.client.ClientConfig"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Applicants</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
	background-color:#95BFC1;
}

h1 {
	text-align: center;
	color: red
}
</style>
<body>
	<h1>Students of selected table  </h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>

                     <th>applicant_no</th>
					<th>name</th>
					<th>percentage</th>
					<th>alloted_dept</th>
					<th>alloted_college</th>
				</tr>
			</thead>
			<%
			ArrayList<Selected_studentsBean> deptList = (ArrayList<Selected_studentsBean>) request.getAttribute("selected_list");
			
			
			for(Selected_studentsBean dept: deptList){
				%>
				<tr>
                    <td><%=dept.getApplicant_no() %></td>
					<td><%= dept.getName()%></td>
					<td><%=dept.getAlloted_dept() %></td>
					<td><%=dept.getPercentage()%></td>
				<td><%= dept.getAlloted_college()%></td>
					
				</tr>
				<%
			}
			%>


		</table>
	
</body>
</html>




