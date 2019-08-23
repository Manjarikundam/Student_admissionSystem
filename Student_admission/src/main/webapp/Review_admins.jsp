<%@ page import="java.sql.*,java.util.*,com.Bean.*, javax.ws.rs.client.Client,
 javax.ws.rs.client.ClientBuilder,
 javax.ws.rs.client.Entity,
 javax.ws.rs.client.Invocation,
 javax.ws.rs.client.WebTarget,
 javax.ws.rs.core.MediaType,
 javax.ws.rs.core.Response,com.DAO.*,org.glassfish.jersey.client.ClientConfig"
 language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <th>college code</th>
                    <th>college name</th>
                    <th>Admin name</th>
				</tr>
			</thead>
			
			
			
			<%
			ArrayList<ClgadminBean> cadlist = (ArrayList<ClgadminBean>) request.getAttribute("adminreview");
			
			for(ClgadminBean clgbean: cadlist){
				%>
				<tr>

					<td><%= clgbean.getClgcode() %></td>
						<td><%= clgbean.getClgname() %></td>
					<td><%= clgbean.getAdminname() %></td>
				</tr>
				<%
			}
			%>
		
		</table>
	
</body>
</html>

