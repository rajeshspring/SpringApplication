<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type='text/javascript' src='/EMP/dwr/interface/Message.js'></script> 
<script type='text/javascript' src='/EMP/dwr/engine.js'></script> 
<script type='text/javascript' src='/EMP/dwr/util.js'></script> 
<script type="text/javascript"> 
function update() 
{ 
Message.doSomething(function(data) { 
	alert(data);
dwr.util.setValue("divResponse", data); 
}); 
} 
 
</script> 
</head>
<body onload="update();">

<div id="divResponse"> </div>


</body>
</html>