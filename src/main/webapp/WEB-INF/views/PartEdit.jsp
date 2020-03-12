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
	<h3>WELCOME TO  PART EDIT PAGE!!!</h3>
	
	<form:form action="update" method="POST" modelAttribute="part">
	 <pre>
	PART ID         :<form:input path="partId" readonly="true"/>
	PART CODE       :<form:input path="partCode"/>
	DIMENSION       :
	              W:  <form:input path="weight" />
	              L:  <form:input path="length" />
	              H:  <form:input path="height" />
	BASE COST       :<form:input path="bCost"/>
	BASE CURRENCY   :<form:select path="baseCurrency">
	                   <form:option value="">-SELECT-</form:option>
	                   <form:option value="inr">INR</form:option>
	                   <form:option value="usd">USD</form:option>
	                   <form:option value="aus">AUS</form:option>
	                   <form:option value="eru">ERU</form:option>
	                 </form:select>
	 
	 <!-- MODULE INTGRATION REQUIRED HERE  -->                
	UOM             :<form:select path="uomOb.uomId">
	                   <form:option value="">-SELECT-</form:option>
	                   <form:options items="${uomMap}"/>
	                 </form:select>
	
	ORDERMETHOD CODE:<form:select path="omSaleOb.orderId">
	                   <form:option value="">-SELECT-</form:option>
	                   <form:options items="${orderSaleMap}"/>
	                 </form:select>
	                 
	                 <form:select path="omPurchaseOb.orderId">
	                   <form:option value="">-SELECT-</form:option>
	                   <form:options items="${orderPurchaseMap}"/>
	                 </form:select>
	Description     :<form:textarea path="description"/>
	            <input type="submit" value="UPDATE"/>
	 </pre>
	</form:form>
	
</body>
</html>