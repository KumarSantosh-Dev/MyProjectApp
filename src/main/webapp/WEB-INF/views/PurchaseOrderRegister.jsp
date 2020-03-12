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
 <h3>WELCOME TO PURCHASE ORDER REGISTER PAGE!!!</h3>
 
 <form:form action="save" method="post" modelAttribute="purchaseOrder">
   <pre>
     ORDER CODE     :<form:input path="orderCode"/>
     SHIPMENT CODE  :<form:select path="shipCode.shipId">
                        <form:option value="">-SELECT-</form:option>
                        <form:options items="${shipmentMap }"></form:options>
                     </form:select>
     VENDOR         :<form:select path="vendor.userId">
                        <form:option value="">-SELECT-</form:option>
                        <form:options items="${venMap }"/>
                     </form:select>
     RFERENCE NUMBER:<form:input path="refNumber"/>
     QUALITY CHECK  :<form:radiobutton path="qltyCheck" value="Required"/>Required
                     <form:radiobutton path="qltyCheck" value="Not Required"/>Not Required
     DEFAULT STATUS :<form:input path="defStatus" readonly="true"/>
     DESCRIPTION    :<form:textarea path="description"></form:textarea>
          <input type="submit" value="PLACE ORDER"/>
   </pre>
 </form:form>
${message }
</body>
</html>