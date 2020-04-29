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
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
   
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
             <span id="uomTypeError"></span>
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
            <div class="col-2">
              <span id="uomModelError"></span>
            </div>
            <div class="col-2">
              <form:errors path="uomModel" cssClass="text-danger"/>
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
              <span id="uomDescError"></span>
            </div>
          </div>
          <!-- One Row End -->
        
           <!-- One Row start -->
          <div class="row">
            <div class="col-4"></div>
            <div class="col-4">
              <input type="submit" value="CREATE UOM" id="register" class="btn btn-success"/>
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
 
 
 <!-- JQUERY VALIDATION  -->
	<script type="text/javascript">
		$(document).ready(function() {
			//hide error section
			$("#uomDescError").hide();
			$("#uomModelError").hide();
			$("#uomTypeError").hide();

			//define error variable]
			var uomDescError = false;
			var uomModelError = false;
			var uomTypeError = false;

			//define validate function
			function validate_uomType() {
				//read variable
				var val = $("#uomType").val();
				//check val validate or not
				if (val == '') {
					$("#uomTypeError").show();
					$("#uomTypeError").html("Choose One <b> Uom Type</b>");
					$("#uomTypeError").css("color", "red");
					uomTypeError = false;
				} else {
					$("#uomTypeError").hide();
					uomTypeError = truee;
				}
				return uomTypeError;
			}

			function validate_uomModel() {
				//read variable 
				var val = $("#uomModel").val();
				//check val validate / not 
				if (val == '') {
					$("#uomModelError").show();
					$("#uomModelError").html("<b>Model Name</b> Required");
					$("#uomModelError").css("color", "red");
					uomModelError = false;
				} else {
					$("#uomModelError").hide();
					uomModelError = true;
				}
				return uomModelError;
			}

			function validate_uomDesc() {
				//read variable
				var val = $("#uomDesc").val();
				//check var validate or not
				if (val == '') {
					$("#uomDescError").show();
					$("#uomDescError").html("<b>UOM NOTE </b> Required");
					$("#uomDescError").css("color", "red");
					uomDescError = false;
				} else {
					$("#uomDescError").hide();
					uomDescError = true;
				}
				return uomDescError;
			}

			//link with action event
			$("#uomDesc").keyup(function() {
				validate_uomDesc();
			});
			$("#uomModel").keyup(function() {
				validate_uomModel();
			});
			$("#uomType").change(function() {
				validate_uomType();
			});

           //click on create UOM button
	         $("#register").click(function(){
                   //on click create button
                   //reset flag as false
	 			    uomDescError = false;
				    uomModelError = false;
				    uomTypeError = false;
				   //call validate function
				    validate_uomType();
				    validate_uomModel();
				    validate_uomDesc();

				  //check if all are true then submit else don't
					  if(uomDescError && uomModelError && uomTypeError){
                            return true;
						  }
					  else return false;
		         });
			
		});
	</script>

</body>
</html>