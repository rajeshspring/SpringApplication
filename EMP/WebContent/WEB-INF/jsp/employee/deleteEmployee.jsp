<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table {
    width:100%;
}
table, th, td {
    border: 1px solid green;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}

</style>

<script type="text/javascript"  src="js/jquery-1.3.2.js"></script>
<script type="text/javascript"  src="js/jquery.json-2.2.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script type="text/javascript"  src="js/jquery-1.10.2.js"></script>
<script type="text/javascript"  src="js/jquery-ui.js"></script>

<script type="text/javascript">
function ConfirmDelete()
{
var x = confirm("Are you sure you want to delete?");
if (x)
return true;
else
return false;
}

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Employee Details:---
<form:form action="deleteEmployeeByUser.html" method="post"  commandName="userForm">

<table style="width:100%" id="t01">

<c:forEach items="${employeeList}" var="emp_var">

<form:hidden path="empId"  />


<tr>
<th>First Name</th> 
<td><c:out value="${emp_var.name}"></c:out></td>
</tr>
<tr>
<th>Last Name</th>
<td><c:out value="${emp_var.lastname}"></c:out></td>
</tr>

<tr>
<th>Date Of Birth</th>
<td><c:out value="${emp_var.date_of_birth}"></c:out></td>
</tr>

<tr>
<th>Eduction</th>
<td><c:out value="${emp_var.education}"></c:out></td>
</tr>
<tr>
<th>Profile</th>
<td><c:out value="${emp_var.profile}"></c:out></td>
</tr>

<tr>
<th>Date Of Join </th>
<td><c:out value="${emp_var.dateofjoin}"></c:out></td>
</tr>



<tr>
<th>Employee Type</th>
<td><c:out value="${emp_var.employeeType}"></c:out></td>
</tr>

<tr>
<th>Phone</th>
<td><c:out value="${emp_var.phone}"></c:out></td>
</tr>


<tr>
<th>Email</th>
<td><c:out value="${emp_var.email}"></c:out></td>
</tr>

<tr>
<th>Parent State</th>
<td><c:out value="${emp_var.email}"></c:out></td>
</tr>

<tr>
<th>Parent District</th>
<td><c:out value="${emp_var.email}"></c:out></td>
</tr>

<tr>
<th>Pin Code</th>
<td><c:out value="${emp_var.parnetPinCode}"></c:out></td>
</tr>

<tr>
<th>Office State</th>
<td><c:out value="${emp_var.email}"></c:out></td>
</tr>

<tr>
<th>Office  District</th>
<td><c:out value="${emp_var.email}"></c:out></td>
</tr>

<tr>
<th>Pin Code</th>
<td><c:out value="${emp_var.officePinCode}"></c:out></td>
</tr>

</c:forEach>
</table>
<input type="submit" name="submit data" value="Delete" onclick="return ConfirmDelete();"/>
</form:form>
</body>
</html>