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
<th>CODE</th>
<th>NAME</th>
<th>TYPE</th>
<th>DELETE</th>
<th>UPDATE</th>

</tr>


<c:forEach items="${allLocations}"  var ="location">
<tr>
//<td style="text-align:center">${location.id}</td>
//<td style="text-align:center">${location.code}</td>
<td style="text-align:center">${location.name}</td>
//<td style="text-align:center">${location.type}</td>
//<td style="text-align:center"><a href ="deleteLocation?id=${location.id}">delete</a></td>
//<td   style="text-align:center" colspan="2"><a href ="showUpdate?id=${location.id}">update</a></td>

</tr>


</c:forEach>

</table>

<a href ="showCreate">Create Locations </a>
<a href ="generateReport">Generate Report </a>

</body>
</html>