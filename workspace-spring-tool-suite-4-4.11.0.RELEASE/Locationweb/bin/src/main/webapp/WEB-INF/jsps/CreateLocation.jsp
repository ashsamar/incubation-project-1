<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="saveLocation" method="POST">

Id:<input type="text" name= "id"/><br><br>

Code:<input type="text" name = "code"/><br><br>

Name:<input type="text" name = "name"/><br><br>

Type:

URBAN: <input type="radio" name ="type" value = "URBAN"/><br><br>
RURAL: <input type="radio" name = "type" value = "RURAL"/><br><br>

<input type="submit" value = "save"/><br><br>

</form>>

${msg}

</body>
</html>