<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style = "background-color:lightblue">

<style type = "css/text">
input
{

 outline : none; border: none ;padding 10px;
}

</style>

<h2 align = "center">Details:</h2>
<table width = 50% height = 400 border = "5" align = "center">
<tr>
<th>ID</th>

<th>NAME</th>

</tr>


<c:forEach items="${allLocations}"  var ="location">
<tr>
//<td style="text-align:center">${location.id}</td>

<td style="text-align:center">${location.name}</td>


</tr>


</c:forEach>

</table>

<a href ="showCreate">Create Client </a>
<a href ="generateReport">Generate Report </a>

</body>
</html>