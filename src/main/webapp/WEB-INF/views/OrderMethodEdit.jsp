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
<h3 style="color: red;text-align: center;">WELCOME TO ORDER METHOD EDIT PAGE!!!</h3>
  <form:form action="update" method="POST" modelAttribute="orderMethod">
    <pre>
    Order Id     :<form:input path="orderId" readonly="true"/>
    Order Mode   :<form:radiobutton path="orderMode" value="Sale"/>SALE
                  <form:radiobutton path="orderMode" value="Purchase"/>PURCHASE
    Order Code   :<form:input path="orderCode"/>
    Order Type :<form:select path="orderType">
                    <form:option value="">-SELECT-</form:option>
                    <form:option value="FIFO">FIFO</form:option>
                    <form:option value="LIFO">LIFO</form:option>
                    <form:option value="FCFO">FCFO</form:option>
                    <form:option value="FEFO">FEFO</form:option>
                  </form:select>
    Order Accept :<form:checkbox path="orderAccpt" value="Multi-Model"/>MULTI-MODEL
                  <form:checkbox path="orderAccpt" value="Accept Return"/>ACCEPT RETURN
    Description  :<form:textarea path="description"/>
              <input type="submit" value="UPDATE"/>
    </pre>
  </form:form>
</body>
</html>