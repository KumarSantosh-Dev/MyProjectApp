<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO  GRN VIEW PAGE</h3>

 <a href="excel?id=${ob.grnId }">Excel Export</a> <br/>
 <a href="pdf?id=${ob.grnId }">PDF Export</a> <br/><br/>
<table border="1">

  <tr>
    <th>ID</th> <td>${ob.grnId }</td>
  </tr>
   <tr>
    <th>CODE</th> <td>${ob.grnCode }</td>
   </tr>
   <tr>
    <th>TYPE</th> <td>${ob.grnType}</td>
   </tr>
   <tr>
    <th>ORD-CODE</th> <td>${ob.ordCode }</td>
   </tr>
   <tr>
    <th>NOTE</th> <td>${ob.grnDesc }</td>
  </tr>
</table>


</body>
</html>