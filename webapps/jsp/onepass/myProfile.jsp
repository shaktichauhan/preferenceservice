<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>


<html>
<head>
<title>My Profile</title>
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function()
{
$(".account").click(function()
{
var X=$(this).attr('id');

if(X==1)
{
$(".submenu").hide();
$(this).attr('id', '0');	
}
else
{

$(".submenu").show();
$(this).attr('id', '1');
}
	
});

//Mouseup textarea false
$(".submenu").mouseup(function()
{
return false;
});
$(".account").mouseup(function()
{
return false;
});


//Textarea without editing.
$(document).mouseup(function()
{
$(".submenu").hide();
$(".account").attr('id', '');
});
	
});
	
</script>
<style>
body {
	background-color: #ffffff;
	font-family: Verdana, Arial, Helvetica, sans-serif;
}

div.dropdown {
	background-color: #ffffff;
	color: #555;
	margin: 3px -22px 0 0;
	width: 243px;
	position: relative;
	height: 17px;
	text-align: left;
}

div.submenu {
	background: #fff;
	position: absolute;
	top: -12px;
	left: -20px;
	z-index: 100;
	width: 135px;
	display: none;
	margin-left: 10px;
	padding: 40px 0 5px;
	border-radius: 6px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.45);
}

.dropdown  li a {
	color: #555555;
	display: block;
	font-family: arial;
	font-weight: bold;
	padding: 6px 15px;
	cursor: pointer;
	text-decoration: none;
}

.dropdown li a:hover {
	background: #155FB0;
	color: #FFFFFF;
	text-decoration: none;
}

a.account {
	font-size: 18px;
	line-height: 16px;
	color: #555;
	position: absolute;
	z-index: 110;
	display: block;
	padding: 11px 0 0 20px;
	height: 28px;
	width: 121px;
	margin: -11px 0 0 -10px;
	text-decoration: none;
	background: url(image/arrow.png) 116px 17px no-repeat;
	cursor: pointer;
}

.root {
	list-style: none;
	margin: 0px;
	padding: 0px;
	font-size: 11px;
	padding: 11px 0 0 0px;
	border-top: 1px solid #dedede;
}
</style>

<style type="text/css">
a {
	text-decoration: none;
	color: #00c6ff;
}

h1 {
	font: 4em normal Arial, Helvetica, sans-serif;
	padding: 20px;
	margin: 0;
	text-align: center;
}

h1 small {
	font: 0.2em normal Arial, Helvetica, sans-serif;
	text-transform: uppercase;
	letter-spacing: 0.2em;
	line-height: 5em;
	display: block;
}

h2 {
	color: #bbb;
	font-size: 3em;
	text-align: center;
	text-shadow: 0 1px 3px #161616;
}

.container {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
}

#content {
	float: left;
	width: 100%;
}

.post {
	margin: 0 auto;
	padding-bottom: 50px;
	float: left;
	width: 960px;
}

