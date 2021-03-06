<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="card-header  bg-primary text-white text-center">
				<h3>WELCOME TO SHIPMENT TYPE DATA PAGE!!!</h3>
			</div>
			<!-- End Card-Header -->

			<div class="card-body">
				<a href="excel"><img src="../resources/images/excel.png" width="100" height="60"></a>
				            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <a href="pdf"><img src="../resources/images/pdf.png" width="100" height="60"></a> <br/><br/>
				
				<c:choose>
					<c:when test="${!empty list }">
						<table border="1">
							<tr>
								<th>ID</th>
								<th>MODE</th>
								<th>CODE</th>
								<th>ENABLE</th>
								<th>GRADE</th>
								<th>DESC</th>
								<th colspan="3">OPERATION</th>
							</tr>

							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.shipId }</td>
									<td>${ob.shipMode }</td>
									<td>${ob.shipCode }</td>
									<td>${ob.enbShip }</td>
									<td>${ob.shipGrd }</td>
									<td>${ob.shipDesc }</td>
									<td>
									  <a href="delete?sid=${ob.shipId } ">
									    <img src="../resources/images/delete.png" width="30" height="30">
									  </a>
									</td>
									<td>
									   <a href="edit?sid=${ob.shipId } ">
									    <img src="../resources/images/edit.jpg" width="30" height="30">
									   </a>
									</td>
									<td>
									   <a href="view?sid=${ob.shipId }">
									    <img src="../resources/images/view.jpg" width="30" height="30">
									   </a>
									</td>
								</tr>
							</c:forEach>
						</table>
                     </c:when>
					<c:otherwise>
						<h2>NO SHIPMENT TYPE DATA FOUND</h2>
					</c:otherwise>
				</c:choose>
			</div> <!-- End Card-Body -->

			<div class="card-footer">
			   ${message}
			</div>
			<!-- End Card-Footer -->
		</div>
		<!-- End Card -->
	</div>
	<!-- End Container -->


</body>
</html>