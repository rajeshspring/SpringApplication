
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<SCRIPT language="javascript">

function addRow(tableID) {
	 
    var table = document.getElementById(tableID);

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    var colCount = table.rows[0].cells.length;

    for(var i=0; i<colCount; i++) {

        var newcell = row.insertCell(i);

        newcell.innerHTML = table.rows[0].cells[i].innerHTML;
        //alert(newcell.childNodes);
        switch(newcell.childNodes[0].type) {
            case "text":
                    newcell.childNodes[0].value = "";
                    break;
            case "checkbox":
                    newcell.childNodes[0].checked = false;
                    break;
            case "select-one":
                    newcell.childNodes[0].selectedIndex = 0;
                    break;
        }
    }
}

function deleteRow(tableID) {
    try {
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;

    for(var i=0; i<rowCount; i++) {
        var row = table.rows[i];
        var chkbox = row.cells[0].childNodes[0];
        if(null != chkbox && true == chkbox.checked) {
            if(rowCount <= 1) {
                alert("Cannot delete all the rows.");
                break;
            }
            table.deleteRow(i);
            rowCount--;
            i--;
        }


    }
    }catch(e) {
        alert(e);
    }
}   
      
        
        
        
        
        
</script>

<body>

 
<form:form action="post" method="addOnsideEmployees.html" commandName="onsideEmployeesForm">
<div>
             
             
    <table style="width:100%" border="1">
    <tr bgcolor="Gray">
    <td width="3%"></td> <td align="center" width="17%">Emp Name</td> <td align="center" width="18%">Emp_id</td> <td align="center" width="17%">Emp_Phone</td> <td align="center" width="18%">Emp_Email</td> <td align="center" width="18%" >Email_Address</td><td align="center">ProjectManager</td>
    </tr>
    </table>
 
    
    <table id="dataTable" style="width:100%" border="1">
        <tr>
            <td><INPUT type="checkbox" name="chk" /></td>
            <td><INPUT type="text" name="emp_name"  /></td>
            <td><INPUT type="text" name="employee_id" /></td>
            <td><INPUT type="text" name="emp_phone"/></td>
            <td><INPUT type="text" name="emp_email"/></td>
            <td><INPUT type="text" name="emp_address"/></td>
            <td>
             <form:select path="manager" id="managerId" >
             <form:option value="" label="--- select---"></form:option>
             <form:options items="${managerLis}" itemValue="manager_id" itemLabel="manager_name" />
             </form:select>
            </td>
        </tr>
    </table>
    <input type="button" value="Add Row" onclick="addRow('dataTable')" />
 
    <input type="button" value="Delete Row" onclick="deleteRow('dataTable')" />
 </div>
 
<input type="submit" name="submit data" value="save"/>
<input type="reset" value="reset"/>
 
</form:form>
</body>
</html>