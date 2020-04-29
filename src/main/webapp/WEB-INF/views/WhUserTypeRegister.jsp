<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>

	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white
				text-uppercase">
				<h3>WELOCME TO WHUserType Register Page!!!</h3>
			</div>
			<!-- End of Header -->

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="whUserType">
					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="userType"> User Type </label>
						</div>
						<div class="col-4">
							<form:radiobutton path="userType" value="vendor" />
							Vendor
							<form:radiobutton path="userType" value="customer" />
							Customer
						</div>
						<div class="col-4">
						  <span id="userTypeError"></span>
						</div>
					</div>

					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="userCode"> User Code </label>
						</div>
						<div class="col-4">
							<form:input path="userCode" class="form-control" />
						</div>
						<div class="col-2">
						   <span id="userCodeError"></span>
						</div>
						<div class="col-2">
						  <form:errors path="userCode" cssClass="text-danger"/>
						</div>
					</div>

					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="userFor"> User For </label>
						</div>
						<div class="col-4">
							<form:input path="userFor" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>

					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="userEmail">User Email</label>
						</div>
						<div class="col-4">
							<form:input path="userEmail" class="form-control" />
						</div>
						<div class="col-2">
						   <span id="userEmailError"></span>
						</div>
						<div class="col-2">
						  <form:errors path="userEmail" cssClass="text-danger"/>
						</div>
					</div>
					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="userContact"> User Contact </label>
						</div>
						<div class="col-4">
							<form:input path="userContact" class="form-control" />
						</div>
						<div class="col-2">
						   <span id="userContactError"></span>
						</div>
						<div class="col-2">
						   <form:errors path="userContact" cssClass="text-danger"/>
						</div>
					</div>

					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="userIdType"> User Id Type</label>
						</div>
						<div class="col-4">
							<form:select path="userIdType" class="form-control">
								<form:option value="">-SELECT-</form:option>
								<form:option value="Pancard">PANCARD</form:option>
								<form:option value="Adhar">ADHAR</form:option>
								<form:option value="Voter Id">VOTER ID</form:option>
								<form:option value="Other">OTHER</form:option>
							</form:select>
						</div>
						<div class="col-4"></div>
					</div>

					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="otherIdType"> If Other </label>
						</div>
						<div class="col-4">
							<form:input path="otherIdType" class="form-control" />
						</div>
						<div class="col-4"></div>
					</div>

					<!-- One Row  -->
					<div class="row">
						<div class="col-4">
							<label for="idNum"> ID Number </label>
						</div>
						<div class="col-4">
							<form:input path="idNum" class="form-control" />
						</div>
						<div class="col-2">
						   <span id="idNumError"></span>
						</div>
						<div class="col-2">
						  <form:errors path="idNum" cssClass="text-danger"/>
						</div>
					</div>

					<!-- One Row  -->
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="CREATE USER" class="btn btn-success" />
						</div>
						<div class="col-4"></div>
					</div>
				</form:form>
			</div><!-- End of Body -->
			

			<div class="card-footer">
				<c:if test="${!empty message }">
					<div class="card-footer bg-info text-white text-center">${message}</div>
				</c:if>
			</div><!-- End of Footer -->
		</div><!-- End of Card -->
	</div>	<!-- End Of Container -->

  <!-- JQuery Validation -->
  
  <script type="text/javascript">
    $(document).ready(function(){
        //hide error section
        $("#userTypeError").hide;
        var userTypeError=false;
        $("#userType").change(function(){
            validate_userType();
         });
        function validate_userType(){
            var val=$('[path="userType"]:checked').length();
            if(val==0){
            	$("#userTypeError").show();
            	alert(val);
             }
         }
         
      });

  </script>

</body>
</html>