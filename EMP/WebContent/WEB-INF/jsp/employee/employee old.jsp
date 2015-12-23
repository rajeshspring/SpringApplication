<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.error {
color: #ff0000;
font-style: italic;
}


table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;    
}

[class|=color]
 {
 background: Gainsboro;
 }

</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--ajx call -->
<script type="text/javascript"  src="js/jquery-1.3.2.js"></script>
<!--<script type="text/javascript"  src="js/jquery.json-2.2.min.js"></script>-->

<!-- date picker -->

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script type="text/javascript"  src="js/jquery-1.10.2.js"></script>
<script type="text/javascript"  src="js/jquery-ui.js"></script>

  
<script type="text/javascript">
   function getParentStateName()
    {
   var stateId=document.getElementById("stateId").value;
   $.ajax({
	    datatype:"json",
	    type: "POST",
	    url: "${pageContext.request.contextPath}/parentdistrictName.html",
	    data: "stateId=" + stateId,
	    success: function(data)
	        {
	       	 var html ="";
	       	 for(i=0; data.length >i; i++)
	           {
	         html +="<option value='"+data[i][0]+"'>"+data[i][1]+"</option>";
	        	}
	        $("#parentdistrictId").html(html);
	       },
	    error: function(e)
	    {
	        alert('Error: ' + e);
	    }
	    });
    }
        
        
 //###############office state
 function officestatename()
    {
	var stateId=document.getElementById("officestateId").value;
	$.ajax({
	    datatype:"json",
	    type: "POST",
	    url: "${pageContext.request.contextPath}/officedistrictName.html",
	    data: "stateId=" + stateId,
	    success: function(data)
	        {
	       	 var html ="";
	        
	         for(i=0; data.length >i; i++)
	           {
	         html +="<option value='"+data[i][0]+"'>"+data[i][1]+"</option>";
	        	}
	          $("#officaldistrictId").html(html);
	       },
	    error: function(e)
	    {
	        alert('Error: ' + e);
	    }
	    });
	    }
   
        //#### DatePicke
         jQuery(function(){
         jQuery('#date_of_birth').datepicker();
         })
        
         jQuery(function(){
         jQuery('#dateofjoin').datepicker();
         })
	   
	     jQuery(function(){
         jQuery('#dateofleave').datepicker();
         })
    
        //#########Joinging and Leave Date compare
        
        
        //########### form validation
         function validateForm()
          {
          var name=document.forms["myForm"]["name"].value;
          var lastname=document.forms["myForm"]["lastname"].value;
          var date_of_birth=document.forms["myForm"]["date_of_birth"].value;
          var education=document.forms["myForm"]["education"].value;
          var profile=document.forms["myForm"]["profile"].value;
          var phone=document.forms["myForm"]["phone"].value;
          var email=document.forms["myForm"]["email"].value;
          var employeeType=document.forms["myForm"]["employeeType"].value;
          var dateofjoin=document.forms["myForm"]["dateofjoin"].value;
          var dateofleave=document.forms["myForm"]["dateofleave"].value;
          var address=document.forms["myForm"]["address"].value;
          var parentstate=document.forms["myForm"]["parentstate"].value;
          var parentdistrict=document.forms["myForm"]["parentdistrict"].value;
          
          var parnetPinCode=document.forms["myForm"]["parnetPinCode"].value;
          var officeaddress=document.forms["myForm"]["officeaddress"].value;
          var officestate=document.forms["myForm"]["officestate"].value;
          var officedistrict=document.forms["myForm"]["officedistrict"].value;
          var officePinCode=document.forms["myForm"]["officePinCode"].value;
          
          var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
          
          if(name==null || name=="")
          {
          alert("Please Enter First Name ");
          return false;
          }
                           
          if(lastname==null || lastname=="")
          {
          alert("Please Enter Last Name ");
          return false;
          }
          if(date_of_birth==null || date_of_birth=="")
          {
          alert("Please Enter Date_Of_Birth ");
          return false;
          }
          
          if(education==null || education=="")
          {
          alert("Please Enter Education ");
          return false;
          }
          
          if(profile==null || profile=="")
          {
          alert("Please Enter Profile ");
          return false;
           }         
         
         if(phone==null || phone=="")
          {
          alert("Please Enter Phone ");
          return false;
           }  
    
        if(email==null || email=="")
          {
          alert("Please Enter Email ");
          return false;
           }  
          
        if(employeeType==null || employeeType=="")
          {
          alert("Please Enter Employee Type ");
          return false;
           }  
          
          if(dateofjoin==null || dateofjoin=="")
          {
          alert("Please Enter Employee Date Of Join ");
          return false;
           }  
          
          if(dateofleave==null || dateofleave=="")
          {
          alert("Please Enter Employee Date Of Leave ");
          return false;
           }  
           
          if(address==null || address=="")
          {
          alert("Please Enter Employee Address ");
          return false;
           }  
          
          if(parentstate==null || parentstate=="")
          {
          alert("Please Enter Employee Parent State ");
          return false;
           }  
          
          if(parentdistrict==null || parentdistrict=="")
          {
          alert("Please Enter Employee Parent District ");
          return false;
           }  
          
          if(parnetPinCode==null || parnetPinCode=="")
          {
          alert("Please Enter Employee Parent Pin Code ");
          return false;
           }  
          
          if(officeaddress==null || officeaddress=="")
          {
          alert("Please Enter Employee Parent Office Address ");
          return false;
           }  
          
          if(officestate==null || officestate=="")
          {
          alert("Please Enter Employee Office State ");
          return false;
           }  
          
          if(officedistrict==null || officedistrict=="")
          {
          alert("Please Enter Employee Office District ");
          return false;
           }  
          
          if(officePinCode==null || officePinCode=="")
          {
          alert("Please Enter Employee Office Pin Code ");
          return false;
           }  
        
             
           if(!emailReg.test(email)) {  
           alert("Please enter valid email id");
           return false;
           }       
           
                  
           if(dateofjoin >= dateofleave)
           {
           alert("date is leaving is less then joining of date");
           return false;
           }
           }
          
          
          //##### Only chacter allow in text box
           function onlyAlphabets(e, t)
             {
             try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))
                    return true;
                else
                    return false;
                 }
              catch (err) {
                alert(err.Description);
               }
               } 
               
               
               //######## allow oly number in text box
               function isNumber(evt) {
                evt = (evt) ? evt : window.event;
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                return false;
                }
                return true;
                }
         
