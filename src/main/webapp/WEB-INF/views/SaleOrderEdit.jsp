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
	<h3>WELCOME TO  SALE-ORDER EDIT PAGE!!!</h3>
	
	<form:form action="update" method="POST" modelAttribute="saleOrder">
	 <pre>
	  SALE ID        :<form:input path="saleId"/>
	  ORDER CODE     :<form:input path="ordCode"/>
	  SHIPMENT CODE  :<form:select path="shipCode.shipId">
	                    <form:option value="">-SELECT-</form:option>
	                    <form:options items="${shipmentMap }"/>
	                  </form:select>
	  CUSTOMER       :<form:select path="customer.userId">
	                     <form:option value="">-SELECT-</form:option>
	                     <form:options items="${custMap }"/>
	                  </form:select>
	  REF NUMBER     :<form:input path="refNum"/>
	  STOCK MODE     :<form:radiobutton path="stMode" value="grade"/>GRADE
	                  <form:radiobutton path="stMode" value="margin"/>MARGIN
	  STOCK SOURCE   :<form:select path="stSource">
	                    <form:option value="">-SELECT-</form:option>
	                    <form:option value="open">OPEN</form:option>
	                    <form:option value="avail">AVAIL</form:option>
	                    <form:option value="refund">REFUND</form:option>
	                  </form:select>
	  DEFAULT STATUS :<form:input path="status" readonly="true"/>
	  Description    :<form:textarea path="saleDesc"/>
	            
	            <input type="submit" value="UPDATE SALE ORDER"/>
	 </pre>
	</form:form>
</body>
</html>