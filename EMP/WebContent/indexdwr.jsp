<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<title>DWR Demo</title> 
<script type='text/javascript' src='EMP/empdwr/interface/Message.js'></script> 
<script type='text/javascript' src='EMP/empdwr/engine.js'></script> 
<script type='text/javascript' src='EMP/empdwr/util.js'></script> 
</head> 
<body> 
<input value="click me!!!" type="button" onclick="update();" /> 
<div style="background-color: #ffeaa7;font-weight: bold;width: 300px;" id="divResponse"> 
</div> 
<script type="text/javascript"> 
 
function update() 
{ 
alert("sfsfsdfdsf");
Message.getMessage(function(data)
 { 
 dwr.util.setValue("divResponse", data); 
}); 
} 
</script> 
</body> 
</html> 
