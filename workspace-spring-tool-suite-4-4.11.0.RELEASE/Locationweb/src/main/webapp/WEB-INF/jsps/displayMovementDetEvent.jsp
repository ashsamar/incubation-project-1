<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h2 align = "center">Available Movement Events:</h2>
<table width = 100% height = 400 border = "5" align = "center">
<tr>
<th>ID</th>

<th>CLIENT ID</th>

<th>EACH CARGO EVENT ID</th>

<th>CARGO EVENT TYPE</th>
<th>RECEIVED DATE</th>
<th>TIMESTAMP</th>

<th>CONFIDENCE</th>

<th>X</th>

<th>Y</th>

<th>Z</th>

<th>WIDTH</th>
<th>DEPTH</th>
<th>HEIGHT</th>



</tr>


<c:forEach items="${allObjects}"  var ="object">
<tr>
<td style="text-align:center">${object.id}</td>


<td style="text-align:center">${clientId}</td>

<td style="text-align:center">${object.eachcargoeventid}</td>

<td style="text-align:center">${object.cargoeventtype}</td>

<td style="text-align:center">${object.receiveddate}</td>

<td style="text-align:center">${object.timestamp}</td>

<td style="text-align:center">${object.confidence}</td>



<td style="text-align:center">${object.x}</td>

<td style="text-align:center">${object.y}</td>

<td style="text-align:center">${object.z}</td>


<td style="text-align:center">${object.width}</td>

<td style="text-align:center">${object.depth}</td>

<td style="text-align:center">${object.height}</td>





<td style="text-align:center"> <a href="displayObjects">
         <img alt="click here" src="/Downloads/enterkeyimage.png" width=50" height="70"></a></td>


</tr>


</c:forEach>

</table>

<a href ="showCreateClient">Create Client </a>
<a href ="generateReport">Generate Report </a>

</body>
</html>