<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Email Confirmation</title>

<link rel="STYLESHEET" type="text/css" href="css/onepass/onePassIpad.css" />

</head>

<body>
	<form id="onePassDigReg">

	<div id="onePassEmailVaildConf">
		<img src="image/readers-digest-logo.gif" width="220" height="102"
			border="0" />
		<h3>Email Address Confirmation</h3>
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
		<p>Need help? Email<a href="mailto:digitalsupport@rd.com?subject=Digital Editions" style="text-decoration:underline;"> Customer Care</a> or call 1-877-342-4775.</p>
	</div>
	</form>

</body>
</html>