<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>

<head>
<meta name="viewport" content="width=device-width, height=device-height, user-scalable=no,initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Reader's Digest</title>

<link rel="STYLESHEET" type="text/css" href="css/onepass/onePassIpad.css" />

</head>

<%
	String password = (String) request.getParameter("password") != null ? (String) request
			.getParameter("password") : "";
	String confirmPassword = (String) request
			.getParameter("confirmPassword") != null ? (String) request
			.getParameter("confirmPassword") : "";
	String token = (String) request.getParameter("token") != null ? (String) request
			.getParameter("token") : "";
	String transactionCompleted = (String) request
			.getParameter("transactionCompleted") != null ? (String) request
			.getParameter("transactionCompleted") : "";
	
	String sourceId = (String) request.getParameter("sourceId") != null ? (String) request.getParameter("sourceId") : "769";

	if ("true".equalsIgnoreCase(transactionCompleted)) {
		password = "";
		confirmPassword = "";
	}
%>

<body>


	<form action="onePassUpdatePasswordAction.do" method="post"
		id="onePassDigReg">

		<img src="image/readers-digest-logo.gif" width="220" height="102"
			border="0" />

		<h3>RESET PASSWORD</h3>
		<p>
			Please choose a password to use with your account.<br />
		</p>

		<fieldset>

			<ol>

				<li><label for=password>Enter New Password</label> <input
					id="password" maxlength="40" name="password"
					value="<%=password %>" type="password" /></li>

				<li><label for=confirmPassword>Confirm Password</label> <input
					id="confirmPassword" maxlength="40" name="confirmPassword"
					value="<%=confirmPassword %>" type="password" /></li>

				<p>Passwords are case sensitive.</p>

			</ol>
			<input type="hidden" id="token" name="token" value="${param.token}" />
			<input type="hidden" id="sourceId" name="sourceId" value="${param.sourceId}" />
		</fieldset>

			<!-- Conditionally show errors -->
			<logic:messagesPresent message="false">
				<html:messages id="aMsg" message="false">
					<logic:present name="aMsg">
						<!-- Error -->
						<li class="errors"><bean:write name="aMsg" filter="false" /></li>

					</logic:present>
				</html:messages>
			</logic:messagesPresent>
			<!-- /Conditionally show errors -->
	
		<fieldset>
			<br />
			<%
				if ("true".equalsIgnoreCase(transactionCompleted)) {
			%>
			<h4 align='center'>
				<font color='#dd3937'>Great! Your password has been updated.</font>
			</h4>
			<%
				}
			%>
			<button type="submit" name="Submit" value="Submit">SUBMIT</button>
			<p>&nbsp;</p>

			<p>Need help? Email<a href="mailto:digitalsupport@rd.com?subject=Digital Editions" style="text-decoration:underline;"> Customer Care</a> or call 1-877-342-4775.</p>
		</fieldset>

	</form>
</body>
</html>