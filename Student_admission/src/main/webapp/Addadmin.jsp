<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
#an{
align:center;

}
td{
padding:10px;
border:none;
}
#f2{
width:400px;
height:450px;
background-color:lightgrey;
}

</style>
</head>
<body>

<CENTER><fieldset id="f2">
<h1>ADD ADMIN</h1>
<form action="uniadmin?varname=add_admins" method="post">

<table>
<tr>
<td>college code:<input type="text" name="clgcode"></td>
<td>college_name:<input type="text" name="clgname"></td>
</tr>


<tr>
<td>admin_name:<input type="text" name="adminname"></td>
</tr>

<tr>
<td></td>

<td><input type="submit" value="APPLY"></td> 
 </tr>

</table>


</form>
</center>
</fieldset>
</CENTER>
</body>
</html>