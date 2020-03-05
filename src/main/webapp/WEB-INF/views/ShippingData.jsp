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
<h3 style="color: red;text-align: center;">WELCOME TO  SHIPPING DATA PAGE!!!</h3>
 <a href="excel"><img  src="../resources/images/excel.png" width="100" height="60"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <a href="pdf"><img  src="../resources/images/pdf.png" width="100" height="60"></a>  
    <br/><br/>
<c:choose>
  <c:when test="${!empty list }">
  <table border="1">
  
     <tr>
     
       <th>ID</th>
       <th>SHP CODE</th>
       <th>SHP REF NO</th>
       <th>COR REF NO</th>
       <th>CNTCT DTLS</th>
       <th>SL ORD CODE</th>
       <th>NOTE</th>
       <th>BL TO ADDRS</th>
       <th>SL TO ADDRS</th>
       <th colspan="3">OPERATION</th>
     </tr>
     
     <c:forEach items="${list}" var="ob">
         
         <tr>
            <td>${ob.shpId }</td>
            <td>${ob.shpCode }</td>
            <td>${ob.shpRefNo }</td>
            <td>${ob.corirRefNo }</td>
            <td>${ob.contactDtls }</td>
            <td>${ob.slOrdCode }</td>
            <td>${ob.description }</td>
            <td>${ob.blToAddrs }</td>
            <td>${ob.shpToAddrs }</td>
            <td>
                <a href="delete?sid=${ob.shpId } ">
                  <img  src="../resources/images/delete.png" width="30" height="30">
                </a>
            </td>
            <td>
                <a href="edit?sid=${ob.shpId } ">
                   <img  src="../resources/images/edit.jpg" width="30" height="30">
                </a>
            </td>
            <td>
               <a href="view?sid=${ob.shpId }">
                  <img  src="../resources/images/view.jpg" width="30" height="30">
               </a>
            </td>
         </tr>
     
     </c:forEach>
     
  </table>
  ${message}
 </c:when>
 <c:otherwise>
       <h2>NO SHIPPING DATA FOUND</h2>
 </c:otherwise>
</c:choose>
</body>
</html>