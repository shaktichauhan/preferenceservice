
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>

<html>

<head>
<title>Reader's Digest</title>
<meta name="viewport" content="width=device-width, height=device-height, user-scalable=no,initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />


<script type="text/javascript">
	function closeOverlay() {
		adobe.dps.store.dismissCustomDialog();
	}

	function convertQuotationMark() {
		var email = document.getElementById("emailAddress").value;
		var confirmEmail = document.getElementById("confirmEmailAddress").value;
		email = email.replace(/"/g, "&quot;");
		confirmEmail = confirmEmail.replace(/"/g, "&quot;");
		document.getElementById("emailAddress").value = email;
		document.getElementById("confirmEmailAddress").value = confirmEmail;
	}
	
</script>

<!--<script type="text/javascript" src="js/onepass/jquery.infieldlabel.min.js"></script>
<script type="text/javascript" src="js/onepass/cn-receipt.js"></script>
<script type="text/javascript" src="js/onepass/closeOverlay.js"></script>-->

<!--<link type="text/css" href="" rel="stylesheet" media="all" />-->
<style>
html {
	-webkit-text-size-adjustment: none;
	/* Prevent font scaling in landscape */
}

body {
	margin: 0;
	padding: 0;
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	font-size: 13px;
	background-color: transparent;
	width: 100%;
	max-width: 1024px;
	min-width: 768px;
}

a,a:link,a:visited {
	color: #FFFFFF;
}

h1 {
	margin: 0;
	margin-bottom: 10px;
	font-size: 18px;
	position: relative;
	z-index: 5;
	text-shadow: 0 -2px 0 #000000;
}

h2 {
	margin: 0;
	font-size: 16px;
	font-weight: bold;
	position: relative;
	z-index: 5;
	text-shadow: 0 -1px 0 #000000;
}

p.formintro {
	font-size: 14px;
	margin: 1em;
}

fieldset {
	background-color: #FFFFFF;
	padding: 0;
	margin: 0;
	border: 1px solid #CCC;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	border-radius: 10px;
	-moz-box-shadow: inset 0px 2px 2px rgba(0, 0, 0, .7);
	-webkit-box-shadow: inset 0px 2px 2px rgba(0, 0, 0, .7);
	box-shadow: inset 0px 2px 2px rgba(0, 0, 0, .7);
	opacity: 1.0;
}

.row {
	clear: both;
	position: relative;
	margin: 0 auto;
}

label {
	position: absolute;
	top: 10px;
	left: 15px;
	color: #666;
	font-size: 16px;
	font-weight: bold;
}

::-webkit-input-placeholder {
	color: #666;
	font-weight: bold;
}

:-moz-placeholder {
	color: #666;
	font-weight: bold;
}

input[type="text"],[type="email"],input[type="password"] {
	width: 280px;
	height: 16px;
	padding: 10px;
	background-color: transparent;
	border: none;
	border-top: 1px solid #CCC;
	opacity: 1.0;
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	font-size: 16px;
}

#email {
	border: none;
}

button,input[type='submit'] {
	color: #fff;
	font: normal 16px/18px "Helvetica Neue", "Arial", "sans-serif";
	letter-spacing: 0.05em;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: none;
	background: rgb(0, 0, 0, 0.8); //
	background: -moz-linear-gradient(#6A7388 0%, #243050 50%, #0A153A 51%, #141F42 100%);
	//
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #6A7388),
		color-stop(50%, #243050), color-stop(51%, #0A153A),
		color-stop(100%, #141F42) );
	background: -moz-linear-gradient(#969DB0, #0A183B);
	background: -webkit-gradient(linear, left top, left bottom, from(#969DB0),
		to(#0A183B) );
	-moz-box-shadow: 0 -1px 0 #061137 inset, 0 1px 0 rgba(0, 0, 0, 0.51)
		inset, 0 1px 1px 0 rgba(0, 0, 0, 0.51), 0 1px 0 0
		rgba(255, 255, 255, 0.18);
	-webkit-box-shadow: 0px 1px 1px rgba(255, 255, 255, .7);
	box-shadow: 0 -1px 0 #061137 inset, 0 1px 0 rgba(0, 0, 0, 0.51) inset, 0
		1px 1px 0 rgba(0, 0, 0, 0.51), 0 1px 0 0 rgba(255, 255, 255, 0.18);
	padding: 8px 0;
	text-shadow: 0 -1px 0 #000;
	min-width: 100px;
	margin: 0px 3px;
	opacity: 1.0;
	width: 43%;
}

/* Form Wrapper */
.appleStyleDialog {
	position: absolute;
	top: 40px;
	left: 50%;
	width: 310px;
	padding: 10px 30px 20px 30px;
	margin-left: -187px;
	/* (width+padding-left+padding-right+border-left+border-right/2) */
	z-index: 99;
	background-color: #0A183B;
	background-color: rgb(10, 24, 59, 0.5);
	color: #FFFFFF;
	text-align: center;
	border: 2px solid #DEE1E6;
	-moz-border-radius: 15px;
	-webkit-border-radius: 15px;
	border-radius: 15px;
	-moz-box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);
	box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.5);
	overflow: hidden;
	opacity: 0.9;
}

.appleStyleDialog .shine {
	display: block;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 18px;
	z-index: 1;
	background: -moz-linear-gradient(-90deg, #969db0, #354264);
	background: -webkit-gradient(linear, left top, left bottom, from(#969db0),
		to(#354264) );
	/* Moz */
	-moz-border-radius-topleft: 12px;
	-moz-border-radius-topright: 12px;
	-moz-border-radius-bottomleft: 75px 10px;
	-moz-border-radius-bottomright: 75px 10px;
	/* border rad */
	border-top-left-radius: 50px;
	border-top-right-radius: 50px;
	border-bottom-left-radius: 75px 10px;
	border-bottom-right-radius: 75px 10px;
}

/* Error Messaging */
.errorBox {
	margin: 0 0 10px 20px;
	padding: 0;
	width: 300px;
	color: #c5212e;
	text-align: left;
	font-weight: bold;
}

.errorBox li {
	margin: 0;
	margin-bottom: 5px;
}

li.errors {
	margin: 0 0 0px 20px;
	padding: 0;
	width: 300px;
	color: #c5212e;
	text-align: left;
	font-weight: bold;
}

/* Registration */
#registration {
	
}

/* Login */
#login {
	
}

/* Thank you */
#thankyou {
	
}

.hide {
	display: none;
}

/* Smart phone display */
@media ( max-width : 480px) {
	body {
		font-size: 12px;
	}
	.appleStyleDialog {
		width: 90%;
		margin-left: 0px;
		box-sizing: border-box;
		-moz-box-sizing: border-box;
		-webkit-box-sizing: border-box;
		top: 50%;
		left: 5%;
		padding: 20px 8px 8px 10px;
	}
	.appleStyleDialog .shine {
		border-radius: 12px 12px 175px 175px/0 0 20px 20px;
		height: 33px;
		opacity: 0.8;
	}
	#register {
		margin-top: -195px;
	}
	#login {
		margin-top: -125px;
	}
	#thankyou {
		margin-top: -63px;
	}
	input[type="text"],[type="email"],input[type="password"] {
		width: 280px;
		height: 16px;
		padding: 10px;
		background-color: transparent;
		border: none;
		border-top: 1px solid #CCC;
		opacity: 1.0;
		font-family: "Helvetica Neue", Helvetica, sans-serif;
		font-size: 14px;
	}
	h1,h2 {
		font-weight: bold;
		line-height: 19px;
	}
	h1 {
		font-size: 17px;
	}
	h2 {
		font-size: 12px;
	}
	p.formintro {
		font-size: 13px;
		margin: 10px 0 7px;
	}
	p {
		margin: 10px 0 6px 0;
		padding: 0;
	}
	button,input[type="submit"] {
		margin: 10px 3px 0;
	}
	label {
		font-size: 14px;
	}
	.errorBox {
		width: auto;
	}
	#login p {
		margin: 12px 0 16px 0;
	}
	#login button,input[type="submit"],#thankyou button,input[type="submit"]
		{
		margin: 0;
	}
	#thankyou.appleStyleDialog {
		padding: 20px 30px 8px;
	}
	#thankyou p {
		margin: 16px 0;
	}
}
</style>

<%

String sourceId = (String)request.getParameter("sourceId");

if(sourceId == null || "".equals(sourceId.trim())) {
	sourceId = "769"; //default
}

%>
</head>

<body>

	<div id="register" class="appleStyleDialog">
		<span class="bg"></span> <span class="shine"></span>

		<h2>Create an account to stay up to date and access future free benefits, including bonus content on your tablet.</h2>

		<form id="minimalRegisterform" action="minimalRegistrationAction.do"
			method="post">
			<br/>
			<fieldset>
				<input type="hidden" id="sourceId"  name="sourceId" value="<%=sourceId%>" />
				<div class="row">
					<!-- <label for="email">Email Address</label> -->
					<input id="emailAddress" name="emailAddress"
						placeholder="Email Address" autocorrect="off" type="text"
						autocapitalize="off" value="${param.emailAddress}" />
				</div>

				<div class="row">
					<!-- <label for="emailConfirm">Confirm Email Address</label> -->
					<input id="confirmEmailAddress" name="confirmEmailAddress"
						placeholder="Confirm Email Address" autocorrect="off" type="text"
						autocapitalize="off" value="${param.confirmEmailAddress}" />
				</div>

				<div class="row">
					<!-- <label for="password">Password</label> -->
					<input id="password" name="password" placeholder="Password" maxlength="50"
						type="password" value="${param.password}" />
				</div>

				<div class="row">
					<!-- <label for="passwordConfirm">Confirm Password</label> -->
					<input id="confirmPassword" name="confirmPassword"
						placeholder="Confirm Password" type="password" maxlength="50" value="${param.confirmPassword}" />
				</div>

			</fieldset>

			  <p>
					  Tap to see our <a href="http://adobestorefront.rd.com/privacy-policy.php" style="text-decoration:underline;">Online Privacy Policy</a>.
    		  </p>

			<div id="errors">
				<p>
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
				</p>
			</div>

			<div class="row">
				<button id="close" type="button" onclick="closeOverlay();">Cancel</button>
				<button id="submit" onclick="convertQuotationMark();">Submit</button>
			</div>

		</form>
	</div>


</body>
</html>
