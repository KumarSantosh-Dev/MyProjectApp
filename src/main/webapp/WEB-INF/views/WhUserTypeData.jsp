<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color: blue;text-align: ">WELCOME TO WHUSER TYPE DATA PAGE</h3>
<a href="excel"><img  src="../resources/images/excel.png" width="100" height="60"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="pdf"><img  src="../resources/images/pdf.png" width="100" height="60"></a>  
    <br/><br/>
 <c:choose>
  <c:when test="${!empty list }">
   <table border="1">
  
     <tr>
        <th>USER ID</th>
        <th>USER TYPE</th>
        <th>USER CODE</th>
        <th>USER FOR</th>
        <th>EMAIL</th>
        <th>CONTACT</th>
        <th>ID TYPE</th>
        <th>OTHER ID</th>
        <th>ID NUMBER</th>
        <th colspan="3">OPERATION</th>
     </tr>
     
     <c:forEach items="${list }" var="ob">
        <tr>
          <td>${ob.userId }</td>
          <td>${ob.userType }</td>
          <td>${ob.userCode }</td>
          <td>${ob.userFor }</td>
          <td>${ob.userEmail }</td>
          <td>${ob.userContact }</td>
          <td>${ob.userIdType }</td>
          <td>${ob.otherIdType }</td>
          <td>${ob.idNum }</td>
          <td>
             <a href="delete?uid=${ob.userId }">
               <img  src="../resources/images/delete.png" width="30" height="30">
             </a>
          </td>
          <td>
            <a href="edit?uid=${ob.userId } ">
              <img  src="../resources/images/edit.jpg" width="30" height="30">
            </a>
          </td>
            <td>
               <a href="view?uid=${ob.userId }">
                <img  src="../resources/images/view.jpg" width="30" height="30">
               </a>
            </td>
        </tr>
     </c:forEach>
   </table>

  ${message }
  </c:when>
  <c:otherwise>
    <h3 style="color: red;">NO WHUSER DATA FOUND</h3>
  </c:otherwise>
 </c:choose>
</body>
</html>