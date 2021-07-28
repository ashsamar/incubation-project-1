<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empty Truck Events</title>
</head>
<body style = "background-color:lightblue">

<style type = "css/text">
input
{

 outline : none; border: none ;padding 10px;
}

</style>

<h2 align = "center">Empty Truck Events:</h2>



<table width = 100% height = 400 border = "5" align = "center">

Filter:<input type="text" name = "keyword" required/>
<tr>
<th>ID</th>

<th>CLIENT ID</th>

<th>EMPTY TRUCK EVENT TYPE</th>
<th>RECEIVED DATE</th>
<th>TIMESTAMP</th>

<th>CONFIDENCE</th>


<th>IMAGES</th>

</tr>


<c:forEach items="${allObjects}"  var ="object">
<tr>
<td style="text-align:center">${object.id}</td>


<td style="text-align:center">${clientId}</td>



<td style="text-align:center">${object.emptytruckdeteventtype}</td>

<td style="text-align:center">${object.receiveddate}</td>

<td style="text-align:center">${object.timestamp}</td>

<td style="text-align:center">${object.confidence}</td>





<td style="text-align:center"><img src="${object.image}" width=10" height="10"></td>




<td style="text-align:center"> <a href="displayObjects">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>


</tr>


</c:forEach>

</table>

<a href ="showCreateClient">Create Client </a>
<a href ="generateReport">Generate Report </a>

</body>
</html>