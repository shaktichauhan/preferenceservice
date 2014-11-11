<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta name="viewport" content="width=device-width">
 <meta charset="utf-8" />

 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,700italic,800,400italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/brandAdvocate/style.css">
<script src="js/brandAdvocate/validateForm.js" type="text/javascript" language="javascript"></script>
 <title>Reader's Digest | Three Free Issues</title>
 
<%
	String token = request.getParameter("token");
	String registerMail=request.getParameter("registerMail");
	String recipiantFirstName=request.getParameter("recipiantFirstName");
	String recipiantLastName= request.getParameter("recipiantLastName");
	String recipiantEmailAddress= request.getParameter("recipiantEmailAddress");
	String trkid=request.getParameter("trkid") == null ? "":request.getParameter("trkid");
	
%>

</head>
  
<body>
<script language="JavaScript" src="js/brandAdvocate/comscore/comscore_udm.js" type="text/javascript"></script><script language="javascript" type="text/javascript"><!--
var trkid='<%=trkid%>';
var campaign = '&ns_campaign='+trkid+'&campaign='+trkid;
udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+registrationpage&category=brandadvocate&content_name=brandadvocate%3a+registrationpage&pv_event=true&content_type=brandadvocate'+campaign);
--></script>
<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+registrationpage&category=brandadvocate&content_name=brandadvocate%3a+registrationpage&pv_event=true&content_type=brandadvocate"+campaign height="1" width="1" alt="*"></p></noscript>
<form method="post" action="registrationAction.do" name="registrationForm" class="registration" onSubmit="return ValidateForm(document.forms[0])" >
<div id="container">
	<div id="header">
 <img src="jsp/brandAdvocate/images/logo.png" />

  </div>
	<div id="left">
    <h1>READ UP!</h1>
      <h2>CLAIM YOUR THREE FREE DIGITAL ISSUES OF READER'S DIGEST </h2>
   <img src="jsp/brandAdvocate/images/ipad2.png" class="ipad" />
    <p><strong>How it works:</strong></p>
    <ol>
      <li>Fill out the quick form.</li>
      <li>We'll send you an email      confirming your login info.</li>
      <li>Download the app, sign in, and start enjoying your first issue. </li>
    </ol>
    <p><strong>It's that easy!</strong></p>
    </div>
    <div id="right">
     <!-- Conditionally show errors -->
			<logic:messagesPresent message="false">
				<html:messages id="aMsg" message="false">
					<logic:present name="aMsg">
						<!-- Error -->
						<font color="red" ><li class="errors"><bean:write name="aMsg" filter="false" /></li></font>

					</logic:present>
				</html:messages>
				<p></p>
			</logic:messagesPresent>
			<!-- /Conditionally show errors -->
    <h3>You've been invited!</h3>
	<p>Complete the fields below to start your free 3-issue subscription. No strings! This is a gift from your friend, and gifts are always free! 
	  <br />
	<p>
    <div class="number"> </div>
    <div class="friend">
   <div class="name">
   <input type="text" placeholder="First Name" name="recipiantFirstName" value='<%=(recipiantFirstName == null?"":recipiantFirstName )%>' id="recipiantFirstName"/></div>
 
 	<div class="last">  <input type="text" placeholder="Last Name" value='<%=(recipiantLastName == null?"":recipiantLastName )%>' name="recipiantLastName" id="recipiantLastNames"/></div>
    
    <div class="email">  <input type="text" placeholder="Email Address"  value='<%=(recipiantEmailAddress == null?"":recipiantEmailAddress )%>' name="recipiantEmailAddress" id="recipiantEmailAddress"/> </div>
   
    </div>
	 
      <div class="number"></div>
    <div class="friend">
    <div class="email"> <input type="password" placeholder="Create a Password for App Login" name="recipiantPassword" id="recipiantPassword"  />
  </div>
    </div>
    
          <div class="number"></div>
       <input name="promotable" type="hidden" id="promotable" value="10" />
       <input name="promotable" type="hidden" id="promotable" value="128" />
    <div class="friend">
      <p>You&rsquo;ll also get <em>This Week</em>, a weekly recap of the best stories on RD.com, and special offers from<em> Reader's Digest</em>.</p>
</div>

    <input type="hidden" value=<%= request.getParameter("token") %> name="token" />
	    <input type="hidden" value="Y" name="registerMail" />   
	    <input type="hidden" value="RD from OnePass" name="sourceName" />     
	    <input type="hidden" value='<%=trkid%>' name="trkId" id="trkId"/>     
	    <input type="hidden" value="RDO" name="prodAbbr" />     
	    <input type="hidden" value="ADV_RDO_3" name="userType" />     
    <input type="image" name="submit" src="jsp/brandAdvocate/images/btn2.png" style=" margin-left: 15px;"/>
   
    </div>
    
    
  </div>
  </form>
  <div class="footer">
    <p>*Free, 3-issue digital subscription available only to non-subscribers of <em>Reader&rsquo;s Digest</em> magazine.</p>
    <p>Apple, the Apple logo, iPad, and iPhone are trademarks of Apple Inc., registered in the U.S. and other countries. App Store is a service mark of Apple Inc. Kindle and Kindle Fire are trademarks of Amazon.com, Inc. or its affiliates.</p>
    <img src="jsp/brandAdvocate/images/app-store.png" />
    <p>&copy; 2014 The Reader's Digest Association, Inc. All rights reserved.</p>
  </div>
<!-- Begin comScore Inline Tag 1.1302.13 -->
<% if(request.getServerPort()==80) { //Is http %>
	<script type="text/javascript" language="JavaScript1.3" src="http://b.scorecardresearch.com/c2/16404798/cs.js"></script>
<% } else { //Is https %>
	<script type="text/javascript" language="JavaScript1.3" src="https://sb.scorecardresearch.com/c2/16404798/cs.js"></script>
<% } %>
<!-- End comScore Inline Tag -->
</body>
</html>
