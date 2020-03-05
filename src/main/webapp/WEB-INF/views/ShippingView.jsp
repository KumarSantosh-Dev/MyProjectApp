<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO  SHIPPING VIEW PAGE</h3>

 <a href="excel?id=${ob.shpId }">Excel Export</a> <br/>
 <a href="pdf?id=${ob.shpId }">PDF Export</a> <br/><br/>
<table border="1">

  <tr>
    <th>ID</th> <td>${ob.shpId }</td>
  </tr>
   <tr>
    <th>SHP CODE</th> <td>${ob.shpCode }</td>
   </tr>
   <tr>
    <th>SHP REF NO</th> <td>${ob.shpRefNo}</td>
   </tr>
   <tr>
    <th>COR REF NO</th> <td>${ob.corirRefNo }</td>
   </tr>
   <tr>
    <th>CNTCT DTLS</th> <td>${ob.contactDtls }</td>
   </tr>
   <tr>
    <th>SL ORD COD</th> <td>${ob.slOrdCode }</td>
  </tr>
   <tr>
    <th>NOTE</th> <td>${ob.description }</td>
  </tr>
   <tr>
    <th>BL TO ADDRS</th> <td>${ob.blToAddrs }</td>
  </tr>
  <tr>
    <th>SL TO ADDRS</th> <td>${ob.shpToAddrs }</td>
  </tr>
  
</table>


</body>
</html>