<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO  SALE-ORDER VIEW PAGE</h3>

 <a href="excel?id=${ob.saleId }">Excel Export</a> <br/>
 <a href="pdf?id=${ob.saleId }">PDF Export</a> <br/><br/>
<table border="1">

  <tr>
    <th>SALE ID</th> <td>${ob.saleId }</td>
  </tr>
   <tr>
    <th>ORD-CODE</th> <td>${ob.ordCode }</td>
   </tr>
   <tr>
    <th>SHIP CODE</th> <td>${ob.shipCode}</td>
   </tr>
   <tr>
    <th>CUSTOMER</th> <td>${ob.customer }</td>
   </tr>
   <tr>
    <th>REF-NO</th> <td>${ob.refNum }</td>
   </tr>
   <tr>
    <th>ST-MOD</th> <td>${ob.stMode }</td>
  </tr>
   <tr>
    <th>ST-SRC</th> <td>${ob.stSource }</td>
  </tr>
   <tr>
    <th>STATUS</th> <td>${ob.status }</td>
  </tr>
   <tr>
    <th>DESCRIPTION</th> <td>${ob.saleDesc }</td>
  </tr>
</table>


</body>
</html>