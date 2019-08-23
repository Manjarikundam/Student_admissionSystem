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
	<h1>List of Applicants </h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>

					<th>applicant_no</th>
					<th>name</th>
					<th>board</th>
					<th>percentage</th>
					<th>gpa</th>
					<th>school_name</th>
					<th>dept_choice</th>
					<th>college_ch1</th>
					<th>college_ch2</th>
				</tr>
			</thead>
			
			
			
			<%
			ArrayList<ApplicationBean> reviewlist = (ArrayList<ApplicationBean>) request.getAttribute("applicantreview");
			
			for(ApplicationBean dept: reviewlist){
				%>
				<tr>

					<td><%= dept.getName()%></td>
					<td><%=dept.getApplicant_no() %></td>
					<td><%= dept.getBoard()%></td>
					<td><%= dept.getPercentage()%></td>
					<td><%= dept.getGpa()%></td>
					<td><%= dept.getSchool_name()%></td>
					<td><%= dept.getDept_choice()%></td>
					<td><%= dept.getCollege_ch1()%></td>
					<td><%= dept.getCollege_ch2()%></td>
				</tr>
				<%
			}
			%>
		
		</table>
	
</body>
</html>




