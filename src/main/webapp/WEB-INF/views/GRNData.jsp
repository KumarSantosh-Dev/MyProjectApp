<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
   <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color: red;text-align: center;">WELCOME TO  GRN DATA PAGE!!!</h3>
 <a href="excel"><img  src="../resources/images/excel.png" width="100" height="60"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="pdf"><img  src="../resources/images/pdf.png" width="100" height="60"></a>  
    <br/><br/>
<c:choose>
  <c:when test="${!empty list }">
  <table border="1">
  
     <tr>
     
       <th>ID</th>
       <th>CODE</th>
       <th>TYPE</th>
       <th>ORD-CODE</th>
       <th>DESCRIPTION</th>
              <th colspan="3">OPERATION</th>
     </tr>
     
     <c:forEach items="${list}" var="ob">
         
         <tr>
            <td>${ob.grnId }</td>
            <td>${ob.grnCode }</td>
            <td>${ob.grnType }</td>
            <td>${ob.ordCode }</td>
            <td>${ob.grnDesc }</td>
            <td>
                <a href="delete?gid=${ob.grnId } ">
                  <img  src="../resources/images/delete.png" width="30" height="30">
                </a>
            </td>
            <td>
                <a href="edit?gid=${ob.grnId } ">
                   <img  src="../resources/images/edit.jpg" width="30" height="30">
                </a>
            </td>
            <td>
               <a href="view?gid=${ob.grnId }">
                  <img  src="../resources/images/view.jpg" width="30" height="30">
               </a>
            </td>
         </tr>
     
     </c:forEach>
     
  </table>
  ${message}
 </c:when>
 <c:otherwise>
       <h2>NO GRN DATA FOUND</h2>
 </c:otherwise>
</c:choose>
</body>
</html>