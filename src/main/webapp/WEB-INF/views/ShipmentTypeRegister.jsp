<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">

			<div class="card-header bg-primary text-center text-white
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
							<!-- ERROR -->
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
						<div class="col-4">
							<!-- ERROR -->
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
							<!-- ERROR -->
						</div>
					</div>
					<!-- 3 ROW End -->

					<div class="row">
						<div class="col-4">
							<label for="shipGrd">Shipment Grade </label>
						</div>
						<div class="col-4">
							<form:radiobutton path="shipGrd" value="A" />
							A
							<form:radiobutton path="shipGrd" value="B" />
							B
							<form:radiobutton path="shipGrd" value="C" />
							C
						</div>
						<div class="col-4">
							<!-- ERROR -->
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
							<!-- ERROR -->
						</div>
					</div>
					<!-- 5 ROW End -->

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="CREATE" class="btn btn-success" />
							 <input type="reset" value="CLEAN" class="btn btn-danger" />
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

</body>
</html>