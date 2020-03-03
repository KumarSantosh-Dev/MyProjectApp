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
	<h3>WELCOME TO  GRN REGISTER PAGE!!!</h3>
	
	<form:form action="save" method="POST" modelAttribute="gRN">
	 <pre>
	  GRN CODE    :<form:input path="grnCode"/>
	  GRN TYPE    :<form:input path="grnType"/>
	  ORDER CODE  :<form:select path="ordCode"></form:select>
	  DESCRIPTION :<form:textarea path="grnDesc"/>
	            <input type="submit" value="CREATE GRN"/>
	 </pre>
	</form:form>
	
     ${message}
</body>
</html>