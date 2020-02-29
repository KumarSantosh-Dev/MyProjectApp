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
	<h3>WELCOME TO  PART REGISTER PAGE!!!</h3>
	
	<form:form action="save" method="POST" modelAttribute="part">
	 <pre>
	PART CODE       :<form:input path="partCode"/>
	DIMENSION       :<form:checkbox path="dimension" value="w"/>W
	                 <form:checkbox path="dimension" value="l"/>L
	                 <form:checkbox path="dimension" value="h"/>H
	BASE COST       :<form:input path="bCost"/>
	BASE CURRENCY   :<form:select path="baseCurrency">
	                   <form:option value="">-SELECT-</form:option>
	                   <form:option value="inr">INR</form:option>
	                   <form:option value="usd">USD</form:option>
	                   <form:option value="aus">AUS</form:option>
	                   <form:option value="eru">ERU</form:option>
	                 </form:select>
	 
	 <!-- MODULE INTGRATION REQUIRED HERE  -->                
	UOM             :<form:select path="uom"></form:select>
	ORDERMETHOD CODE:<form:select path="omCode"></form:select>
	
	Description     :<form:textarea path="description"/>
	            
	            <input type="submit" value="CREATE PART"/>
	 </pre>
	</form:form>
	
     ${message}
</body>
</html>