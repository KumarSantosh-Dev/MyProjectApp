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
	<h3>WELCOME TO UOM DATA PAGE!!!</h3>
	<a href="excel"><img  src="../resources/images/excel.png" width="100" height="60"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="pdf"><img  src="../resources/images/pdf.png" width="100" height="60"></a>  
    <br/><br/>
  <c:choose>
    <c:when test="${!empty list }">
	<table border="1">
       <tr>
         <th>UOM ID</th>
         <th>UOM TYPE</th>
         <th>UOM MODEL</th>
         <th>DESCRIPTION</th>
         <th colspan="2">OPERATION</th>
       </tr>
    
     <c:forEach items="${list }" var="ob">       
       <tr>
         <td>${ob. uomId}</td>
         <td>${ob. uomType}</td>
         <td>${ob. uomModel}</td>
         <td>${ob. uomDesc}</td>
         <td>
            <a href="delete?uid=${ob. uomId}">
             <img  src="../resources/images/delete.png" width="30" height="30">
            </a>
         </td>
         <td>
            <a href="edit?uid=${ob.uomId }">
             <img  src="../resources/images/edit.jpg" width="30" height="30">
            </a>
         </td>
         <td>
            <a href="view?uid=${ob.uomId }">
             <img  src="../resources/images/view.jpg" width="30" height="30">
            </a>
         </td>
       </tr>
     </c:forEach>
     
	</table>
   </c:when>
   <c:otherwise>
      <h3 style="color: red;">NO DATA UOM FOUND</h3>
   </c:otherwise>
  </c:choose>
	${message }
</body>
</html>