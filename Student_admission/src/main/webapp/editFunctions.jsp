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
	<%@page import="javax.ws.rs.client.*"%>
<%@page import="javax.ws.rs.core.*"%>
<%@page import="org.glassfish.jersey.client.ClientConfig"%>
<%@page import="java.util.*"%>

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
	<h1>your application has been rejected apply for other college</h1>
	
	<br>
	<br>
	<form action="Servlett?varname=edit" method="post">
	<%
	
		Client client = ClientBuilder.newClient(new ClientConfig());
		String apiURL = "http://localhost:8012/Student_admission/webapi/myresource";
		WebTarget webTarget = client.target(apiURL).path("getclgnames");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		GenericType<ArrayList<ClgadminBean>> gType = new GenericType<ArrayList<ClgadminBean>>() {
		};
		Response clientResponse = invocationBuilder.get();
		ArrayList<ClgadminBean> clg_names = clientResponse.readEntity(gType);
	%>
		<table border="1" align="center">
			<thead>
				<tr>

					<th>appliant_no</th>
					<th>name</th>
					<th>dept_choice</th>
					<th>college_choice</th>
				</tr>
			</thead>
			<%
				ArrayList<ApplicationBean> list = (ArrayList<ApplicationBean>) request.getAttribute("view_details");
				for (ApplicationBean applicationbean : list) {
			%>
			<tr>

				<td><%=applicationbean.getApplicant_no()%></td>
				<td><%=applicationbean.getName()%></td>
			
				<td><select name="dept_choice">
								<option value="cse">cse</option>
								<option value="ece">ece</option>
								<option value="it">it</option>
								<option value="mech">mech</option>
						</select></td>
					
		
				
					<td><select name="college_ch1">
							<%
								for (ClgadminBean clgbean : clg_names) {
									out.println("<option value=" + clgbean.getClgname() + ">" + clgbean.getClgname() + "</option>");
								}
							%>
						</select></td>
					
								
			</tr>
			<%
				}
			%>
<tr>
<td><input type="submit" value="APPLY"></td>
</tr>
		</table>

</body>
</html>