<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="updatedLocation" method="POST">

Id:<input type="text" name= "id" value = "${location.id}" readonly/><br><br>

Code:<input type="text" name = "code" value = "${location.code}"/><br><br>

Name:<input type="text" name = "name" value = "${location.name}"/><br><br>

Type:

URBAN: <input type="radio" name ="type" value = "URBAN"  ${location.type=='URBAN'?'Checked':' '} /><br><br>
RURAL: <input type="radio" name = "type" value = "RURAL" ${location.type=='RURAL'?'Checked':' '}  /><br><br>

<input type="submit" value = "save"/><br><br>

</form>>

</body>
</html>