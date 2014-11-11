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
 <script src="js/brandAdvocate/formValidation.js" type="text/javascript" language="javascript"></script>
 <title>Reader's Digest | Share Three Free Issues</title>
<%
	String[] firstNames = request.getParameterValues("firstName");
	String[] lastNames = request.getParameterValues("lastName");
	String[] emails = request.getParameterValues("emailAddress");
	String trkid=request.getParameter("trkid") == null ? "":request.getParameter("trkid");

%>

</head>

<body>
<script language="JavaScript" src="js/brandAdvocate/comscore/comscore_udm.js" type="text/javascript"></script><script language="javascript" type="text/javascript"><!--
var trkid='<%=trkid%>';
var campaign = '&ns_campaign='+trkid+'&campaign='+trkid;

udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+landingpage&category=brandadvocate&content_name=brandadvocate%3a+landingpage&pv_event=true&content_type=brandadvocate'+campaign);
--></script>
<noscript><p><img src='http://b.scorecardresearch.com/p?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+landingpage&category=brandadvocate&content_name=brandadvocate%3a+landingpage&pv_event=true&content_type=brandadvocate'+campaign height="1" width="1" alt="*"></p></noscript>

<div id="container">
<form method="post" action="landingAction.do" name="brandAvocateForm" class="landing"  onSubmit="return validateform()" >

	<div id="header">
 <img src="jsp/brandAdvocate/images/logo.png" />

  </div>
 
	<div id="left">
    <h1>GIVE THREE FREE!</h1>
      <h2>SEND THREE DIGITAL ISSUES TO THREE OF YOUR FRIENDS</h2>
   <img src="jsp/brandAdvocate/images/ipad2.png" class="ipad" />
    <p><strong>How it works:</strong></p>
    <ol>
      <li>Provide your friends names and emails.</li>
      <li>We'll notify them about your gift, and how to access it.</li>
      <li>You can sit back and enjoy that happy, gift-giving feeling! </li>
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
    <h3>Invite your friends to READ UP! </h3>
	<p>This gift-sharing opportunity is available exclusively to subscribers.    
	<p>Complete the fields below to send a FREE 3-issue digital subscription to three of your friends who don't already subscribe to <em>Reader's Digest</em>.     
	<p>
    <div class="number"><h2>1.</h2></div>
    <div class="friend">
    <div class="name">
      <input type="text" placeholder="First Name" value='<%=firstNames != null ? (firstNames[0] == null ? "": firstNames[0]):"" %>' name="firstName" id="firstName1"  /></div>
 
 <div class="last">  <input type="text" placeholder="Last Name" value='<%= lastNames != null ?(lastNames[0] == null ? "" : lastNames[0]) : "" %>' name="lastName" id="lastName1"/></div>
    
    <div class="email">  <input type="text" placeholder="Email Address" value='<%=emails != null ? (emails[0] == null ? "" : emails[0]):"" %>'  name="emailAddress" id="emailAddress1"/> </div>
    </div>
    
    <div class="number">
      <h2>2.</h2></div>
    <div class="friend">
   <div class="name">
      <input type="text" placeholder="First Name" value='<%=firstNames != null ? (firstNames[1] == null ? "": firstNames[1]) :"" %>' name="firstName" id="firstName2"  /></div>
 
 <div class="last">  <input type="text" placeholder="Last Name" value='<%=lastNames != null ?(lastNames[1] == null ? "" : lastNames[1]):"" %>' name="lastName" id="lastName2"/></div>
    
    <div class="email">  <input type="text" placeholder="Email Address" value='<%=emails != null? (emails[1] == null ? "" : emails[1]) :""%>'  name="emailAddress" id="emailAddress2"/> </div>
    </div>
    
    <div class="number">
      <h2>3.</h2></div>
    <div class="friend">
   <div class="name">
      <input type="text" placeholder="First Name" value='<%=firstNames != null ? (firstNames[2] == null ? "": firstNames[2]):"" %>' name="firstName" id="firstName3"  /></div>
 
 <div class="last">  <input type="text" placeholder="Last Name" value='<%=lastNames != null ?(lastNames[2] == null ? "" : lastNames[2]):"" %>' name="lastName" id="lastName3"/></div>
    
    <div class="email">  <input type="text" placeholder="Email Address" value='<%=emails != null?(emails[2] == null ? "" : emails[2]):"" %>'  name="emailAddress" id="emailAddress3"/> </div>
    </div>
	 
      <div class="number">
      <h2>&nbsp;</h2></div>
    <div class="friend">
      <p>Your Information</p>
    <div class="name">
      <input type="text" placeholder="First Name" name="advocateFirstName" value='<%=request.getParameter("advocateFirstName") == null ? "": request.getParameter("advocateFirstName") %>'   id="advocateFirstName" /></div>
 
 <div class="last">  <input type="text" placeholder="Last Name" name="advocateLastName" value='<%=request.getParameter("advocateLastName") == null ? "": request.getParameter("advocateLastName") %>'  id="advocateLastName" /></div>
    
    <div class="email">  <input type="text"  placeholder="Email Address" name="advocateEmailAddress" value='<%=request.getParameter("advocateEmailAddress") == null ? "": request.getParameter("advocateEmailAddress") %>'  id="advocateEmailAddress"/>
</div>
    </div>
  <input type="hidden" name="trkId"  value='<%=trkid%>' />
  <input type="hidden" name="promoKey"  value='ADV_RDO_3' />
   <input type="hidden" value="RDO" name="prodAbbr" />  
    <input type="image" name="submit" src="jsp/brandAdvocate/images/btn.png" style="margin-left: 30px; padding-top: 15px;" />
    </div>
    </form>
  </div>
  <div class="footer">
    <p>*Free, 3-issue digital subscription can only be shared with non-subscribers of <em>Reader&rsquo;s Digest</em> magazine. </p>
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
