<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, height=device-height, user-scalable=no,initial-scale=1" />
<title>Taste of Home</title>

<link rel="STYLESHEET" type="text/css" href="css/onepass/toh/onePassIpad.css" />

<%
   String emailAddress = (String)request.getParameter("emailAddress") != null ? (String)request.getParameter("emailAddress") : "";
   String confirmEmailAddress = (String)request.getParameter("confirmEmailAddress") != null ? (String)request.getParameter("confirmEmailAddress") : "";
   
   String sourceId = (String) request.getParameter("sourceId");

   if(sourceId == null || "".equals(sourceId.trim())) {
		sourceId = "853"; // default ipad RD source id
   }
	
   String transactionCompleted = (String)request.getParameter("transactionCompleted")!= null ? (String)request.getParameter("transactionCompleted") : "";
	
	if("true".equalsIgnoreCase(transactionCompleted)) {
		emailAddress = "";
		confirmEmailAddress = "";
	}
%>
</head>

<body>
		
	<form action="onePassForgetPasswordAction.do" method="post">
	<div id="outer-container">
		<jsp:include page="tohimage.jsp" />
	<div id="onePassDigReg1">
		<h3>FORGOT PASSWORD</h3>
		</div>
		
		<div id="onePassDigReg">
		
		<p>Please enter your email address. We'll send you a link to reset
			your password.</p>

		<fieldset>
			<ol>
				<li><label for=email>Email Address</label> <input
					id="emailAddress" name="emailAddress" maxlength="100" type="text"
					value="<%=emailAddress %>" placeholder="example@domain.com" /></li>

				<li><label for=confirmEmail>Confirm Email Address</label> <input
					id="confirmEmailAddress" name="confirmEmailAddress" value="<%=confirmEmailAddress %>"
					maxlength="100" type="text" placeholder="example@domain.com" /></li>
			</ol>
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

		<fieldset>

			<%if("true".equalsIgnoreCase(transactionCompleted)) { %>
			<h4 align='center'>
				<font color='#dd3937'>We've sent an email with instructions on how to reset your password.</font>
			</h4>
			<%} %>
			<button type="submit" name="Submit" value="Submit">SUBMIT</button>
			<p>&nbsp;</p>
		</fieldset>
</div>
</div>
	</form>
                <jsp:include page="customercare.jsp" /></body>
</body>
</html>