</script>
</head>
<body>

        Add Employee Details:- ${data}
  <form:form  name="myForm"  action="saveemployee.html" method="Post" commandName="userForm" onsubmit="return validateForm();">
   <table style="width:100%">
   <tr class="color">
   <th>First Name:</th>
   <td><form:input path="name" id="name"  onkeypress="return onlyAlphabets(event,this);"  length="30"></form:input></td>
   <td><form:errors path="name" cssClass="error" ></form:errors></td>
   
  </tr>
   <tr>
   <th>Last_Name:</th>
   <td><form:input path="lastname" id="lastname"  onkeypress="return onlyAlphabets(event,this);" length="30"></form:input></td>
   <td><form:errors path="lastname" cssClass="error" ></form:errors></td>
   
  </tr>
		   
		       <tr class="color">
		       <th>Date Of Birth :</th>
		       <td>
		       <form:input path="date_of_birth" id="date_of_birth"  maxlength="2"></form:input>
		        </td>
		        <td><form:errors path="date_of_birth_error" cssClass="error" ></form:errors></td>
		      </tr>

		<tr>
		<th>Education :-</th>
		<td>
		<form:input path="education"  onkeypress="return onlyAlphabets(event,this);" />
		</td>
		<td><form:errors path="education" cssClass="error" ></form:errors></td>
		</tr>

		<tr class="color">
		<th>Profile:</th>
		<td>
		<form:input path="profile"  onkeypress="return onlyAlphabets(event,this);" maxlength="50"></form:input>
		</td>
		<td><form:errors path="profile" cssClass="error" ></form:errors></td>
		</tr>

		<tr>
		<th>Phone : </th>
		<td> <form:input path="phone" onkeypress="return isNumber(event)" maxlength="10"></form:input></td>
		<td><form:errors path="phone" cssClass="error" ></form:errors></td>
		</tr>


		<tr class="color">
		<th>Email :</th>
		<td><form:input path="email"></form:input> </td>
		<td><form:errors path="email" cssClass="error" ></form:errors></td>
		</tr>

		<tr>
		<th>Emp Type  :</th>
			<td> <form:select
				path="employeeType" id="employeeType">
				<form:option value="" label="--- Select ---" />
				<form:option value="fulltime" label="fulltime" />
				<form:option value="parttime" label="parttime" />
			</form:select></td>
			<td><form:errors path="employeeType" cssClass="error" ></form:errors></td>
		</tr>

		<tr class="color">
		<th>Date Of Join :</th>
			<td> <form:input path="dateofjoin"
				id="dateofjoin" ></form:input></td>
				<td><form:errors path="dateofjoin_error" cssClass="error" ></form:errors></td>
		</tr>

		<tr>
		<th>Date Of Leave :</th>
			<td> <form:input path="dateofleave" id="dateofleave"
				 onclick="dateCompare();"></form:input>
				 </td>
				 <td><form:errors path="dateofleave_error" cssClass="error" ></form:errors></td>
		</tr>


		<tr class="color">
		<th>Parent Address :</th>
			<td><form:textarea path="address"></form:textarea>
			</td>
			<td><form:errors path="address" cssClass="error" ></form:errors></td>
		</tr>

		<tr>
		<th>Parent State :</th>
			<td><form:select path="parentstate"
				id="stateId" onchange="getParentStateName();">
				<form:option value="" label="--- Select ---" />
				<form:options items="${stateList}" itemValue="state_id"
					itemLabel="statename" />
			</form:select></td>
			<td><form:errors path="parentstate" cssClass="error" ></form:errors></td>
		</tr>
		<tr class="color">
		<th>Parent District :</th>
			<td> <form:select path="parentdistrict"
				id="parentdistrictId" onchange="getDistrictDetails()">
				<form:option value="" label="--- Select ---" />
			</form:select></td>
			<td><form:errors path="parentdistrict" cssClass="error" ></form:errors></td>
		</tr>
		<tr>
		<th>Parent Pin Code :</th>
			<td> <form:input path="parnetPinCode" onkeypress="return isNumber(event)" ></form:input></td>
			<td><form:errors path="parnetPinCode" cssClass="error" ></form:errors></td>
		</tr>
		<tr class="color">
		<th>Office Address : :</th>
			<td> <form:textarea path="officeaddress"></form:textarea></td>
			<td><form:errors path="officeaddress" cssClass="error" ></form:errors></td>
		</tr>
		<tr>
		<th>Office State :</th>
			<td>
			 <form:select path="officestate" id="officestateId"
				onchange="officestatename();">
				<form:option value="" label="--- Select ---" />
				<form:options items="${stateList}" itemValue="state_id"
					itemLabel="statename" />
			</form:select></td>
			<td><form:errors path="officestate" cssClass="error" ></form:errors></td>
		</tr>


		<tr class="color">
		<th>Office District :</th>
			<td> <form:select
				path="officedistrict" id="officaldistrictId">
				<form:option value="" label="--- Select ---" />
			</form:select></td>
			<td><form:errors path="officedistrict" cssClass="error" ></form:errors></td>
		</tr>


		<tr>
		<th>Office Pin Code  :</th>
		<td> <form:input path="officePinCode" onkeypress="return isNumber(event)" ></form:input></td>
		<td><form:errors path="officePinCode" cssClass="error" ></form:errors></td>
		</tr>
             
        
        <tr class="color">
        <td align="center">
		<input type="submit" name="submit data" value="save"  />
		<input type="reset" value="reset" />
		</td>        
        </tr>
	    </table>



	    <table>
		<td align="center">Display All Records:-</td>
		<c:if test="${!empty emp_list}">
			<table class="tbl_with_brdr display" id="familyTable">
				<thead>
					<tr class="color">

						<th class='columns_head' rowspan="2" align="left">Name</th>
						<th class='columns_head' rowspan="2" align="left">Address</th>
						<th class='columns_head' rowspan="2" align="left">Email</th>
						<th class='columns_head' rowspan="2" align="left">Profile</th>
						<th class='columns_head' rowspan="2" align="left">Emp Type</th>
						<th class='columns_head' rowspan="2" align="left">Phone</th>

						<th class='columns_head' colspan="3" align="center">Action</th>
					</tr>

					<tr class="tblRowTitle tblclear topTr">
						<th class='columns_head' align="left">View</th>
						<th class='columns_head' align="left">Update</th>
						<th class='columns_head' align="left">Delete</th>
					</tr>
				</thead>


				<c:forEach items="${emp_list}" var="emp_var" varStatus="count">
					<tr>
						<td width="20%">
						<c:out value="${emp_var.name}" />
						</td>
						<td width="20%"><c:out
							value="${emp_var.lastname}" /></td>
						<td width="20%"><c:out
							value="${emp_var.email}" /></td>
						<td width="20%"><c:out
							value="${emp_var.profile}" /></td>
						<td  width="20%"><c:out
							value="${emp_var.employeeType}" /></td>
						<td  width="20%"><c:out
							value="${emp_var.phone}" /></td>
						<td width="20%">
						<a href="viewemployee.html?Id=<c:out value="${emp_var.empId}"/> ">View</a></td>
						<td width="20%">
						<a 	href="BusinessContext.jsp?value1=${emp_var.empId}">Update</a></td>
						<td width="20%">
						<a 	href="BusinessContext.jsp?value1=${emp_var.empId}">Delete</a></td>
					<tr>
				   </c:forEach>
			      </table>
		          </c:if>
		          <%!
		          String first="First";
		          String one="1";
		          String two="2";
		          String three="3";
		          String four="4";
		          String five="5";
		          String last="Last";
		         %>
		    <div>
		    <!-- "><a href="deletestandingCommitteeMemeber.htm?id=<c:out value="${committeeMember.commiteeId.committeeId}"/> -->
            <ul>
            <a href="manageEmployee.html?page=<c:out value="<%=first%>"/>">First</a>
            <a href="manageEmployee.html?page=<c:out value="<%=one%>"/> ">1</a>
            <a href="manageEmployee.html?page=<c:out value="<%=two%>"/> ">2</a>
            <a href="manageEmployee.html?page=<c:out value="<%=three%>"/> ">3</a>
            <a href="manageEmployee.html?page=<c:out value="<%=four%>"/> ">4</a>
            <a href="manageEmployee.html?page=<c:out value="<%=five%>"/> ">5</a>
            <a href="manageEmployee.html?page=<c:out value="<%=last%>"/> ">Last</a>
            </ul>
            </div>
            
            </table>
                  
               
            
           

</form:form>
</body>
</html>