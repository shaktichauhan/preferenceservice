<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta name="viewport" content="width=device-width">
 <meta charset="utf-8" />

 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,700italic,800,400italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/brandAdvocate/style.css">
 <title>Reader's Digest</title>
  <% 
 	 String trkid=request.getParameter("trkid") == null ? "":request.getParameter("trkid");
   %>
</head>

<body>
<script language="JavaScript" src="js/brandAdvocate/comscore/comscore_udm.js" type="text/javascript"></script><script language="javascript" type="text/javascript"><!--
var trkid='<%=trkid%>';
var campaign = '&ns_campaign='+trkid+'&campaign='+trkid;
udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+registrationpageconfirmationpage&category=brandadvocate&content_name=brandadvocate%3a+registrationpageconfirmationpage&pv_event=true&content_type=brandadvocate'+campaign);
--></script>
<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+registrationpageconfirmationpage&category=brandadvocate&content_name=brandadvocate%3a+registrationpageconfirmationpage&pv_event=true&content_type=brandadvocate"+campaign height="1" width="1" alt="*"></p></noscript><div id="container">
	<div id="header">
 <img src="jsp/brandAdvocate/images/logo.png" />

  </div>
	<div id="left">
    <h1>ENJOY YOUR FREE ISSUES! </h1>
    <p>&nbsp;</p>
     <img src="jsp/brandAdvocate/images/ipad2.png" width="170" height="226" class="ipad" />    
    <p>We pride ourselves in bringing our readers the best uplifting stories, real-life dramas, practical advice, and belly-laugh humor for the whole family. Read up!</p>
    <p>&nbsp;</p>
    </div>
    <div id="right">
      <h3>You're all set!</h3>
      <p>You'll receive an email confirmation shortly.<br />
        <strong>NOTE!</strong> Your username is the email address entered on the previous page. </p>
      <p><br />
      <strong>Here's how to get started:</strong></p>
      <ol>
        <li>Download the app for <a href="https://itunes.apple.com/us/app/readers-digest/id411524298">iPhone/iPad.</a> </li>
        <li>Sign in with your username and password.</li>
        <li>Enjoy your 3 free issues!</li>
      </ol>
      <h3>&nbsp;</h3><p>    
	<p>    
	<p>
  </div>
  </div>
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
