<%@ page import="java.sql.*,java.util.*,com.Bean.*,com.DAO.*,javax.ws.rs.client.*,javax.ws.rs.core.Response,javax.ws.rs.core.MediaType,org.glassfish.jersey.client.ClientConfig"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of employees</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
	background-color: powderblue;
}

h1 {
	text-align: center;
	color: Tomato
}
</style>
<body>
	<h1>confirm </h1>
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
					<th>college_choice</th>
					<th>status</th>
				</tr>
			</thead>
			
			
	
			<%
			
			ArrayList<ApplicationBean> reviewlist = (ArrayList<ApplicationBean>) request.getAttribute("confirm");
	          
	        	   for(ApplicationBean dept: reviewlist){
	   				%>
	   				<tr>
                        <td><%=dept.getApplicant_no() %></td> 
	   					<td><%= dept.getName()%></td>
	   				    <td><%= dept.getPercentage()%></td>
	   					<td><%= dept.getDept_choice()%></td>
	   					<td><%= dept.getCollege_ch1()%></td>
	   					<td><%= dept.getStatus()%></td>
	   					<td><a href="SubadminServlet?varname=accept&name=<%=dept.getName()%>&applicant_no=<%=dept.getApplicant_no()%>&percentage=<%=dept.getPercentage()%>&dept_choice=<%=dept.getDept_choice()%>&college_ch1=<%=dept.getCollege_ch1()%>">Accept</a></td>
	   					<td><a href="SubadminServlet?varname=reject&name=<%=dept.getName()%>&applicant_no=<%=dept.getApplicant_no()%>&percentage=<%=dept.getPercentage()%>&dept_choice=<%=dept.getDept_choice()%>&college_ch1=<%=dept.getCollege_ch1()%>">Reject</a></td>
	   				
	   				</tr>
	   				<%
	   			}
	   			%>
	   		
	
		</table>
	</form>
	
</body>
</html>