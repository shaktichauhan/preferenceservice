<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta name="viewport" content="width=device-width">
 <meta charset="utf-8" />

 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,700italic,800,400italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/brandAdvocate/style.css">

 <title>Reader's Digest</title>

<% 

String trkid = request.getParameter("trkid") == null ? "":request.getParameter("trkid");

StringBuffer queryString = new StringBuffer();
queryString.append(request.getScheme()+"://").append(request.getHeader("Host")).append(request.getContextPath()).append("/freeGiftregistration.do");
queryString.append("?token=").append(request.getParameter("token"));
String fbQueryString = queryString + "&trkid=" + trkid;
queryString.append("&trkid=").append(trkid);
%>
</head>

<body>
<script language="JavaScript" src="js/brandAdvocate/comscore/comscore_udm.js" type="text/javascript"></script><script language="javascript" type="text/javascript">
<!--
var trkid= '<%=trkid%>';
var campaign = '&ns_campaign='+trkid+'&campaign='+trkid;
var token='&token_reference=<%=request.getParameter("token")%>';
udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+confirmationpage&category=brandadvocate&content_name=brandadvocate%3a+confirmationpage&pv_event=true&content_type=brandadvocate'+campaign+token);
--></script>
<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+confirmationpage&category=brandadvocate&content_name=brandadvocate%3a+confirmationpage&pv_event=true&content_type=brandadvocate"+campaign+token height="1" width="1" alt="*"></p></noscript><div id="container">
	<div id="header">
 <img src="jsp/brandAdvocate/images/logo.png" />

  </div>
	<div id="left">
    <h1>THANKS FOR SHARING!</h1>
    <p>&nbsp;</p>
     <img src="jsp/brandAdvocate/images/ipad.png" class="ipad" />    
    <p>We pride ourselves in bringing you the very best in every issue of <em>Reader's Digest</em>, and we're thrilled that readers like you help spread the word.</p>
    <p>Your gift recipient(s) will receive an email announcement shortly.</p>
    <p>&nbsp;</p>
    </div>
    <div id="right">
    <h3>we appreciate your feedback. </h3>
	<p>Here's your link to share one FREE ISSUE with 10 friends.
	<p style="font-weight: bold;color:#ed1c24;" >http://freeissue.rd.com/<%=request.getParameter("token") %>
	 </p> Simply copy and paste the link into an email or get social and share on Facebook!<p></p>
	<p>  <a target="_blank" href="http://www.facebook.com/share.php?u=http://freeissue.rd.com/<%=request.getParameter("token") + "&trkid=brandadvocatefb" %>"><img src="jsp/brandAdvocate/images/facebook.png"  class="facebook"/></a>  
	<p>    
	<p>    
	<p>    
	<p>    
	<p>    
	<p>    
	<p>                            
    </div>
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