.btn-sign {
	width: 460px;
	margin-bottom: 20px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 5px;
	background: -moz-linear-gradient(center top, #00c6ff, #018eb6);
	background: -webkit-gradient(linear, left top, left bottom, from(#00c6ff),
		to(#018eb6) );
	background: -o-linear-gradient(top, #00c6ff, #018eb6);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#00c6ff',
		EndColorStr='#018eb6' );
	text-align: center;
	font-size: 36px;
	color: #fff;
	text-transform: uppercase;
}

.btn-sign a {
	color: #fff;
	text-shadow: 0 1px 2px #161616;
}

#mask {
	display: none;
	background: #ffffff;
	position: fixed;
	left: 0;
	top: 0;
	z-index: 10;
	width: 100%;
	height: 100%;
	opacity: 0.8;
	z-index: 999;
}

.login-popup {
	display: none;
	background: #9cbc2c;
	padding: 10px;
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%;
	left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
	-webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px; /* Firefox */
	-webkit-border-radius: 3px; /* Safari, Chrome */
}

img.btn_close {
	float: right;
	margin: -28px -28px 0 0;
}

fieldset {
	border: none;
}

fieldset legend {
	background: #b9cf6a;
	background: rgba(255, 255, 255, .3);
	border-color: #e3ebc3;
	border-color: rgba(255, 255, 255, .6);
	border-style: solid;
	border-width: 2px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	-khtml-border-radius: 5px;
	border-radius: 5px;
	line-height: 35px;
	list-style: none;
	padding: 5px 10px;
	margin-bottom: 6px;
}

form.signin .textbox label {
	display: block;
	padding-bottom: 7px;
}

form.signin .textbox span {
	display: block;
}

form.signin p,form.signin span {
	color: #111111;
	font-size: 16px;
	font-weight: normal;
	padding-bottom: 0;
}

form.signin .textbox input {
	background: #ffffff;
	border: none;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	-khtml-border-radius: 3px;
	border-radius: 3px;
	font: italic 16px Verdana, Arial, Helvetica, sans-serif;
	color: #999999;
	outline: none;
	padding: 8px;
	width: 300px;
}

form.signin input:-moz-placeholder {
	color: #bbb;
	text-shadow: 0 0 2px #000;
}

form.signin input::-webkit-input-placeholder {
	color: #bbb;
	text-shadow: 0 0 2px #000;
}

.button {
	width: 260px;
	background: #384313;
	border: none;
	-moz-border-radius: 20px;
	-webkit-border-radius: 20px;
	-khtml-border-radius: 20px;
	border-radius: 20px;
	color: #ffffff;
	display: block;
	font: 18px Verdana, Arial, Helvetica, sans-serif;
	letter-spacing: 1px;
	margin: 0 auto;
	text-align: center;
	padding: 7px 15px;
	text-shadow: 0 1px 1px #000000;
	text-transform: uppercase;
}

.button:hover {
	background: #1e2506;
	cursor: pointer;
}

form.signin .textbox input:focus {
	background: #eaeaea;
}

li.errors {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 16px;
	line-height: 26px;
	color: #cc0000;
	font-weight: bold;
	margin-left: 30px;
}
</style>

<% 
   String emailAddress = request.getParameter("emailAddress") == null?"":request.getParameter("emailAddress");
   String password = request.getParameter("password") == null?"":request.getParameter("password");
%>

<script type="text/javascript">
$(document).ready(function() {
	$('a.login-window').click(function() {
		
		// Getting the variable's value from a link 
		var loginBox = $(this).attr('href');

		//Fade in the Popup and add close button
		$(loginBox).fadeIn(400);
		
		//Set the center alignment padding + border
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(300);
		$('#errors').hide();
		$('#emailAddress').val(""); 
		$('#password').val(""); 
		
		return false;
	});
	
	// When clicking on the button close or the mask layer the popup closed
	$('a.close, #mask').live('click', function() { 
	  $('#mask , .login-popup').fadeOut(300 , function() {
		$('#mask').remove();  
	}); 
	  
	  
	return false;
	});
	
	var showloginDialog = '<%=request.getParameter("error") %>';
	
	if(showloginDialog == true || showloginDialog == "true") {
	
		// Getting the variable's value from a link 
		var loginBox = '#login-box';
	
		//Fade in the Popup and add close button
		$(loginBox).fadeIn(400);
		
		//Set the center alignment padding + border
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(300);
		
		return false;
	}
});


</script>

</head>
<body>
	<div style='margin: 50px'>
		<form name="form1">

			<div class="dropdown">
				<a class="account"> <span>My Profile</span>
				</a>
				<div class="submenu" style="display: none;">

					<ul class="root">
						<li><a href="#login-box" class="login-window">Loginforsvntesting /
								Sign In for SVN Testing</a></li>


					</ul>
				</div>
			</div>
		</form>
		<div id="login-box" class="login-popup">
			<a href="#" class="close"><img src="image/close_pop.png"
				class="btn_close" title="Close Window" alt="Close" /></a>
			<form name="onePassLoginForm" method="post" class="signin"
				action="/preference/onePassLoginAction.do">


				<fieldset class="textbox">
					<legend>
						<label class="username"> <span>Email Address</span> <input
							id="emailAddress" name="emailAddress" value="<%=emailAddress %>"
							type="text" />
						</label>
					</legend>
					<legend>
						<label class="password"> <span>Password</span> <input
							id="password" name="password" value="<%=password %>"
							type="password" />
						</label>
					</legend>
				</fieldset>
				<fieldset>
					<button class="submit button" type="submit">Sign in</button>
				</fieldset>

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
			</form>
		</div>

	</div>
</body>
</html>
