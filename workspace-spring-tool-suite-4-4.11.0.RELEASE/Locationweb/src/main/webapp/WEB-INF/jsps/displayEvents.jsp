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

<h2 align = "center">Available Events:</h2>
<table width = 50% height = 400 border = "5" align = "center">
<tr>
<th>ID</th>

<th>CLIENT ID</th>

<th>EVENTS TYPES</th>

<th>RECEIVED DATE</th>

<th>TIMESSTAMP</th>

</tr>


<c:forEach items="${allEvents}"  var ="event">
<tr>
<td style="text-align:center">${event.id}</td>

<td style="text-align:center">${clientId}</td>

<td style="text-align:center">${event.eventsid}</td>

<td style="text-align:center">${event.date}</td>

<td style="text-align:center">${event.timestamp}</td>

 
<c:choose>
    <c:when test ="${event.id == '1'}">
        
        <td style="text-align:center"> <a href="displayCargoDetecEvent?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>
        
        
    </c:when>
    
     <c:when test ="${event.id == '2'}">
        
        <td style="text-align:center"> <a href="displayDoorDetEvent?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>
        
        
    </c:when>
    
    <c:otherwise>
        <td style="text-align:center"> <a href="displayMovementDetEvent?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>
        
    </c:otherwise>
</c:choose>









</tr>


</c:forEach>

</table>

<a href ="showCreateClient">Create Client </a>
<a href ="generateReport">Generate Report </a>

</body>
</html>