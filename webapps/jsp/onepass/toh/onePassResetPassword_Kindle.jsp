<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, height=device-height, user-scalable=no,initial-scale=1" />
<title>Taste of Home</title>

<link rel="STYLESHEET" type="text/css" href="css/onepass/toh/onePassKindle.css" />

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
	
	String sourceId = (String) request.getParameter("sourceId");

	if(sourceId == null || "".equals(sourceId.trim())) {
		sourceId = "853"; // default Kindle Toh source id
	}

	if ("true".equalsIgnoreCase(transactionCompleted)) {
		password = "";
		confirmPassword = "";
	}
%>

<body>
	<jsp:include page="tohimage.jsp" />
		
	<form action="onePassKindleUpdatePasswordAction.do" method="post">

		<div id="onePassDigReg">
		<h3>RESET PASSWORD</h3>
		</div>
		<div id="onePassDigReg">
		
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
			<html:hidden property="sourceId" value="<%=sourceId%>" />
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

		</fieldset>
</div>
	</form>
	 <jsp:include page="customercare.jsp" /></body>		
</body>
</html>