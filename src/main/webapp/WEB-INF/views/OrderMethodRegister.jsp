<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%@include file="UserMenu.jsp" %>
 <div class="container">
    <div class="card">
      
      <div class="card-header bg-primary text-center text-white text-uppercase">
         <h3 style="color: red;text-align: center;">WELCOME TO ORDER METHOD PAGE!!!</h3>
      </div> <!-- End card-Header -->
      
      <div class="card-body">
        <form:form action="save" method="POST" modelAttribute="orderMethod">
         <div class="row">
           <div class="col-4">
             <label for="orderMode">Order Mode</label>
           </div>
           <div class="col-4">
             <form:radiobutton path="orderMode" value="Sale" />SALE
             <form:radiobutton path="orderMode" value="Purchase" />PURCHASE
           </div>
           <div class="col-4">
           </div>
         </div> <!-- One row -->
         
         <div class="row">
           <div class="col-4">
             <label for="orderCode">Order Code  </label>
           </div>
           <div class="col-4">
              <form:input path="orderCode" class="form-control"/>
           </div>
           <div class="col-4">
           </div>
         </div> <!-- Second row -->
         
         <div class="row">
           <div class="col-4">
             <label for="orderType">Order Type</label>
           </div>
           <div class="col-4">
                 <form:select path="orderType" class="form-control">
                    <form:option value="">-SELECT-</form:option>
                    <form:option value="FIFO">FIFO</form:option>
                    <form:option value="LIFO">LIFO</form:option>
                    <form:option value="FCFO">FCFO</form:option>
                    <form:option value="FEFO">FEFO</form:option>
                  </form:select>
           </div>
           <div class="col-4">
           </div>
         </div> <!-- Third row -->
         
         <div class="row">
           <div class="col-4">
             <label for="orderAccpt">Order Accept</label>
           </div>
           <div class="col-4">
              <form:checkbox path="orderAccpt" value="Multi-Model" />MULTI-MODEL
              <form:checkbox path="orderAccpt" value="Accept Return" />ACCEPT RETURN
           </div>
           <div class="col-4">
           </div>
         </div> <!-- Four row -->
         
         <div class="row">
           <div class="col-4">
             <label for="description"> Description</label>
           </div>
           <div class="col-4">
             <form:textarea path="description" class="form-control"/>
           </div>
           <div class="col-4">
           </div>
         </div> <!-- Five row -->
         
          <div class="row">
           <div class="col-4">
             <label for=""></label>
           </div>
           <div class="col-4">
              <input type="submit" value="CREATE ORDER METHOD" class="btn btn-success"/>
           </div>
           <div class="col-4">
           </div>
         </div> <!-- SIX row -->
         
       </form:form> 
      </div> <!-- End card-body -->
      
      <c:if test="${!empty message }">
       <div class="card-footer bg-info text-white text-center">
         ${message}
       </div> <!-- End card-footer -->
      </c:if>
    </div> <!-- Card End --> 
  </div> <!-- End Container -->
</body>
</html>