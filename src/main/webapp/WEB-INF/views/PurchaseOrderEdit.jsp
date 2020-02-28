<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>WELCOME TO PURCHASE ORDER EDIT PAGE!!!</h3>
 
 <form:form action="update" method="post" modelAttribute="purchaseOrder">
   <pre>
     ORDER ID       :<form:input path="orderId"/>
     ORDER CODE     :<form:input path="orderCode"/>
     SHIPMENT CODE  :<form:select path="shipCode">
                       <form:option value=""></form:option>
                     </form:select>
     VENDOR         :<form:select path="vendor">
                       <form:option value=""></form:option>
                    </form:select>
     RFERENCE NUMBER:<form:input path="refNumber"/>
     QUALITY CHECK  :<form:radiobutton path="qltyCheck" value="Required"/>Required
                     <form:radiobutton path="qltyCheck" value="Not Required"/>Not Required
     DEFAULT STATUS :<form:input path="defStatus"/>
     DESCRIPTION    :<form:textarea path="description"></form:textarea>
          <input type="submit" value="UPDATE"/>
   </pre>
 </form:form>

</body>
</html>