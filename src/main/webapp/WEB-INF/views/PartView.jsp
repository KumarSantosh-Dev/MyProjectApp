<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO  PART VIEW PAGE</h3>

 <a href="excel?id=${ob.partId }">Excel Export</a> <br/>
 <a href="pdf?id=${ob.partId }">PDF Export</a> <br/><br/>
<table border="1">

  <tr>
    <th>ID</th> <td>${ob.partId }</td>
  </tr>
   <tr>
    <th>CODE</th> <td>${ob.partCode }</td>
   </tr>
   <tr>
    <th>DIMENSION</th> <td>${ob.dimension}</td>
   </tr>
   <tr>
    <th>COST</th> <td>${ob.bCost }</td>
   </tr>
   <tr>
    <th>CURRENCY</th> <td>${ob.baseCurrency }</td>
   </tr>
   <tr>
    <th>UOM</th> <td>${ob.uom }</td>
  </tr>
   <tr>
    <th>OM CODE</th> <td>${ob.omCode }</td>
  </tr>
   <tr>
    <th>NOTE</th> <td>${ob.description }</td>
  </tr>
</table>


</body>
</html>