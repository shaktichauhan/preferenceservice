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
udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+optoutconfirmationpage&category=brandadvocate&content_name=brandadvocate%3a+optoutconfirmationpage&pv_event=true&content_type=brandadvocate'+campaign);
--></script>
<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+brandadvocate%3a+optoutconfirmationpage&category=brandadvocate&content_name=brandadvocate%3a+optoutconfirmationpage&pv_event=true&content_type=brandadvocate"+campaign height="1" width="1" alt="*"></p></noscript><div id="container">
	<div id="header">
 <img src="jsp/brandAdvocate/images/logo.png" />

  </div>
	 <h1>Your preferences have been updated, and you'll no longer receive emails about your Free Gift Subscription.</h1>
    <p>&nbsp;</p>
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
