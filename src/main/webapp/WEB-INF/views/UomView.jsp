<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO UOM VIEW PAGE</h3>

<a href="excel?id=${obj. uomId}">Excel Export</a> <br/>
 <a href="pdf?id=${obj. uomId}">PDF Export</a> <br/><br/>
 
  <table border="1">
    <tr>
      <th>ID</th> <td>${obj. uomId}</td>
    </tr>
   
   
    <tr>
      <th>TYPE</th> <td>${obj. uomType}</td>
    </tr>
    
    <tr>
      <th>MODEL</th> <td>${obj. uomModel}</td>
    </tr>
    
    <tr>
      <th>DESCRIPTION</th> <td>${obj. uomDesc}</td>
    </tr>
  </table>

</body>
</html>