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
	background-color:#95BFC0;
}

h1 {
	text-align: center;
	color: Tomato
}
</style>
<body>
	<h1>selected studentslist of their choice </h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>

					<th>applicant_no</th>
					<th>name</th>
					<th>percentage</th>
					<th>dept_choice</th>
					<th>alloted_dept</th>
				</tr>
			</thead>
			
			<%
			ArrayList<Selected_studentsBean> deptList = (ArrayList<Selected_studentsBean>) request.getAttribute("studentsOf_their_choice");
			
			for(Selected_studentsBean dept: deptList){
				%>
				<tr>

					
					<td><%=dept.getApplicant_no() %></td>
					<td><%= dept.getName()%></td>
					<td><%= dept.getPercentage()%></td>
					<td><%= dept.getDept_choice()%></td>
					<td><%=dept.getAlloted_dept() %></td>
				</tr>
				<%
			}
			%>
			

			</table>
		
	</body>
	</html>

	
			
			
