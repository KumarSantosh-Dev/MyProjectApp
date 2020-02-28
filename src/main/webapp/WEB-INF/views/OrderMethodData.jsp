<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO ORDER METHOD DATA PAGE!!!</h3>

 <a href="excel"><img  src="../resources/images/excel.png" width="100" height="60"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="pdf"><img  src="../resources/images/pdf.png" width="100" height="60"></a>  
    <br/><br/>
 <c:choose>
  <c:when test="${!empty list }">
  <table border="1">
    <tr>
      <th>ID</th>
      <th>MODE</th>
      <th>CODE</th>
      <th>TYPE</th>
      <th>ACCEPT</th>
      <th>DESCRIPTION</th>
      <th colspan="3">OPERATION</th>
    </tr>
    <c:forEach items="${list}" var="ob">
    <tr>
      <td>${ob. orderId}</td>
      <td>${ob. orderMode}</td>
      <td>${ob. orderCode}</td>
      <td>${ob. orderType}</td>
      <td>${ob. orderAccpt}</td>  
      <td>${ob. description}</td>
      <td>
        <a href="delete?oid=${ob. orderId}">
          <img  src="../resources/images/delete.png" width="30" height="30">
        </a>
      </td>
      <td>
        <a href="edit?oid=${ob. orderId}">
         <img  src="../resources/images/edit.jpg" width="30" height="30">
        </a>
      </td>
      <td>
        <a href="view?oid=${ob. orderId}">
         <img  src="../resources/images/view.jpg" width="30" height="30">
        </a>
      </td>
    </tr>
    </c:forEach>
  </table>
  ${message}
  </c:when>
  <c:otherwise>
    <h4 style="color: red">NO ORDER METHOD FOUND</h4>
  </c:otherwise>
 </c:choose>
</body>
</html>