<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Events</title>
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
     <!-- 
        <td style="text-align:center"> <a href="displayCargoDetecEvent?id=${clientId}">
        <img alt="click here" src="/var/lib/mysql-files/image/enterkeyimage.png" width=50" height="70"></a>-->
        
       <td style="text-align:center"> <button  style=" background-color:red;     height:50px;width:50px "  type="button"  onclick="location.href='/displayCargoDetecEvent?id=${clientId}'">Details!</button>
       
     <button  style=" background-color:blue;    height:50px;width:50px  background-color:red;"    type="button"  onclick="location.href='/displayCargoDetecEventImage?id=${clientId}'">Image!</button>
          
      <button style="background-color:green;    height:50px;width:50px "     type="button"  onclick="location.href='/displayCargoDetecEventPointCloud?id=${clientId}'">3DPC!</button></td>
        
    </c:when>
    
     <c:when test ="${event.id == '2'}">
    
     <!--     
        <td style="text-align:center"> <a href="displayDoorDetEvent1?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>-->
        
        
         <td style="text-align:center"> <button  style=" background-color:red;     height:50px;width:50px "  type="button"  onclick="location.href='/displayDoorDetEvent1?id=${clientId}'">Details!</button>
       
     <button  style=" background-color:blue;    height:50px;width:50px  background-color:red;"    type="button"  onclick="location.href='/displayDoorDetEventImage?id=${clientId}'">Image!</button>
          
      <button style="background-color:green;    height:50px;width:50px "     type="button"  onclick="location.href='/displayDoorDetEventPointCloud?id=${clientId}'">3DPC!</button></td>
        
        
    </c:when>
    
     <c:when test ="${event.id == '3'}">
        <!--
        <td style="text-align:center"> <a href="displayEmptyTruckDetEvent1?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>-->
        
        
         
      <td style="text-align:center"> <button  style=" background-color:red;     height:50px;width:50px "  type="button"  onclick="location.href='/displayEmptyTruckDetEvent1?id=${clientId}'">Details!</button>
       
     <button  style=" background-color:blue;    height:50px;width:50px  background-color:red;"    type="button"  onclick="location.href='/displayEmptyTruckDetEventImage?id=${clientId}'">Image!</button>
          
      <button style="background-color:green;    height:50px;width:50px "     type="button"  onclick="location.href='/displayEmptyTruckDetEventPointCloud?id=${clientId}'">3DPC!</button></td>
        
        
        
    </c:when>
    
    
    
      <c:when test ="${event.id == '4'}">
      <!--  
        
        <td style="text-align:center"> <a href="displayPersonDetEvent1?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>-->
        
        
         
      <td style="text-align:center"> <button  style=" background-color:red;     height:50px;width:50px "  type="button"  onclick="location.href='/displayPersonDetEvent1?id=${clientId}'">Details!</button>
       
     <button  style=" background-color:blue;    height:50px;width:50px  background-color:red;"    type="button"  onclick="location.href='/displayPersonDetEventImage?id=${clientId}'">Image!</button>
          
      <button style="background-color:green;    height:50px;width:50px "     type="button"  onclick="location.href='/displayPersonDetEventPointCloud?id=${clientId}'">3DPC!</button></td>
        
        
    </c:when>
    
    
    
     <c:when test ="${event.id == '5'}">
        
        <!--
        <td style="text-align:center"> <a href="displayAutomaticRecalEvent1?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td> -->
        
        
         
       <td style="text-align:center"> <button  style=" background-color:red;     height:50px;width:50px "  type="button"  onclick="location.href='/displayMovementDetEvent?id=${clientId}'">Details!</button>
       
     <button  style=" background-color:blue;    height:50px;width:50px  background-color:red;"    type="button"  onclick="location.href='/displayMovementDetEventImage?id=${clientId}'">Image!</button>
          
      <button style="background-color:green;    height:50px;width:50px "     type="button"  onclick="location.href='/displayMovementDetEventPointCloud?id=${clientId}'">3DPC!</button></td>
        
        
    </c:when>
    
    
      <c:when test ="${event.id == '6'}">
        
        <!--
        <td style="text-align:center"> <a href="displayAutomaticRecalEvent1?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td> -->
        
        
         
       <td style="text-align:center"> <button  style=" background-color:red;     height:50px;width:50px "  type="button"  onclick="location.href='/displayAutomaticRecalDetEvent1?id=${clientId}'">Details!</button>
       
     <button  style=" background-color:blue;    height:50px;width:50px  background-color:red;"    type="button"  onclick="location.href='/displayAutomaticRecalDetEventImage?id=${clientId}'">Image!</button>
          
      <button style="background-color:green;    height:50px;width:50px "     type="button"  onclick="location.href='/displayAutomaticRecalDetEventPointCloud?id=${clientId}'">3DPC!</button></td>
        
        
    </c:when>
    
    
       
    
     
    
    
    
    <c:otherwise>
    
    <!--  
        <td style="text-align:center"> <a href="displayMovementDetEvent?id=${clientId}">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a>  </td>  -->
         
    
        
    </c:otherwise>
</c:choose>









</tr>


</c:forEach>

</table>

<a href ="showCreateClient">Create Client </a>
<a href ="generateReport">Generate Report </a>

</body>
</html>