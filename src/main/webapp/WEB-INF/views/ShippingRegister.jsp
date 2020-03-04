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
  <div class="container">
   <div class="card">
   
    <div class="card-header">
       <h3>WELCOME TO SHIPPING REGISTER PAGE!!!</h3>
    </div><!-- End Card-Header -->
    <div class="card-body">
      <form:form action="save" method="post" modelAttribute="shipping">
       <div class="row">
          <div class="col-4">
           <label for="shpCode"> SHIPPING CODE</label> 
          </div>
          <div class="col-4">
            <form:input path="shpCode"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 1 Row -->
       
       <div class="row">
          <div class="col-4">
            <label for="shpRefNo">SHIPPING REF NUM</label>
          </div>
          <div class="col-4">
            <form:input path="shpRefNo"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 2 Row -->
       
       <div class="row">
          <div class="col-4">
            <label for="corirRefNo">COURIER REF NUM</label>
          </div>
          <div class="col-4">
            <form:input path="corirRefNo"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 3 Row -->
       
       <div class="row">
          <div class="col-4">
            <label for="contactDtls">CONTACT DETAILS</label>
          </div>
          <div class="col-4">
            <form:textarea path="contactDtls"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 4 Row -->
       
       <div class="row">
          <div class="col-4">
            <label for="slOrdCode">SALE ORDER CODE</label>
          </div>
          <div class="col-4">
             <form:input path="slOrdCode"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 5 Row -->
       
       <div class="row">
          <div class="col-4">
            <label for="description">DESCRIPTION</label>
          </div>
          <div class="col-4">
              <form:textarea path="description"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 6 Row -->
       
       <div class="row">
          <div class="col-4">
            <label for="blToAddrs">BILL TO ADDRESS</label>
          </div>
          <div class="col-4">
              <form:textarea path="blToAddrs"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 7 Row -->
       
       <div class="row">
          <div class="col-4">
            <label for="shpToAddrs">SHIP TO ADDRESS</label>
          </div>
          <div class="col-4">
              <form:textarea path="shpToAddrs"/>
          </div>
          <div class="col-4"></div>
       </div><!-- 8 Row -->
       
       <div class="row">
          <div class="col-4"></div>
          <div class="col-4">
              <input type="submit" value="CREATE SHIPPING">
          </div>
          <div class="col-4"></div>
       </div><!-- 9 button Row -->
       
     </form:form>  
    </div><!-- End Card-Body -->
    
    <div class="card-footer">
    
    </div><!-- End Card-Footer -->
   </div><!-- End Card -->
  </div><!-- End Container -->
  

</body>
</html>