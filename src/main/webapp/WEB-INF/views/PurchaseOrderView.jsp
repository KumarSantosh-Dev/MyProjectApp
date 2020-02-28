<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO SHIPMENT TYPE VIEW PAGE</h3>

 <a href="excel?id=${ob.orderId }">Excel Export</a> <br/>
 <a href="pdf?id=${ob.orderId }">PDF Export</a> <br/><br/>
<table border="1">

  <tr>
    <th>ORDER ID</th> <td>${ob.orderId }</td>
  </tr>
   <tr>
    <th>ORDER CODE</th> <td>${ob.orderCode}</td>
   </tr>
   <tr>
    <th>SHIP CODE</th> <td>${ob.shipCode }</td>
   </tr>
   <tr>
    <th>VENDOR</th> <td>${ob.vendor }</td>
   </tr>
   <tr>
    <th>REF NO</th> <td>${ob.refNumber }</td>
   </tr>
   <tr>
    <th>QLTY CHECK</th> <td>${ob.qltyCheck }</td>
  </tr>
  <tr>
    <th>STATUS</th> <td>${ob.defStatus }</td>
  </tr>
  <tr>
    <th>DESCRIPTION</th> <td>${ob.description }</td>
  </tr>
</table>


</body>
</html>