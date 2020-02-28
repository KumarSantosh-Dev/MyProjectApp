<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO ORDER METHOD VIEW PAGE!!!</h3>

<a href="excel?id=${om. orderId} ">Excel Export</a> <br/>
 <a href="pdf?id=${om. orderId} ">PDF Export</a> <br/><br/>

 <table border="1">
    <tr>
      <th>ID</th> <td>${om. orderId} </td>
    </tr>
   
    <tr>
      <th>MODE</th> <td>${om. orderMode} </td>
    </tr>
   
    <tr>
      <th>CODE</th> <td>${om. orderCode} </td>
    </tr>
   
    <tr>
      <th>TYPE</th> <td>${om. orderType} </td>
    </tr>
   
    <tr>
      <th>ACCEPT</th> <td>${om. orderAccpt} </td>
    </tr>
   
    <tr>
      <th>DESCRIPTION</th> <td>${om. description} </td>
    </tr>
    </table>

</body>
</html>