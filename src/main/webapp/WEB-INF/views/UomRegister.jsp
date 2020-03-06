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
        <h3>WELCOME TO UOM REGISTER PAGE</h3>
      </div><!-- End Card Header -->
      
      <div class="card-body">
        <form:form action="save" method="post" modelAttribute="uom" >
        <!-- One Row start -->
        <div class="row">
          <div class="col-4">
            <label for="uomType">UOM TYPE</label>
          </div>
          <div class="col-4">
                <form:select path="uomType" class="form-control">
                  <form:option value="">-SELECT-</form:option>
                  <form:option value="packing">PACKING</form:option>
                  <form:option value="noPacking">NOPACKING</form:option>
                  <form:option value="na">-NA-</form:option>
                </form:select>
          </div>
          <div class="col-4">
             <!-- ERROR MESSAGE -->
          </div>
          </div>
          <!-- One Row End -->
        
          <!-- One Row start -->
          <div class="row">
            <div class="col-4">
              <label for="uomModel">UOM MODEL</label>
            </div>
            <div class="col-4">
              <form:input path="uomModel" class="form-control"/>
            </div>
            <div class="col-4">
              <!-- ERROR MESSAGE -->
            </div>
          </div>
          <!-- One Row End -->
        
          <!-- One Row start -->
          <div class="row">
            <div class="col-4">
              <label for="">DESCRIPTION</label>
            </div>
            <div class="col-4">
              <form:textarea path="uomDesc" class="form-control"/>
            </div>
            <div class="col-4">
              <!-- ERROR MESSAGE -->
            </div>
          </div>
          <!-- One Row End -->
        
           <!-- One Row start -->
          <div class="row">
            <div class="col-4"></div>
            <div class="col-4">
              <input type="submit" value="CREATE UOM" class="btn btn-success"/>
            </div>
            <div class="col-4">
              <!-- ERROR MESSAGE -->
            </div>
          </div>
        <!-- One Row End -->
        </form:form>
      </div><!-- End Card Body -->
      
      <c:if test="${!empty message }">
        <div class="card-footer">
          <b>${message }</b>
        </div><!-- End Card Footer -->
      </c:if>
    </div><!-- End Card -->
   </div><!-- End of Container -->
   
  
</body>
</html>