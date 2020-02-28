<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO WHUSER TYPE VIEW PAGE</h3>

 <a href="excel?id=${ob.userId }">Excel Export</a> <br/>
 <a href="pdf?id=${ob.userId }">PDF Export</a> <br/><br/>
<table border="1">

  <tr>
    <th>ID</th> <td>${ob.userId }</td>
  </tr>
   <tr>
    <th>TYPE</th> <td>${ob.userType}</td>
   </tr>
   <tr>
    <th>CODE</th> <td>${ob.userCode }</td>
   </tr>
   <tr>
    <th>USER FOR</th> <td>${ob.userFor }</td>
   </tr>
   <tr>
    <th>EMAIL</th> <td>${ob.userEmail }</td>
   </tr>
   <tr>
    <th>CONTACT</th> <td>${ob.userContact }</td>
  </tr>
   <tr>
    <th>ID TYPE</th> <td>${ob.userIdType }</td>
  </tr>
   <tr>
    <th>OTHER ID</th> <td>${ob.otherIdType }</td>
  </tr>
   <tr>
    <th>ID NO</th> <td>${ob.idNum }</td>
  </tr>
</table>


</body>
</html>