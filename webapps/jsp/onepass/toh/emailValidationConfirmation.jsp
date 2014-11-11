<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, height=device-height, user-scalable=no,initial-scale=1" />
<title>Taste of Home</title>

<link rel="STYLESHEET" type="text/css" href="css/onepass/toh/onePassIpad.css" />

</head>

<body>
		
	<form>
	<div id="outer-container">
		<jsp:include page="tohimage.jsp" />
	<div id="onePassDigReg1">
		<h3>Email Address Confirmation</h3>
		</div>
		<div id="onePassDigReg">
		
		
		<% 
		if("true".equalsIgnoreCase((String)request.getParameter("transactionCompleted"))) {%>
		<p>Thank you for confirmation of your email address.</p>
		<% } else { %>
		<p>Invalid User Error !! </p>
		<% }%>
		<!--  <p>
			<strong>Please use the instructions mentioned on email to reset your password.</strong><br />
		</p> -->
		<p>&nbsp;</p>
	</div>
	</div>
	</form>
                <jsp:include page="customercare.jsp" /></body>
</body>
</html>