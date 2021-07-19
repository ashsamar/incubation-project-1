<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cargo Details</title>
</head>
<body style = "background-color:lightblue">

<style type = "css/text">
input
{

padding 10px;
}
.btn
{
background-color : lightgray;
width : 50%;
height : 200;
}
</style>



<h2 align = "center">Cargo Details:</h2>

<table width = 50% height = 50% border = "5" align = "center">


<form action="saveClient" method="POST">





<tr><td height = 50>Name:</td><td height = 50><input type="text" name = "name"/></td></tr><br><br>


<tr><td height = 50><input class = "btn" type="submit" value = "save"/></td></tr><br><br>


<tr><td><a href ="displayClients">View All </a></td></tr>
</form>>
</table>
${msg}

</body>
</html>