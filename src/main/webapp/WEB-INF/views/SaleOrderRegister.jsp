<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO  SALE-ORDER REGISTER PAGE!!!</h3>
	
	<form:form action="save" method="POST" modelAttribute="saleOrder">
	 <pre>
	  ORDER CODE     :<form:input path="ordCode"/>
	  SHIPMENT CODE  :<form:select path="shipCode"></form:select>
	  CUSTOMER       :<form:select path="customer"></form:select>
	  REF NUMBER     :<form:input path="refNum"/>
	  STOCK MODE     :<form:radiobutton path="stMode" value="grade"/>GRADE
	                  <form:radiobutton path="stMode" value="margin"/>MARGIN
	  STOCK SOURCE   :<form:select path="stSource">
	                    <form:option value="">-SELECT-</form:option>
	                    <form:option value="open">OPEN</form:option>
	                    <form:option value="avail">AVAIL</form:option>
	                    <form:option value="refund">REFUND</form:option>
	                  </form:select>
	  DEFAULT STATUS :<form:input path="status"/>
	  Description    :<form:textarea path="saleDesc"/>
	            
	            <input type="submit" value="CREATE SALE ORDER"/>
	 </pre>
	</form:form>
	
     ${message}
</body>
</html>