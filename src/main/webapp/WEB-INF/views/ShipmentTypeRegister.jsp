<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

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
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	
	<div class="container">
		<div class="card" >

			<div
				class="card-header bg-primary text-center text-white
				text-uppercase">
				<h3>WELCOME TO SHIPMENT TYPE REGISTER PAGE!!!</h3>
			</div>
			<!-- Header End -->

			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="shipmentType">

					<div class="row">
						<div class="col-4">
							<label for="shipMode">Shipment Mode</label>
						</div>
						<div class="col-4">
							<form:select path="shipMode" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:option value="Air">AIR</form:option>
								<form:option value="Truck">TRUCK</form:option>
								<form:option value="Ship">SHIP</form:option>
								<form:option value="Train">TRAIN</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<span id="shipModeError"></span>
						</div>
					</div>
					<!-- End one ROW -->

					<div class="row">
						<div class="col-4">
							<label for="shipCode">Shipment Code</label>
						</div>
						<div class="col-4">
							<form:input path="shipCode" class="form-control" />
						</div>
						<div class="col-2">
							<span id="shipCodeError"></span>
						</div>
						<div class="col-2">
						   <form:errors path="shipCode" cssClass="text-danger"/>
						</div>
					</div>
					<!-- 2 ROW End -->

					<div class="row">
						<div class="col-4">
							<label for="enbShip">Enable Shipment</label>
						</div>
						<div class="col-4">
							<form:select path="enbShip" class="form-control">
								<form:option value="">--SELECT--</form:option>
								<form:option value="YES">YES</form:option>
								<form:option value="NO">NO</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<span id="enbShipError"></span>
						</div>
					</div>
					<!-- 3 ROW End -->

					<div class="row">
						<div class="col-4">
							<label for="shipGrd">Shipment Grade </label>
						</div>
						<div class="col-4">
							<form:radiobutton path="shipGrd" id="shipGrd1" value="A" />
							A
							<form:radiobutton path="shipGrd" id="shipGrd2" value="B" />
							B
							<form:radiobutton path="shipGrd" id="shipGrd3" value="C" />
							C
						</div>
						<div class="col-4">
							<span id="shipGrdError"></span>
						</div>
					</div>
					<!-- 4 ROW End -->


					<div class="row">
						<div class="col-4">
							<label for="shipDesc">Description</label>
						</div>
						<div class="col-4">
							<form:textarea path="shipDesc" class="form-control" />
						</div>
						<div class="col-4">
							<span id="shipDescError"></span>
						</div>
					</div>
					<!-- 5 ROW End -->

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="CREATE" id="register" class="btn btn-success" /> <input
								type="reset" value="CLEAN" class="btn btn-danger" />
						</div>
					</div>
					<!-- 6 Row End -->

				</form:form>
			</div>
			<!-- End body -->
			<c:if test="${!empty message }">
				<div class="card-footer bg-info text-white text-center">${message}</div>
			</c:if>
			<!-- End of Footer -->
		</div>
		<!-- End of Card -->
	</div>
	<!-- End of container -->
	
	
	<!-- JQuery Validation -->
	
	<script type="text/javascript">
      $(document).ready(function(){
           //Hide Error Section
           $("#shipDescError").hide();
           $("#shipCodeError").hide();
           $("#enbShipError").hide();
           $("#shipModeError").hide();
           $("#shipGrdError").hide();

           //define ERROR variable
           var shipDescError=false;
           var shipCodeError=false;
           var enbShipError=false;
           var shipModeError=false;
           var shipGrdError=false;

           //link with action event
           $("#shipDesc").keyup(function(){
        	     validate_shipDesc();
               });
           $("#shipCode").keyup(function(){
        	   validate_shipCode();
             });
           $("#enbShip").change(function(){
              validate_enbShip();
             });
           $("#shipMode").change(function(){
        	   validate_shipMode();
             });
           $('[path="shipGrd"]').change(function(){
                validate_shipGrd();
              });


           //define validate function
           
           function validate_shipGrd(){
        	   var val=$('[path="shipGrd"].checked').length;
        	   alert(val);
             }
           
           function validate_shipMode(){
               var val=$("#shipMode").val();
               if(val==''){
                   $("#shipModeError").show();
                   $("#shipModeError").html("Choose atleast One  <b>MODE Type</>");
                   $("#shipModeError").css("color","red");
                   shipModeError=false;
               }
              else{
              	$("#shipModeError").hide();
              	shipModeError=true;
               }
              return shipModeError;
             }
           
           //enable shipment
           function validate_enbShip(){
               var val=$("#enbShip").val();
               if(val==''){
                   $("#enbShipError").show();
                   $("#enbShipError").html("Choose atleast One  <b>Yes/No</>");
                   $("#enbShipError").css("color","red");
                   enbShipError=false;
               }
              else{
              	$("#enbShipError").hide();
              	enbShipError=true;
               }
              return enbShipError;
            }
           
           //shipmentCode
           function validate_shipCode(){
                var val=$("#shipCode").val();
                if(val==''){
                     $("#shipCodeError").show();
                     $("#shipCodeError").html("Must Fill <b>Shipment Code</>");
                     $("#shipCodeError").css("color","red");
                     shipCodeError=false;
                 }
                else{
                	$("#shipCodeError").hide();
                	shipCodeError=true;
                 }
                return shipCodeError;
            }
           //shipDescription
           function validate_shipDesc(){
        	 //read input value
        	 var val=$("#shipDesc").val();
          	 //check validate or not
          	 if(val==''){
                 $("#shipDescError").show();
                 $("#shipDescError").html("write some <b>NOTE</b>");
                 $("#shipDescError").css("color","red");
                 shipDescError=false;
              }
          	 else{
          		 $("#shipDescError").hide();
          		 shipDescError=true;
              }
             return shipDescError;
            }

           //click on create UOM button
	         $("#register").click(function(){
                 //on click create button
                 //reset flag as false
	 			    shipDescError = false;
	 			    shipCodeError = false;
	 			    enbShipError = false;
	 			    shipModeError = false;
				   //call validate function
        	       validate_shipMode();
                   validate_enbShip();
            	   validate_shipCode();
                   validate_shipDesc();
				  //check if all are true then submit else don't
					  if(shipDescError && shipCodeError && enbShipError && shipModeError){
                          return true;
						  }
					  else return false;
		         });
         
        });
	</script>
 </body>
</html>