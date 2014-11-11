<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ page import="com.readersdigest.onepass.util.StringUtils"%>
<html:html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Readers Digest</title>
<link rel="stylesheet" type="text/css" href="css/promotional/registration.css" />
<meta name="description" content="">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=0"/>
<meta http-equiv="cleartype" content="on">
<meta name="msapplication-TileColor" content="#222222">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="">


<%
		
		String customerName = (String)request.getParameter("customerName")!= null?(String)request.getParameter("customerName"):"";
		String emailAddress = (String)request.getParameter("emailAddress")!= null?(String)request.getParameter("emailAddress"):"";
		String password = (String)request.getParameter("password") != null?(String)request.getParameter("password"):"";
		String trkid = ((String)request.getParameter("trkid") != null && !"".equals((String)request.getParameter("trkid").trim()))?(String)request.getParameter("trkid"):"PR_Free_digital_def"; //default id=PR_Free_digital_def
%>
</head>

<body>

<!--
Start of DoubleClick Floodlight Tag: Please do not remove
Activity name of this tag: Retargeting_Get Free Issue_Order Form_From DIGO
URL of the webpage where the tag is expected to be placed: http://rd.com/reads
This tag must be placed between the <body> and </body> tags, as close as possible to the opening tag.
Creation Date: 12/11/2013
-->
<script type=""text/javascript"">
var axel = Math.random() + """";
var a = axel * 10000000000000;
document.write('<iframe src=""https://4179798.fls.doubleclick.net/activityi;src=4179798;type=rdcom120;cat=retar343;ord=1;num=' + a + '?"" width=""1"" height=""1"" frameborder=""0"" style=""display:none""></iframe>');
</script>
<noscript>
<iframe src=""https://4179798.fls.doubleclick.net/activityi;src=4179798;type=rdcom120;cat=retar343;ord=1;num=1?"" width=""1"" height=""1"" frameborder=""0"" style=""display:none""></iframe>
</noscript>

<!-- End of DoubleClick Floodlight Tag: Please do not remove -->

<script language="javascript" type="text/javascript">
function udm_(e){var t="comScore=",n=document,r=n.cookie,i="",s="indexOf",o="substring",u="length",a=2048,f,l="&ns_",c="&",h,p,d,v,m=window,g=m.encodeURIComponent||escape;if(r[s](t)+1)for(d=0,p=r.split(";"),v=p[u];d<v;d++)h=p[d][s](t),h+1&&(i=c+unescape(p[d][o](h+t[u])));e+=l+"_t="+ +(new Date)+l+"c="+(n.characterSet||n.defaultCharset||"")+"&c8="+g(n.title)+i+"&c7="+g(n.URL)+"&c9="+g(n.referrer),e[u]>a&&e[s](c)>0&&(f=e[o](0,a-8).lastIndexOf(c),e=(e[o](0,f)+l+"cut="+g(e[o](f+1)))[o](0,a)),n.images?(h=new Image,m.ns_p||(ns_p=h),h.src=e):n.write("<","p","><",'img src="',e,'" height="1" width="1" alt="*"',"><","/p",">")};
</script>
<script language="javascript" type="text/javascript">
<!--
udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+promotional%3a+freedigitalissue%3a+entry+form&category=promotional&content_name=promotional%3a+freedigitalissue%3a+entry+form&pv_event=true&content_type=promotional&prod_view=true&ns_campaign=<%=trkid %>&campaign=<%=trkid %>');
-->
</script>
<noscript>
<p>
<img src="http://b.scorecardresearch.com/p?c1=2&c2=16404798&ns_site=rdna&_site=rd&name=rd%3a+promotional%3a+freedigitalissue%3a+entry+form&category=promotional&content_name=promotional%3a+freedigitalissue%3a+entry+form&pv_event=true&content_type=promotional&prod_view=true&ns_campaign=<%=trkid %>&campaign=<%=trkid %>" height="1" width="1" alt="*">
</p>
</noscript>

<div id="wrapper">
  <div id="container">
    <!--Content-->
    <div id="content"> <span class="logo"><img src="css/promotional/images-order/logo.jpg" alt="Reader&#39;s Digest" title="Reader&#39;s Digest" /></span>
      <div class="details">
        <div class="cl"></div>
      </div>
    </div>
    <!--Content End-->
    <!-- Form -->
    <div id="form">
      <form class="form-det" method="post" action="promotionalRDRegistrationAction.do?trkid=<%=trkid %>">
        <div class="wrap">
          <h2>Fill in your info to access your Free Issue. It's available for iPhone<span class="sup2">&reg;</span>, iPad<span class="sup2">&reg;</span>, Kindle Fire<span class="sup2">&#8482;</span>, and Android<span class="sup2">&#8482;</span> (powered by Zinio).</h2>
          <div class="imageBlcok"><!--  <a href="http://itunes.apple.com/us/app/readers-digest/id411524298"> --><img alt="App Store" src="css/promotional/images-order/appStore.jpg"><!-- </a> <a href="http://www.amazon.com/gp/product/B0063HB1HU/"> --><img alt="Amazone" src="css/promotional/images-order/amazone.jpg"><!--  </a><a href="http://itunes.apple.com/us/app/readers-digest/id411524298">--><img alt="Amazone" src="css/promotional/images-order/android.jpg"><!-- </a>--></div>
          <div class="section">
            <!--<span class="error"></span>-->
            <h3>Your Information</h3>
            <span class="req">All fields required</span>
            <div id="clearall"></div>
            <span class="label1">Full Name<br />
            <input type="text" class="inp3" class="inp3" name="customerName" id="customerName" maxlength="50" value="<%=customerName%>"/>
            </span> <span class="label1">Email Address<br />
            <input type="text" class="inp3" name="emailAddress" id="emailAddress" maxlength="100" value="<%=emailAddress%>"/>
            </span> <span class="label1">Create Password<br />
            <input type="password" class="inp3" class="inp3" name="password" id="password" maxlength="50" value="<%=password%>"/>
            </span>
            <% if(StringUtils.isETApisCall()) { %>
           		<input type="hidden" name="promotable" id="promotable" value="10" />
            <% } else { %>
            	<input type="hidden" name="promotable" id="promotable" value="20" />
            <% } %>
            <html:hidden property="sourceId" value="1027" />
             
            
            <div class="cl"></div>
            <!-- Conditionally show errors -->
			<logic:messagesPresent message="false">
				<html:messages id="aMsg" message="false">
					<logic:present name="aMsg">
						<!-- Error -->
						<li class="error"><bean:write name="aMsg" filter="false" /></li>

					</logic:present>
				</html:messages>
				<p></p>
			</logic:messagesPresent>
			<!-- /Conditionally show errors -->
          </div>
          <div class="section"> <span class="checkbox">
            <label>In addition to your free issue, we'll also keep you in the loop about  new digital products and special offers from <em>Reader&#39;s Digest.</em></label>
            </span> <span class="btn-sec">
            <input type="submit" value="" name="send" />
            <a href="http://www.rd.com/privacy-policy/" target="_blank">Online Privacy Policy</a> </span>
            <div class="cl"></div>
          </div>
          <div class="cl"></div>
        </div>
      </form>
    </div>
    <!-- Form End -->
    <div class="cl"></div>
   <!--Footer-->
    <div id="footer"> <span class="copy">&copy; 2013 The Reader&#39;s Digest Association, Inc. All rights reserved. </br>Apple, the Apple logo, iPad, and iPhone, are trademarks of Apple, Inc registered in the U.S. and other countries. App Store is a service mark of Apple, Inc. Amazon, Kindle Fire, the Amazon Kindle logo and the Kindle Fire logo are trademarks of Amazon.com, Inc. or its affiliates. </span>  </div>
    <!--Footer End -->
  </div>
</div>
<!-- ClickTale Bottom part -->
<script type="text/javascript">
var fb_param = {};
fb_param.pixel_id = '6012311147504';
fb_param.value = '0.00';
fb_param.currency = 'USD';
(function(){
  var fpw = document.createElement('script');
  fpw.async = true;
  fpw.src = '//connect.facebook.net/en_US/fp.js';
  var ref = document.getElementsByTagName('script')[0];
  ref.parentNode.insertBefore(fpw, ref);
})();
</script>
<noscript><img height="1" width="1" alt="" style="display:none" src="https://www.facebook.com/offsite_event.php?id=6012311147504&amp;value=0&amp;currency=USD" /></noscript>
<!-- Begin comScore Inline Tag 1.1302.13 -->

	<script type="text/javascript" language="JavaScript1.3" src="http://b.scorecardresearch.com/c2/16404798/cs.js"></script>

<!-- End comScore Inline Tag -->

</body>
</html:html>