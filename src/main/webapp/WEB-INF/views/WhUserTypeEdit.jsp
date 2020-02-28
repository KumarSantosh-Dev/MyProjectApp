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
<h3>WELOCME TO WHUserType EDIT Page!!!</h3>

 <form:form action="update" method="POST" modelAttribute="whUserType">
   <pre>
   User ID     :<form:input path="userId" readonly="true"/>
   User Type   :<form:radiobutton path="userType" value="vendor"/>Vendor
                <form:radiobutton path="userType" value="customer"/>Customer
                
   User Code   :<form:input path="userCode"/>
   User For    :<form:input path="userFor"/>
   User Email  :<form:input path="userEmail" />
   User Contact:<form:input path="userContact"/>
   
   User Id Type:<form:select path="userIdType">
                  <form:option value="">-SELECT-</form:option>
                  <form:option value="Pancard">PANCARD</form:option>
                  <form:option value="Adhar">ADHAR</form:option>
                  <form:option value="Voter Id">VOTER ID</form:option>
                  <form:option value="Other">OTHER</form:option>
                </form:select>
                
   If Other    :<form:input path="otherIdType"/>
   ID Number   :<form:input path="idNum"/>
   
             <input type="submit" value="UPDATE"/>
   </pre>
 </form:form>
 ${message}
</body>
</html>