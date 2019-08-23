<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.ws.rs.client.*"%>
<%@page import="javax.ws.rs.core.*"%>
<%@page import="org.glassfish.jersey.client.ClientConfig"%>
<%@page import="java.util.*"%>
<%@page import="com.Bean.*"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<style type="text/css">
#an {
	align: center;
}

td {
	padding: 10px;
	border: none;
}

#f2 {
	width: 400px;
	height: 500px;
	background-color: lightgrey;
}
</style>
	<script>
		function ssc() {
			document.getElementById("id3").disabled = true;

		}
		function cbse() {
			document.getElementById("id3").disabled = false;
		}

		function myFunction() {
			var x = document.getElementById("mySelect").options[0].text;
			/* document.getElementById("demo").innerHTML = x;*/
		}
	</script>
</head>
<body>

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
	<CENTER>
		<fieldset id="f2">
			<h1>student application form</h1>
			<form action="Servlett?varname=insert" method="post">

				<table>
					<tr>
						<td>Applicant_no:<input type="text" name="applicant_no"></td>
						<td>name:<input type="text" name="name"></td>
					</tr>

					<tr>
						ssc
						<input onclick="ssc()" type="radio" name="board" value="ssc">
						cbse
						<input onclick="cbse()" type="radio" name="board" value="cbse">

						<td>password:<input type="password" name="password"></td>
						<td>percentage:<input id="id4" type="text" name="percentage"></td>
					</tr>

					<tr>
						<td>gpa:<input id="id3" type="text" name="gpa"></td>
						<td>school_name:<input type="text" name="school_name"></td>
					</tr>
					<tr>
						<td><select name=dept_choice>
								<option value="cse">cse</option>
								<option value="ece">ece</option>
								<option value="it">it</option>
								<option value="mech">mech</option>
						</select></td>
						

						<select name="college_ch1">
							<%
								for (ClgadminBean clgbean : clg_names) {
									out.println("<option value=" + clgbean.getClgname() + ">" + clgbean.getClgname() + "</option>");
								}
							%>
						</select>
					</tr>

					<tr>
						<select name="college_ch2">
							<%
								for (ClgadminBean clgbean : clg_names) {
									out.println("<option value=" + clgbean.getClgname() + ">" + clgbean.getClgname() + "</option>");
								}
							%>
						</select>
						<td><input type="submit" value="APPLY"></td>
					</tr>

				</table>


			</form>
	</center>
	</fieldset>
	</CENTER>
</body>
</html>