<%@ page
	import="java.sql.*,java.util.*,javax.ws.rs.client.Client,com.Bean.*,
javax.ws.rs.client.ClientBuilder,
javax.ws.rs.client.Entity,
javax.ws.rs.client.Invocation,
javax.ws.rs.client.WebTarget,
javax.ws.rs.core.MediaType,
javax.ws.rs.core.Response,com.Bean.*,org.glassfish.jersey.client.ClientConfig"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESULT</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
}

h1 {
	text-align: center;
	view_grad color: black
}
</style>
<body bgcolor="#a3a3a3">
	<h1>RESULT</h1>
	<br>
	<br>
	<form method="post">
		<table border="1" align="center">
			<thead>
				<tr>

					<th>appliant_no</th>
					<th>name</th>
					<th>dept_choice</th>
					<th>college_choice</th>
					<th>status</th>
				</tr>
			</thead>


			<%
				ArrayList<ApplicationBean> list = (ArrayList<ApplicationBean>) request.getAttribute("view_details");
				for (ApplicationBean applicationbean : list) {
			%>
			<tr>

				<td><%=applicationbean.getApplicant_no()%></td>
				<td><%=applicationbean.getName()%></td>
				<td><%=applicationbean.getDept_choice()%></td>
				<td><%=applicationbean.getCollege_ch1()%></td>
				<td><%=applicationbean.getStatus()%></td>
				
			</tr>
			<%
				}
			%>

		</table>
</body>
</html>