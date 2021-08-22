<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create client</title>

<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>


<style type="text/css">

table td {
   // width:300px;
    height:200px;
    text-align:center;
    vertical-align:middle;
    background-color:#ccc;
    border:1px solid #fff;
}
table td.highlighted {
    background-color:#999;
}
</style>



<!-- For three.js  -->
<script src="js/three.js"></script>
    <script src="GLTFLoader.js"></script>
    <script src="OrbitControls.js"></script>

 
<!-- For D3 design -->


  <script src="https://d3js.org/d3.v7.min.js"></script>  
 
 

</head>
<body style = "background-color:lightblue">


<script src="js/three.js"></script>


<div class="game-wrapper"></div>

 
<script type="text/javascript">


$(document).ready(function () {

    init();

    registerEvents();

});


var isMouseDown = false;
var isHighlighted;

var startCell;
var currentCell;


function init() {
    buildTable(10);
}




function registerEvents() {


    $("#our_table td").on('mousedown', function () {

        isMouseDown = true;

        startCell = getCellPosition($(this));

        highlightCells(startCell, startCell);

        //$(this).toggleClass("highlighted");
        //isHighlighted = $(this).hasClass("highlighted");

        return false; // prevent text selection

    }).on('mouseover', function () {

        if (isMouseDown) {

            currentCell = getCellPosition($(this));

            highlightCells(startCell, currentCell);

            //$(this).toggleClass("highlighted", isHighlighted);
        }

    }).on('selectstart', function () {
        return false;
    });


    $(document)
        .mouseup(function () {
        isMouseDown = false;
    });

}




function highlightCells(start, end) {

    var fromRow = Math.min(start.row, end.row);
    var toRow = Math.max(start.row, end.row);

    var fromCol = Math.min(start.col, end.col);
    var toCol = Math.max(start.col, end.col);


    console.log('fromRow ' + fromRow + ' toRow ' + toRow);
    console.log('fromCol ' + fromCol + ' toCol ' + toCol);


    clearHighlight();

    for (i = fromRow; i <= toRow; i++) {
        for (j = fromCol; j <= toCol; j++) {
            $('td[data-row="' + i + '"][data-col="' + j + '"]').addClass('highlighted');
        }

    }
}

function clearHighlight() {
    $('td').removeClass('highlighted');
}


function getCellPosition($cell) {
    var cell = {
    
        row: $cell.data('row'),
  
        col: $cell.data('col')
    }
    return cell;
}

function buildTable(size) {
    var tableHtml = '';
    tableHtml = '<table style="height:800px" cellpadding="0" cellspacing="0" id="our_table">';
    var x = 2;var y= 3;
    
    
    
        for (i = 28; i <29; i++ ) {
    	       tableHtml += '<tr>';
    	       for (j = 4; j < 5;j++) {
    	           tableHtml += '<td style="height:70px;width:70px" data-row="' + i + '" data-col="' + j + '">[' + i + ',' + j + ']</td>';
    	       }
    	       tableHtml += '</tr>';
    	    }
    
    
    
    
    
    
    
 //   for (i = 26; i <29; i++ ) {
 //       tableHtml += '<tr>';
 //       for (j = 3; j < 5;j++) {
 //           tableHtml += '<td style="height:70px;width:70px" data-row="' + i + '" data-col="' + j + '">[' + i + ',' + j + ']</td>';
 //       }
 //       tableHtml += '</tr>';
 //   }
    tableHtml += '</table>';
    $('.game-wrapper').html(tableHtml);
}


</script>

       
 
 
  

  </body>
</html>
