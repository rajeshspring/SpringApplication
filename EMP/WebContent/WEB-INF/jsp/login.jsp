<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/emp.css" rel="stylesheet" type="text/css">
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
</head>


<body>
                          User Login:-
<table>
<tr>
<td class="error">
<c:if test="${userlogin != null}"></c:if>
<c:out value="${loginFailed}"> </c:out>
</td>
</tr>
</table>


<form:form action="login.html"  method="POST" commandName="loginForm">
<table>

<tr>
<td>
<label>user name:-</label>  
<form:input path="username" size="20" ></form:input>
</td>
<td><form:errors path="username" cssClass="error" /></td>
</tr>

<tr>
<td> 
<label>password :-</label>  
<form:input path="password" size="20"></form:input>
</td>
<td><form:errors path="password" cssClass="error" /></td>
</tr>
</table>
<input type="submit"  value="login"/>
<input type="submit"  value="cancel"/>

</form:form>

</body>
</html>