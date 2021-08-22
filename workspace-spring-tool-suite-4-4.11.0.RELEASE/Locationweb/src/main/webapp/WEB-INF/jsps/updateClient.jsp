<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>










<title>edit client</title>
</head>
<body>







<h2 align = "center">Edit Client Details:</h2>

<form action="updatedClient" method="POST">

<!-- 

<table width = 50% height = 400  border = 5 border-top: 1em solid transparent align = "center">
        <tbody>
        
        <tr align = "center">
        <td>Id:</td>
        <td><input type="text" name= "id" value = "${client.id}" readonly></td>
        </tr>

      <tr align = "center">
      <td>Name:</td>
      <td><input type="text" name = "name" value = "${client.name}"></td></tr>

      <tr align = "center"> 
      <td>Trailer Configuration:</td>
      <td><input type="text" name= "trailerconfig" value = "${client.trailerconfig}" readonly></td></tr>

      <tr align = "center">
      <td><input type="submit" value = "save"/></td></tr>

     </tbody>
</table>


<!--  
Type:

URBAN: <input type="radio" name ="type" value = "URBAN"  ${location.type=='URBAN'?'Checked':' '} /><br><br>
RURAL: <input type="radio" name = "type" value = "RURAL" ${location.type=='RURAL'?'Checked':' '}  /><br><br>

-->



</form>
<script src="js/three.js"></script>

 -->


<canvas id="grid"></canvas>
<script type="text/javascript">


var drawGrid = function(w, h, id) {
    var canvas = document.getElementById(id);
    var ctx = canvas.getContext('2d');
    ctx.canvas.width  = w;
    ctx.canvas.height = h;


    for (x=3;x<=w;x+=10) {
        for (y=5;y<=h;y+=10) {
            ctx.moveTo(x, 0);
            ctx.lineTo(x, h);
            ctx.stroke();
            ctx.moveTo(0, y);
            ctx.lineTo(w, y);
            ctx.stroke();
        }
    }

    };


    drawGrid(40, 50, "grid");
</script>
 





</body>
</html>